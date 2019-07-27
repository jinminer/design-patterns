



# 设计模式

## 概述

<a href="#simple-factory">简单工厂模式</a>

<a href="#factory-method">工厂方法模式</a>

<a href="#product-race-level">产品族-产品等级</a>

<a href="#abstract-factory">抽象工厂模式</a>

<a href="#builder">建造者模式</a>

<a href="#singleton">单例模式</a>





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

* `Double Check`

  ![double-check-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/double-check-1.png>)



​		![double-check-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/double-check-2png.png>)



* 静态内部类

  ![static-inner-class](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/singleton/static-inner-class.png>)



* 奇技淫巧
  * 反编译
  * 内存原理
  * 多线程`debug`
* 相关设计模式
  * 单例模式和工厂模式
  * 单例模式和享元模式

### 单例模式线程安全

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











