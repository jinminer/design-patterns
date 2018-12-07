# 开闭原则



#### 定义   

---

> [**开放—封闭原则**](https://zh.wikipedia.org/wiki/%E5%BC%80%E9%97%AD%E5%8E%9F%E5%88%99) **(OCP: open-closed principle)**
>
> * 软件中的对象(类、模块、函数等)应该对于**扩展**是开放的，但对于**修改**是封闭的。
> * 系统设计开放工作一旦完成，一个类的实现只应该因为错误而修改，新的或者改变的特性应该通过新建不同的类去实现。



#### 用例

---

* 需求：`Client`客户端调用`Server`服务端提供的服务，`Client`通过调用`HttpConnetion`工具类与`Server`进行http通信

  ```java
  /**
   * 客户端
   */
  public class Client{
      /**
       * 请求调用
       */
      public sendRequest(){
          String url = "http://140.205.94.189:8848";
          String content = "hello world";
          HttpConnection conn = new HttpConnection();
          conn.doRequest(url, content);
      }
  }
  
  /**
   * http请求处理类
   */
  public class HttpConnection{
  
      public doRequest(String url, String content){
          ......
          /**
           * 处理http请求
           */
          ......
      }
      
  }
  
  /**
   * 服务端
   * 提供http请求服务
   */
  public class Server{
      
  	......
      
  }                                                                                                                                                                                                                          
  ```




#### 问题

---

* 新需求：现在`Server`端开发了一些新的业务，但是需要以https的请求方式进行调用。
* `Client`如果要使用`Server`提供的新增业务需要同时满足http和https两种请求方式，但是上面的用例中`HttpConnection`是具体的类，只能处理http请求。当前这种情况下只能修改`HttpConnection`类才能达到目的，但是如果再增加一种请求方式呢，是不是每次随着服务端调用方式的变化我们要去重构`HttpConnection`类呢？



#### 改进

---

* 下面我们根据**开闭原则**对上面的需求进行实现

  ```java
  
  /**
   * 请求处理抽象类
   */
  public abstract class Connection{
  	public abstract doRequest(String url, String content);
  }
  
  /**
   * http请求处理类
   */
  public class HttpConnection extends Connection{
      public doRequest(String url, String content){
          ......
          /**
           * 处理http请求
           */
          ......
      }
  }
  
  /**
   * http请求处理类
   */
  public class HttpsConnection extends Connection{
      
      public doRequest(String url, String content){
          ......
          /**
           * 处理https请求
           */
          ......
      }
      
  }
  
  /**
   * 客户端
   */
  public class Client{
      
      String url = "http://140.205.94.189:8848";
      String content = "hello world";
      //Connection conn = new HttpConnection();
      Connection conn = new HttpsConnection();
      conn.doRequest(url, content);
      
  }
  
  /**
   * 服务端
   * 同时提供http和https服务
   */
  public class Server{
      
  }
  ```

  * `Client`需要向`Server`发送请求，它使用在`Connection` 抽象接口类去统一描绘了发送请求这个功能，`Connection`的子类实现`doRequest()`抽象方法，不同的实现类展现了不同的特性，比如http和https，这样我们在进行业务扩展时不会变的拘谨，再也不必像之前那样为了实现https的新需求去修改原先http的实现。只需简单的扩展，再不影响以有业务的前提下，轻松的实现了新的业务。



#### 结论

---

* **开闭原则**在实际运用中，通过抽象类和接口的模式，把一个功能的通用部分和实现细节部分清晰的分离开来，这样对于系统的迭代开放来说意义重大。在系统升级时，增加新功能不会影响原有功能，实时开放实时调用即可；出于不同实现类的隔离性，维护原有功能也不会影响其他功能。
* 从本质上来说，**开闭原则**也体现了面向对象设计的核心思想，在程序设计过程中遵循这个原则，会在很大程度上提高系统的**灵活性、可重用性、可维护性**。



#### 思考

---

* 通过前面的论述，我们了解到**开闭原则**给予系统开发维护的好处，那是不是只要遵循了这一原则，系统就完美了？很明显，答案是否定的。
  * **开闭原则**本质上可以理解为面向对象设计中的抽象思想，在进行系统设计时，首先对当前系统所涉及的业务进行较为周全的分析，去猜测、去推敲业务中的种种变化。在设计之初，这项抽丝剥茧的工序至关重要，而且需要尽可能的详细(强烈建议)，我们将实际的业务流程映射为一个个相互独立的可变因子，分析它们之间的区别和联系，将那些行为相像的因子归并为一类，并将这些行为进行统一的抽象处理。也就是说如果我们预测到了这些变化，那么就设计一个抽象进行隔离操作：封闭通用的行为表现，而对每个可变因子各自的特性保持开放态度。
  * 我们已经知道了如何使用**开闭原则**去约束可变因子(业务的具体表现点)，这些变化遵循了开放—封闭的约定。但是既然原则是对变化的约定，那么无论模块是多么的**封闭**，一般而言，都会存在一些无法对之封闭的变化，很多时候我们很难做到完全封闭，我们必须策略性地看待这个问题。设计人员必须对自己所设计的模块应该对哪些变化封闭进行抉择，这种预测性工作对设计人员的系统开发经验要求颇高，因为这意味着他们要根据经验猜测那些应用程序在生长过程中可能遭受到的变化。但是就算是那些对业务和用户行为非常了解的"老手"而言，遵循**OCP**原则的代价也十分昂贵，创建正确的抽象需要花费开发时间和精力。
  * 当然我们也不能对应用程序中的每个部分都肆意地进行抽象，过度地抽象只会徒增程序地复杂性。正确的做法是，仅仅对那些意料之中的、频繁发生变化的部分进行抽象。

* 深谙其道：Java中的接口和抽象类
  * 接口和抽象类中都会定义抽象方法，抽象类中的方法可以有默认的实现；一个类可以实现多个接口，但只能继承一个类(抽象类)
  * 在这里我们可以把抽象方法的定义看作是对业务通性的**显示封闭**，显而易见，这个思路是基于接口类的。因为接口类中的抽象方法一旦完成定义，在业务不变的情况下，一般不会因外在因素而改变，如果我们需要对其进行扩展和维护，只能通过具体的子类实现去做。而对于抽象类而言，虽然它不是我们程序中之间调用的目标类，但是却可以包含有具体实现的方法，这个方法可以是它自己定义的，或者是上层接口类和抽象类的。从某些方面来说，这个特性也会增加系统的不稳定性，因为有些时候我们很难准确的推测出业务的通用抽象行为应该在类继承链路的哪个节点去实现。
  * 一般来说接口是对通用行为的抽象，具有统一的规范性，这种行为一旦定义了，那就很难去更改，具备**封闭原则**；抽象类是对某一类事物的抽象，它的优点是，对于顶层超类来讲，如果新增一个行为实现，子类不必修改即可直接，从某个角度来看，这也暗合了**开放原则**的思想。

* 前面我们花费了一些篇幅描述了**封闭原则**被破坏的现象，并阐述了Java中接口和抽象类的部分特点，以及它们和**开闭原则**之间的关系。其实到这里，我们已经对解决封闭原则被破坏的问题有了些许思路，可以用抽象类来变相的解决这个问题，称之为**另类开放**。

* 以上面的请求处理类`Connection`为例，比如`Client`和`Server`在通信过程中出现了请求乱码的问题。先分析一下这个新增的需求，请求编码问题在https和http都会涉及，`Client`要解决这个问题有以下几个解决思路

  * 1.最直接的从实现类入手，分别在`HttpConnection`类和`HttpsConnection`中添加一个新方法`decode()`来处理这个问题

  * 2.修改`Connection`接口,增加一个抽象方法`decode()`，子类实现该方法

  * 1和2两种方法都能解决当前的需求，但却破坏了源代码，更严重的问题是，如果再新增一个诸如请求乱码的问题，我们就要做很多不必要的重复性工作，很显然这两种方案是不可取的。我们重新调整一下代码结构，实现如下：

  ```java
  /**
   * 请求处理抽象类
   */
  public interface Connection{
      public abstract doRequest(String url, String content);
  }
  
  //请求处理抽象类
  public abstract class abstractConnection implements Connection{
      
    	public String decode(String content, String charset){
              ......
                  
              //进行url decode
                  
              ......
             }
      
    }
  
  /**
   * http请求处理类
   */
  public class HttpConnection extends abstractConnection{
      
      public doRequest(String url, String content){
          ......
  
          //处理http请求
  
          ......
      }
      
  }
  
  /**
   * http请求处理类
   */
  public class HttpsConnection extends abstractConnection{
      
      public doRequest(String url, String content){
  
          ......
  		//处理https请求
          ......
                
        }
      
  }
  
  /**
   * 客户端
   */
  public class Client{
      
      String url = "http://140.205.94.189:8848";
      String content = "hello world";
      //Connection conn = new HttpConnection();
      Connection conn = new HttpsConnection();
      conn.decode(content, "UTF-8");
      conn.doRequest(url, content);
      
  }
  
  /**
   * 服务端同时提供http和https服务
   */
  public class Server{
  
  }
  
  ```

   

  * 上面的代码中，我们把`Connection`由抽象类改为接口，并且增加了`AbstractConnection`类来统一处理请求编码问题，这样设计的原因如下：
    * 1.顶层的`Connection`接口是根据实际业务的共性行为抽象而来(比如`doRequest()`方法)，这个接口是不是随意更改的，对其自身我们要确保封闭性，它只能由具体的实现类去扩展使用。
    * 2.在整个继承体系中我们新增了`AbstractConnection`抽象类，专门用来处理类似于`decode()`这样的突发性需求(这一类行为是每个实现类都要使用的，而且不需要各自的特性实现)。新增一个类似的需求，只需要修改`AbstractConnection`类即可，而且子类只在有需要的情况下去调用该方法，不会有代码冗余。再者这个类被定义为一个抽象类，在保持开放性的同时也保证了自身的封闭性。
  * 回过头再看**开闭原则**，上面使用`decode()`请求编码的例子，阐述了如何解决**封闭破坏**的问题，但是我们还是提倡这些可变隐患能在系统设计之初就被意识到，尽管一个很大地问题是**开闭原则**的准确运用受到开发人员自身的软件开发经验以及业务熟悉程度的制约。当然我们也可以通过较为细致的测试过程来刺激变化，让那些可变因子尽可能早的暴露出来，使得开发人员能尽早地进行系统调整。

















