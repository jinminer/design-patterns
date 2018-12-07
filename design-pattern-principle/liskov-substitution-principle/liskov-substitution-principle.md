# 里氏替换原则



#### 定义

---

> [**Liskov替换原则**](https://en.wikipedia.org/wiki/Liskov_substitution_principle) **(LSP: Liskov substitution principle)** 是对子类型的特别定义。
>
> 派生类(子类)对象可以在程序中代替其基类(超类)对象



#### 用例

---

* 场景：一个支付API的公共请求处理类，涉及支付宝和微信两种请求的处理。

```java
/**
 * 消息实体基类
 */
public abstract class BaseRequest{

    protected String sign;
    
    public String getSign(){
        return this.sign;
    }
    public void setSign(String sign){
        this.sign = sign;
    }
    
}

/**
 * 支付宝消息实体类
 */
public class AlipayRequest extends BaseRequset{
    ......
    /**
     * 支付宝特有的属性
     */
    ......
}

/**
 * 微信消息实体类
 */
public class WechatRequest extends BaseRequset{
    ......
    /**
     * 微信特有的属性
     */
    ......
}

/**
 * 请求处理类
 */
public class client{
    
    /**
     * 请求处理
     */
    public void execute(BaseRequest request){
        ......
        //设置签名
        request.setSign("XXX");
        ......
    }
    
}

/**
 * 业务处理类
 */
public class PayService{
    
    /**
     * 支付宝业务处理
     */
    public void doAlipay(){
        
        AlipayRequest request = new AlipayRequset();
        //设置支付宝支付参数
        ......
        //调用Client处理支付请求
        Client client = new Client();
        client.execute(request);
  
    }
    
    /**
     * 微信业务处理
     */
    public void doWechat(){
        
        WechatRequest request = new WechatRequset();
        //设置支付宝支付参数
        ......
        //调用Client处理支付请求
        Client client = new Client();
        client.execute(request);
  
    }
    
}
```



* 上面的支付请求处理类涉及请求消息基类`BaseRequest`、支付宝请求实体类`AlipayRequest`、微信请求实体类`WechatRequest`、请求处理类`client`以及业务处理类`PayService`。其中`PayService`需要调用`client`处理不同的请求(支付宝/微信)，根据业务流程的分析，支付宝和微信在发送请求前都需要进行签名，这是它们两者的共有行为，所以我们对消息请求实体进行了继承式的结构设计，`AlipayRequest`和`WechatRequest`都可以替换父类`BaseRequest`执行`client.execute()`方法，达到了类复用的效果，并且按照这种约定新增其他支付通道(比如银联、网联等)也是顺理成章，**扩展性**良好。当然实际开发中，支付宝、微信等支付通道的消息实体区别很大，接口的设计也并非如此，这里只是举例论证**LSP**的特点。



#### 问题

---

> 从派生类抛出异常如果在派生类的方法中添加了基类不会抛出的异常，但是基类的使用者不期望这些异常，那么把它们添加到派生类的方法中就会导致不可替代性。

```java
public class ParentClass{
    public void method(){
        system.out.println("hello world");
    }
}

public class ChildClass extends ParentClass{
    public void method(){
        //运行时异常，在开发过程中覆盖父类方法，编译不报错
        throw new UnsupportedOperationException();
    }
}

public class TestDemo{
    
    public static void main(String[] args){
        ParentClass parent = new ParentClass();
        ParentClass child = new ChildClass();
        test(parent);//运行正常
        test(child);//运行时异常
    }
    
    public static void test(ParentClass parent){
        parent.method();
    }
}
```

* 子类`SubClass`继承了父类`ParentClass`并且重写了父类的方法，显然这种做法违反了**LSP**，我们期望的是子类无条件支持父类的使用者功能的完整性，此时要遵守**LSP**，要么改变使用者，要么派生类就不应该抛出这些异常。所以在**LSP**中，重写这个行为我们要谨慎对待。比如前面支付请求处理的例子中，如果`BaseRequest`基类的`setSign()`方法被子类覆盖，添加了某种异常，对使用者`Client`来说这种行为无疑非常危险的。

 

#### 优化

---

* 在使用**LSP**进行代码结构设计时，子类替换父类情况屡见不鲜，很多时候子类覆盖父类方法的做法确实非常必要，也确实会出现父类使用者调用子类例子，出现这种结果确实让人无奈，那我们到底该如何应对呢？其实，反过来思考，父类的方法实现被子类覆盖的情况我们也可以稍作推敲。
  * 1.对于子类抛出异常的情况，我们得思考这个方法在设计之初是否考虑周全，这种情况其实是变相的违背了**封闭性原则**。所以我们还是希望系统设计之初就尽可能地考虑到这些潜在地风险，比如类似于`io`处理的类，我们在设计类的继承结构和调用关系时，就应该趁早将异常处理考虑进去，将这些风险扼杀在摇篮里。
  * 2.提倡父类中出现的方法应该以抽象方法为主，除非从客观因素考虑到该方法确实需要被子类继承，而且不会被覆盖。否则我们判定方法的实现工作都应该由最底层的子类来完成，保证其**扩展性**，以免对父类的使用者造成影响。



#### 结论

---

* 把**LSP**和**OCP**放到一起来看，两者之间的关系似乎异常紧密，确实如此，LSP是OCP成为可能的主要原则之一。子类和基类之间的无缝替换性，增强了程序的扩展性，削减代码冗余度，使得系统更加紧凑合理。
* 我们在享受**LSP**为系统设计带来优势的同时，要特别警惕方法重写带来的风险。这种行为带来的问题往往只有项目真正运行时，才会暴露出来，而且大多数情况下开发人员都潜移默化的认为，子类应该完美的承担(代替)父类的职责。所以这种神不知鬼不觉的覆盖行为会给类的调用者造成不小的困惑。



#### 思考

---

* 来看一个奇妙的例子

  * 矩形/正方形

    ```java
    /**
     * 矩形
     */
    public class Rectangle{
        protected double length;
        protected double width;
        
        public void setLength(double length){
            this.length = length;
        }
        public double getLength(){
            return this.length;
        }
        
        public void setWidth(double width){
            this.width = width;
        }
        public double getWidth(){
            return this.width;
        } 
    }
    
    /**
     * 正方形
     */
    public Square extends Rectangle{
        
        public double getArea(){
            return this.length * this.length;
        }
        
    }
    
    public class TestDemo{
        
        public static void main(String[] args){
            
            //创建一个矩形对象，并设置矩形的长度为10
            Rectangle rectangle = new Rectangle();
            test(rectangle);
            
            //创建一个正方形对象，并设置正方形的边长为10
            Rectangle square = new Square();
            test(square);
        }
        
        public static test(Rectangle rectangle){
            rectangle.setLength(10);
        }
        
    }
    ```

  * 上面的例子中，我创建了矩形对象和正方形对象，并为它们长赋值。不难发现测试类中的`test()`方法存在错误，当的入参是一个`Rectangle`对象时会正确设置矩形长度的值，但是当入参是`Square`对象时只设置长度的值，明显违背了宏观真理，因为对于一个正方形来说，它的边长都是相等，单纯的设置了长度的值而忽略宽度的值是不科学的。


* 为了满足正方形的需求，我们修改一下代码

  * 让正方形`Square`重写父类`Rectangle`矩形的方法

    ```java
    /**
     * 正方形
     */
    public Square extends Rectangle{
        
        @Override
        public void setLength(double length){
            //为长度赋值的同时，为宽度赋值
            this.length = length;
            this.width = length;
        }
        
        @Override
        public void setWidth(double width){
            //为宽度赋值的同时，为长度赋值
            this.width = width;
            this.length = length;
        }
        
        public double getArea(){
            return this.length * this.length;
        } 
    }
    ```

  * 这时候我们在调用`test()`方法，当的入参是一个`Rectangle`对象时会正确设置矩形长度的值，当入参是`Square`对象时会同时设置长度和宽度的值，这样貌似问题解决了。


* 再看一个例子

  * 我们在`TestDemo`里创建一个`test2()`方法

    ```java
    public class TestDemo{
        
        public static void main(String[] args){
            
            //创建一个矩形对象，并设置矩形的长度为10
            Rectangle rectangle = new Rectangle();
            test(rectangle);
            
            //创建一个正方形对象，并设置正方形的边长为10
            Rectangle square = new Square();
            test2(square);
        }
        
        public static test(Rectangle rectangle){
            rectangle.setLength(10);
        }
        
        public static test2(Rectangle rectangle){
            rectangle.setLength(10);
            rectangle.setWidth(8);
        }
        
    }
    ```

  * 我们调用`test2()`方法为矩形和正方形的长度和宽度赋值，它们的长度和宽度确实更新了，但是我们发现由于`Square`正方形类的`setWidth()`方法和`setLength()`被重写过，在给正方形对象设置长度(宽度)会同时更新长度和宽度两个值。当对一个正方形对象执行`test2()`方法时其实进行了两次边长更新操作，也就是是说，上面的方法执行之后，正方形的边长实际值是8。

* **lsp**似乎在矩形和正方形的这个例子中失效了？正方形和矩形从宏观上来看确实具有派生关系，但是在上面的场景中我们发现，子类代替父类进行程序计算时，各自的功能都被制约了。这就涉及到了一个很客观的问题，业务模型如何能准确的抽象为程序模型，其实虽然正方形也是矩形，但是如果从程序员的角度剖析它们的内部结构，矩形有两个属性(长和宽)，正方形只有一个属性(边长)。我们说类的属性和方法是由实际生活中的某一类事务所抽象出来的共性，从程式和类的角度来看长方形和矩形的属性和方法(行为)，二者之间其实是大相径庭，而**lsp**也是对程序的约定和规范，并不能去约束业务场景，所以遇到这种问题通常让人颇为难堪。故此，我们再重新提及，尽量不要强行得将某一原则生搬硬套到我们的程序中来，首先应该详细地分析业务模型，再结合每种设计原则特点，具体问题具体对待。













