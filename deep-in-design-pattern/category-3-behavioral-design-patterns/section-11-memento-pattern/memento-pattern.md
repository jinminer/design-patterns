Memento [design pattern](https://www.journaldev.com/1827/java-design-patterns-example-tutorial) is one of the behavioral design pattern. Memento design pattern is used when we want to save the state of an object so that we can restore later on. Memento pattern is used to implement this in such a way that the saved state data of the object is not accessible outside of the object, this protects the integrity of saved state data.



## Memento Design Pattern

[![memento design pattern java, memento pattern](https://cdn.journaldev.com/wp-content/uploads/2013/07/memento-design-pattern.png)](https://cdn.journaldev.com/wp-content/uploads/2013/07/memento-design-pattern.png)
Memento design pattern is implemented with two objects – `Originator` and `Caretaker`.

Originator is the object whose state needs to be saved and restored and it uses an [inner class](https://www.journaldev.com/996/java-inner-class) to save the state of Object. The inner class is called **Memento** and it’s private, so that it can’t be accessed from other objects.

Caretaker is the helper class that is responsible for storing and restoring the Originator’s state through Memento object. Since Memento is private to Originator, Caretaker can’t access it and it’s stored as an Object within the caretaker.

### Memento Design Pattern Java

One of the best real life example is the text editors where we can save it’s data anytime and use undo to restore it to previous saved state.



We will implement the same feature and provide a utility where we can write and save contents to a File anytime and we can restore it to last saved state. For simplicity, I will not use any IO operations to write data into file.

### Memento Pattern Originator Class

```java
package com.journaldev.design.memento;

public class FileWriterUtil {

	private String fileName;
	private StringBuilder content;
	
	public FileWriterUtil(String file){
		this.fileName=file;
		this.content=new StringBuilder();
	}
	
	@Override
	public String toString(){
		return this.content.toString();
	}
	
	public void write(String str){
		content.append(str);
	}
	
	public Memento save(){
		return new Memento(this.fileName,this.content);
	}
	
	public void undoToLastSave(Object obj){
		Memento memento = (Memento) obj;
		this.fileName= memento.fileName;
		this.content=memento.content;
	}
	
	
	private class Memento{
		private String fileName;
		private StringBuilder content;
		
		public Memento(String file, StringBuilder content){
			this.fileName=file;
			//notice the deep copy so that Memento and FileWriterUtil content variables don't refer to same object
			this.content=new StringBuilder(content);
		}
	}
}
```

Notice the Memento inner class and implementation of save and undo methods. Now we can continue to implement Caretaker class.

### Memento Pattern Caretaker Class

```java
package com.journaldev.design.memento;

public class FileWriterCaretaker {

	private Object obj;
	
	public void save(FileWriterUtil fileWriter){
		this.obj=fileWriter.save();
	}
	
	public void undo(FileWriterUtil fileWriter){
		fileWriter.undoToLastSave(obj);
	}
}
```

Notice that caretaker object contains the saved state in the form of Object, so it can’t alter its data and also it has no knowledge of it’s structure.

### Memento Pattern Example Test Class

Lets write a simple test program that will use our memento pattern implementation.

```java
package com.journaldev.design.memento;

public class FileWriterClient {

	public static void main(String[] args) {
		
		FileWriterCaretaker caretaker = new FileWriterCaretaker();
		
		FileWriterUtil fileWriter = new FileWriterUtil("data.txt");
		fileWriter.write("First Set of Data\n");
		System.out.println(fileWriter+"\n\n");
		
		// lets save the file
		caretaker.save(fileWriter);
		//now write something else
		fileWriter.write("Second Set of Data\n");
		
		//checking file contents
		System.out.println(fileWriter+"\n\n");

		//lets undo to last save
		caretaker.undo(fileWriter);
		
		//checking file content again
		System.out.println(fileWriter+"\n\n");
		
	}

}
```

Output of above memento pattern example test program is:

```shell
First Set of Data



First Set of Data
Second Set of Data



First Set of Data
```

Memento pattern is simple and easy to implement, one of the thing needs to take care is that Memento class should be accessible only to the Originator object. Also in client application, we should use caretaker object for saving and restoring the originator state.

Also if Originator object has properties that are not [immutable](https://www.journaldev.com/129/how-to-create-immutable-class-in-java), we should use deep copy or cloning to avoid data integrity issue like I have used in above example. We can use [Serialization](https://www.journaldev.com/2452/serialization-in-java) to achieve memento pattern implementation that is more generic rather than Memento pattern where every object needs to have it’s own Memento class implementation.

One of the drawback is that if Originator object is very huge then Memento object size will also be huge and use a lot of memory.

