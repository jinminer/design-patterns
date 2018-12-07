# 接口隔离原则



#### 定义

---

>**[接口隔离原则](https://zh.wikipedia.org/wiki/%E6%8E%A5%E5%8F%A3%E9%9A%94%E7%A6%BB%E5%8E%9F%E5%88%99) (ISP: interface segregation principles)** 指明客户(client)应该不依赖于它不使用的方法。**ISP**拆分非常庞大臃肿的接口成为更小的和更具体地接口，这样客户只需要知道他们感兴趣的方法。
>
>**ISP** 目的是系统解开耦合，从而容易重构，更改和重新部署。



#### 用例

---

* 公交车

```java
/**
 * 汽车接口
 */
public interface Car{
    
    //驾驶驱动
    public void drive();
    
    //刹车
    public void stop();
    
    //加油
    public void fill();
    
    //载客
    public void carryPeople();
    
}
```

* 如果我们需要一个汽车实例，只需要写一个类实现`Car`接口即可。



#### 问题

---

* 上面的例子定义了一个汽车接口，包含了`drive()`，`stop()`，`fill()`，`carryPeople()` 方法。但是我们仔细思考发现，对于一个汽车来说`carryPeople()`类可能不是所有汽车共有的行为，比如F1赛车，它不具备载客的属性，这个时候我们再通过实现`Car`接口去创建F1赛车的对象，`carryPeople()` 方法的局面就很尴尬，实现这个功能或者是把方法制空都不是很好的的选择。
* 对于赛车对象而言`carryPeople()` 方法是冗余代码，它不具备这种能力，也不需要这种能力。



#### 优化

---

* 通过继承隔离接口

  * 既然`carryPeople()`不是所有汽车都具有的行为，那么我们试着把它分开。以轿车为例：

  ```java
  /**
   * 汽车接口
   */
  public interface Car{
      
      //驾驶驱动
      public void drive();
      
      //刹车
      public void stop();
      
      //加油
      public void fill();
      
  }
  
  /**
   * 轿车接口
   */
  public inerface MotorCar extends Car{
      //载客
      public void carryPeople();
  }
  ```

  * 我们定义了一个轿车接口，把`carryPeople()`载客行为单独分离开来，这样实现`Car`接口创建F1赛车的对象就不会出现代码冗余的情况(这里对F1赛车特有的行为暂不考虑)，而通过实现`MotorCar`接口创建的轿车对象也会满足载客功能。



* 通过实现多个接口分离接口

  * 坦克具有驾驶驱动、刹车、加油、载人以及战斗的行为，那么我们是不是也像`MotorCar`接口的设计那样，运用继承的方式去实现呢？让坦克接口去继承`MotorCar`接口，从逻辑上来看是正确的，坦克确实具备`MotorCar`接口的所有行为。

  * 但是从生活实际来看，在汽车体系中坦克的这种战斗行为略显突兀，使用继承`MotorCar`的方式去定义坦克接口会显得格格不入。我们用另一种方式来描述坦克接口：

    ```java
    /**
     * 坦克接口
     */
    public inerface Tank{
        //战斗
        public void fight();
    }
    
    public class TankImpl implements MotorCar, Tank{
        //驾驶驱动
        public void drive(){
            ......
        }
        
        //刹车
        public void stop(){
            ......
        }
        
        //加油
        public void fill(){
            ......
        }
        
        //载客
        public void carryPeople(){
            ......
        }
        
        //战斗
        public void fight(){
            ......
        }
    }
    ```

  * 我们用实现多个接口的方式创建了坦克类，这种方式对于处理那些体系之外的特殊行为是非常合理的。



#### 结论

---

* 接口的设计承担过多的职责，导致派生类必须实现某些它用不到的功能，这样不仅增加了接口间的耦合，还会带来不必要的复杂性，造成接口污染。
* 使用继承或实现多个接口的方式分离接口，推断接口实现类功能之间的交集，而且要让这个交集尽可能的小。另外还需要关注接口使用者(客户程序)的行为，因为客户程序也有可能影响它们所使用的接口，所以合理的分割客户程序(业务类)也有利于接口隔离。



#### 思考

---

* 使用委托隔离接口
  * 餐厅厨师做一碗牛肉面：
    * 拉面师完成拉面工作
    * 调味师完成捞加汤、调味等工作

  * 对于拉面师和调味师来说他们操作相同的数据(面)，他们也有各自的特性行为，看起来要做成一碗拉面，同一个实例对象必须实现这两个接口的所有方法，用**接口继承**和**实现多接口**的办法可以解决这个问题,其实不然。

  * 拉面师和调味师是完全不同的两类人(不同体系),如果由一个对象去实现这两个完全不同的体系，也会稍显臃肿。需要注意的是我们不能把拉面这个例子和坦克的例子混为一谈。
    * 坦克用例中，系统设计的侧重于同一类事物的不同行为表现，关注点是`fight()`这个坦克特有的行为
    * 牛肉面用例描述的是两类不同的事物(拉面师/调味师)处理同一个数据(面条)的过程。

  * 那么我们怎么分离必须在一起实现的接口呢？换句话说，一个对象的使用者是不是必须通过该对象的接口去访问它？来看下面这个例子。

    ```java
    /**
     * 拉面实体
     */
    public class Noodles{
        ......
    }
    
    /**
     * 牛肉面拉面师接口
     */
    public interface HandPulledCook{
        
        //拉面
        public Noodles handPulled();
        
    }
    
    /**
     * 牛肉面调味师接口
     */
    public interface FlavorCook{
        
        //加汤
        public void soup(Noodles noodles);
        //调味
        public void flavor(Noodles noodles);
        
    }
    
    public class HandPulledCooker implements HandPulledCook{
        //拉面
        public void handPulled(){
            ......
        }
    }
    
    /**
     * 厨师适配器
     */
    public class CookerAdapter implements FlavorCook{
        
        private Noodles noodles;
        
        private CookerAdapter(){
            
        }
        
        public CookerAdapter(HandPulledCook handPulledCook){
            this.noodles = handPulledCook.handPulled();
        }
        
        //加汤
        public void soup(){
            ......
            //noodles加汤
            ......
        }
        //调味
        public void flavor(){
            ......
            //noodles调味
            ......
        }
        
    }
    ```

  * 我们创建了一个对象`CookerAdapter`，它是`FlavorCook`的一个派生类，会将`HandPulledCook`实现类生产的拉面以委托的方式进行使用。与直接实现接口不同的是，`HandPulledCook`的实现类作为该类构造函数的一个参数，通过这种参数传递的方式将`HandPulledCook`和`FlavorCook`接口之间的行为关联了起来。

    * 对于`CookerAdapter`和`HandPulledCook`的实现类而言，他们的行为处理对象都是`Noodles`,也就是他们都访问相同的数据。
    * `HandPulledCook`作为参数是因为业务流程的顺序性问题，只有拉面厨师完成了自己的工作，调味厨师才能开始自己的工作。
    * `CookerAdapter`同样保证了接口之间的隔离性，如果新增一个调味厨师就创建一个新的`CookerAdapter`，而换一个拉面厨师`CookerAdapter`的内部实现则不用改变。

* 当然这种接口隔离规则也存在弊病，为了保证接口调用的顺序性，我们在创建`CookerAdapter`时去初始化一碗拉好的面条，这意味着每做一碗面都要`new`一个`CookerAdapter`，显然存在资源浪费。



