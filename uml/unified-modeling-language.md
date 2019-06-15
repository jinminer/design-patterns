# `UML`类图及时序图的入门

## 概要

<a href="#definition">定义</a>

<a href="#feature">特点</a>

<a href="#classification">分类</a>

<a href="#skills">记忆技巧</a>

<a href="#sequence-diagram">时序图</a>

<a href="#class-diagram">类图</a>

## <a name="definition">定义</a>

* 统一建模语言(`UML`: Unified Modeling Language)
* 非专利的第三代建模和规约语言



## <a name="feature">特点</a>

* `UML`是一种开放的方法
* 用于说明、可视化、构建和编写一个正在开发的面向对象的、软件密集系统的制品的开发方法
  * 制品是在软件开发过程中产生的特定产物，如：模型、流程图、源代码、测试用例等

* `UML`展现了一系列最佳工程实践，这些最佳实践在对大规模、复杂系统进行建模方面，特别是在软件架构层次已经被验证有效
* `UML`能使我们更直观地认识系统，并且不同类型的图形，使大家交流起来也更加方便,更容易理解对方所表述的意思和系统内容



## <a name="classification">分类</a>

> version: `UML2.2`

* 结构式图形：强调系统式的建模
* 行为式图形：强调系统模型中触发的事件
* 交互式图形：属于行为式图形子集合，强调系统模型中资料流程

### 结构式图形

* 静态图（类图、对象图、包图）
* 实现图（组件图、部署图）
* 剖面图
* 复合结构图

### 行为式图形

* 活动图
* 状态图
* 用例图

### 交互式图形

* 通信图
* 交互概述图（`UML`2.0）
* 时序图（`UML`2.0）
* 时间图（`UML`2.0）

### 类图

* `Class Diagram` ：用于表示类、接口、实例等之间相互的静态关系
* 类图不仅仅只有类，还包括权限、属性、方法等



## <a name="skills">记忆技巧</a>

* `UML`箭头方向：从子类指向父类

  * 误区：可能会认为子类式以父类未基础的，从父类引申而来，所以箭头应该从父类指向子类

  

### 箭头方向

* 定义子类时需要通过`extends`关键字指定其父类
* 子类一定知道父类定义的内容，但父类并不知道子类的定义
* 只有知道对方信息时才能指向对方
* 所以箭头方向是从子类指向父类

#### 实线-继承|虚线-实现



![arrow-virtual-real](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/uml/1-arrow-virtual-real.png>)

* 空心三角箭头：继承或实现
  * 实线-继承：is a 关系，扩展的目的，不虚，很结实，有具体的内容，无实现细节
  * 虚线-实现：虚线代表“虚”无实体，无具体的内容，无实现细节

#### 实线-关联|虚线-依赖



![line-virtual-real](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/uml/2-line-virtual-real.png>)



![line-virtual-real](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/uml/3-line-virtual-real.png>)

* 虚线-依赖关系：临时用一下，若即若离，虚无缥缈，若有若无
  * 表示一种使用关系，一个类需要借助另一个类来实现功能
  * 一般事一个类使用另一个类作为参数使用，或者作为返回值
* 实线-关联关系：关系稳定，实打实的关系，铁哥们
  * 表示一个类对象和另一个类对象有关联
  * 通常事一个类中有一个类对象作为属性

### 空心菱形-聚合|实心菱形-组合

* 菱形就是一个盛放东西的器皿（例如盘子）
  * 聚合：代表空器皿里可以放很多相同东西，聚在一起（箭头方向所指的类）
  * 组合：代表满器皿里已经有实体结构的存在，生死与共；它们之间是强关系，组合关系中会带有数字



![diamond-blank-polymerization](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/uml/4-diamond-blank-polymerization.png>)



![diamond-real-combination](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/uml/5-diamond-real-combination.png>)



#### 空心菱形-聚合

* 整体和局部的关系，两者有独立的生命周期，是has a的关系
* 弱关系
* 消极的词：弱-空

#### 实心菱形-组合

* 整体与局部的关系，和聚合的关系相比，关系更加强烈，两者有相同的生命周期，是contains a的关系
* 强关系
* 积极的词：强-满

##### 实心菱形-组合

* 常见数字表达及含义，假设有A类和B类，数字标记在A类侧
  * 0..1：0或1个实例
    * 代表在系统的某一时刻，B的实例可以与0个或1个A类的实例相关
  * `0..*`：0或多个实例
    * 代表在系统的某一时刻，B的实例可以与0个或多个A类的实例相关
  * `1..1`：1个实例
    * 代表在系统的某一时刻，B的实例只能与1个A类的实例相关，有且只有一个
  * `1`：只能有1个实例，等同于`1..1`
    * 代表在系统的某一时刻，B的实例只能与1个A类的实例相关，有且只有一个
  * `1..*`：至少有1个实例
    * 代表在系统的某一时刻，B的实例可以与1个或多个A类的实例相关，至少有一个



## <a name="sequence-diagram">`UML`时序图</a>

* Sequence Diagram：是显示对象之间交互的图，这些对象是按照时间顺序排列的
* 时序图中包括的建模元素主要有：
  * 对象（Actor）
  * 生命线（Life Line）
  * 控制焦点（Focus Of Control）
  * 消息（Message）



![sequence-diagram](<https://raw.githubusercontent.com/jinminer/docs/master/design-patterns/uml/6-uml-sequence-diagram.png>)

> 如图：左侧代码，右侧时序图
>
> * 顶部的矩形：类的实例，`c,s,d` 分别代表`Client,Server,Device`三个类的实例
> * 由类实例向下延伸的虚线：该实例的生命线
>   * 时间从上向下流逝，上面是过去，下面是未来
>   * 生命线仅存在于实例的生命周期内
> * 生命线上细长的矩形长条：实例处于某种活动中，如实例`c`处于`work`活动中
>
> * 实线箭头：方法调用
> * 虚线箭头：方法调用返回
>   * `c`的`work()`方法调用（实线箭头）`s`的`open()` 方法，`s`处于活动中；`oper()`方法调用完毕，返回给`wrok()`方法（虚线箭头），`s`的活动结束（矩形长条结束）
> * 实线实心箭头-同步调用、虚线空心箭头-返回、实线空心箭头-异步调用



## <a name="class-diagram">类图</a>

























