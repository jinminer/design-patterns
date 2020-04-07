Interpreter [design pattern](https://www.journaldev.com/1827/java-design-patterns-example-tutorial) is one of the **behavioral design pattern**. Interpreter pattern is used to defines a grammatical representation for a language and provides an interpreter to deal with this grammar.



## Interpreter Design Pattern

The best example of interpreter design pattern is java compiler that interprets the java source code into byte code that is understandable by [JVM](https://www.journaldev.com/546/difference-jdk-vs-jre-vs-jvm). Google Translator is also an example of interpreter pattern where the input can be in any language and we can get the output interpreted in another language.



### Interpreter Pattern Example

To implement interpreter pattern, we need to create Interpreter context engine that will do the interpretation work.

Then we need to create different Expression implementations that will consume the functionalities provided by the interpreter context.

Finally we need to create the client that will take the input from user and decide which Expression to use and then generate output for the user.



Let’s understand this with an example where the user input will be of two forms – “` in Binary`” or “` in Hexadecimal`.” Our interpreter client should return it in format “` in Binary= `” and “` in Hexadecimal= `” respectively.

Our first step will be to write the Interpreter context class that will do the actual interpretation.

```java
package com.journaldev.design.interpreter;

public class InterpreterContext {

	public String getBinaryFormat(int i){
		return Integer.toBinaryString(i);
	}
	
	public String getHexadecimalFormat(int i){
		return Integer.toHexString(i);
	}
}
```

Now we need to create different types of Expressions that will consume the interpreter context class.

```java
package com.journaldev.design.interpreter;

public interface Expression {

	String interpret(InterpreterContext ic);
}
```

We will have two expression implementations, one to convert int to binary and other to convert int to hexadecimal format.

```java
package com.journaldev.design.interpreter;

public class IntToBinaryExpression implements Expression {

	private int i;
	
	public IntToBinaryExpression(int c){
		this.i=c;
	}
	@Override
	public String interpret(InterpreterContext ic) {
		return ic.getBinaryFormat(this.i);
	}

}
package com.journaldev.design.interpreter;

public class IntToHexExpression implements Expression {

	private int i;
	
	public IntToHexExpression(int c){
		this.i=c;
	}
	
	@Override
	public String interpret(InterpreterContext ic) {
		return ic.getHexadecimalFormat(i);
	}

}
```

Now we can create our client application that will have the logic to parse the user input and pass it to correct expression and then use the output to generate the user response.

```java
package com.journaldev.design.interpreter;

public class InterpreterClient {

	public InterpreterContext ic;
	
	public InterpreterClient(InterpreterContext i){
		this.ic=i;
	}
	
	public String interpret(String str){
		Expression exp = null;
		//create rules for expressions
		if(str.contains("Hexadecimal")){
			exp=new IntToHexExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
		}else if(str.contains("Binary")){
			exp=new IntToBinaryExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
		}else return str;
		
		return exp.interpret(ic);
	}
	
	public static void main(String args[]){
		String str1 = "28 in Binary";
		String str2 = "28 in Hexadecimal";
		
		InterpreterClient ec = new InterpreterClient(new InterpreterContext());
		System.out.println(str1+"= "+ec.interpret(str1));
		System.out.println(str2+"= "+ec.interpret(str2));

	}
}
```

The client also has a main method for testing purpose, when we run above we get following output:

```shell
28 in Binary= 11100
28 in Hexadecimal= 1c
```

### Interpreter Design Pattern Example Class Diagram

![interpreter design pattern in java](https://cdn.journaldev.com/wp-content/uploads/2013/07/interpreter-pattern-java.png)

### Important Points about Interpreter pattern

1. Interpreter pattern can be used when we can create a syntax tree for the grammar we have.
2. Interpreter design pattern requires a lot of error checking and a lot of expressions and code to evaluate them. It gets complicated when the grammar becomes more complicated and hence hard to maintain and provide efficiency.
3. `java.util.Pattern` and subclasses of `java.text.Format` are some of the examples of interpreter pattern used in JDK.



