State [design pattern](https://www.journaldev.com/1827/java-design-patterns-example-tutorial) is one of the behavioral design pattern. State design pattern is used when an Object change its behavior based on its internal state.



## State Design Pattern

[![state design pattern, state design pattern in java, state pattern](https://cdn.journaldev.com/wp-content/uploads/2013/07/state-design-pattern.jpg)](https://cdn.journaldev.com/wp-content/uploads/2013/07/state-design-pattern.jpg)

If we have to change the behavior of an object based on its state, we can have a state variable in the Object. Then use **if-else** condition block to perform different actions based on the state. State design pattern is used to provide a systematic and loosely coupled way to achieve this through `Context` and `State` implementations.

State Pattern **Context** is the class that has a State reference to one of the concrete implementations of the State. Context forwards the request to the state object for processing. Let’s understand this with a simple example.

Suppose we want to implement a TV Remote with a simple button to perform action. If the State is ON, it will turn on the TV and if state is OFF, it will turn off the TV.



We can implement it using if-else condition like below;

```java
TVRemoteBasic.java
package com.journaldev.design.state;

public class TVRemoteBasic {

	private String state="";
	
	public void setState(String state){
		this.state=state;
	}
	
	public void doAction(){
		if(state.equalsIgnoreCase("ON")){
			System.out.println("TV is turned ON");
		}else if(state.equalsIgnoreCase("OFF")){
			System.out.println("TV is turned OFF");
		}
	}

	public static void main(String args[]){
		TVRemoteBasic remote = new TVRemoteBasic();
		
		remote.setState("ON");
		remote.doAction();
		
		remote.setState("OFF");
		remote.doAction();
	}

}
```

Notice that client code should know the specific values to use for setting the state of remote. Further more if number of states increase then the tight coupling between implementation and the client code will be very hard to maintain and extend.

Now we will use State pattern to implement above TV Remote example.

### State Design Pattern Interface

First of all we will create State interface that will define the method that should be implemented by different concrete states and context class.

```java
State.java
package com.journaldev.design.state;

public interface State {

	public void doAction();
}
```

### State Design Pattern Concrete State Implementations

In our example, we can have two states – one for turning TV on and another to turn it off. So we will create two concrete state implementations for these behaviors.

```java
TVStartState.java
package com.journaldev.design.state;

public class TVStartState implements State {

	@Override
	public void doAction() {
		System.out.println("TV is turned ON");
	}

}
TVStopState.java
package com.journaldev.design.state;

public class TVStopState implements State {

	@Override
	public void doAction() {
		System.out.println("TV is turned OFF");
	}

}
```

Now we are ready to implement our Context object that will change its behavior based on its internal state.

### State Design Pattern Context Implementation

```java
TVContext.java
package com.journaldev.design.state;

public class TVContext implements State {

	private State tvState;

	public void setState(State state) {
		this.tvState=state;
	}

	public State getState() {
		return this.tvState;
	}

	@Override
	public void doAction() {
		this.tvState.doAction();
	}

}
```

Notice that Context also implements State and keep a reference of its current state and forwards the request to the state implementation.

### State Design Pattern Test Program

Now let’s write a simple program to test our state pattern implementation of TV Remote.

```java
TVRemote.java
package com.journaldev.design.state;

public class TVRemote {

	public static void main(String[] args) {
		TVContext context = new TVContext();
		State tvStartState = new TVStartState();
		State tvStopState = new TVStopState();
		
		context.setState(tvStartState);
		context.doAction();
		
		
		context.setState(tvStopState);
		context.doAction();
		
	}

}
```

Output of above program is same as the basic implementation of TV Remote without using state pattern.

### State Design Pattern Benefits

The benefits of using State pattern to implement polymorphic behavior is clearly visible. The chances of error are less and it’s very easy to add more states for additional behavior. Thus making our code more robust, easily maintainable and flexible. Also State pattern helped in avoiding if-else or switch-case conditional logic in this scenario.

State Pattern is very similar to Strategy Pattern, check out **[Strategy Pattern in Java](https://www.journaldev.com/1754/strategy-design-pattern-in-java-example-tutorial)**.

Thats all for State design pattern in java, I hope you liked it.

