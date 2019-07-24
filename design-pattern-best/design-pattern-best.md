



# 设计模式

## 概述

<a href="#simple-factory">简单工厂模式</a>

<a href="#factory-method">工厂方法模式</a>

<a href="#product-race-level">产品族-产品等级</a>

<a href="#abstract-factory">抽象工厂模式</a>

<a href="#builder">建造者模式</a>



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





























