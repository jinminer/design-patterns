# 依赖倒置原则



#### 定义

---

> **[依赖倒置原则](https://zh.wikipedia.org/wiki/%E4%BE%9D%E8%B5%96%E5%8F%8D%E8%BD%AC%E5%8E%9F%E5%88%99)(DIP: dependency inversion principle)** 是指一种特定地**解耦**(传统的依赖关系创建在高层次上，而具体的策略设置则应用在低层次的模块上)形式，使得高层次的模块不依赖于低层次的模块的实现细节，依赖关系被颠倒(反转)，从而使得低层次模块依赖于高层次模块的需求抽象。
>
> * 高层次的模块不应该依赖于低层次的模块，两者都应该依赖于**抽象接口**
> * 抽象接口不应该依赖于具体实现。而具体实现则应该依赖于抽象接口



* 先抛开这些书面定义，我们逐字剖析一下**依赖倒置**，它到底是个什么东东？
  * 所谓**依赖**无非就是“谁依赖了谁、谁被谁依赖”的问题，从开发的角度来说**依赖**就是程式(函数/类)的互相调用而已。那么程式之间的调用关系为什么要被**倒置**，这样做的意义何在。
  * 程序语言有**面向过程**和**面向对象**之分，从解决问题的过程来看：
    * **面向过程**就是自顶向下先根据业务需求分析出解决问题所需要的步骤，然后用函数将这些步骤按部就班的实现，再依次调用即可。
    * **面向对象**则是先将业务场景根据职责的不同抽象为多个对象，这些对象不是为了完成某一个步骤，更偏向于描述不同功能在整个业务场景中的行为。
    * 所以从开发的角度来看，**面向过程**更关注于服务提供者(被调用者)的实现，也就是它会被动的去适配服务提供者。而且对于这种类和类、函数和函数之间的直接调用关系而言，这种上层的模块完全依赖于底层模块的关系我们可以简单的理解为**正向依赖**。
    * 而**面向对象**只关注于模块的行为表现，不会关心模块的具体实现过程。在解决问题时，上层模块首先会对自己需要调用的服务抽象出一套具体的行为规范，下层模块(服务提供者)根据这个约定实现具体内容，这个过程可以看成是上层模块促成了底层模块的实现，这与**面向过程**设计中上层模块的被动调用恰恰相反，是一种**反向依赖**，即是为**依赖倒置**。
  * **面向对象**程序设计语言提供的抽象接口是实现**依赖倒置原则**的利器(后面会提到为什么不提倡使用抽象类)，得益于**面向对象**语言的优秀特性，良好的**面向对象**程序设计就是**依赖倒置原则**的完美实践。



#### 用例

---

* 场景：人们乘坐高铁出行。
  * `TravelServer`提供了出行服务API，`People`定义人类，`Location`定义地域，`HighSpeedRailway`提供了高铁载人去某地的方法。

```java
/**
 * 人类实体
 */
public class People{
    
    private String name;//姓名
    private String id;//身份证
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
        
}

/**
 * 地域实体
 */
public class Location{
    
    private String begin;//出发地
    private String end;//目的地
    public void setBegin(String begin){
        this.begin = begin;
    }
    public String getBegin(){
        return begin;
    }
    public void setEnd(String end){
        this.end = end;
    }
    public String getEnd(){
        return end;
    }
    
}

/**
 * 高铁实体
 */
public class HighSpeedRailWay{

    /**
     * 高铁载人从出发地到目的地
     */
    public void run(People p, Location l){
        
        ......
        
    }
    
}

/**
 * 出行服务API
 */
public class TravelServer{
    public void travel(People p, Location l){
        //高铁载人从出发地到目的地
        HighSpeedRailWay hsr = new HighSpeedRailWay();
        hsr.run(p, l);
    }
}

public class TestDemo{
    public void test(){
        People p = new People();
        p.setName("老王");
        p.setId("1234567890");
        
        Location l = new Location();
        l.setBegin("北京");
        l.setEnd("杭州");
        
        new TravelServer().travel(p, l);
    }
}
```



#### 问题

---

* 现在有一个新需求，出行方式改变了，比如老王想打飞的去。很简单我们再定义一个飞机类，并且修改`TravelServer`类，新增一个乘坐飞机出行的方法。那如果出行方式变为乘船、驾驶汽车呢？是不是每次新增一种出行方式(增加一个`HighSpeedRailWay`这样的类)，就必须得修改`TravelServer`类呢？这样的做法肯定是错误的，因为`TravelServer`类作为`API`是对外提供的公共服务，这种频繁的变更是非常不可取的。



#### 优化

---

* 上面的例子中，作为底层实现，变更了出行方式新增一个飞机实体或者是汽车实体，这是无可厚非的，但是却影响了`TravelServer`公共服务API。我们对代码结构进行调整，实体`People`和`Location`保持原状。

```java
/**
 * 出行方式抽象
 */
public interface Transportation{
    //交通工具载人行为抽象
    public void run(People p, Location l);
}

/**
 * 高铁实体
 */
public class HighSpeedRailWay implements Transportation{

    /**
     * 高铁载人从出发地到目的地
     */
    @Override
    public void run(People p, Location l){
        
        ......
        
    }
    
}

/**
 * 飞机实体
 */
public class Airplane implements Transportation{

    /**
     * 飞机载人从出发地到目的地
     */
    @Override
    public void run(People p, Location l){
        
        ......
        
    }
    
}

/**
 * 出行服务API
 */
public class TravelServer{
    public void travel(People p, Location l, Transportation t){
        //交通工具载人从出发地到目的地
        t.run(p, l);
    }
}

public class TestDemo{
    public void test(){
        People p = new People();
        p.setName("老王");
        p.setId("1234567890");
        
        Location l = new Location();
        l.setBegin("北京");
        l.setEnd("杭州");
        
        //Transport t = new HighSpeedRailWay();
        Transport t = new Airplane();
        
        new TravelServer().travel(p, l, t);
    }
}
```



#### 结论

---

* 不难发现，所有的交通工具都有共同的行为：从始发地载人去目的地。所以我们自然而然地定义了`Transportation`接口类，新增一种交通方式都去实现`Transportation`接口，对于`TravelServer`出行服务API而言，我们只在乎某个人从始发地到目地这样一个结果即可，并不需要知道这个人是选择哪种交通工具，这样我们只需要新增具体的交通 工具实体即可，`TravelServer`并不需要作任何变化。
* 再重新分析业务场景和系统层次结构
  - 老王从北京到杭州这个业务场景中，选择什么交通方式其实是由老王本人(客户端)来定的，和服务提供着`TravelServer`并没有直接关系，飞机或者高铁是否正常运行才会影响老王。
  - 从系统层次来看，`TestDemo`客户端模拟了最顶层的业务模块，`TravelServer`服务提供者将人和交通工具联系到了一起，交通工具实体相当于最底层的API，`Transportation`抽象接口定义了出行这种行为。

* 我们用面向对象语言(Java)描述了"老王从北京去杭州"的场景，在使用`Transportation`抽象接口进行代码优化后，提高了程序的灵活性。**面向对象**编程的优势在于，它会使程序员的工作变得欢快无比，比如对于`TravelServer`而言，只会去关心它需要什么，而不是别人有什么，这种思维方式的调换(**依赖反转**)是非常合理。`TravelServer`需要有交通工具载人去某地这样一个行为，于是它根据这个需求定义了一种规范`Transportation`，这样谁想为我提供这种能力，谁就去实现`Transportation`接口，只有你遵循了我要求的规范，我才会消费你提供服务。



#### 思考

---

* 我们将**DIP**大胆断言为面向对象编程中抽象接口的使用，这种断言看起来确实稍显极端，其实实际上我们关注的是编程思维的转变，即从一味的程式调用上升到大家共同遵守约定这个层面。对于某个服务而言，首先应该将那些解决服务内部问题的功能做出**约定**，这些**约定**一般情况下不会变更，服务只关心我需要什么样的行为，对那些解决问题的具体实现内容并不在意，而接口恰恰是实现这种约定最佳实践之一。

> 基于**DIP**的启发式规则：
>
> - 任何变量都不应该持有一个指向具体类的指针或者引用
> - 任何类都不应该从具体类派生
> - 任何方法都不应该覆写它的任何基类中的已经实现了的方法



* 接口优于抽象类

  * 抽象类也能实现接口的功能，比如老王的例子中，完全可以将`Transportation`定义为一个抽象类。那为何非要用接口呢？还是分析问题的本质，首先为什么要用接口？我们为了提高程序的可扩展性、可维护性，将解决问题的功能进行了统一的约定，这种约定在业务场景不发生变化的情况下基本上是固化的，变的只是具体的实现过程。

  * 抽象类内部可以定义有具体实现过程的方法，如果我们用抽象类来规范和约定某个功能，这会让已经制定好的规范存在不稳定。因为一旦这个抽象类中包含了一些有具体实现过程的方法，那么就会有子类覆盖父类方法的可能，这些可变因素会削弱**约定**的稳定性。


* 接口确实会使我们的编码过程变得优雅，但这也并不意味着滥用。对于某些基本不会变化或者更新周期较长的类来说，直接进行函数式的调用比用于接口更加合理，比如就**JDK**而言，我们可以直接调用，像是表示字符串的`String`类，直接依赖它并无不妥。







