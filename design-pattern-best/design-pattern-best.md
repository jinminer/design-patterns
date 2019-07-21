



# 设计模式

## 概述

<a href="#simple-factory">简单工厂</a>

<a href="#factory-method">工厂方法模式</a>





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
* 产品族-产品等级
  * 产品族：产于同一厂商(工厂类)，但是每个产品完成的功能接口不同，并且产品之间相互联系，这个集合称之为**产品族**
  * 产品等级：一系列具有相似功能(提供的接口功能相同)，来自于不同产地(工厂类)的产品，称它们处于同一个**产品等级**

![product-race-level-2](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/factory-method/product-level-2.png>)

注：`PythonVideo`、`JavaVideo`、`FEVideo`三者处于同一产品等级，Java视频教程和配套的Java文档形成Java教程产品族。

![product-race-level-1](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/factory-method/product-race-level-1.png>)

* 源码示例

 `java.util.Collection#iterator` 不同的工厂实现类提供不同的实现内容

![source-code-example](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/design-pattern-best/factory-method/source-code-example.png>)



















