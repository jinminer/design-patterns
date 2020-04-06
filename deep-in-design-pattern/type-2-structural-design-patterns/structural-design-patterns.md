## Structural Design Patterns

Structural patterns provide different ways to create a class structure, for example using inheritance and composition to create a large object from small objects.

1. 

2. 

3. ### Adapter Pattern

   The adapter design pattern is one of the structural design patterns and it’s used so that two unrelated interfaces can work together. The object that joins these unrelated interfaces is called an Adapter. As a real-life example, we can think of a mobile charger as an adapter because the mobile battery needs 3 volts to charge but the normal socket produces either 120V (US) or 240V (India). So the mobile charger works as an adapter between the mobile charging socket and the wall socket. Check out **[Adapter Pattern](https://www.journaldev.com/1487/adapter-design-pattern-java)** for example program and it’s usage in Java.

4. 

5. ### Composite Pattern

   Composite pattern is one of the Structural design patterns and is used when we have to represent a part-whole hierarchy. When we need to create a structure in a way that the objects in the structure have to be treated the same way, we can apply the composite design pattern.

   Let’s understand it with a real-life example – A diagram is a structure that consists of Objects such as Circle, Lines, Triangle etc and when we fill the drawing with color (say Red), the same color also gets applied to the Objects in the drawing. Here drawing is made up of different parts and they all have the same operations. Check out **[Composite Pattern](https://www.journaldev.com/1535/composite-design-pattern-in-java)** article for different component of composite pattern and example program.

6. 

7. ### Proxy Pattern

   Proxy pattern intent is to “Provide a surrogate or placeholder for another object to control access to it”. The definition itself is very clear and proxy pattern is used when we want to provide controlled access of a functionality.

   Let’s say we have a class that can run some command on the system. Now if we are using it, it’s fine but if we want to give this program to a client application, it can have severe issues because client program can issue a command to delete some system files or change some settings that you don’t want. Check out **[Proxy Pattern](https://www.journaldev.com/1572/proxy-design-pattern)** post for the example program with implementation details.

8. 

9. ### Flyweight Pattern

   Flyweight design pattern is used when we need to create a lot of Objects of a class. Since every object consumes memory space that can be crucial for low memory devices, such as mobile devices or embedded systems, flyweight design pattern can be applied to reduce the load on memory by sharing objects. String Pool implementation in java is one of the best example of Flyweight pattern implementation. Check out **[Flyweight Pattern](https://www.journaldev.com/1562/flyweight-design-pattern-java)** article for sample program and implementation process.

10. 

11. ### Facade Pattern

    Facade Pattern is used to help client applications to easily interact with the system. Suppose we have an application with a set of interfaces to use MySql/Oracle database and to generate different types of reports, such as HTML report, PDF report etc. So we will have a different set of interfaces to work with different types of database. Now a client application can use these interfaces to get the required database connection and generate reports. But when the complexity increases or the interface behavior names are confusing, the client application will find it difficult to manage it. So we can apply Facade pattern here and provide a wrapper interface on top of the existing interface to help client application. Check out **[Facade Pattern](https://www.journaldev.com/1557/facade-design-pattern-in-java)** post for implementation details and sample program.

12. 

13. ### Bridge Pattern

    When we have interface hierarchies in both interfaces as well as implementations, then bridge design pattern is used to decouple the interfaces from implementation and hiding the implementation details from the client programs. Like Adapter pattern, it’s one of the Structural design pattern.

    The implementation of bridge design pattern follows the notion to prefer Composition over inheritance. Check out [Bridge Pattern](https://www.journaldev.com/1491/bridge-design-pattern-java) post for implementation details and sample program.

14. 

15. ### Decorator Pattern

    The decorator design pattern is used to modify the functionality of an object at runtime. At the same time, other instances of the same class will not be affected by this, so individual object gets the modified behavior. The decorator design pattern is one of the structural design pattern (such as Adapter Pattern, Bridge Pattern, Composite Pattern) and uses abstract classes or interface with the composition to implement.

    We use inheritance or composition to extend the behavior of an object but this is done at compile time and it’s applicable to all the instances of the class. We can’t add any new functionality to remove any existing behavior at runtime – this is when Decorator pattern comes into the picture. Check out [**Decorator Pattern**](https://www.journaldev.com/1540/decorator-design-pattern-in-java-example) post for sample program and implementation details.