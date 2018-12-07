# 迪米特原则



#### 定义

---

>**[迪米特原则](https://en.wikipedia.org/wiki/Law_of_Demeter)(LoD: Law of Demeter)** 或**最少知识原则(LKP: Least Knowledge Principle)**
>
>* 应该限制每个单元对其他单元的知识了解，除非这些单元与当前单元关系紧密。
>* 每个单元应该只能和它关系紧密的“朋友”进行交互，而不和“陌生人”说话。
>* 只与你的直接朋友交谈。

一个类对其他类的细节了解应该尽可能的少。

#### 用例

---

* 场景：乐队`Band`、歌手`Singer`、鼓手`Drummer`、吉他手`Guitarist`。

```java
/**
 * 歌手
 */
public class Singer{
    
    //姓名
    private String name;
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
}

/**
 * 鼓手
 */
public class Drummer{
    
    //姓名
    private String name;
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
}

/**
 * 吉他手
 */
public class Guitarist{
    
    //姓名
    private String name;
    //吉他设备号
    private String devNum;
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void setDevNum(String devNum){
        this.devNum = devNum;
    }
    public String getDevNum(){
        return guitarNo;
    }
    
}

/**
 * 乐队实体
 */
public class Band{
    
    private String bandName;
    
    private Singer singer;
    private Drummer drummer;
    private Guitarist guitarist;
    
    private Band(){
        
    }
    
    public Band(String bandName, Singer singer, Drummer drummer, Guitarist guitarist){
        this.bandName = bandName;
        this.singer = singer;
        this.drummer = durmmer;
        this.guistarist = guistarist;
    }
    
    public Singer getSinger(){
        return singer;
    }
    
    public Drummer getDrummer(){
        return drummmer;
    }
    
    public Guitarist getGuitarist(){
        return guitarist;
    }
    
}

/**
 * 乐队演出服务
 */
public class ActionServer{
    
    /**
     * 表演
     */
    public void action(Band band){      
		......
    }    
    
}

public class TestDemo{
    
    public static  Band band;
    
    //乐队进行商业演出
    public void businessAction(){
        
        String bandName = "皇后";
        
        Singer singer = new Singer();
        singer.setName = ("旺财");
        
        Drummer drummer = new Drummer();
        durmmer.setName = ("二哈");
        
        Guitarist guitarist = new Guitarist();
        guitarist.setName("老王");
        guitarist.setDevNo("666");
        
        band = new Band(bandName, singer, drummer, guitarist);
        
        //演出
        ActionServer action = new ActionServer();
        action.action(band);
  
    }    
    
}

```

* 由歌手旺财、鼓手二哈、吉他手老王(老王用666型号的吉他)组成的乐队进行了一场商演。



#### 问题

---

* 现在皇后乐队要参加一场慈善演出，慈善演出需要登记演出人员的信息。修改`TestDemo`，由于是同一支乐队演出，只需添加`philanthropyAction()`慈善演出方法和`register()`人员信息登记方法。



```java

public class TestDemo{
    
    public static  Band band;
    
    //乐队进行商业演出
    public void businessAction(){
        
        String bandName = "皇后";
        
        Singer singer = new Singer();
        singer.setName = ("旺财");
        
        Drummer drummer = new Drummer();
        durmmer.setName = ("二哈");
        
        Guitarist guitarist = new Guitarist();
        guitarist.setName("老王");
        guitarist.setDevNo("666");
        
        band = new Band(bandName, singer, drummer, guitarist);
        
        //演出
        ActionServer action = new ActionServer();
        action.action(band);
  
    }    
    
    //乐队进行慈善演出
    public void philanthropyAction(){
        
        //登记演出人员信息
        register(band);
        
        //表演
        ActionServer action = new ActionServer();
        action.action(band);
        
    }
    
    //登记演出人员信息
    public void register(Band band){
        
        String singerName = band.getSinger().getName();
        String drummerName = band.getDrummer().getName();
        String guitaristName = band.getGuitarist().getName();
        
        ......
        System.out.println("演出人员信息登记成功");
        ......
            
        //工作人员在登记演出人员信息时，不小心做了危险操作
        band.getGuitarist().setDevNum("888");
    }
    
}
```

* 对于`register()`信息登记方法来说，它应该只关注演出人员的姓名属性，但是由于系统设计的缺陷，使得`register()`有了吉他设备号字段的操作权限，就方法本身而言`devNum`毫无卵用，但是设备的更换很可能会影响`Guitarist`吉他手的演出。
* 这种代码结构设计过多的暴露了`Singer`,`Drummer`,`Guitarist`类的信息，外部调用者可以轻松的通过`Band`类操作它们的信息，显然违背了**LoD**。



#### 优化

---

* 调整一下`Band`类的实现方式

```java
/**
 * 乐队实体
 */
public class Band{
    
    private String bandName;
    
    private Singer singer;
    private Drummer drummer;
    private Guitarist guitarist;
    
    private Band(){
        
    }
    
    public Band(String bandName, Singer singer, Drummer drummer, Guitarist guitarist){
        this.bandName = bandName;
        this.singer = singer;
        this.drummer = durmmer;
        this.guistarist = guistarist;
    }
    
    public String getSingerName(){
        return singer.getName();
    }
    
    public String getDrummerName(){
        return drummmer.getName();
    }
    
    public String getGuitaristName(){
        return guitarist.getName();
    }
    
}
```

* 对于乐队而言，他只关心乐队的成员是谁，都负责哪些工作，并不需要知晓成员自身的细节，比如吉他手使用那种吉他设备并不是乐队需要关心，这种细节问题只需要吉他手自己去处理即可。我们通过调整代码屏蔽了乐队对象对乐队成员对象的直接访问，只暴露出`Band`感兴趣的属性。



#### 结论

---

* `guitaristName = band.getGuitarist().getName()`与`guitaristName = band.getGuitaristName()`最终目的是相同的，遇到这种情况我们应该尽可能地按需分配。两个类之间进行信息交互时，要把握信息共享的权限问题，在访问感兴趣数据的同时，要注意非相关信息的隐私问题，被对方掌握的把柄越多，对自己的威胁就越大。

* 增加非相关属性的访问，就增加了被调用类可变性。设计类时一旦对外开放某个属性或方法，类的使用者一般都会潜意识的认为这个开放点是可以被肆意访问，这种访问对调用层级较深的代码结构来说是非常危险的，容易造成高层模块修改低层模块的问题，而一旦这个被动修改底层模块同时其他高层模块调用，会产生蝴蝶效应。   
* 一个类的属性只允许它的直接调用者进行访问，屏蔽间接访问的行为。      



#### 思考

---

* **LoD**非常矜持，只和关系好的朋友说话，从来不和陌生人打交道，作为她的朋友，我们也要替她保守秘密。











