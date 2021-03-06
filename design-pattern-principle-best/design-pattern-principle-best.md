# 设计原则

## 概述

<a href="#open-closed">开闭原则</a>

<a href="#dependency-inversion">依赖倒置原则</a>

<a href="#single-responsibility">单一职责原则</a>

<a href="#interface-segregation">接口隔离原则</a>

<a href="law-of-demeter">迪米特法则</a>(最少知道原则)

<a href="#liskov-substitution">里氏替换原则</a>

<a href="">合成复用原则</a>(组合/复用原则)



## <a name="open-closed">开闭原则</a>

* 定义：一个软件实体如类、模块和函数应该对扩展开发，对修改关闭
* 用抽象构建框架，用实现扩展细节，是面向对象中最基础的设计原则
* 优点：提高软件系统的可复用性及可维护性
* 核心思想：面向抽象编程
  * 抽象相对来说是稳定的，实现类依赖于固定的抽象类，通过抽象隔离以后可能会发生的变化
  * 通过实现接口、抽象方法以及类的继承、方法重写等方式应对变化
  * 从业务场景中抽象出业务模型，以及从抽象模型中得出具体的实例
  * 越低层的基础模块变化，影响范围越大；越高层的模块变化，影响范围越小；
* 范例：spring容器提供的控制反转机制
  * spring提供了类扩展机制，将控制权限交给开发者，通过控制反转特性，实现源码的修改
  * 使用配置文件或者注解的方式注入bean，从而修改spring源码中的一些内容，达到对修改关闭，对扩展开放的目的。



## <a name="dependency-inversion">依赖倒置原则</a>

* 定义
  * 高层模块不应该依赖低层模块，二者都应该依赖其抽象
  * 抽象不应该依赖细节，细节应该依赖抽象
  * 针对接口编程，不要针对实现编程
* 面向抽象
  * 低层类接口或抽象方法往往是某一些业务模型的行为抽象，抽象层描述了一系列相似行为的共有能力
  * 接口或者抽象方法的返回值和入参，是某一类业务模型流转完成后的结果以及完成该业务所必须的条件
  * 低层的抽象方法(业务模型)，只关心业务流转结果(方法返回值)和影响业务的因子(方法入参)，并不在乎具体的业务执行过程
  * 低层类将业务的具体实现交由应用层，应用层决定业务什么时候执行、怎样执行
* 优点
  * 可以减少类之间的耦合性，提高系统的稳定性，提高代码的可读性和可维护性，降低修改程序所造成的风险



## <a name="single-responsibility">单一职责原则</a>

* 定义
  * 不要存在多余一个导致类变更的原因
  * 一个类/接口/方法只负责一项职责
  * 程序的设计、开发、运行是一个不断迭代变更的过程，变更是必然的，我们要接收变更
  * 对于业务模型，在开发过程中，如果能够正确的使用单一职责原则，就能很好的避免对其他业务的影响
* 优点
  * 降低类的复杂度、提高类的可读性，提高系统的可维护性、降低变更引起的风险

* 目的
  * 将方法、模块、服务的业务逻辑交给应用层去处理，底层服务提供的职责应该尽可能地单一，出现什么样的业务流程，就用底层服务组合什么样的代码逻辑，把业务逻辑尽可能的放在业务层
  * 保证基础服务、抽象模型的耐用性，底层服务一旦完成定义，那么就应该保持其耐用性(关闭修改、开发扩展)

## <a name="interface-segregation">接口隔离原则</a>

* 定义
  * 用多个专门的接口，而不使用单一的总接口，客户端不应该依赖它不需要的接口
  * 一个类对一个类的依赖应该建立在最小的接口上
  * 建立单一接口，不要建立庞大臃肿的接口
  * 尽量细化接口，接口中的方法尽量少
  * 注意适度原则，一定要适度
* 优点
  * 符合高内聚低耦合的设计思想，从而使得类具有很好的可读性、可扩展性和可维护性

* 分析
  * 接口隔离原则 vs 单一职责原则
    * 接口隔离原则顾名思义针对的是接口层次的抽象模型
    * 单一职责原则面向的是具体的类以及方法
    * 接口隔离原则可以变相认为是接口层面的单一职责原则
  * 按照细粒度划分，接口隔离原则的目的是确保一个接口所具备的职责尽量单一、所能够表达的行为尽可能的详细
  * 从宏观角度来看，接口隔离原则是业务模型是否合理抽象的体现；遵循这个原则，能够让系统、程序的业务逻辑更加清晰明了，确保系统在不断迭代过程中的稳定性、健壮性以及可维护性
  * 当然要注意不能走极端主义路线，也不是说系统的设计和业务模型的抽象愈是详细愈好；不能一拍脑袋，闷头干，不论遇到什么样的业务或需求都一刀切，立马进行详尽的功能职责划分；具体问题具体对待。
  * 过渡的使用接口隔离原则也会造成系统中接口模型过多，而使得程序维护困难

## <a name="law-of-demeter">迪米特法则</a>

* 定义
  * 迪米特原则，又称之为最少知道原则，即一个对象应该对其他对象保持最少的了解
  * 梳理清楚类和类之间的调用关系，尽可能减少当前类中其他类的属性
  * 做好业务层次划分和业务模型的抽象定义，尽可能地减少无关服务地相互耦合
* 原则
  * 尽量降低类与类之间的耦合
  * 对外部的类引入的越少越好
  * 强调只和朋友交流，不和陌生人说话
  * 朋友
    * **出现在成员变量、方法的输入、输出参数中的类称为成员朋友类，而出现在方法体内部的类不属于朋友类**
* 优点
  * 降低类之间的耦合













