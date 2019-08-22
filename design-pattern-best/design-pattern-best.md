



# 设计模式

## 概述

### <a name="creational-head" name="#creational">创建型</a>

#### <a href="#simple-factory">简单工厂模式</a>

#### <a href="#factory-method">工厂方法模式</a>

#### <a href="#product-race-level">产品族-产品等级</a>

#### <a href="#abstract-factory">抽象工厂模式</a>

#### <a href="#builder">建造者模式</a>

#### <a href="#singleton">单例模式</a>

##### <a name="multithreading-safe-head" href="#multithreading-safe">单例模式线程安全</a>

##### <a name="double-check-synchronized-head" href="#double-check-synchronized">双重检查锁</a>

##### <a name="command-sort-head" href="#command-sort">程序指令重排</a>

##### <a name="volatile-head" href="#volatile">volatile</a>

##### <a name="static-inner-class-head" href="#static-inner-class">静态内部类</a>

##### <a name="lazy-hungry-compare-head" href="#lazy-hungry-compare">懒汉模式vs饿汉模式</a>

##### <a name="serializable-break-head" href="#serializable-break">序列化破坏单例</a>

##### <a name="reflection-break-head" href="#reflection-break">反射破坏单例</a>

##### <a name="signleton-enum-head" href="#signleton-enum">枚举类型单例</a>

##### <a name="container-head" href="#container">容器单例</a>

##### <a name="thread-local-head" href="#thread-local">线程单例 `ThreadLocal`</a>

##### <a name="singleton-in-sources-head" href="#singleton-in-sources">源码实践</a>

#### <a name="prototype-head" href="#prototype">原型模式</a>

##### <a name="clone-shallow-head" href="#clone-shallow">浅克隆</a>

##### <a name="clone-deep-head" href="#clone-deep">深克隆</a>

##### <a name="clone-singleton-break-head" href="#clone-singleton-break">克隆破坏单例</a>

### <a name="structural-head" href="#structural">结构型</a>

#### <a name="facade-head" href="#facade">外观模式</a>

#### <a name="decorator-head" href="#decorator">装饰器模式</a>

#### <a name="adapter-head" href="#adapter">适配器模式</a>

##### <a name="spring-mvc-head" href="#spring-mvc">源码实践`springmvc`</a>

#### <a name="flyweight-head" href="#flyweight">享元模式</a>

#### <a name="composite-head" href="#composite">组合模式</a>

#### <a name="bridge-head" href="#bridge">桥接模式</a>

#### <a name="proxy-head" href="#proxy">代理模式</a>

##### <a name="proxy-static-head" href="#proxy-static">静态代理</a>

##### <a name="proxy-dynamic-head" href="#proxy-dynamic">动态代理</a>

##### <a name="proxy-cglib-head" href="#proxy-cglib">CGLib</a>

##### <a name="proxy-spring-head" href="#proxy-spring">代理之`spring`</a>

##### <a name="proxy-performance-vs-head" href="#proxy-performance-vs">代理性能对比</a>

### <a name="behavioral-head" href="#behavioral">行为型</a>

#### <a name="template-method-head" href="#template-method">模板方法模式</a>

#### <a name="iterator-head" href="#iterator">迭代器模式</a>

#### <a name="strategy-head" href="#strategy">策略模式</a>

#### <a name="interpretor-head" href="#interpretor">解释器模式</a>

#### <a name="observer-head" href="#observer"> 观察者模式</a>

#### <a name="memento-head" href="#memento">备忘录模式</a>

  

## <a name="creational" href="#creational-head">创建型</a> 

### <a name="simple-factory">简单工厂</a>

* 定义
  
  * 由一个工厂对象决定创建出哪一种产品类的实例
  
* 类型
  
  * 创建型，不属于GOF23中的设计模式
  
* 适用场景
  * 工厂类负责创建的对象比较少
  * 客户端(应用层)只知道传入工厂类的参数，对于如何创建对象(逻辑)并不关心

* 优点
  * 只需要传入一个正确的参数，就可以获取所需要的对象而无需指定其创建细节
  * 从类的角度看，将所需要的功能服务作为参数方式进行传递，避免了无关类的引入
  
* 缺点
  * 工厂类的职责相对过重，增加新的产品需要修改工厂类的判断逻辑，违背开闭原则
  * 无法形成基于继承的等级结构

* `JDK`源码示例

  * `java.util.Calendar#createCalendar` 

  ![jdk-calender-example](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/simple-factory/calendar-example-1.png>)



### <a name="factory-method">工厂方法模式</a>

* 定义
  * 定义一个创建对象的接口，让实现这个接口的类来决定实例化哪个工厂方法
  * 让类的实例化推迟到子类种进行
* 类型：创建型
* 适用场景
  * 创建对象需要大量重复的代码
  * 客户端(应用层)不依赖于产品类实例如果被创建、实现等细节，使应用层与基础服务层解耦
  * 一个类通过其子类来指定创建哪个对象
  * 
* 优点
  * 用户只需要关心所需产品对应的工厂，无须关心创建细节
  * 加入新产品符合开闭原则，提高扩展性
* 缺点
  * 类的个数容易过多，增加复杂度
  * 增加了系统的抽象性和理解难度
* 源码示例

 `java.util.Collection#iterator` 不同的工厂实现类提供不同的实现内容

![source-code-example](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/factory-method/source-code-example.png>)



### <a name="product-race-level">产品族-产品等级</a>

* 产品族：产于同一厂商(工厂类)，但是每个产品完成的功能接口不同，并且产品之间相互联系，这个集合称之为**产品族**
* 产品等级：一系列具有相似功能(提供的接口功能相同)，来自于不同产地(工厂类)的产品，称它们处于同一个**产品等级**

![product-race-level-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/factory-method/product-level-2.png>)

注：`PythonVideo`、`JavaVideo`、`FEVideo`三者处于同一产品等级，Java视频教程和配套的Java文档形成Java教程产品族。

![product-race-level-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/factory-method/product-race-level-1.png>)



* 产品族、产品等级结构

![product-race-level-3](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/factory-method/product-race-level-3.png)



* 产品族

![product-race-level-4](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/factory-method/product-race-level-4.png)



* 一个产品族由同一个工厂生产

![product-race-level-5](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/factory-method/product-race-level-5.png)



* 生活实例-家电
  * 美的品牌(工厂)，拥有美的电冰箱、空调等产品
  * 格力品牌(工厂)，拥有格力电冰箱、空调等产品
  * 格力旗下的电冰箱、空调等产品同属于一个产品族：格力产品族；
  * 美的旗下的电冰箱、空调等产品同属于一个产品族：美的产品族；
  * 格力电冰箱和美的电冰箱处于同一产品等级
  * 格力空调和美的空调处于同一产品等级
  * 从格力工厂生产的电冰箱一定是格力电冰箱；从美的工厂生产的空调一定是格力空调；

> **工厂模式是适用于产品族、产品等级的一种抽象模型和解决方案**
>
> * 工厂方法模式关注于产品的等级结构
> * 抽象工厂模式关注于产品族



### <a name="abstract-factory">抽象工厂模式</a>

* 定义
  * 抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口
  * 无须指定他们具体的类
* 类型
  * 创建型
* 适用场景
  * 客户端(应用层)不依赖于产品类实例如何被创建、实现等细节
  * 强调一系列相关产品对象(属于同一产品族)一起使用创建对象时，需要大量重复的代码
  * 提供一个产品类库，所有的产品以同样的接口出现，从而使客户端不依赖于具体实现
* 优点
  * 具体产品在应用层代码隔离，无需关心创建细节
  * 将一个系列的产品族统一到一起创建
* 缺点
  * 规定了所有可能被创建的产品集合，产品族中扩展新的产品较为困难，需要修改抽象工厂的接口
  * 增加了系统的抽象性和理解难度
  * 扩展产品等级时，需要修改原先代码的实现

* 代码示例

![product-race-level-code](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/factory-method/product-race-level-code.png)

1. `Test`类作为客户端(应用层)，如果某个业务涉及到一个产品族产品的使用，只需要在该业务逻辑模块声明对应的工厂类、调用工厂类所提供的方法即可精准的获取相应产品；不用关心产品如何生产，生产的产品是否正确可用，比如调用 `JavaCourseFactory`工厂的方法，即可获取 `JavaVideo`、`JavaArticle`,不会有 `JavaCourseFactory`工厂生产 `Python`相关产品的风险
2. 新增一个产品族，只需要声明对应的工厂类和具体的产品即可，不会对原有业务造成影响，扩展新功能方便，快捷
3. 新增产品等级需要进行代码重构，比如在课程产品族中新增一个源码产品，所有代码都需要调整
4. 产品等级变更较为困难，产品族变更较为容易
5. 实际开发过程中，在需求分析阶段要尽可能详尽的做好业务模型的抽象，特别是在进行产品等级的定义时，要充分考虑到需求迭代变更的情况，使得程序更加健壮



### <a name="builder">建造者模式</a>

* 定义
  * 将一个复杂对象的构建与他的表示分离，使得同样的构建过程可以创建不同的表示
  * 用户只需要指定需要建造的类型就可以得到所需要的产品，建造过程及细节不需要指定
  * 如何一步步构建一个包含多个组件的对象，相同的构建过程可以构建不同的产品
* 类型
  * 创建型
* 适用场景
  * 如果一个对象有非常复杂的内部结构(很多属性)
  * 想把复杂对象的创建和使用分离
* 优点
  * 封装性好，创建和使用分离
  * 扩展性好、建造类之间独立、一定程度上解耦
* 缺点
  * 产生多余的`Builder`对象
  * 产品内部发生变化，构造者都要修改，成本较大
* 区别
  * 关注点不同
    * 建造者模式更注重方法的执行顺序(生产某个产品过程中不同方法步骤的执行顺序)，不仅要生产产品，还要知道产品是由哪些部件所组成
    * 工厂模式注重于创建产品，只关心生产产品的结果
    * 建造者模式下，不同的生产顺序，所产出的产品可能不同
    * 工厂模式生产的产品跟制造方法的顺序无关
  * 创建对象的粒度不同
    * 创建者模式创建内部构造较为复杂的产品，这些产品一般由各种复杂的组件组成
    * 工厂模式创建的对象结构较为简单



### <a name="singleton">单例模式</a>

* 定义

  * 保证一个类仅有一个实例，并提供一个全局访问点

* 类型

  * 创建型

* 适用场景

  * 想确保任何情况下都绝对只有一个实例

* 优点

  * 在内存里只有一个实例，减少了内存开销
  * 可以避免对资源的多重占用
  * 设置全局访问点，严格控制访问

* 缺点

  * 没有接口，扩展困难

* 重点

  * 私有构造器
  * 线程安全
  * 延迟加载
  * 序列化和反序列化安全
  * 反射


* 奇技淫巧
  * 反编译
  * 内存原理
  * 多线程`debug`
* 相关设计模式
  * 单例模式和工厂模式
  * 单例模式和享元模式

#### <a name="multithreading-safe" href="#multithreading-safe-head">单例模式线程安全</a>

* 相关代码

  * `LazySingleton` 单例类

    ![lazy-singleton](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/lazy-singleton.png>)

  * `T` 线程类

    ![thread](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/thread.png>)

  * `Test` 测试类

    ![test](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/test.png>)



* `idea` 多线程`debug`

  * 设置idea debug模式为 suspend-thread 模式

  ![idea-debug-suspend](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/idea-debug-suspend.png>)
  
  * 选择需要执行的线程，进行步进操作，进而**对线程执行过程进行人工干预，模拟多线程场景下线程安全的问题** 
  
  ![thread-choose](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/thread-choose.png>)

* 场景1：模拟多线程完全顺序执行，无线程安全问题

  1. 以`debug`模式运行`Test`类的`main`函数，步进启动`t1`线程和`t2`线程，当前运行线程：`main、Thread-0、Thread-1` 

     ![in-thread-main](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/multithreading-safe/in-thread-main.png>)

  2. 在`debug-Frames` 窗口中选择 `Thread-0` 线程，对线程`Thread-0`进行 `debug` ，**此时已经进入人工干预线程运行顺序的模式，这里对  `Thread-0` 进行步进，`main` 线程和 `Thread-1` 线程会处于阻塞状态（虽然Frames窗口显示三个线程都处于 `RUNNING` 状态，这是人工干预线程运行顺序结果）**，这时在`Thread-0`  下步进，直到`Thread-0` 执行完毕，这时查看静态变量 `lazySingleton` 被赋值为 `LazySingleton@515` 

     ![in-thread-0-value](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/multithreading-safe/in-thread-0-value.png>)

  3. 在`debug-Frames` 窗口中切换到 `Thread-1` 线程，查看静态变量 `lazySingleton` 的值为 `LazySingleton@515`  

     ![in-thread-1-value](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/multithreading-safe/in-thread-1-value.png>)

  4. 在 `Thread-1` 线程下步进，执行`if`逻辑代码，程序判断 `lazySingleton` 的为 `LazySingleton@515` 不为空，所以直接`return lazySingleton` ，显然 `Thread-1` 运行后结果， `lazySingleton` 静态变量值仍然是 `Thread-0` 线程执行的结果 `LazySingleton@515` ，程序运行完毕，控制台打印结果显示 `Thread-1`  `Thread-0` 运行结果相同。通过人工干预，两个线程在线程安全隐患：**静态变量赋值** 处顺序执行，无线程安全问题。

     ![in-thread-1-value-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/multithreading-safe/in-thread-1-value-1.png>)

     ![thread-end](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/multithreading-safe/thread-end.png>)



* 场景2：模拟多线程无顺序随机执行，抢占`cup`资源，出现线程安全问题

  1. 以`debug`模式运行`Test`类的`main`函数，步进启动`t1`线程和`t2`线程，当前运行线程：`main、Thread-0、Thread-1` 

     ![in-thread-main](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/multithreading-unsafe/in-thread-main.png>)

  2. 在`debug-Frames` 窗口中选择 `Thread-0` 线程，对线程`Thread-0`进行 `debug` ，**此时已经进入人工干预线程运行顺序的模式，这里对  `Thread-0` 进行步进，**，这时在`Thread-0`  下步进，程序判断 `lazySingleton` 的为 `null` 进入`if`代码块，这里先不执行 `lazySingleton = new LazySingleton()` 代码，切换到线程 `Thread-1` 

     ![in-thread-0-valuenull](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/multithreading-unsafe/in-thread-0-valuenull.png>)

  3. 在`debug-Frames` 窗口中选择 `Thread-1` 线程，对线程`Thread-1`进行 `debug` ，**此时已经进入人工干预线程运行顺序的模式，这里对  `Thread-1` 进行步进**，这时在`Thread-1`  下步进，程序判断 `lazySingleton` 的为 `null` 进入`if`代码块

     ![in-thread-1-valuenull](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/multithreading-unsafe/in-thread-1-valuenull.png>)

  4. 在`Thread-1`  下继续步进，执行 `lazySingleton = new LazySingleton()` 代码，对静态变量 `lazySingleton` 赋值为：`LazySingleton@511` 

     ![in-thread-1-value](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/multithreading-unsafe/in-thread-1-value.png>)

  5. 在`debug-Frames` 窗口中选择 `Thread-0` 线程，在`Thread-0`  下继续步进，执行 `lazySingleton = new LazySingleton()` 代码，对静态变量 `lazySingleton` 赋值为：`LazySingleton@512` 

     ![in-thread-0-value](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/multithreading-unsafe/in-thread-0-value.png>)

  6. 程序执行完毕，此时 `Thread-1`  `Thread-0` 完成对静态变量 `lazySingleton` 的赋值操作，具体的值分别为：`LazySingleton@511` 、`LazySingleton@512` ，跳步执行，程序执行完毕，控制台打印结果显示 `Thread-1`  `Thread-0` 运行结果不相同，破坏单例

     ![unsafe-result](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/multithreading-unsafe/multithreading-unsafe-result.png>)



* 多线程线程安全问题分析
  * 对于同一段程序代码，运行每一行代码 `cup` 都花费一定时间来计算逻辑、读取数据等
  * `cup` 计算运行多个线程程序时，由于操作系统的特性，资源的分配是随机的，每个线程计算某一行代码的时间会有偏差性，可能是不相同的，所以对于同一段代码、同一个方法、同一个类，线程A先进行调用执行，线程B后进行调用执行，但线程B先执行完毕，这种程序运行机制导致程序运行结果和程序设计逻辑相悖，比如多个线程操作同一个静态变量的场景等等
  * 以上面的例子来说，我们设计懒汉单例模式，是为了保证对象的唯一性，但是在进行`debug`干预后，我们发现多线程场景下是反单例的，当单例类比较重、逻辑比较复杂时，随着线程数量的不断增加，会在我们毫无察觉的情况下不断创建对象，对系统资源的消耗呈指数性增长，最终导致服务崩溃
  * 而这种问题在程序开发设计之初，乃至测试阶段不经过详细的分析、压测都很难被察觉发现，一旦问题暴露，就意味着整个服务的不可用

* 场景3：多线程场景下的单例模式加同步锁 `synchronized`，解决线程安全问题

  1. 以`debug`模式运行`Test`类的`main`函数，步进启动`t1`线程和`t2`线程，当前运行线程：`main、Thread-0、Thread-1` 

     ![multithreading-synchronized-safe-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/multithreading-synchronized-safe/multithreading-synchronized-safe-1.png>)

  2. 在`debug-Frames` 窗口中选择 `Thread-0` 线程，对线程`Thread-0`进行 `debug` ，**此时已经进入人工干预线程运行顺序的模式，这里对  `Thread-0` 进行步进**，这时在`Thread-0`  下步进，程序判断 `lazySingleton` 的为 `null` 进入`if`代码块，这里先不执行 `lazySingleton = new LazySingleton()` 代码，切换到线程 `Thread-1` 

     ![multithreading-synchronized-safe-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/multithreading-synchronized-safe/multithreading-synchronized-safe-2.png>)

  3. 在`debug-Frames` 窗口中选择 `Thread-1` 线程，对线程 `Thread-1`进行 `debug` ，这时发现`Thread-1`  处于 `MONITOR` 监听状态，无法继续向下执行

     * 由于 `LazySingleton` 类的 `getInstance()` 方法被 `synchronized` 关键字修饰，加锁变为同步方法，而该方法是由 `Thread-0` 线程先调用的，只有 `Thread-0` 将该方法执行完毕，`Thread-1`线程才能获得方法的执行权限，继续执行

     ![multithreading-synchronized-safe-3](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/multithreading-synchronized-safe/multithreading-synchronized-safe-3.png>)

  4.  `Thread-0` 线程执行完毕 `LazySingleton` 类的 `getInstance()` 方法， `Thread-1` 开始执行该方法，这时，由于在 `Thread-0` 线程执行过后，已经对静态变量 `lazySingleton` 完成赋值操作，不为空， `Thread-1` 线程下，直接返回 `lazySingleton` 的值，无线程安全问题

     ![multithreading-synchronized-safe-4](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-thread-unsafe/multithreading-synchronized-safe/multithreading-synchronized-safe-4.png>)
  
  * 注意
    *  `synchronized` 关键字虽然能够解决线程安全问题，但是这种同步加锁的方式会使程序性能下降
    * 对静态方法加 `synchronized` 锁，相当于对静态方法所在类加同步锁



#### <a name="double-check-synchronized" href="#double-check-synchronized-head">双重检查锁</a>

```java
public class LazySingletonDoubleCheck {

    public static LazySingletonDoubleCheck instance = null;

    private LazySingletonDoubleCheck(){

    }

    /**
     *  双重检查锁：提高程序性能，并确保只有一个线程来完成对象创建操作
     *      添加双重判断逻辑：
     *          内层加锁的同步判断逻辑保证多线程场景下，对象实例创建的单例性，解决线程安全问题；
     *          外层判断逻辑，确保在对象已经创建成功的情况下，线程不去执行加锁的同步代码，提高程序性能;
     */
    public static LazySingletonDoubleCheck getInstance(){

        if (instance == null){
            synchronized (LazySingletonDoubleCheck.class){
                if (instance == null){
                    instance = new LazySingletonDoubleCheck();
                }
            }
        }

        return instance;

    }

}
```



#### <a name="command-sort" href="#command-sort-head">程序指令重排</a>

* 问题描述

```java
public class LazySingletonDoubleCheck {

    public static LazySingletonDoubleCheck instance = null;

    private LazySingletonDoubleCheck(){

    }

    /**
     *  双重检查锁：提高程序性能，并确保只有一个线程来完成对象创建操作
     *      添加双重判断逻辑：
     *          内层加锁的同步判断逻辑保证多线程场景下，对象实例创建的单例性，解决线程安全问题；
     *          外层判断逻辑，确保在对象已经创建成功的情况下，线程不去执行加锁的同步代码，提高程序性能
     *  问题：指令重排
     */
    public static LazySingletonDoubleCheck getInstance(){

        if (instance == null){
            synchronized (LazySingletonDoubleCheck.class){
                if (instance == null){
                    instance = new LazySingletonDoubleCheck();
                    
                    /**
                     * java语言规范：所有线程在执行程序时必须遵守 intra-thread-semantics 规定：
                     *      保证重排序不会改变单线程内的程序运行结果
                     * 程序指令排序：提高程序的执行性能
                     */
                    
                    //1.分配内存给LazySingletonDoubleCheck对象

                    //3.对instance变量进行赋值(这一步可能会在2之前执行)

                    //2.初始化LazySingletonDoubleCheck对象
                    //------3.对instance变量进行赋值：将1中分配的内存指针(句柄)赋值给instance变量

                }
            }
        }

        return instance;

    }

}

```



![double-check-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/double-check-1.png>)



​		![double-check-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/double-check-2png.png>)

* 注意：多线程场景下，程序指令重排序可能将一个未初始化的对象引用暴露出来，从而导致不可预料的结果，虽然这种问题的出现具有一定的概率性的，但是作为程序隐患一定要进行消除

#### <a name="volatile" href="#volatile-head">`volatile`</a>

* 程序指令重排问题解决方案一：禁止指令重排序
  
* 使用 `volatile`关键字修饰变量，解决程序指令重排序问题
  
* 原理
  * 多线程场景下`cup`也有共享内存
  * 使用`volatile`关键字修饰变量后，所有的线程都能看到共享内存的最新状态，保证内存的可见性
  * 使用`volatile`关键字修饰的共享变量，在进行写操作时会多出一些汇编代码，起到以下作用：
    1. 防止重排序
    2. 实现可见性
       * 将当前处理器缓存行的数据，写回到系统内存。这个写回内存的操作会使得其他`cup`里已经缓存了该内存地址的数据无效；因为其他`cup`缓存的数据已经无效，所以这些`cup` 又从共享内存同步数据(从系统内存中重新把数据读到`cup`的缓存里)，这样就保证了内存的可见性，这里主要使用了**缓存一致性协议** 

* 代码

  ```java
  public class LazySingletonVolatile {
  
      /**
       *  volatitle:
       *      防止重排序
       *      实现可见性
       */
      public static volatile LazySingletonVolatile instance = null;
  
      private LazySingletonVolatile(){
  
      }
  
      public static LazySingletonVolatile getInstance(){
  
          if (instance == null){
              synchronized (LazySingletonVolatile.class){
                  if (instance == null){
                      instance = new LazySingletonVolatile();
                  }
              }
          }
  
          return instance;
  
      }
  
  }
  ```

  

#### <a name="static-inner-class" href="#static-inner-class-head">静态内部类</a>

* 程序指令重排问题解决方案二：基于类初始化的解决方案
  * 允许程序指令重排序，但不允许非构造线程看到构造线程的指令重排序
    * 构造线程：执行对象初始化操作的线程
    * 非构造线程：不执行`new`对象操作，而直接使用变量值的线程

* 原理

  ![static-inner-class](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/static-inner-class.png>)

  * 类的初始化
    * 生命周期： `class`被加载后，并且被线程使用之前
    * 初始化内容：
      * 执行类的静态初始化
      * 初始化在类中声明的静态变量
    * 根据 `java`语言规范，出现以下情况类会被立刻初始化
      1. 类的实例被创建，即 `new` 操作
      2. 类中声明的静态方法被调用
      3. 类中声明的一个静态成员被赋值
      4. 类中声明的一个静态成员被使用，并且这个成员不是一个常量成员
      5. 类为顶级类，并且在这个类中有嵌套的断言语句
    * 首次发生的时候，一个类将被立刻初始化(这里的类泛指包括接口`interface`在内的一切类)
  * `jvm`在类的初始化阶段，会获取一个锁，这个锁会同步多个线程对一个类的初始化
  * 图解
    * 比如上图中的 `线程0` 先调用静态内部类，那么 `线程0` 就是一个构造线程，它会持有静态内部类的初始化锁
    * 其他非构造线程如 `线程1` ，在 `线程0` 完成静态内部类的调用之前都处于`MONITOR`阻塞状态
    * 也就是说，即使静态内部类在完成对象创建和变量赋值操作时发生指令重排序情况，也只是在 `线程0` 执行方法期间，避免暴露未初始化对象的问题

#### <a name="lazy-hungry-compare" href="#lazy-hungry-compare-head">懒汉模式vs饿汉模式</a>

* 懒汉模式
  * 延迟加载，被调用时完成加载
  * 适用于内部构造较为复杂，内容较重，创建消耗资源较大的单例模型
* 饿汉模式
  * 类初始化时，就完成加载
  * 适用于内部构造简单，创建花费资源较少的单例模型



#### <a name="serializable-break" href="#serializable-break-head">序列化破坏单例</a>

* 代码示例

* 源码`debug`

  * 序列化反序列化破坏单例

    ![1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/serializable/serializable-1.png>)

  * `readResolve()` 避免序列化反序列化破坏单例问题

  1. 首先调用单例方法获取单例对象 `HungrySingleton@494` 

     ![2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/serializable/serializable-2.png>)

  2. 反序列化方法 `readObject()` 内部实现

     ![3](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/serializable/serializable-3.png>)

  3. `object`反序列化方法

     ![4](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/serializable/serializable-4.png>)

  4. 反序列化时默认会先创建一个新的对象 `HungrySingleton@781` 

     ![5](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/serializable/serializable-5.png>)

  5. 判断实现 `Serializable`接口的类是否有 `readResolve()`方法

     ![6](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/serializable/serializable-6.png>)

  6. `readResolve()`方法原理

     ![7](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/serializable/serializable-7.png>)

  7. `readResolve()`方法原理：`readResolve`方法名定义

     ![8](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/serializable/serializable-8.png>)

  8. 反射调用类中的`readResolve()`方法

     ![9](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/serializable/serializable-9.png>)

  9. 反射调用`readResolve()`方法内部实现

     ![10](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/serializable/serializable-10.png>)



#### <a name="reflection-break" href="#reflection-break-head">反射破坏单例</a>

* 通过反射机制，`new` 对象

  ```java
  public class Test {
  
      public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
  
          SingletonStaticInnerClass instance = SingletonStaticInnerClass.getInstance();
  
          Constructor constructor = SingletonStaticInnerClass.class.getDeclaredConstructor();
          //修改私有构造器的访问权限
          constructor.setAccessible(true);
          SingletonStaticInnerClass instance1 = (SingletonStaticInnerClass) constructor.newInstance();
  
          System.out.println(instance);
          System.out.println(instance1);
          System.out.println(instance == instance1);
  
      }
  
  }
  ```

* 防止反射攻击

  ```java
  public class SingletonStaticInnerClass {
  
      private SingletonStaticInnerClass(){
          //在构造器中添加判断，避免通过反射new对象
          if (InnerClass.instance != null){
              throw new RuntimeException("单例构造器，禁止反射");
          }
      }
  
      private static class InnerClass{
          private static SingletonStaticInnerClass instance = new SingletonStaticInnerClass();
      }
  
      public static SingletonStaticInnerClass getInstance(){
          return InnerClass.instance;
      }
  
  }
  ```

* 懒汉模式延迟加载场景下，防止反射破坏需要注意单例方法和反射方法的调用顺序

  * 单例类的私有方法中添加静态变量值的判断逻辑防止反射攻击

    ```java
    public class LazySingleton {
    
        /**
         *  由于静态变量需要在静态方法getInstance()调用时才被初始化，
         *  所以当反射生成单例对象执行在单例初始化对象方法之前时，
         *  通过在私有方法内部，添加变量值的判断来防止反射攻击并不奏效，
         *  在多线程场景下，因为每个线程执行代码的顺序具有随机性，所以这种情况很容易发生；
         */
        public static LazySingleton instance = null;
    
        private LazySingleton(){
            /**
             *  防止反射攻击
             */
            if (instance != null){
                throw new RuntimeException("单例构造器，禁止反射");
            }
        }
    
        public static synchronized LazySingleton getInstance(){
    
            if (instance == null){
                instance = new LazySingleton();
            }
            return instance;
    
        }
    
    }
    ```

  * 懒汉模式下，单例类私有构造方法中添加静态变量判断的方式不能防止反射攻击，特别是在多线程场景下

    ```java
    public class Test {
    
        public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    
            /**
             *  调用单例方法初始化对象，在反射初始化对象之前，
             *  通过在私有方法中添加静态变量值得判断能够防止反射攻击
             */
            LazySingleton instance = LazySingleton.getInstance();
            Constructor constructor = LazySingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            LazySingleton instance1 = (LazySingleton) constructor.newInstance();
    
            /**
             *  调用单例方法初始化对象，在反射初始化对象之后，
             *  通过在私有方法中添加静态变量值得判断不能防止反射攻击，
             *  这种情况在多线程场景中，很可能会发生
             */
    //        LazySingleton instance = LazySingleton.getInstance();
    
    
            System.out.println(instance);
            System.out.println(instance1);
            System.out.println(instance == instance1);
        }
    
    }
    ```

* 结论
  * 反射会破坏单例(懒汉、饿汉、静态内部类)
  * 通过在私有构造器中添加变量值的判断逻辑，可以防止反射攻击(饿汉、静态内部类)
  * 懒汉延迟加载单例模式不能防止反射攻击
    * 单线程场景下，与单例实例化对象方法和反射实例化对象方法的调用顺有关
    * 多线程场景下，代码的执行顺序不确定，一定会出现反射破坏单例的现象



#### <a name="signleton-enum" href="#signleton-enum-head">枚举类型单例</a>

* 单例模式最佳实践

  * **Effective Java** 强烈推荐推荐的单例模型实现方式

* 序列化破坏单例

  * 示例

    * 代码

      ```java
      /**
       *  枚举单例模型
       */
      public enum EnumSingleton {
      
          /**
           *  instance
           */
          INSTANCE;
      
          private Object data;
      
          public Object getData() {
              return data;
          }
      
          public void setData(Object data) {
              this.data = data;
          }
      
          public static EnumSingleton getInstance(){
              return INSTANCE;
          }
      }
      
      /**
       *  序列化反序列化测试类
       */
      public class Test {
      
          public static void main(String[] args) throws IOException, ClassNotFoundException {
              EnumSingleton instance = EnumSingleton.getInstance();
      
              ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton-enum"));
              oos.writeObject(instance);
      
              ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton-enum"));
              EnumSingleton instance1 = (EnumSingleton) ois.readObject();
      
              System.out.println(instance);
              System.out.println(instance1);
              System.out.println(instance == instance1);
      
          }
      }
      ```

    * 运行结果

      ![serializable-safe](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/enum-singleton/serializable-safe.png>)

  * 源码解析

    * `java.io.ObjectInputStream#readEnum()`

    * 枚举中的`name`是唯一的，并且每个name只对应一个枚举常量，所以源码中通过枚举读取到的反序列化对象，一定是唯一

    ![source-code-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/enum-singleton/source-code-1.png>)

  * 结论：**枚举单例模型，在序列化和反序列化过程中仍然保持单例性**

* 反射破坏单例

  * 示例

    * 代码

      ```java
      /**
       *  枚举单例模型
       */
      public enum EnumSingleton {
      
          /**
           *  instance
           */
          INSTANCE;
      
          private Object data;
      
          public Object getData() {
              return data;
          }
      
          public void setData(Object data) {
              this.data = data;
          }
      
          public static EnumSingleton getInstance(){
              return INSTANCE;
          }
      
      }
      
      /**
       *  枚举单例模型反射破坏测试类
       */
      public class Test {
      
          public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
              EnumSingleton instance = EnumSingleton.getInstance();
      
              Constructor constructor = EnumSingleton.class.getDeclaredConstructor();
              constructor.setAccessible(true);
              EnumSingleton instance1 = (EnumSingleton) constructor.newInstance();
      
              System.out.println(instance);
              System.out.println(instance1);
              System.out.println(instance == instance1);
      
          }
      }
      ```

    * 运行结果1：反射获取构造器异常

      * 报错原因1：枚举类型没有无参的构造函数

        ![reflection-constructor-error](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/enum-singleton/reflection-constructor-error.png>)

      * 源码解读：枚举类型有且仅有一个带参的构造函数

        ![enum-source-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/enum-singleton/enum-source-1.png>)

    * 运行结果2：

      * 根据枚举类型源码解读，返回获取枚举类型的带参构造函数

      * 报错原因2：无法通过反射创建枚举实例

        ![reflection-new-error](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/enum-singleton/reflection-new-error.png>)

      * `Constructor`类源码解析：**无法通过反射创建枚举类对象**

        ![constructor-source-enum-error](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/enum-singleton/constructor-source-enum-error.png>)



* 枚举类型源码解析

  * `EnumSingleton.java` 

    ```java
    public enum EnumSingleton {
    
        /**
         *  instance
         */
        INSTANCE;
    
        private Object data;
    
        public Object getData() {
            return data;
        }
    
        public void setData(Object data) {
            this.data = data;
        }
    
        public static EnumSingleton getInstance(){
            return INSTANCE;
        }
    
    }
    ```

  * `EnumSingleton.class`

    * 使用[**jad**](https://varaneckas.com/jad/)编译工具查看编译后的字节码文件

    ```java
    /**
     *  枚举类是final型：不能被继承
     */
    public final class EnumSingleton extends Enum
    {
    
        public static EnumSingleton[] values()
        {
            return (EnumSingleton[])$VALUES.clone();
        }
    
        public static EnumSingleton valueOf(String name)
        {
            return (EnumSingleton)Enum.valueOf(com/jinm/learning/design/pattern/creational/singleton/enumsingleton/reflection/EnumSingleton, name);
        }
        
        /**
         *  构造器私有：符合单例模式的设计思想，不允许外部实例化
         */
        private EnumSingleton(String s, int i)
        {
            super(s, i);
        }
    
        public Object getData()
        {
            return data;
        }
    
        public void setData(Object data)
        {
            this.data = data;
        }
    
        public static EnumSingleton getInstance()
        {
            return INSTANCE;
        }
    
        /**
         *  变量是static/final型
         */
        public static final EnumSingleton INSTANCE;
        private Object data;
        private static final EnumSingleton $VALUES[];
    
        /**
         *  通过静态代码块的方式实例化变量，不会延迟加载，是线程安全的
         *	在枚举类初始化加载时，枚举类中的变量就会声明初始化完成
         */
        static 
        {
            INSTANCE = new EnumSingleton("INSTANCE", 0);
            $VALUES = (new EnumSingleton[] {
                INSTANCE
            });
        }
    }
                                               
    ```

  * 枚举类型解析

    * 被final修饰的类：不能被继承扩展
    * 构造器私有：不允许外部实例化
    * 枚举类变量被`final/static`修饰：一旦初始化以后就不能被赋值修改
    * 枚举变量通过静态代码块赋值初始化：在类初始化加载时就完成变量赋值，由于类初始化同步锁的机制，也保证了其线程安全性
    * `Constructor` 类中限制了枚举类型反射初始化的操作，防止反射攻击
    * 序列化反序列过程中枚举对象的创建方式，防止序列化反序列破坏单例

  * 总结

    * 枚举类型的设计机制，与单例模式的设计思想高度吻合
    * 枚举类型是单例模型的最近实践

  * 枚举类扩展使用

    * 枚举类中声明方法

      * `EnumSingleton.java`

        ```java
        public enum EnumSingleton {
        
            /**
             *  declare enum method
             */
            INSTANCE{
                @Override
                protected void enumMethodTest(){
                    System.out.println("enum method test.....");
                }
            };
        
            /**
             *  该方法必须写，否则无法调用
             */
            protected abstract void enumMethodTest();
        
            public static EnumSingleton getInstance(){
                return INSTANCE;
            }
        
        }
        
        /**
         *  测试类
         */
        public class Test {
        
            public static void main(String[] args) {
        
                EnumSingleton instance = EnumSingleton.getInstance();
                instance.enumMethodTest();
        
            }
        }
        ```

      * `EnumSingleton.class`

        ```java
        public abstract class EnumSingleton extends Enum
        {
        
            public static EnumSingleton[] values()
            {
                return (EnumSingleton[])$VALUES.clone();
            }
        
            public static EnumSingleton valueOf(String name)
            {
                return (EnumSingleton)Enum.valueOf(com/jinm/learning/design/pattern/creational/singleton/enumsingleton/extensions/EnumSingleton, name);
            }
        
            private EnumSingleton(String s, int i)
            {
                super(s, i);
            }
        
            protected abstract void enumMethodTest();
        
            public static EnumSingleton getInstance()
            {
                return INSTANCE;
            }
        
        
            public static final EnumSingleton INSTANCE;
            private static final EnumSingleton $VALUES[];
        
            static 
            {
                INSTANCE = new EnumSingleton("INSTANCE", 0) {
        
                    protected void enumMethodTest()
                    {
                        System.out.println("enum method test.....");
                    }
        
                };
                $VALUES = (new EnumSingleton[] {
                    INSTANCE
                });
            }
        }
        ```




#### <a name="container" href="#container-head">容器单例</a>

* 概述
  * 和享元模式类似
  * 使用容器单例模型来统一管理多个单例对象

* 代码示例

  ```java
  public class ContainerSingleton {
  
  //    private static HashMap<String, Object> container = new HashMap<>();
  //    private static Hashtable<String, Object> container = new Hashtable<>();
      private static ConcurrentHashMap<String, Object> container = new ConcurrentHashMap<>();
  
      private ContainerSingleton(){
  
      }
  
      public static void putInstance(String key, Object value){
  
          /**
           *  双重检查锁确保单例
           */
          if (!container.containsKey(key)){
  
              synchronized (ContainerSingleton.class){
                  if (StringUtils.isNotBlank(key) && value != null){
                      if (!container.containsKey(key)){
                          container.put(key, value);
                      }
                  }
              }
  
          }
  
      }
  
      public static Object getInstance(String key){
          return container.get(key);
      }
  
  }
  ```

  

#### <a name="thread-local" href="#thread-local-head"> `ThreadLocal`线程单例</a>

* 概述
  * 保证线程唯一，确保每个线程内部的单例性
  * 不能保证整个应用全局唯一
  * 隔离了多个线程对数据的访问冲突
  * 多线程资源共享
    * 同步锁：以时间换空间的方式，线程需要排队等待
    * `ThreadLocal` ：以空间换时间的方式，多个线程创建多个对象，每个线程获取的对象都是唯一的，线程之间相互不会影响

* 代码示例

  ```java
  public class ThreadLocalSingleton {
  
      public static final ThreadLocal<ThreadLocalSingleton> threadLocal = new ThreadLocal<ThreadLocalSingleton>(){
          @Override
          protected ThreadLocalSingleton initialValue() {
              return new ThreadLocalSingleton();
          }
      };
  
      private ThreadLocalSingleton(){
  
      }
  
      public static ThreadLocalSingleton getInstance(){
          return threadLocal.get();
      }
  
  }
  ```



#### <a name="singleton-in-sources" href="#singleton-in-sources-head">源码实践</a> 

* `jdk Runtime` 

  * 饿汉单例模型实践

    ![jdk-runtime](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-in-source/jdk-runtime.png>)



* `spring` 

  * `org.springframework.beans.factory.config.AbstractFactoryBean` 

    ![spring-bean-factory-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-in-source/spring-bean-factory-1.png>)
    ![spring-bean-factory-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-in-source/spring-bean-factory-2.png>)

  * `spring`中单例模型的特点

    * 基于容器(如tomcat等)：如果一个主函数(`SpringBootApplication`)或一个应用启动了多个容器，那么在每个容器中都能拿到单例对象
    * `spring` 中的单例是`bean`作用域中的一种，被设置了单例属性实例的作用域贯穿于整个应用程序中，即在每个应用程序的上下文`context`中仅创建一个单例实例

* `mybatis` 

  * `org.apache.ibatis.executor.ErrorContext`

    ![mybatis-errorcontext](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/singleton-in-source/mybatis-errorcontext.png>)



### <a name="prototype" href="#prototype-head">原型模式</a> 

* 定义
  * 指原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象
  * 不需要指定任何创建的细节，不调用构造函数
* 类型
  
  * 创建型
* 适用场景
  * 类初始化消耗较多的资源
  * `new`产生一个的一个对象需要非常繁琐的过程(数据准备、访问权限等)
  * 构造函数比较复杂
  * 循环体中产生大量的对象时
* 优点
  * 原型模式是在内存中进行二进制流的拷贝，性能比直接`new`一个对象高
  * 简化创建过程
* 缺点
  * 必须配备克隆方法
  * 对克隆复杂对象或对克隆出的对象进行复杂改造时，容易引入风险
  * 深拷贝、浅拷贝要运用得当
* 原型扩展
  * 深克隆
    * 对于引用类型，如果需要让它们指向不同的对象，一定要使用深克隆
    * 深克隆某一个对象的引用类型时，要显示的去写对哪个具体的属性进行深克隆
  * 浅克隆

* 代码示例

  * 代码

    ```java
    /**
     * 类实现克隆方法
     */
    public class Mail implements Cloneable{
    
        private String name;
        private String address;
        private String content;
    
        public Mail(){
            System.out.println("mail class constructor");
        }
    
        /**
         *  实现Cloneable的clone()方法
         */
        @Override
        protected Object clone() throws CloneNotSupportedException {
            System.out.println("clone mail object");
            return super.clone();
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getAddress() {
            return address;
        }
    
        public void setAddress(String address) {
            this.address = address;
        }
    
        public String getContent() {
            return content;
        }
    
        public void setContent(String content) {
            this.content = content;
        }
    
        @Override
        public String toString() {
            return "Mail{" +
                    "name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", content='" + content + '\'' +
                    '}' + super.toString();
        }
        
    }
    
    /**
     * 测试类
     */
    public class Test {
    
        public static void main(String[] args) throws CloneNotSupportedException {
    
            Mail mail = new Mail();
            mail.setContent("初始化模板......");
            System.out.println("调用构造函数创建mail:" + mail);
            for (int i = 0; i < 5; i++) {
    
                Mail tempMail = (Mail) mail.clone();
                tempMail.setName("姓名" + i);
                tempMail.setAddress("姓名" + i + "@gmail.com");
                tempMail.setContent("恭喜你, 离秃头又近了一步");
                MailUtil.sendMail(mail);
                System.out.println("调用克隆方法创建mail:" + tempMail);
    
            }
    
            MailUtil.saveOriginRecord(mail);
    
        }
    
    }
    ```

  * 运行结果

    ![constructor-cloneable-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/prototype/constructor-cloneable-1.png>)

  

#### <a name="clone-shallow" href="#clone-shallow-head">浅克隆</a>

* 只克隆类当前的层次，不会克隆类内部的引用属性

* 代码示例

  * 代码

    ```java
    /**
     * 类实现克隆方法
     */
    public class People implements Cloneable{
    
        private String name;
        private Date birthday;
    
        public People(String name, Date birthday) {
            this.name = name;
            this.birthday = birthday;
        }
    
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public Date getBirthday() {
            return birthday;
        }
    
        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }
    
        @Override
        public String toString() {
            return "People{" +
                    "name='" + name + '\'' +
                    ", birthday=" + birthday +
                    '}' + super.toString();
        }
    }
    
    /**
     * 测试类
     */
    public class Test {
    
        public static void main(String[] args) throws CloneNotSupportedException {
    
            People p = new People("jack", new Date(0L));
            People p1 = (People) p.clone();
    
            System.out.println(p.toString());
            System.out.println(p1.toString());
            System.out.println("              ");
    
            p.getBirthday().setTime(520520520520520520L);
            System.out.println(p.toString());
            System.out.println(p1.toString());
    
        }
    
    }
    ```

  * 运行结果

    * 设置克隆实例的字段属性，会一并修改被克隆类的属性

      ![clone-shallow-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/prototype/clone-shallow-1.png>)

    * `debug`查找问题原因

      ![clone-shallow-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/prototype/clone-shallow-2.png>)



#### <a name="clone-deep" href="#clone-deep-head">深克隆</a>

* 对于类内部的引用类型属性也要重写克隆方法，克隆对象的同时也克隆对象中的引用类型属性

* 代码示例

  * 代码

    ```java
    /**
     * 实现克隆方法的类
     */
    public class People implements Cloneable{
    
        private String name;
        private Date birthday;
    
        public People(String name, Date birthday) {
            this.name = name;
            this.birthday = birthday;
        }
    
        @Override
        protected Object clone() throws CloneNotSupportedException {
    
            /**
             *  深克隆:
             *      单独对类的某个属性实现克隆方法
             */
            People p = (People) super.clone();
            p.birthday = (Date) p.birthday.clone();
            return p;
    
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public Date getBirthday() {
            return birthday;
        }
    
        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }
    
        @Override
        public String toString() {
            return "People{" +
                    "name='" + name + '\'' +
                    ", birthday=" + birthday +
                    '}' + super.toString();
        }
    }
    
    /**
     * 测试类
     */
    public class Test {
    
        public static void main(String[] args) throws CloneNotSupportedException {
    
            People p = new People("jack", new Date(0L));
            People p1 = (People) p.clone();
    
            System.out.println(p.toString());
            System.out.println(p1.toString());
            System.out.println("              ");
    
            p.getBirthday().setTime(520520520520L);
            System.out.println(p.toString());
            System.out.println(p1.toString());
    
        }
    
    }
    ```

  * 运行结果

    ![clone-deep-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/prototype/clone-deep-1.png>)

  * debug查找原因

    ![clone-deep-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/prototype/clone-deep-2.png>)



#### <a name="clone-singleton-break" href="#clone-singleton-break-head">克隆破坏单例</a>

* 代码示例

  * 代码

    ```java
    /**
     *  单例类
     */
    public class HungrySingleton implements Cloneable{
    
        private static HungrySingleton instance = new HungrySingleton();
    
        private HungrySingleton(){
    
        }
    
        public static HungrySingleton getInstance(){
            return instance;
        }
    
        /**
         *  单例类实现克隆方法
         */
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
    
    /**
     *  单例类
     */
    public class Test {
    
        public static void main(String[] args) throws CloneNotSupportedException {
    
            HungrySingleton instance = HungrySingleton.getInstance();
            HungrySingleton instance1= (HungrySingleton) instance.clone();
    
            System.out.println(instance);
            System.out.println(instance1);
            System.out.println(instance == instance1);
    
        }
    
    }
    ```

  * 运行结果

    ![singleton-break](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/prototype/singleton-break.png>)

  * 解决方案：重写`clone`方法确保单例

    * 代码

      ```java
      public class HungrySingletonSafe implements Cloneable{
      
          private static HungrySingletonSafe instance = new HungrySingletonSafe();
      
          private HungrySingletonSafe(){
      
          }
      
          public static HungrySingletonSafe getInstance(){
              return instance;
          }
      
          /**
           *  重写克隆方法实现
           */
          @Override
          protected Object clone() throws CloneNotSupportedException {
              return getInstance();
          }
      }
      ```

    * 运行结果

      ![singleton-break-safe](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/prototype/singleton-break-safe.png>)



#### 源码实践

* `java.util.ArrayList#clone()` 

  ![prototype-in-sources-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/prototype/prototype-in-sources-2.png>)

  ![prototype-in-sources-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/prototype/prototype-in-sources-1.png>)

* `java.util.HashMap#clone()` 

  ![prototype-in-sources-3](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/prototype/prototype-in-sources-3.png>)

  ![prototype-in-sources-4](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/prototype/prototype-in-sources-4.png)



## <a name="structural" href="#structural-head">结构型</a>

### <a name="facade" href="#facade-head">外观模式</a>

* 定义
  * 又称为门面模式，提供一个统一的接口，用来访问子系统中的一群接口
  * 外观模式定义了一个高层接口，让子系统更容易使用
* 类型
  
  * 结构型
* 角色
  * 外观角色
    * 知道子系统所有的方法
    * 有自己的方法
    * 客户端通过调用外观角色的方法来调用子系统的功能
  * 子系统
    * 并不是单独的类
    * 可以是一个或多个
    * 按照不同的维度分成不同的处理模块
    * 子系统形成一个集合为外观模式中的外观类提供子系统的服务
* 适用场景
  * 子系统越来越复杂，增加外观模式提供更简单的调用接口
  * 构建多层系统结构，利用外观对象作为每层的入口，简化层间调用
* 优点
  * 简化了调用过程，无需深入了解子系统，防止带来风险
    * 风险：对子系统直接集成调用，不会去修改其內部实现，不会带来风险
  * 减少系统依赖、松散耦合
    * 降低了客户端与子系统之间的耦合关系，客户端不与子系统直接交流，而是和外观对象进行交流，让子系统内部的模块更容易扩展和维护
  * 更好的划分访问层次
    * 对一个系统而言，有些方法需要暴露到系统外部使用，有些方法只能由内部系统调用
    * 把那些需要暴露在外部功能集中到外观类上，即方便客户端调用，也能很好的隐藏系统内部细节
  * 符合迪米特法则，即最少知道原则
    * 客户端不需要了解子系统内部的实现
    * 也不需要跟众多内部的子系统直接进行交互
* 缺点
  * 增加子系统、扩展系统的行为容易引入风险
  * 不符合开闭原则
* 相关设计模式
  * 外观模式和中介者模式
    * 外观模式关注的是外界和子系统之间的交互
    * 中介者模式关注的是各个内部子系统之间的交互
* 外观模式和单例模式
  
  * 通常会把外观模式中的外观对象结合单例模式进行设计
* 外观模式和抽象工厂模式
  
* 外观类可以通过抽象工厂获取子系统的实例，这样子系统可以在内部对外观类进行屏蔽
  
* 应用举例

  * 把积分兑换系统中信息校验、积分支付、物流子系统提供的服务设计为外观模式，客户端不需要直接与各个子系统进行交互

  ![facade-uml](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/facade/facade-uml.png>)



* 源码实践

  * `org.apache.catalina.connector.RequestFacade()` 

    ![tomcat-source-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/facade/tomcat-source-1.png>)

  * 在 `RequestFacade` 类中包装 `Request` 类，向外部暴露 `Request` 的相关操作方法

    ![tomcat-source-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/facade/tomcat-source-2.png>)



### <a name="decorator" href="#decorator-head">装饰器模式</a>

* 定义
  * 在不改变原有对象的基础上，将功能附加到对象上
  * 提供了比继承更有弹性的替代方案(扩展原有对象功能)
* 类型
  
  * 结构型
* 使用场景
  * 扩展一个类的功能或给一个类添加附加职责
  * 动态的给一个对象添加功能，并且这些功能可以再动态的撤销
* 优点
  * 继承的有力补充，比继承灵活，不改变原有对象的情况下给一个对象扩展功能
    * 通常使用继承就可以实现对象的功能扩展，如果需要扩展的功能种类繁多，势必生成许多子类，这样会增加系统的复杂性
    * 如果使用继承扩展类的功能，那么这些扩展功能就必须是可预见的，因为这些功能在编译时就确定了，是**静态**的
    * 在装饰器模式中，这些扩展功能是由用户或者应用层代码**动态**的决定加入的时间和方式
    * 装饰器模式提供了一套即插即用的方法，可以在程序运行期间决定何时加入何种功能
    * 装饰器模式本身也使用了继承，是建立在继承基础之上的模式，所以不能说用装饰器模式完全代替继承的实现方式
    * vs：继承能够实现程序功能的扩展，但不见得是弹性设计的最佳方式
  * 通过使用不同装饰类以及这些装饰类的排序组合，可以实现不同的效果
  * 符合开闭原则
    * 使用装饰器模式可以扩展对象的行为，并且具体的装饰者和被装饰者可以独立变化，新增功能，原有的代码不会改变
    * 从程序的角度来看，装饰器做的事情，是把类的装饰功能从类中移出去，简化了被装饰类的实现，同时把类的核心职责和装饰功能区分开，这样还可以去除相关类中的装饰逻辑
* 缺点
  * 会出现更多的代码，更多的类，增加程序复杂性
  * 动态装饰时，多层装饰时，程序复杂度急剧上升
    * 鉴于装饰器模式动态扩展的实现机制，它的实现过程比继承这种方式使用的类可能更少，但是比继承关系使用更多的对象，这会使得我们排查错误时更加的困难，并且这些装饰对象大多都是类似的，看上去非常的相像
    * 装饰器会继承被装饰对象，被装饰对象又有具体的实体，在类的机构层次上，装饰器拥有同一个父类，看起来是同一个对象，所以会增加排查错误的复杂度
* 相关设计模式
  * 装饰器模式和代理模式
    * 装饰器模式主要关注在给一个对象动态的添加功能和方法
    * 代理模式关注于控制对对象的访问
      * 代理模式中的代理类可以对其调用者隐藏被代理对象的具体信息
    * 使用方法不同
      * 通常在使用代理模式是，会在代理类中创建一个被代理对象的实例
      * 而在使用装饰器模式时，通常会把原始对象作为一个参数，传给装饰器类的构造器
  * 装饰器模式和适配器模式
    * 装饰器模式和适配器模式都可以称之为包装模式 `wrapper` ，在源码中有很多名称包含 `wrapper` 的类，通常都统称为包装类，至于具体是适配器模式还是装饰器模式，需要根据代码的设计结构和功能来进行判断，理性看待
    * 区别：
      * 装饰者和被装饰者都可以实现相同的接口，或者装饰者是被装饰者的子类
      * 在适配器模式中，适配器和被适配的类具有不同的接口，当然部分接口也有可能是重合的
    * 装饰者还可以退化成半装饰者，也就是说一个装饰器，除了提供被装饰类的接口外，还提供了其他的方法，即半透明的装饰器
  
* 代码示例

  * 场景：街边小贩卖煎饼，并计算煎饼价格

  * 使用继承的扩展方式实现需求

    ![code-uml-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/decorator/code-uml-2.png>)

  * 使用装饰器模式的扩展方式实现需求

    * 通过装饰器模式实现类的功能扩展后，类似这种加多个鸡蛋、多根香肠的需求，只需要在应用层调用相应的装饰器实例即可完成，不需要再对底层的类进行二次开发和扩展

    ![code-uml-3](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/decorator/code-uml-3.png>)



* 源码实践

  * `java.io.BufferedInputStream` 

    ![decorator-in-source-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/decorator/decorator-in-source-2.png>)

    ![decorator-in-source-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/decorator/decorator-in-source-1.png>)

  * `org.springframework.cache.transaction.TransactionAwareCacheDecorator` 

    ![decorator-in-source-3](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/decorator/decorator-in-source-3.png>)

  * `org.springframework.session.web.http.SessionRepositoryFilter.SessionRepositoryRequestWrapper` 

    ![decorator-in-source-4](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/decorator/decorator-in-source-4.png>)

    ![decorator-in-source-5](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/decorator/decorator-in-source-5.png>)

  * `org.apache.ibatis.cache.decorators.TransactionalCache` 

    ![decorator-in-source-6-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/decorator/decorator-in-source-6-1.png>)

    ![decorator-in-source-6](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/decorator/decorator-in-source-6.png>)

  
  

### <a name="adapter" href="#adapter-head">适配器模式</a> 

* 定义
  * 将一个类的接口(被适配者)转换成客户期望的另一个接口(目标类)
  * 使原本接口不兼容的类可以以前工作(如：手机、笔记本的电源适配器等)
  
* 类型
  
  * 结构型
  
* 适用场景
  * 已经存在的类，它的方法和需求不匹配时
    * 方法结果相同或相似
    * 为了复用一些现有的类，系统的数据和行为都匹配，但接口不符合的场景
    * 使原有对象和新接口相匹配
  * 不是软件设计阶段考虑的设计模式，而是随着软件迭代维护的不断演进，由于不同产品、不同厂家造成功能类似和接口不相同情况下的解决方案
    * 比如在进行新项目、新系统的开发时通常不会考虑使用适配器模式，它的作用更多的提现在**亡羊补牢**上
    * 随着项目不断地发展，需要兼容、利用旧系统功能，或者匹配外部系统的行为时，就可以使用适配模式的思想进行系统设计了
  
* 优点
  * 能提高类的透明性和复用性，现有的类复用但不需要改变，能够解决现有类和目标类不匹配的问题
  * 目标类和适配器类解耦，提高程序扩展性
  * 符合开闭原则
  
* 缺点
  * 适配器编写过程需要全面考虑，可能会增加系统的复杂性
  * 增加系统代码可读的难度

* 适配器-扩展
  * 对象适配器
    * 符合组合复用原则
    * 使用委托机制
  * 类适配器
    * 通过类继承来实现
  * 在对象适配器和类适配器之间优先选择对象适配器模式，类之间的组合关系更符合设计原则
  
* 相关设计模式
  * 适配器模式和外观模式
    * 二者都是对现有的类、现存系统的封装
    * 设计出发点不同
      * 外观模式定义了新的接口，目的是在现有系统的基础上提供一个更加方便地访问入口
      * 适配器模式则是复用原有的接口，它的作用是使两个已有的接口协同工作
    * 适配粒度不同
      * 外观模式是用来适配整个子系统或相关子系统，它所针对的对象粒度更大
      * 适配器模式注重在某一类功能行为的适配，比如接口

* 代码示例

  * 类适配器

    * 通过继承以及实现接口的方式建立被适配者和目标类之间的联系
  
    * 把目标接口 `Target` 的实现委托给被适配者`Adaptee` 去实现
    
    * `Adaptee` ---> 被适配者(系统中已有的功能)
    
    * `Target` ---> 定了目标对象行为规范
    
    * `ConcreteTarget` ---> 目标对象的具体实例(系统中的新功能)，可以看作被适配者的模板对象，被适配者在进行适配之后，能够具备和`ConcreteTarget`相像的行为
    
    * `Adapter` ---> 适配器，是连接被适配者(已有功能)和目标对象(新功能)的**转换器**，被适配者的行为经过**转换器**转换之后，会变为和目标类实例相像的行为，这样新系统能够调用目标类实例，同样也可以通过适配器调用被适配者的功能，实现了在不改变旧功能的前提下，使用旧系统所提供的功能
    
      ```java
      public class Adaper extends Adaptee implements Target{
      
          /**
           *  类适配器：
           *      把Adaptee适配给Target
           *      建立被适配对象和适配后的目标之间的联系
           *      继承被适配对象，并实现目标类的接口规范，
           *      从而使得旧功能Adaper#adapteeRequest()，符合目标类Target#request()定义的规范，建立两者之间的联系
           */
          @Override
          public void request() {
      
              //......适配逻辑代码
              super.adapteeRequest();
              //......适配逻辑代码
          }
      
      }
      ```
    
      
    
      ![adapter-code-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/adapter/adapter-code-1.png>)
    
  * 对象适配器
  
    * 在`Adapter` 中直接声明 `Adaptee` 被适配者，并调用其方法，将目标接口 `Target` 的实现委托给`Adaptee` 处理
  
    * 在适配器中声明被适配者，并调用其方法，是类之间的组合关系
  
      ```java
      public class Adapter implements Target{
      
          /**
           *  对象适配器：
           *      在适配器中声明被适配者，并调用其方法，
           *      即通过组合的方式，将目标接口 Target 的实现委托给目标类 Adaptee 去处理
           */
          private Adaptee adaptee = new Adaptee();
      
          @Override
          public void request() {
      
              //......适配逻辑代码
              adaptee.adapteeRequest();
              //......适配逻辑代码
      
          }
      
      }
      ```
  
      
  
      ![adapter-object-code-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/adapter/adapter-object-code-2.png>)



* 源码实践

  * `org.springframework.aop.framework.adapter.AdvisorAdapter` ---> `org.springframework.aop.framework.adapter.MethodBeforeAdviceAdapter`

    ![adapter-source-springaop-1](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/adapter/adapter-source-springaop-1.png)

    ![adapter-source-springaop-2](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/adapter/adapter-source-springaop-2.png)

  * `org.springframework.orm.jpa.JpaVendorAdapter` ---> `org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter` 

    ![adapter-source-springdatajpa-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/adapter/adapter-source-springdatajpa-1.png>)

    ![adapter-source-springdatajpa-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/adapter/adapter-source-springdatajpa-2.png>)



#### <a name="spring-mvc" href="#spring-mvc-head">`springmvc` 源码实践</a> 

* `org.springframework.web.servlet.DispatcherServlet` 

  * `spring-webmvc` 中的核心类，可以把它看作是适配器中的`client` 、代码示例中的`Test` 
  * 处于上帝视角，主要的作用在于通过处理映射器 `HandlerMapping` 来找到对应的 `Handler`
    * `Handler` ---> `Controller/Servlet/HttpRequestHandler`  
  * 同时执行`Handler` 中的对应方法，并返回 `ModelAndView` 
  * `org.springframework.web.servlet.DispatcherServlet#doDispatch(HttpServletRequest request, HttpServletResponse response)` 

  ![adapter-source-springwebmvc-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/adapter/adapter-source-springwebmvc-1.png>)
  ![adapter-source-springwebmvc-3](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/adapter/adapter-source-springwebmvc-3.png>)

  * `org.springframework.web.servlet.DispatcherServlet#getHandlerAdapter(Object handler)` 

  ![adapter-source-springwebmvc-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/adapter/adapter-source-springwebmvc-2.png>)

* `org.springframework.web.servlet.HandlerAdapter` 

  *  `HandlerAdapter` 接口类，定义了该类型适配器的适配规则

  ![adapter-source-springwebmvc-5](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/adapter/adapter-source-springwebmvc-5.png>)

  * 多种适配器实例，适配相应的请求，并进行相应的逻辑处理

  ![adapter-source-springwebmvc-6](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/adapter/adapter-source-springwebmvc-6.png>)

* `org.springframework.web.servlet.mvc.Controller` 

  ![adapter-source-springwebmvc-4](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/adapter/adapter-source-springwebmvc-4.png>)

* 设计思想

  * 以 `Controller` 为例，它包含的多实现对象
  * 按照一般思维，一个请求到达 `DispatcherServlet` 后，我们可以通过类似于 `instanceof` 的方式，通添加分支判断，实现请求路由，将不同类型请求对应到不同的处理逻辑中去。如果这样设计，当增加一中新的 `Controller` 类型时，就必须修改`DispatcherServlet` 类的判断逻辑，并且`Handler` 对象和 `Controller` 对象之间并未相互关联，这样就很难实现多类型请求的处理

  * 使用适配器模式，进行请求处理逻辑设计，将被适配对象 `Handler` 拿到的请求，通过适配器委托到相应的 `Controller` 实现对象中，这样不仅简化了 `DispatcherServlet` 请求处理逻辑，并且如果新增 `Controller` 类型时，只需要增加一个相应的适配即可，不需要对原有的代码逻辑进行修改，符合设计模式指导原则



### <a name="flyweight" href="#flyweight-head">享元模式</a> 

* 定义

  * 提供了减少对象数量从而改变应用所需的对象结构的方式
  * 运用共享技术有效地支持大量细粒度的对象
  * 减少创建对象的数量，从而减少内存占用，提高性能
  * 系统中如果存在大量的对象时，就有可能造成内存溢出，把其中有共同部分抽象出来，如果有相同的业务请求，直接返回内存中的已有对象，避免重复创建
  * 关注点在共享

* 类型

  * 结构型

* 适用场景

  * 常常应用于系统底层的开发，以便解决系统的性能问题

    * `Java`中的`String`类型：如果已经有则直接返回，如果没有则创建该字符串，并且保存在字符串缓存池中
    * 数据库连接池：数据库连接保存在连接池中，需要时直接拿来用，用完了放回去

  * 系统有大量的相似对象，需要缓冲池的场景

    * 一个系统中存在大量的细粒度对象，并且这些细粒度对象的状态中，有大部分都可以外部化(享元模式状态：外部化、内部化)
    * 如果软件系统不依赖于这些相似对象的身份，即随便获取一个对象，假设它们都是相同的，无法分辨出来，这种场景下都可以使用享元模式
    * 第一个享元对象肯定是占用内存的，如果该对象的使用率较高的化，使用享元模式进行对象设计，非常划算

    * 所以在有非常多的享元对象可供共享时，才值得我们使用享元模式，如果对象的复用度较低，使用享元模式的价值并不大

* 优点

  * 减少对象的创建，降低内存中对象的数量，降低系统的内存，提高效率
  * 减少内存之外其他资源的占用率
    * 其他资源：
      * 时间：创建对象时需要的时间。通过使用享元模式共享对象，可以减少使用`new`关键字创建实例的次数，也就提高程序的运行速度，降低响应耗时
      * 操作系统中的文件句柄和窗口句柄：在不同的操作系统中，可以同时使用的窗口句柄和文件句柄的数量都是有限的，如果不进行共享对象，应用程序在运行时很容易达到资源极限，从而导致程序崩溃

* 缺点

  * 关注内/外部状态，关注线程安全问题
    * 在使用享元对象进行程序设计时，一般情况下会使用`HashMap`
    * 如果出于线程安全问题角度考虑而使用`HashTable`，会因为同步锁的存在而排队等待，有可能得不偿失
    * 折中办法是使用`ConcurrentHashMap` 兼顾性能和线程安全问题
  * 使系统、程序的逻辑复杂化
    * 使用享元对象，需要分离出外部状态和内部状态，而且外部状态不应该随着内部状态的变化而变化，否系统就混乱了，这种内部的实现机制会提高系统的复杂度。
    * 例如`jdk`中`Integer`类型，使用了享元模式，其中的缓存机制，在对象判等时会给开发人员造成困惑

* 扩展

  * 内部状态
    * 在享元模式内部，并且不随着外部环境的改变而改变的共享部分
    * 可以看作为享元模式的一个属性，这个属性不会随着外部环境的改变而变化
  * 外部状态
    * 记录在享元模式外部，会随着外部环境的改变而改变
    * 在调用享元模式获取享元对象时，通过方法的参数，传入一个状态，不同状态对应不同的表现
  * 举例
    * 比如使用程序画一个圆形，如果圆形类的属性半径声明在对象内部，并且是固定不变的，这个属性就称之为是内部状态
    * 如果圆形类要根据传入参数的不同，而画出不同大小的圆形，这时对半径这个属性可以在外部进行设置、传入，此时这个属性就是外部状态

* 相关设计模式

  * 享元模式和代理模式
    * 在使用代理模式对一个类进行代理时，如果生成代理类所花费的时间和资源都比较多，这时可以与享元模式结合使用，提高程序的处理速度
  * 享元模式和单例模式
    * 二者的共同点在于对象的复用
    * 单例模式中的容器单例，就是享元模式和单例模式的结合使用

* 代码示例

  * 场景：某公司要求公司内部的各个部门做年终总结报告，每个部门可能会进行多次报告，如果某个部门已经完成过一次报告，那么当该部门需要再次做报告时，不需要生成新的报告文件。
  * 角色：部门、部门负责人。

  ![code-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/flyweight/code-1.png>)

  * 主要类

  ```java
  /**
   *  员工创建工厂类
   */
  public class EmployeeFactory {
  
      //对象池：单例容器
      private static final Map<String, Employee> EMPLOYEE_MAP = new HashMap<String, Employee>();
  
      public static Employee getManager(String department){
  
          //享元共享设计：如果没有创建并保存，如果有直接获取
          Manager manager = (Manager) EMPLOYEE_MAP.get(department);
          if (manager == null){
  
              manager = new Manager(department);
              System.out.print("创建 " + department + " 负责人;" );
              String reportContent = department + "部门汇报：此次汇报的主要内容是......";
              manager.setReportContent(reportContent);
              System.out.println(" 创建报告 " + reportContent);
              EMPLOYEE_MAP.put(department, manager);
  
  
          }
          return manager;
  
      }
  
  }
  
  /**
   *  测试类
   */
  public class Test {
  
      private static final String[] DEPARTMENTS = {"RD", "QA", "PM", "BD"};
  
      public static void main(String[] args) {
  
          for (int i = 0; i < 10; i++) {
              String department = DEPARTMENTS[(int) (Math.random() * DEPARTMENTS.length)];
              Manager manager = (Manager) EmployeeFactory.getManager(department);
              manager.report();
          }
  
      }
  
  }
  ```

  * 运行结果：第一次调用时创建，以后调用直接从对象池获取

  ![code-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/flyweight/code-2.png>)

* 源码实践

  * `jdk Integer`

    * `java.lang.Integer#valueOf(int)` 
    * 享元模式共享设计：当对象在缓存范围内则直接返回，否则new一个

    ![source-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/flyweight/source-1.png>)

  * `java.lang.Integer.IntegerCache` 

    ![source-3](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/flyweight/source-3.png)

  * 代码验证运行结果

    ![source-2](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/flyweight/source-2.png)

  * `apache` 连接池

    * `org.apache.commons.pool2.impl.GenericKeyedObjectPool#borrowObject(K, long)` 

      ![source-4](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/flyweight/source-4.png>)

    * `org.apache.commons.pool2.impl.GenericKeyedObjectPool#register` 

      ![source-5](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/flyweight/source-5.png)

    * `org.apache.commons.pool2.impl.GenericKeyedObjectPool#poolMap` 

      ![source-6](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/flyweight/source-6.png)



### <a name="composite" href="#composite-head">组合模式</a>

* 定义

  * 将对象组合成树形结构以表示"部分-整体"的层次结构
    * 例如树形结构的菜单，菜单中包含子菜单，也有子菜单的子菜单，这种树形结构模型就可以使用组合模式。还有文件/目录、`git`中`commit`对象`tree`对象等类似的层级结构
  * 组合模式使客户端对单个对象和组合对象保持一致的方式处理
  * 在组合模式中，用树形的方式创建对象的结构，树里面包含了组合以及个别的对象，可以把相同的操作应用在组合和组合中的个别对象上，这样在业务模型中就可以忽略对象组合与个别对象的差别，对个别对象和组合对象可以一视同仁

* 类型

  * 结构型

  ![node-1](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/composite/node-1.png)

* 适用场景

  * 希望客户端可以忽略组合对象与单个对象的差异时
  * 处理一个树形结构时

* 优点

  * 清楚的定义分层次的复杂对象，表示对象的全部或部分层次
  * 让客户端忽略了层次的差异，方便对整个层次结构进行控制
  * 简化客户端代码。可以统一处理个别对象和组合对象
  * 符合开闭原则。在组合模式中增加新的节点、子节点、叶子节点都异常方便，无需对现有的类库进行修改

* 缺点

  * 限制类型较为复杂
    * 在使用组合模式时，不能用类型系统来施加约束，因为它们都来自于相同的抽象层(节点的抽象层)，在这种情况下，程序必须在运行时进行类型检查，做动态类型判断，而实现类型限制的过程是非常复杂的。例如在某个文件夹中只能包含文本文件。这种有别于其他节点的类型控制也可以认为是组合模式中，组合对象和个别对象的个性化差异。
  * 使设计变得更加抽象
    * 如果业务模型涉及的逻辑非常复杂，那么在使用组合模式进行设计时挑战性会非常大，因为逻辑较为复杂的业务模型中，常常会出现独立于通用体系之外的一些对象类型，这些特例使得组合模型的运用充满挑战

* 相关设计模式

  * 组合模式和访问者模式
    * 可以使用访问者模式来访问组合模式中的递归结构

* 代码示例

  * 场景：某教育网站的视频课程，不同层级的课程目录、课程，组合关系实现

    ![code-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/composite/code-2.png>)
    
    ![code-3](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/composite/code-3.png)
    
  * 代码解析
  
    * 组合模式缺点
  
      * 如果动态的对组合类型进行限制，会增加代码的复杂度
      * 例如代码示例中一级主目录、二级子目录、一级课程、二级课程，为了达到层次结构的展示效果，需要按照级别进行行缩进，这时候不同级别的目录和课程缩进的幅度大小就是组合类型限制的一个体现，需要进行动态的类型判断
  
    * 组合模式设计要点
  
      * 做好最上层的抽象组件的定义规则分析，比如抽象的方法的参数、返回值都要结合实际业务合理设计
      * 组合对象实例和单体实例对组合抽象组件的覆写要结合具体的业务逻辑，方法的覆写要保证业务相关性
        * 例如，如果例子中的目录实例覆写的价格方法，那么它可能返回的是该目录下所有课程的总价格，否者覆写无效，所以要结合实际业务场景仔细分析每个组合对象/个体对象的业务逻辑，合理设计代码
      * 树形结构中各个节点、叶子节节点之间的关系也要分析透彻
        * 例如不同层级的课程目录和课程之间行缩进的问题，如果需要让目标排版显示更清晰的层级关系，那么还要在目录中定义一个`level`属性，用于区分不同级别的组合模型和个体模型
  
* 源码实践

  * `java.util.HashMap#putAll` 

    ![source-1](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/composite/source-1.png)

  * `java.util.ArrayList#addAll(java.util.Collection<? extends E>)` 

    ![source-2](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/composite/source-2.png)
  
  * `org.apache.ibatis.scripting.xmltags.MixedSqlNode` 
  
    ![source-3](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/composite/source-3.png)
  
    ![source-4](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/composite/source-4.png)
  
* 总结

  * 叶子节点和组合节点都要实现相同的接口或者继承相同的抽象类
  * 当叶子节点和组合节点之间建立了关联关系(实现相同的接口/者继承相同的抽象类)后，才能将这些树形结构中叶子节点和组合节点进行一致性处理



### <a name="bridge" href="#bridge-head">桥接模式</a>

* 定义
  * 将抽象部分与它的具体实现部分分离，使它们都可以独立地变化，即在一定程度上实现解耦
    * 抽象：忽略一些信息，把不同的实体当作同样的实体对待
    * 实现：将抽象化的模型具体化
    * 桥接模式的重点是理解抽象部分和具体实现部分的关系以及设计模型
  * 通过组合地方式建立两个类之间的联系，而不是继承
  * 桥接模式是通过组合的方式建立两个类之间的关系，符合设计原则中的合成复用原则，优先使用组合的方式。
  * 桥接模式的重点是理解
* 类型
  * 结构型
* 适用场景
  * 抽象和具体实现之间需要增加更多的灵活性时
    * 使用桥接模式可以避免在抽象和实现这两个层次之间直接建立静态关系
    * 通过桥接模式使抽象和实现之间建立有别于继承的关联关系，而且抽象部分和实现部分都可以以继承的方式独立扩展，并且互不影响，进而动态的将一个抽象化的子类对象和一个具体实现化的子类对象进行组合，提高两者之间的灵活性
    * 实现了抽象化对象和实现化对象之间的解耦
  * 一个类存在两个或多个独立变化的维度，并且这两个或多个维度都需要独立进行扩展
    * 抽象部分和具体实现部分都可以独立扩展
  * 不希望使用继承，或因为多层继承导致系统类的个数剧增的场景
* 优点
  * 分离抽象部分及其具体实现部分
    * 桥接模式使用了组合建立二者之间的关系，解耦了抽象和具体实现之间固有的绑定关系，使抽象和实现可以沿着各自的维度来变化扩展，即抽象和实现并不处于同一个继承层次结构中，从而通过组合来获得多维度的组合对象
  * 提高了系统的可扩展性
    * 在抽象和具体的实现部分，进行任意维度的扩展，都不需要修改原有的系统，因为两者之间是弱关系
  * 符合开闭原则
  * 符合合成复用原则
* 缺点
  * 增加了系统的理解与设计难度
    * 类之间的关系建立在抽象层，所以在系统设计之初就要对抽象层进行详尽的设计
  * 需要正确的识别出系统中两个独立变化的维度
    * 需要对业务模型较为熟悉，且在该领域有一定的经验积累，还要有可预见性
* 相关设计模式
  * 桥接模式和组合模式
    * 组合模式强调的是部分和整体间的组合
    * 桥接模式强调的是同一平行级别上，不同类的组合
  * 桥接模式和适配器模式
    * 共同点
      * 二者都是为了两个组件之间能够更好的协同配合进行工作
    * 不同点
      * 适配器模式的目的是改变已有的接口，让它们之间可以相互配合。适配器模式可以把功能相似但是接口不同的类适配起来。
      * 桥接模式是为了分离抽象和具体实现之间的静态关系，目的在于分离。桥接模式是把类的抽象和类的具体实现分离开，在此基础上使这些层次结构结合起来。



* 代码示例

  * 场景：不同银行拥有不同类型的银行账户，账户行为包括打开账户、展示账户类型

    * 在桥接模式的运用过程中，很重要的一点是要划分清楚桥两侧的抽象层、和实现层
    * 如下图
      * 左侧为实现层，即桥的实现接口；
      * 右侧为抽象层，通过组合方式，调用了实现层的方法，即建立桥接关系，这样就把抽象层的行为委托给了实现层。
      * 中间的`uml`类图中的组合关系菱形箭头，就是两个层次结构之间的桥梁，即桥接关系

  * 如果使用类的继承关系来实现这个需求，那么，必须在每个银行实现类中都创建不同类型的银行账户子类对象，这样在银行种类和账户类型较多的情况下，会出现子类爆炸的情况，所以桥接模式也是简化代码量的一种上佳选择

  * 桥接模式符合合成复用原则，实现层和抽象层相互独立，可以按照各自的维度扩展，再增加新的银行种类或银行账户类型时，不需要修改桥对岸的实现逻辑，所以使用桥接组合的方式优于继承

    ![code-1](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/bridge/code-1.png)

* 源码实践

  * `java.sql.Driver` ---> 桥接模式中的实现层

    * `java` 定义数据库驱动的实现规范

    ![source-1](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/bridge/source-1.png)

  * `java.sql.DriverManager` ---> 桥接模式中的抽象层

    * `java` 数据库驱动管理类

    ![source-2](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/bridge/source-2.png)

    ![source-3](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/bridge/source-3.png)

    ![source-4](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/bridge/source-4.png)

  * `com.mysql.jdbc.Driver` ---> 实现层的具体实现类

    ![source-5](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/bridge/source-5.png)

  * 源码解析

    * 通过桥接模式设计数据库驱动代码结构，不同类型的驱动只需要执行统一的实现层接口`Driver` 即可，新增驱动类型不用修改抽象层的代码逻辑
    * 实现层和抽象层都可以沿着各自的维度进行扩展互不影响，如 `com.mysql.jdbc.Driver` 在实现 `java.sql.Driver` 接口的同时也继承了 `com.mysql.jdbc.NonRegisteringDriver` 类，这个类和抽象层并无关系
    * 抽象层可以直观的认为是调用者，它调用实现层的实现类提供的方法，来完成自己的行为，而这种调用关系是通过桥接的方式，委托实现的

### <a name="proxy" href="#proxy-head">代理模式</a> 

* 定义
  * 为其他对象提供一种代理，以控制对这个对象的访问
  * 代理对象在客户端和目标对象之间起到中介的作用
    * 代理对象是对目标对象的增强，相当于一个中介，客户端不直接与目标对象打交道，比如房屋中介增强了租房这个行为
* 类型
  * 结构型
* 适用场景
  * 保护目标对象
    * 例如租房子，在租房合同签订的过程中，我们不知道房东长啥样，姓谁名谁
  * 增强目标对象
    * 如房屋中介在租房这件事上，可能比房东更加专业，那么中介这个代理对象从一定意义上增强了房东的租房行为
* 优点
  * 代理模式能将代理对象与真实被调用的目标对象分离
  * 一定程度上降低了系统的耦合度，扩展性好
  * 保护目标对象
  * 增强目标对象
* 缺点
  * 代理模式会造成系统设计中类的数目增加
  * 在客户端和目标对象之间增加一个代理对象，会造成请求处理速度变慢
  * 增加系统的复杂度

#### <a name="proxy-static" href="#proxy-static-head">静态代理</a> 

* 定义
  * 在代码中显式指定代理
  * 即在代码中显式的定义了业务类的一个代理，并在代理类中对同名的方法进行包装，用户通过调用代理类中被包装过的业务方法来调用目标对象的业务方法，同时对目标对象的业务方法进行增强

#### <a name="proxy-dynamic" href="#proxy-dynamic-head">动态代理</a> 

* 定义
  * 动态代理类无法代理类，可以代理接口
  * 只能对实现了某个接口的类进行动态代理，并不能对一个具体实现类进行动态代理
    * 如 `jdk` 中，用到的代理类，是在程序调用到代理类对象时才由`jvm`真正创建
    * `jvm`根据传入的业务实现类对象，以及方法名，动态的创建了一个代理类的`.class`文件，并且这个`.class`文件被字节码引擎执行，然后再通过该代理类的对象进行方法调用
  * 通过接口中的方法名，在动态生成代理类中调用业务实现类的同名方法

#### <a name="proxy-cglib" href="#proxy-cglib-head">`CGLib`</a> 

* 定义
  * 针对类实现进行代理
  * 通过继承的机制实现，生成的动态代理类就是业务类的子类，再通过重写业务方法进行代理
* 原理
  * 如果我们代理一个类，`CGLib`会生成一个被代理类的子类，覆盖父类中的方法，也就是继承和重写，

#### <a name="proxy-spring" href="#proxy-spring-head">`spring` 中的代理选择</a> 

* 当`Bean` 有实现接口时，`spring` 就会用 `jdk` 的动态代理

* 当`Bean` 没有实现接口时，`spring` 使用 `CGLib` 的动态代理

* 可以强制使用 `CGLib` 

  * 在 `spring` 配置中加入 `<aop:aspectj-autoproxy proxy-target-class="true"/>` 

  * <https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html> 

#### <a name="proxy-performance-vs" href="#proxy-performance-vs-head">代理性能对比</a> 

* 原理
  * `CGLib ` 
    * `CGLib ` 底层使用了`ASM` (一个短小精悍的字节码操作框架)来操作字节码生成新的类
    * 通过这种方式比使用 `java` 反射效率要高
    * 但是在使用 `CGLib ` 时一定要关注  `final` 修饰符
  * `JDK` 动态代理
    * `JDK` 原生的代理实现
* 性能对比
  * 例如在万级次数执行的情况下 `jdk7` 和 `jdk8` 的动态代理性能大约比 `CGLib ` 快20%左右

#### 相关设计模式

* 代理模式和装饰者模式
  * 实现较为相似
  * 目的不同
    * 装饰者模式
      * 为对象加上行为
    * 代理模式
      * 控制访问
      * 更加注重通过设置代理对象的方式来增强目标对象，这些增强方式一般体现在增强目标对象的某些行为
* 代理模式和适配器模式
  * 适配器模式
    * 主要考虑改变目标对象的接口
  * 代理模式
    * 不能改变目标类的接口

#### 代码示例

* 要点

  * 在设计代理类时要注意目标对象被增强方法实现逻辑中的先后顺序
  * 即：根据具体的业务逻辑，确定 `beforeMethod()` 和 `afterMethod()` 在代理逻辑中的确切位置
  
  

##### 静态代理

* 静态代理代码实现

  ```java
  public class OrderServiceStaticProxy {
  
      /**
       *  声明/注入目标对象
       */
      private IOrderService orderService;
  
      /**
       *  增强目标对象orderService 的 saveOrder 行为;
       *  这里的方法命名可以与被增强的目标对象方法相同，也可不同
       */
      public int saveOrder(Order order){
  
          /**
           *  这里要注意beforeMethod()方法和afterMethod()方法的界限划分
           *      代理类中的方法OrderServiceStaticProxy.saveOrder()  是为了增强 目标对象的方法orderService.saveOrder()：
           *          beforeMethod()：确定目标数据库，在执行orderService.saveOrder()之前要完成对分库分表的数据库路由选择逻辑，即确定数据要插入哪个库；
           *          afterMethod()：在执行orderService.saveOrder()完毕之后需要完成的逻辑；
           */
  
          /**
           *  具体的代理处理逻辑
           *  即，在目标对象的saveOrder()方法被调用之前，数据要插入哪个库已经确定
           */
          beforeMethod(order);
  
          //显示注入，模拟spring注入
          orderService = new OrderServiceImpl();
  
          //被代理的目标对象的方法，也就是目标对象被实际增强的方法
          int result = orderService.saveOrder(order);
  
          afterMethod();
  
          return result;
      }
  
      private void beforeMethod(Order order){
  
          System.out.println("静态代理    before  code");
  
          /*-----------------------被代理目标对象方法增强    begining---------------------------*/
          int userId = order.getUserId();
          //设置分库分表路由规则
          int dbRouter = userId %2;
          System.out.println("静态代理分配到 db【" + dbRouter + "】处理数据");
  
          //TODO 设置datasource
          DataSourceContextHolder.setDBType("db" + String.valueOf(dbRouter));
          /*-----------------------被代理目标对象方法增强    ending---------------------------*/
  
      }
  
      private void afterMethod(){
          System.out.println("静态代理    after   code");
      }
  
  }
  ```

  

* 场景：简单模拟订单入库的分库分表过程

* 角色
  * `IOrderService`  目标对象(被代理对象) 
  * `IOrderService.saveOrder()` 目标对象中被代理增强的具体行为
  * `OrderServiceStaticProxy` 代理对象
  * `OrderServiceStaticProxy.saveOrder()` 代理对象中具体的代理方法，方法的命名可以与被代理对象中的方法相同或不同
  * `DataSourceContextHolder` 、`DataSourceContextHolder` 模拟订单分库分表实现，与代理并无关系

* 解析
  * `OrderServiceStaticProxy` 代理对象对目标对象 `IOrderService` 进行代理(使用组合的方式)，增强了目标对象的 `saveOrder()` 方法(行为)，使订单数据分库插入
  * 显示指定代理，是静态代理

![code-1](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/code-1.png)



##### 动态代理

* 与静态代理的区别

  * 静态代理：需要显示的指定被代理的对象，目标对象在程序编码时已经确定，所以对于不同的代理目标对象/目标对象的被代理方法，都要创建相应的代理类
  * 动态代理：由于是在运行时代理被调用后，才去创建被代理对象，所以一个代理就可以处理多个目标对象的处理逻辑

* 动态代理代码实现

  ```java
  public class OrderServiceDynamicProxy implements InvocationHandler {
  
      //要被代理的目标对象
      private Object target;
  
      //构造器注入被代理的目标对象
      public OrderServiceDynamicProxy(Object target) {
          this.target = target;
      }
  
      public Object build(){
          Class clazz = target.getClass();
  
          //动态代理的核心
          return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
      }
  
      /**
        * Create by jinm on 2019/8/15 .
        * @description    动态代理
        * @param proxy    一般很少使用，被调用方法的代理实例
        * @param method   要被增强的方法对象
        * @param args 被增强方法的参数
        * @return java.lang.Object
        */
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
  
          Object arg = args[0];
          beforeMethod(arg);
          Object object = method.invoke(target, args);
          afterMethod();
  
          return object;
      }
  
      private void beforeMethod(Object obj){
  
          System.out.println("动态代理    before  code");
  
          if (obj instanceof Order){
              /*-----------------------被代理目标对象方法增强    begining---------------------------*/
              Order order = (Order) obj;
              int userId = order.getUserId();
              //设置分库分表路由规则
              int dbRouter = userId %2;
              System.out.println("动态代理分配到 db【" + dbRouter + "】处理数据");
  
              //TODO 设置datasource
              DataSourceContextHolder.setDBType("db" + String.valueOf(dbRouter));
              /*-----------------------被代理目标对象方法增强    ending---------------------------*/
          }
          
      }
  
      private void afterMethod(){
          System.out.println("动态代理    after   code");
      }
  
  }
  ```

* 代码 `debug` 解析

  * 1- `Test` 类中调用 `OrderServiceDynamicProxy` 动态代理类的构造方法

    ![dynamic-debug-1](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/dynamic-debug-1.png)

  * 2- `OrderServiceDynamicProxy` 动态代理类的构造方法被调用，并注入被代理的目标对象类 `OrderServiceImpl`  

    ![dynamic-debug-2](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/dynamic-debug-2.png)

  * 3-调用动态代理类的动态绑定方法 `OrderServiceDynamicProxy#build()` 

    ![dynamic-debug-3](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/dynamic-debug-3.png)

  * 4- `java.lang.reflect.Proxy#newProxyInstance()` 

    ![dynamic-debug-4](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/dynamic-debug-4.png)

  * 5- `java.lang.reflect.Proxy#getProxyClass0()` 

    * 从 `class` 缓存中获取目标对象的代理对象
    * 如果缓存中有，直接获取返回
    * 如果没有则通过工厂模式创建该对象，并加载到 `class` 缓存中，并返回该对象

    ![dynamic-debug-5](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/dynamic-debug-5.png)

  * 6- `java.lang.reflect.WeakCache#get()` 

    ![dynamic-debug-6](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/dynamic-debug-6.png)

    ![dynamic-debug-7](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/dynamic-debug-7.png)

    ![dynamic-debug-8](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/dynamic-debug-8.png)

    ![dynamic-debug-9](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/dynamic-debug-9.png)

  * 7- `java.lang.reflect.Proxy#newProxyInstance()` 

    * 根据上一步得到的代理类的 `class` 对象，创建目标对象的代理对象

    ![dynamic-debug-10](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/dynamic-debug-10.png)

  * 8- 目标类 `OrderServiceImpl` 的代理对象创建成功，并调用目标类被代理的具体方法 `IOrderService#saveOrder()` 

    ![dynamic-debug-11](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/dynamic-debug-11.png)

  * 9- `IOrderService#saveOrder()` 方法被调用，进入 `OrderServiceDynamicProxy#invoke()` 方法

    * 为什么调用代理类中的被代理方法 `IOrderService#saveOrder()` 会进入 `OrderServiceDynamicProxy#invoke()` 方法？来看 `java.lang.reflect.Proxy` 类中的描述：

      ![dynamic-debug-17](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/dynamic-debug-17.png)

    * 参数 `proxy` 在当前代码方法中并未使用，但它是不可缺少的：

    *  由 `java.lang.reflect.Proxy#newProxyInstance()` 中的代码 `Class<?> cl = getProxyClass0(loader, intfs)` 创建，是`jdk` 动态生成的 `class` 字节码文件

    * 用来获取获取 `method` 和 `args` 参数的值，对动态生成的 `$Proxy0` 进行持久化，再通过反编译后发现代码中会通过 `Class.forName()` 方法获取具体的方法

      ![dynamic-debug-12](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/dynamic-debug-12.png)

    * 参数 `method` ---> 被代理的目标对象的代理行为 ，即 `savaOrder()` 方法

    * 作为 `Class.forName()` 方法的参数获取具体的方法

      ![dynamic-debug-13](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/dynamic-debug-13.png)

    * 通过参数 `proxy` 获取具体的方法参数

      ![dynamic-debug-14](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/dynamic-debug-14.png)

  * 10-调用 `java.lang.reflect.Method#invoke()` 方法，并加入被代理目标对象的真正方法中

    ![dynamic-debug-15](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/dynamic-debug-15.png)

  * 11-被代理目标对象的具体方法被调用，代码执行完毕，整个动态代理过程结束

    ![dynamic-debug-16](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/dynamic-debug-16.png)

#### 源码实践

* `mybatis` 

  *  `org.apache.ibatis.binding.MapperProxy` 

    ![source-1](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/source-1.png)

*  `springframework` 

  * `org.springframework.aop.framework.ProxyFactoryBean#getObject()` 

    ![source-2](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/source-2.png)

  * `org.springframework.aop.framework.ProxyFactoryBean#getSingletonInstance()` 

    ![source-3](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/source-3.png)

  * `org.springframework.aop.framework.ProxyFactoryBean#getProxy()` 

    ![source-4](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/source-4.png)

  * `org.springframework.aop.framework.DefaultAopProxyFactory#createAopProxy` 

    ![source-5](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/source-5.png)

  * `org.springframework.aop.framework.JdkDynamicAopProxy#invoke()` 

    ![source-5-jdk-1](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/source-5-jdk-1.png)

    ![source-5-jdk-2](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/source-5-jdk-2.png)

  * `org.springframework.aop.framework.CglibAopProxy#getProxy(java.lang.ClassLoader)` 

    ![source-5-cglib-1](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/proxy/source-5-cglib-1.png)



## <a name="behavioral" href="#behavioral-head">行为型</a> 

### <a name="template-method" href="#template-method-head">模板方法模式</a> 

* 定义
  * 定义了一个算法的骨架，并允许子类为一个或多个步骤提供实现
  * 模板方法使子类可以在不改变算法结构的情况下，重新定义算法的某些步骤
* 类型
  
  * 行为型
* 适用场景
  * 一次性实现一个算法的不变部分，并将可变的行为留给子类来实现
  * 各子类中公共的行为被提取出来并集中到一个公共父类中，从而避免代码重复

* 优点
  * 提高复用性
  * 提高扩展性
  * 符合开闭原则
* 缺点
  * 类数目增加
    * 引入了抽象类，对于每一个不同的实现，都需要一个子类来实现，这样就导致了类的个数增加
  * 增加了系统实现的复杂度
  * 继承关系自身缺点，如果父类添加新的抽象方法，所有子类都要改一遍
* 扩展
  * 钩子方法
    * 提供了缺省的行为
    * 子类可以在必要时进行扩展
* 相关设计模式
  * 模板方法模式和工厂方法模式
    * 工厂方法模式是模板方法模式的一种特殊实现
  * 模板方法模式和策略模式
    * 相同点
      * 策略模式和模板方法模式，二者都有封装算法
    * 区别
      * 策略模式
        * 目的是使不同的算法可以相互替换，并且不影响应用层、客户端的使用
        * 可以改变算法的流程，并且它们之间是可以相互替换的
      * 模板方法模式
        * 针对定义一个算法的流程，而将一些存在差异性的算法步骤交给不同的子类去实现
        * 不改变算法的流程

* 代码示例

  * 要点
    * 在使用模板方法模式进行代码结构设计时，一定要注意业务模型的抽象化规则，将业务模型抽象好，对于业务的扩展性，以及这个业务后续的发展都要有一些前瞻性的思考，充分的考虑好哪些行为是固定的，哪些行为是需要交给子类的，哪些行为是可选的，所以要对业务模型分析的足够透彻。
    * 缺省项钩子方法的使用：使用钩子方法可以实现对父类中有固定逻辑的模板方法进行权限控制，从而把某些可选行为交由子类去控制，实现了个性化定制
    * 在进行业务模型抽象时，如果业务模型转换的不够合理，出现了抽象层次不明确的情况，而导致因产品等级不匹配，而造成了子类实现差异化需求无法处理的情况，这时可将对应用层开放适当的权限，来处理这些个性化差异

  ```java
  /**
   *  场景：
   *      某网络课程平台，有不同的视频课程；
   *      视频课程包含各种资料如：视频、文档、源代码、图片等；
   *      对于所有的课程，课程制作的步骤都是一样的所以可定义为模板方法；
   *      对于不同的课程，配套的资料可能有所不同，这些差异性特点可交由子类去处理；
   */
  public abstract class ACourse {
  
      /**
       *  模板方法：
       *      final修饰，不能被子类覆写，保证了算法逻辑流程不被修改
       */
      protected final void makeCourse(){
  
          /**
           *  模板方法的具体算法逻辑：
           *      逻辑步骤都是规定好的，而且是逻辑规则是不可更改的；
           *      如先制作ppt资料，再制作视频资料，最后打包所有的课程资料；
           */
          this.makePPT();
          this.makeVideo();
  
          /**
           *  钩子方法：由具体的实现子类来控制可选行为
           */
          if (needWriteArticle()){
              this.makeArticle();
          }
  
          this.packageCourse();
  
      }
  
      /**
       *  课程ppt：所有子类来说都适用，不需要个性化定制，所以声明为final型
       */
      final void makePPT(){
          System.out.println("制作PPT");
      }
  
      /**
       *  课程视频：所有子类通用方法，final修饰
       */
      final void makeVideo(){
          System.out.println("制作 Video");
      }
  
      /**
       *  课程笔记：
       *      对于编写笔记这个行为本身来说所以的课程编写的过程都是一样的，即内部实现都是相同的；
       *      但是并不是所有的课程都需要编写笔记，所以这个方法对于子类来讲是可选项；
       */
      final void makeArticle(){
          System.out.println("制作 笔记");
      }
  
      /**
       *  钩子方法：
       *      对于编写笔记这类可选行为，设置一个缺省的钩子方法，子类可以覆盖这个方法；
       *      即，添加一个权限控制方法，把控制逻辑交给子类，由子类决定是否执行；
       */
      protected boolean needWriteArticle(){
          return false;
      }
  
      /**
       *  包装课程：
       *      这个行为对于不同子类有不同的课程包装方式，所以声明为抽象方法，交由具体的子类去实现；
       *      如：前端课程需要打包ppt、视频、源码、图片素材等；设计模式课程需要打包ppt、源码、视频、笔记等；
       */
      abstract void packageCourse();
  
  }
  
  /**
   *  设计模式课程
   */
  public class DesignPatternCourse extends ACourse {
  
      @Override
      void packageCourse() {
          System.out.println("提供课程的 Java 源代码");
      }
  
      /**
       *  覆写父类暴露出来的钩子方法，用来控制可选行为 ：编写笔记
       */
      @Override
      protected boolean needWriteArticle() {
          return true;
      }
  }
  
  /**
   *  前端课程
   */
  public class FECourese extends ACourse {
  
      /**
       *  场景：
       *      对于前端课程，可能包括：vue、react、angularjs等具体类型的课程；
       *      如果其中的react课程需要编写课程笔记，而且其他课程不需要编写；
       *      这时就需要对应用层客户端开放是否编写课程笔记的控制权限，以处理这些个性化差异
       */
      private boolean needWriteArticleFlag = false;
  
      /**
       *  构造器注入行为控制权限，也可用set方法注入
       */
      public FECourese(boolean needWriteArticleFlag) {
          this.needWriteArticleFlag = needWriteArticleFlag;
      }
  
      @Override
      protected boolean needWriteArticle() {
          return this.needWriteArticleFlag;
      }
  
      @Override
      void packageCourse() {
  
          System.out.println("提供课程的前端代码");
          System.out.println("提供课程的图片等多媒体资料");
  
      }
  
  }
  
  public class Test {
  
      public static void main(String[] args) {
  
          System.out.println("后端设计模式课程    start -------");
          ACourse designPatternCoures = new DesignPatternCourse();
          designPatternCoures.makeCourse();
          System.out.println("后端设计模式课程    end -------");
          System.out.println("--------------------------------------------------");
  
          System.out.println("前端课程 react    start -------");
  
          ACourse reactCourse = new FECourese(true);
          reactCourse.makeCourse();
          System.out.println("前端课程 react  end -------");
          System.out.println("--------------------------------------------------");
  
          System.out.println("前端课程 react    start -------");
          ACourse vueCourse = new FECourese(false);
          vueCourse.makeCourse();
          System.out.println("前端课程 react  end -------");
  
      }
  
  }
  ```



### <a name="iterator" href="#iterator-head">迭代器模式</a>

* 定义

  * 提供一种方法，顺序访问一个集合对象中的各个元素，而又不暴露该对象的内部表示

* 类型

  * 行为型

* 适用场景

  * 访问一个集合对象的内容而无需暴露它的内部表示
  * 为遍历不同的集合结构提供一个统一的接口

* 优点

  * 分离了集合对象的遍历行为
    * 抽象出了一个迭代器，来负责这个集合对象的遍历，这样就可以让外部代码，透明的访问集合内部的数据

* 缺点

  * 类的个数成对增加
    * 因为迭代器模式是将存储数据和遍历数据这两个职责进行分离，所以新增加一个集合类，就同时得增加一个新的迭代器类，这样类的个数是成对增加的

* 相关设计模式

  * 迭代器模式和访问者模式
    * 共同点
      * 两者都是通过迭代的方式，访问集合中的各个元素
    * 不同点
      * 在访问者模式中扩展开放的部分，是在作用于对象的操作上
      * 在迭代器模式中扩展开放的部分，是在集合对象的种类上

* 代码示例

  * 课程集合和对应的迭代器实现

    ![code-1](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/iterator/code-1.png)



* 源码实践
  * `java.util.ArrayList.Itr` 
  * `java.util.LinkedList.ListItr` 
  * `org.apache.ibatis.cursor.defaults.DefaultCursor#iterator()`  



### <a name="strategy" href="#strategy-head">策略模式</a> 

* 定义
  * 定义了算法家族，分别封装起来，让它们之间可以互相转换，此模式让算法的变化不会影响使用算法的用户
  * 消除 `if...else...` 逻辑
* 类型
  
  * 行为型
* 适用场景
  * 系统有很多类，而且它们的区别仅仅在于各自的行为不同
    * 在这种情况下，使用策略模式就可以让一个对象动态的从若干行为中选择一个行为
    * 即，我们把一个对象不同的行为抽离到不同的类中，这个对象会衍生出很多行为类，而不同的行为类对应不同的策略
  * 一个系统需要动态地在几种算法中选择一种
    * 这里所说地算法就是策略，因为策略里面封装的就是一系列的业务逻辑以及计算方式
* 优点
  * 开闭原则
    * 策略模式提供了对开闭原则的完美支持，我们可以在不修改原有类的基础上选择不同的行为，并且这种行为是可扩展的
  * 避免使用多重条件转移语句
    * 大量 `if...else...`  
    * 大量 `switch...case...` 
    * 把具体的策略行为分离成一个个单独的类，来替换原来的条件判断转移逻辑，这样的设计也会降低代码的耦合度
  * 提高算法的保密性和安全性
    * 在使用某一个策略类时，我们只需要知道这个策略的功能是什么(入参、名称、返回值)就可以，不需要知道其内部的具体实现
    * 比如在系统中封装了一个促销的服务，对外提供的是不同的策略(不同的促销方式)，假设采用 `dubbo` 框架，客户端在调用促销服务时，只需要使用 `dubbo` 所提供的促销接口即可，而具体的策略实现是放在 `dubbo` 的 `provider` 中，策略内部具体的实现过程对客户端时封闭的
    * 即，在具体的策略类中，封装了不同的行为和算法以及相关的数据结构，对于客户端来说，它并不需要知道策略内部的实现过程
* 缺点
  * 客户端必须知道所有的策略类，并自行决定使用哪一个策略类
  * 产生很多策略类
    * 原来是一个类中不同的 `if...else...` 处理不同的逻辑行为，而策略模式中，则要将每一个行为逻辑都要封装到一个具体的策略类中
* 相关设计模式
  * 策略模式和工厂模式(抽象工厂、工厂方法)
    * 共同点
      * 从逻辑角度来讲都是不同的类对应不同的行为逻辑
    * 不同点
      * 工厂模式：创建型。工厂模式接收客户端指令，创建符合要求的具体对象
      * 策略模式：行为型。接收已经创建好的对象从而实现不同行为
  * 策略模式和状态模式
    * 相关性
      * 在策略模式中，客户端调用者，知道它到底要选择哪个策略
      * 在状态模式中，客户端不需要关心具体的状态，并且这些状态会自动转换
    * 场景区别
      * 如果系统中某个类的对象存在多种状态，并且在不同状态下该对象的行为又具有差异性，同时这些不同的状态可以发生转换时，就可以使用状态模式
      * 如果系统中某个类的某一行为存在多种实现方式，

* 代码示例

  * 场景：某网上商城不同类型的促销活动

    * `v1` 版本：应用层每执行一次促销都要 `new` 一个促销活动和促销策略，并且要显示指定活动场景，比如京东618和淘宝1111

      ![code-1](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/strategy/code-1.png)

  * 代码

    ```java
    /**
     *  促销策略抽象规则
     */
    public interface PromotionStrategy {
        void doPromotion();
    }
    
    public class ManJianPromotionStrategy implements PromotionStrategy{
        /**
         *  满减促销
         */
        @Override
        public void doPromotion() {
            System.out.println("满减促销，满900-300元");
        }
    }
    
    public class LiJianPromotionStrategy implements PromotionStrategy {
        /**
         *  立减促销
         */
        @Override
        public void doPromotion() {
            System.out.println("立减促销，商品的价格直接减去系统配置的价格");
        }
    }
    
    public class FanXianPromotionStrategy implements PromotionStrategy {
        /**
         *  返现促销
         */
        @Override
        public void doPromotion() {
            System.out.println("返现促销，返现的金额存放到用户的账户余额中");
        }
    
    }
    
    public class EmptyPromotionStrategy implements PromotionStrategy {
        /**
         *  空处理：无促销活动
         */
        @Override
        public void doPromotion() {
            System.out.println("无促销活动");
        }
    }
    
    public class PromotionStrategyActivity {
    
        /**
         *  业务侧促销活动
         *  场景：
         *      某网上商城不同类型的促销活动
         */
    
        private PromotionStrategy promotionStrategy;
    
        public PromotionStrategyActivity(PromotionStrategy promotionStrategy) {
            this.promotionStrategy = promotionStrategy;
        }
    
        public void executePromotion(){
            promotionStrategy.doPromotion();
        }
    
    }
    
    public class PromotionStrategyFactory {
    
        /**
         *  策略模式和工厂模式结合使用降低业务层代码量
         */
    
        private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();
    
        static {
            PROMOTION_STRATEGY_MAP.put(PromotionKey.LI_JIAN, new ManJianPromotionStrategy());
            PROMOTION_STRATEGY_MAP.put(PromotionKey.MAN_JIAN, new LiJianPromotionStrategy());
            PROMOTION_STRATEGY_MAP.put(PromotionKey.FAN_XIAN, new FanXianPromotionStrategy());
        }
    
        private static final PromotionStrategy non_promotion = new EmptyPromotionStrategy();
    
        private PromotionStrategyFactory() {
    
        }
    
        public static PromotionStrategy getPromotionStrategy(String promotionKey){
            PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
            return promotionStrategy == null ? non_promotion : promotionStrategy;
        }
    
        private interface PromotionKey{
    
            /**
             *  声明常量，起到逻辑分组的作用
             */
            String LI_JIAN = "LI_JIAN";
            String MAN_JIAN = "MAN_JIAN";
            String FAN_XIAN = "FAN_XIAN";
        }
    
    }
    
    public class Test {
    
        public static void main(String[] args) {
    
    //        /**
    //         *  策略模式实现：应用层选择哪个策略，哪个策略内部的促销逻辑就被执行，而应用层并不知道具体的实现内容
    //         *  传统的if-else实现：应用层要将各个促销策略中的实现逻辑都通过if-else逻辑串联在一起，代码耦合度高，并且会使方法过于臃肿，不利于以后的维护扩展
    //         */
    //        PromotionStrategyActivity activity618 = new PromotionStrategyActivity(new FanXianPromotionStrategy());
    //        activity618.executePromotion();
    //        PromotionStrategyActivity activity1111 = new PromotionStrategyActivity(new ManJianPromotionStrategy());
    //        activity1111.executePromotion();
    //        PromotionStrategyActivity activity0000 = new PromotionStrategyActivity(new LiJianPromotionStrategy());
    //        activity1111.executePromotion();
    
    //        /**
    //         *  缺点：
    //         *      对于业务层来讲这种简版的策略模式，每调用一个促销活动都要new 一个活动和相应的策略；
    //         *      并且没有完全消除if-else逻辑
    //         */
    //        PromotionStrategyActivity activity = null;
    //        String promotionKey = "LI_JIAN";
    //        if (StringUtils.equals(promotionKey, "LI_JIAN")){
    //            activity = new PromotionStrategyActivity(new LiJianPromotionStrategy());
    //        }else if (StringUtils.equals(promotionKey, "MAN_JIAN")){
    //            activity = new PromotionStrategyActivity(new ManJianPromotionStrategy());
    //        }//......
    //
    //        activity.executePromotion();
    
            /**
             *  工厂模式-策略模式结合使用：减少业务层代码量
             */
            String promotionKey = "LI_JIAN";
            PromotionStrategyActivity activity = new PromotionStrategyActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
            activity.executePromotion();
    
        }
    
    }
    ```

* 源码实践

  * `java.util.Arrays#sort(T[], int, int, java.util.Comparator<? super T>)` 

  * `java.util.Comparator` 

    ![source-1](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/strategy/source-1.png)

  * `java.util.TreeMap#compare` 

    ![source-2](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/strategy/source-2.png)

  * `org.springframework.beans.factory.support.InstantiationStrategy` 

    ![source-3](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/strategy/source-3.png)

### <a name="interpretor" href="#interpretor-head">解释器模式</a>

* 定义
  * 给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子
  * 为了解释一种语言，而为语言创建的解释器
* 类型
  * 行为型
* 适用场景
  * 某个特定类型问题发生频率足够高
    * 例如，在日常开发过程中，我们用脚本语言或者编程语言来处理日志的时候，系统包含很多服务，每个服务都会产生大量的日志，当我们对日志进行解析时，会生成一些报表，而各个服务的日志格式可能不同，但是日志中的数据要素是相同的，这种情况下，可以通过程序来解决该问题，这个程序就可以理解为一个解释器，只不过它的作用是解析不同的日志格式。如类似功能的开源包：`express4j` 、`jep` 、`mdsp` 等等。
* 优点
  * 语法由很多类表示，容易改变及扩展此"语言"
* 缺点
  * 当语法规则数目太多时，会增加系统的复杂度
* 相关设计模式
  * 解释器模式和适配器模式
    * 区别
      * 适配器模式不需要预先知道需要适配的规则
      * 解释器模式中需要把规则提前写好，再根据规则进行解析

* 源码实践
  * `java` 正则解释器
    * `java.util.regex.Pattern` 
  * `spring` 表达式解释器
    * `org.springframework.expression.ExpressionParser` 
    * `org.springframework.expression.spel.standard.SpelExpressionParser` 
    * `org.springframework.expression.common.TemplateAwareExpressionParser` 



### <a name="observer" href="#observer-head"> 观察者模式</a> 

* 定义
  * 定义了对象之间的一对多依赖，让多个观察者对象同时监听某一个主题对象，当主题对象发生变化时，它的所有依赖者(观察者)都会收到通知并更新
    * 如微信朋友圈的说说，当我们在朋友圈给某一条动态点赞或评论时，我们自己作为观察者，朋友圈的这条动态就是被观察者，即主题对象，当这个主题对象被点赞或评论的时候，微信就会通知观察者(进行点赞或评论行为的人和其他能够看见该说说的好友)，不需要我们时时刻刻的去盯着或刷新这条说说是否被评论或点赞
    * 再如淘宝、京东、唯品会等电商网站，如果我们看中某件商品并点击关注，这时后台会对商品的价格进行监听，当商品降价时会给关注该商品的用户，推送降价提醒
* 类型
  
  * 行为型
* 适用场景
  * 关联行为场景，建立一套触发机制
    * 比如关注某一件商品的价格，并且伴随着相应的通知事件，这里关注商品和通知这两个行为相互关联
    * 如果第一个对象的行为将影响第二个对象，同时第二个对象的行为还将影响第三个对象等等，把这种场景可以理解为一个触发链条，这时就可以适用观察者模式来创建一种链式的触发机制
* 优点
  * 观察者和被观察者之间建立了一个抽象的耦合
    * 由于加了一个抽象的耦合，所以对于观察者和被观察者来说都是易扩展的
  * 观察者模式支持广播通信
    * 比如对微信朋友圈的说说进行点赞或评论后，就会添加一个观察者，而这个观察者就是好友和我们自己的微信账号(当然实际的朋友圈不是用观察者来实现，但它是基于观察者这种抽象模型的)
* 缺点
  * 观察者之间有过多的细节依赖、提高时间消耗及程序复杂度
    * 观察者模式中的触发机制和触发链条有大量的细节依赖
  * 使用要得当，要避免循环调用
    * 如果被观察者和观察者之间有循环依赖关系，被观察者(主题对象)会触发循环调用，可能会导致系统崩溃

* 代码示例

  * 场景

    * 某网络视频课程平台中，用户向对某个课程进行提问后，该课程的老师收到提问内容

  * 角色

    * `Course` ---> 主题对象：被观察者
    * `Teacher` ---> 接收提问信息：观察者
    * `Test` ---> 客户端，事件发起者

    ![code-1](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/observer/code-1.png)

  * 注意点
  
    * 要注意区分观察者和被观察者的角色含义，特别是对主题对象被观察者来讲，它是消息作用的对象，而不是消息本身
    * 比如代码示例中的被观察者是 `Course` 对象，而不是具体的提问内容
    * 类似的在互联网商城中，被观察者是商品，而不是商品对应的价格或其他属性

* 源码实践
  * `java.util.EventListener` 
  * `org.springframework.beans.factory.parsing.ReaderEventListener` 



### <a name="memento" href="#memento-head">备忘录模式</a>

* 定义
  * 保存一个对象的某个状态，以便在适当的时候恢复对象
  * “后悔药”
    * 例如游戏存档，开发工具eclipse、idea中的撤销动作，浏览器中的后退操作等
* 类型
  * 行为型
* 适用场景
  * 保存及恢复数据相关业务场景
  * 后悔的时候，即想恢复到之前的状态
* 优点
  * 为用户提供一种可恢复机制
  * 存档信息的封装 
    * 将存档信息封装之后，才能更好的为用户提供恢复的机制
    * 对象状态：对象内部各个属性的存档，是一个快照
* 缺点
  * 资源占用
* 相关设计模式
  * 备忘录模式和状态模式
    * 备忘录模式中，适用实例来保存状态的，即存档内容是一个对象的实例
    * 状态模式中，只是用类来表示状态

* 代码示例

  * 撰写笔记，并实现  `ctrl + z` 版本回退效果

    ![code-1](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/memento/code-1.png)

* 源码实践
  * `org.springframework.binding.message.StateManageableMessageContext` ---> `spring` 工作流
    * `org.springframework.binding.message.StateManageableMessageContext#createMessagesMemento()`  ---> 日志记录、归档
    * `org.springframework.binding.message.StateManageableMessageContext#restoreMessages()`  ---> 版本回退











