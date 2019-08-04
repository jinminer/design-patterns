



# 设计模式

## 概述

* <a href="#simple-factory">简单工厂模式</a>
* <a href="#factory-method">工厂方法模式</a>
* <a href="#product-race-level">产品族-产品等级</a>
* <a href="#abstract-factory">抽象工厂模式</a>
* <a href="#builder">建造者模式</a>
* <a href="#singleton">单例模式</a>
  * <a name="multithreading-safe-head" href="#multithreading-safe">单例模式线程安全</a> 
  * <a name="double-check-synchronized-head" href="#double-check-synchronized">双重检查锁</a>
  * <a name="command-sort-head" href="#command-sort">程序指令重排</a> 
  * <a name="volatile-head" href="#volatile">`volatile`</a>
  * <a name="static-inner-class-head" href="#static-inner-class">静态内部类</a>
  * <a name="lazy-hungry-compare-head" href="#lazy-hungry-compare">懒汉模式vs饿汉模式</a>
  * <a name="serializable-break-head" href="#serializable-break">序列化破坏单例</a>
  * <a name="reflection-break-head" href="#reflection-break">反射破坏单例</a>
  * <a name="signleton-enum-head" href="#signleton-enum">枚举类型单例</a> 
  * <a name="container-head" href="#container">容器单例</a> 
  * <a name="thread-local-head" href="#thread-local">`ThreadLocal`线程单例</a> 
  * <a name="singleton-in-sources-head" href="#singleton-in-sources">单例模式源码实践</a> 
* <a name="prototype-head" href="#prototype">原型模式</a> 
  * <a name="clone-shallow-head" href="#clone-shallow">浅克隆</a> 
  * <a name="clone-deep-head" href="#clone-deep">深克隆</a> 
  * <a name="clone-singleton-break-head" href="#clone-singleton-break">克隆破坏单例</a> 
* <a name="facade-head" href="#facade">外观模式</a> 
* <a name="decorator-head" href="#decorator">装饰器模式</a> 



## <a name="simple-factory">简单工厂</a>

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



## <a name="factory-method">工厂方法模式</a>

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



## <a name="product-race-level">产品族-产品等级</a>

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



## <a name="abstract-factory">抽象工厂模式</a>

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



## <a name="builder">建造者模式</a>

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



## <a name="singleton">单例模式</a>

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

### <a name="multithreading-safe" href="#multithreading-safe-head">单例模式线程安全</a>

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



### <a name="double-check-synchronized" href="#double-check-synchronized-head">双重检查锁</a>

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



### <a name="command-sort" href="#command-sort-head">程序指令重排</a>

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

### <a name="volatile" href="#volatile-head">`volatile`</a>

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

  

### <a name="static-inner-class" href="#static-inner-class-head">静态内部类</a>

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

### <a name="lazy-hungry-compare" href="#lazy-hungry-compare-head">懒汉模式vs饿汉模式</a>

* 懒汉模式
  * 延迟加载，被调用时完成加载
  * 适用于内部构造较为复杂，内容较重，创建消耗资源较大的单例模型
* 饿汉模式
  * 类初始化时，就完成加载
  * 适用于内部构造简单，创建花费资源较少的单例模型



### <a name="serializable-break" href="#serializable-break-head">序列化破坏单例</a>

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



### <a name="reflection-break" href="#reflection-break-head">反射破坏单例</a>

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



### <a name="signleton-enum" href="#signleton-enum-head">枚举类型单例</a>

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




### <a name="container" href="#container-head">容器单例</a>

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

  

### <a name="thread-local" href="#thread-local-head"> `ThreadLocal`线程单例</a>

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



### <a name="singleton-in-sources" href="#singleton-in-sources-head">单例模式源码实践</a>

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



## <a name="prototype" href="#prototype-head">原型模式</a> 

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

  

### <a name="clone-shallow" href="#clone-shallow-head">浅克隆</a>

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



### <a name="clone-deep" href="#clone-deep-head">深克隆</a>

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



### <a name="clone-singleton-break" href="#clone-singleton-break-head">克隆破坏单例</a>

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



### 源码中的原型模式

* `java.util.ArrayList#clone()` 

  ![prototype-in-sources-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/prototype/prototype-in-sources-2.png>)

  ![prototype-in-sources-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/prototype/prototype-in-sources-1.png>)

* `java.util.HashMap#clone()` 

  ![prototype-in-sources-3](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/prototype/prototype-in-sources-3.png>)

  ![prototype-in-sources-4](https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/prototype/prototype-in-sources-4.png)



## <a name="facade" href="#facade-head">外观模式</a>

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



## <a name="decorator" href="#decorator-head">装饰器模式</a>

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
    * 如果使用继承扩展类的功能，那么这些扩展功能就必须是可预见的，因为这些功能在编译时就确定了，是**静态的**
    * 在装饰器模式中，这些扩展功能是由用户或者应用层代码**动态的**决定加入的时间和方式
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
    * 装饰器模式和适配器模式都可以称之为包装模式 `wrapper` 
      * 装饰者和被装饰者都可以实现相同的接口，或者装饰者是被装饰者的子类
      * 在适配器模式中，适配器和被适配的类具有不同的接口，当然部分接口也有可能是重合的
      * 装饰者还可以退化成半装饰者，也就是说一个装饰器，除了提供被装饰类的接口外，还提供了其他的方法，即半透明的装饰器

* 代码示例

  * 场景：街边小贩卖煎饼，并计算煎饼价格

  * 使用继承的扩展方式实现需求

    ![code-uml-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/decorator/code-uml-2.png>)

  * 使用装饰器模式的扩展方式实现需求

    * 通过装饰器模式实现类的功能扩展后，类似这种加多个鸡蛋、多根香肠的需求，只需要在应用层调用相应的装饰器实例即可完成，不需要再对底层的类进行二次开发二外扩展

    ![code-uml-3](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/decorator/code-uml-3.png>)



* 源码时间

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

    























