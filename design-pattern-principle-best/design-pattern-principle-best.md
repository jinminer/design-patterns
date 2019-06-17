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





































