## Behavioral Design Patterns

Behavioral patterns provide solution for the better interaction between objects and how to provide lose coupling and flexibility to extend easily.

1. 

2. 

3. ### Template Method Pattern

   Template Method is a behavioral design pattern and it’s used to create a method stub and deferring some of the steps of implementation to the subclasses. Template method defines the steps to execute an algorithm and it can provide a default implementation that might be common for all or some of the subclasses.

   Suppose we want to provide an algorithm to build a house. The steps need to be performed to build a house are – building a foundation, building pillars, building walls, and windows. The important point is that we can’t change the order of execution because we can’t build windows before building the foundation. So, in this case, we can create a template method that will use different methods to build the house. Check out **[Template Method Pattern](https://www.journaldev.com/1763/template-method-design-pattern-in-java)** post for implementation details with example program.

4. 

5. ### Mediator Pattern

   The mediator design pattern is used to provide a centralized communication medium between different objects in a system. The mediator design pattern is very helpful in an enterprise application where multiple objects are interacting with each other. If the objects interact with each other directly, the system components are tightly coupled with each other that makes maintainability cost higher and not flexible to extend easily. Mediator pattern focuses on to provide a mediator between objects for communication and help in implementing lose-coupling between objects.

   Air traffic controller is a great example of a mediator pattern where the airport control room works as a mediator for communication between different flights. The mediator works as a router between objects and it can have it’s own logic to provide a way of communication. Check out **[\**Mediator Pattern\**](https://www.journaldev.com/1730/mediator-design-pattern-java)** post for implementation details with example program.

6. 

7. ### Chain of Responsibility Pattern

   Chain of responsibility pattern is used to achieve loose coupling in software design where a request from the client is passed to a chain of objects to process them. Then the object in the chain will decide themselves who will be processing the request and whether the request is required to be sent to the next object in the chain or not.

   We know that we can have multiple catch blocks in a try-catch block code. Here every catch block is kind of a processor to process that particular exception. So when an exception occurs in the try block, it’s sent to the first catch block to process. If the catch block is not able to process it, it forwards the request to next object in chain i.e next catch block. If even the last catch block is not able to process it, the exception is thrown outside of the chain to the calling program.

   ATM dispense machine logic can be implemented using **[Chain of Responsibility Pattern](https://www.journaldev.com/1617/chain-of-responsibility-design-pattern-in-java)**, check out the linked post.

8. 

9. ### Observer Pattern

   Observer design pattern is useful when you are interested in the state of an object and want to get notified whenever there is any change. In observer pattern, the object that watch on the state of another object are called **Observer** and the object that is being watched is called **Subject**.

   Java provides an inbuilt platform for implementing Observer pattern through java.util.Observable class and java.util.Observer interface. However, it’s not widely used because the implementation is really simple and most of the times we don’t want to end up extending a class just for implementing Observer pattern as java doesn’t provide multiple inheritances in classes.

   Java Message Service (JMS) uses Observer pattern along with Mediator pattern to allow applications to subscribe and publish data to other applications. Check out **[Observer Pattern](https://www.journaldev.com/1739/observer-design-pattern-in-java)** post for implementation details and example program.

10. 

11. ### Strategy Pattern

    Strategy pattern is used when we have multiple algorithm for a specific task and client decides the actual implementation to be used at runtime.

    Strategy pattern is also known as Policy Pattern. We define multiple algorithms and let client application pass the algorithm to be used as a parameter. One of the best examples of this pattern is the Collections.sort() method that takes the [Comparator](https://www.journaldev.com/780/comparable-and-comparator-in-java-example) parameter. Based on the different implementations of Comparator interfaces, the Objects are getting sorted in different ways.

    Check out **[Strategy Pattern](https://www.journaldev.com/1754/strategy-design-pattern-in-java-example-tutorial)** post for implementation details and example program.

12. 

13. ### Command Pattern

    Command Pattern is used to implement lose coupling in a request-response model. In command pattern, the request is send to the invoker and *invoker* pass it to the encapsulated *command* object. Command object passes the request to the appropriate method of *Receiver* to perform the specific action.

    Let’s say we want to provide a File System utility with methods to open, write and close the file and it should support multiple operating systems such as Windows and Unix.

    To implement our File System utility, first of all, we need to create the receiver classes that will actually do all the work. Since we code in terms of Java interfaces, we can have FileSystemReceiver interface and it’s implementation classes for different operating system flavors such as Windows, Unix, Solaris etc. Check out **[Command Pattern](https://www.journaldev.com/1624/command-design-pattern)** post for the implementation details with example program.

14. 

15. ### State Pattern

    State design pattern is used when an Object change it’s behavior based on it’s internal state.

    If we have to change the behavior of an object based on its state, we can have a state variable in the Object and use if-else condition block to perform different actions based on the state. State pattern is used to provide a systematic and loosely coupled way to achieve this through Context and State implementations.

    Check out **[State Pattern](https://www.journaldev.com/1751/state-design-pattern-java)** post for implementation details with example program.

16. 

17. ### Visitor Pattern

    Visitor pattern is used when we have to perform an operation on a group of similar kind of Objects. With the help of visitor pattern, we can move the operational logic from the objects to another class.

    For example, think of a Shopping cart where we can add a different type of items (Elements), when we click on the checkout button, it calculates the total amount to be paid. Now we can have the calculation logic in item classes or we can move out this logic to another class using visitor pattern. Let’s implement this in our example of a visitor pattern. Check out **[Visitor Pattern](https://www.journaldev.com/1769/visitor-design-pattern-java)** post for implementation details.

18. 

19. ### Interpreter Pattern

    is used to defines a grammatical representation for a language and provides an interpreter to deal with this grammar.

    The best example of this pattern is java compiler that interprets the java source code into byte code that is understandable by JVM. Google Translator is also an example of an interpreter pattern where the input can be in any language and we can get the output interpreted in another language.

    Check out **[Interpreter Pattern](https://www.journaldev.com/1635/interpreter-design-pattern-java)** post for example program.

20. 

21. ### Iterator Pattern

    Iterator pattern in one of the behavioral pattern and it’s used to provide a standard way to traverse through a group of Objects. Iterator pattern is widely used in [Java Collection Framework](https://www.journaldev.com/1260/collections-in-java-tutorial) where Iterator interface provides methods for traversing through a collection.

    Iterator pattern is not only about traversing through a collection, but we can also provide different kind of iterators based on our requirements. Iterator pattern hides the actual implementation of traversal through the collection and client programs just use iterator methods. Check out **[Iterator Pattern](https://www.journaldev.com/1716/iterator-design-pattern-java)** post for example program and implementation details.

22. 

23. ### Memento Pattern

    The memento design pattern is used when we want to save the state of an object so that we can restore later on. Memento pattern is used to implement this in such a way that the saved state data of the object is not accessible outside of the object, this protects the integrity of saved state data.

    Memento pattern is implemented with two objects – Originator and Caretaker. The originator is the object whose state needs to be saved and restored and it uses an inner class to save the state of Object. The inner class is called Memento and it’s private so that it can’t be accessed from other objects.

    Check out **[Memento Pattern](https://www.journaldev.com/1734/memento-design-pattern-java)** for sample program and implementation details.