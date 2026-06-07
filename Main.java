/*
=========================================================
JAVA OOP CONCEPTS NOTES
=========================================================

1. Inner Class
-------------
A class defined inside another class is called an Inner Class.

Example:
class Person {
    class Phone {
    }
}

Advantages:
- Better grouping of related classes.
- Can access outer class members directly.

---------------------------------------------------------

2. Abstract Class
-----------------
An abstract class cannot be instantiated.

It may contain:
- Abstract methods (without body)
- Concrete methods (with body)

Example:

abstract class A {
    abstract void show();
}

Any subclass must implement the abstract methods.

---------------------------------------------------------

3. Interface
------------
An interface defines a contract.

Before Java 8:
- Only abstract methods were allowed.

Java 8:
- Default methods
- Static methods

Java 9:
- Private methods

---------------------------------------------------------

Types of Interfaces

1. Normal Interface
   - More than one abstract method

2. Functional Interface (SAM)
   - Single Abstract Method
   - Used with Lambda Expressions

3. Marker Interface
   - No methods
   - Example: Serializable, Cloneable

---------------------------------------------------------

4. Functional Interface
------------------------
A functional interface contains exactly one abstract method.

Example:

@FunctionalInterface
interface A {
    void show();
}

---------------------------------------------------------

5. Default Method
-----------------
Allows implementation inside interface.

default void disp() {
    System.out.println("Default Method");
}

---------------------------------------------------------

6. Anonymous Inner Class
-------------------------
A class without a name used for one-time implementation.

Example:

A obj = new A() {
    public void show() {
        System.out.println("Implementation");
    }
};

---------------------------------------------------------

7. Lambda Expression
---------------------
Short way of implementing Functional Interfaces.

Example:

A obj = () -> System.out.println("Hello");

Only works with Functional Interfaces.

=========================================================
*/

@FunctionalInterface
interface A {

    // Single Abstract Method (SAM)
    void show();

    // Default Method
    default void disp() {
        System.out.println("This is the default method");
    }

    /*
     * Not counted as an abstract method because
     * toString() already exists in Object class.
     */
    String toString();
}


// ------------------------------------------------------
// Outer Class
// ------------------------------------------------------
class Person {

    String name;
    int age;

    public void show() {
        System.out.println("Inside Person Class");
    }

    // Inner Class
    class Phone {

        int number;
        String features;

        public void display() {
            System.out.println("Inside Phone Class");
        }
    }
}


// ------------------------------------------------------
// Abstract Class Example
// ------------------------------------------------------
abstract class Vehicle {

    abstract void start();

    public void stop() {
        System.out.println("Vehicle Stopped");
    }
}


class Car extends Vehicle {

    @Override
    void start() {
        System.out.println("Car Started");
    }
}


// ------------------------------------------------------
// Main Class
// ------------------------------------------------------
public class Main {

    public static void main(String[] args) {

        // ==========================================
        // 1. Inner Class Example
        // ==========================================
        Person person = new Person();
        person.show();

        Person.Phone phone = person.new Phone();
        phone.display();


        // ==========================================
        // 2. Abstract Class Example
        // ==========================================
        Vehicle car = new Car();
        car.start();
        car.stop();


        // ==========================================
        // 3. Anonymous Inner Class
        // ==========================================
        A obj1 = new A() {
            @Override
            public void show() {
                System.out.println("Anonymous Inner Class Implementation");
            }
        };

        obj1.show();
        obj1.disp();


        // ==========================================
        // 4. Lambda Expression
        // ==========================================
        A obj2 = () ->
                System.out.println("Lambda Expression Implementation");

        obj2.show();
        obj2.disp();
    }
}