package CoreJava;

import java.util.ArrayList;

/*
 * ==========================================================
 * GENERICS IN JAVA
 * ==========================================================
 *
 * Generics were introduced in JDK 1.5.
 *
 * Purpose:
 * 1. Type Safety
 * 2. Eliminate explicit type casting
 * 3. Detect errors at compile time rather than runtime
 *
 * Before Generics:
 *
 * ArrayList list = new ArrayList();
 * list.add("Hello");
 * Integer num = (Integer) list.get(0); // Runtime Error
 *
 *
 * After Generics:
 *
 * ArrayList<String> list = new ArrayList<>();
 * list.add("Hello");
 * Integer num = list.get(0); // Compile Time Error
 *
 */

// ==========================================================
// GENERIC CLASS
// ==========================================================

// class Check<T>{
//
//     /*
//      * T is called a Type Parameter.
//      *
//      * It acts as a placeholder for any datatype.
//      *
//      * Common Naming Conventions:
//      * T -> Type
//      * E -> Element
//      * K -> Key
//      * V -> Value
//      */
//
//     T variable;
//
//     Check(T var){
//         this.variable = var;
//     }
//
//     void disp(){
//
//         /*
//          * getClass().getName()
//          * returns the runtime class name
//          */
//
//         System.out.println(variable.getClass().getName());
//     }
// }


// ==========================================================
// INHERITANCE HIERARCHY
// ==========================================================

// class Human{
//
// }
//
// class Student extends Human{
//
// }
//
// class Employee{
//
// }


public class Generics {

    public static void main(String[] args) {

        // ==========================================================
        // GENERIC OBJECT CREATION
        // ==========================================================

        /*
         * Here T becomes Integer.
         *
         * Check<Integer>
         *
         * Therefore:
         * variable type = Integer
         */

        // Check<Integer> c = new Check<>(5);
        // c.disp();


        /*
         * Here T becomes String.
         *
         * Check<String>
         *
         * Therefore:
         * variable type = String
         */

//        Check<String> c1 = new Check("String");
//        c1.disp();



        // ==========================================================
        // NORMAL INHERITANCE
        // ==========================================================

        /*
         * Child object can be assigned to Parent reference.
         */

        // Human h = new Human();
        // Student st = new Student();
        //
        // h = st;   // Valid (Upcasting)
        //
        // st = h;   // Compile Time Error
        //            (Downcasting requires explicit cast)



        // ==========================================================
        // GENERICS ARE INVARIANT
        // ==========================================================

        /*
         * Many beginners assume:
         *
         * Student IS-A Human
         *
         * Therefore:
         *
         * ArrayList<Student>
         * should be assignable to
         * ArrayList<Human>
         *
         * But Java DOES NOT allow this.
         *
         * Generics are INVARIANT.
         */

        // ArrayList<Human> hlist = new ArrayList<>();
        // ArrayList<Student> stlist = new ArrayList<>();
        //
        // hlist = stlist;    // Compile Time Error


        /*
         * Why?
         *
         * Suppose Java allowed:
         *
         * hlist = stlist;
         *
         * Then:
         *
         * hlist.add(new Human());
         *
         * would insert a Human object inside
         * ArrayList<Student>.
         *
         * This breaks type safety.
         */



        // ==========================================================
        // UNBOUNDED WILDCARD ( ? )
        // ==========================================================

        /*
         * ? means ANY TYPE.
         *
         * Also called:
         * Wildcard
         *
         * It can reference:
         *
         * ArrayList<Student>
         * ArrayList<Employee>
         * ArrayList<String>
         * ArrayList<Integer>
         * etc.
         */

        // ArrayList<?> hlist = new ArrayList<>();
        //
        // ArrayList<Student> stlist = new ArrayList<>();
        //
        // hlist = stlist;
        //
        // hlist = new ArrayList<Employee>();


        /*
         * Limitation:
         *
         * You cannot add elements
         * (except null)
         *
         * because compiler doesn't know
         * the actual type.
         */


        // ==========================================================
        // UPPER BOUNDED WILDCARD
        // ==========================================================

        /*
         * Syntax:
         *
         * <? extends Human>
         *
         * Means:
         * Human OR any subclass of Human
         *
         * Allowed:
         * Human
         * Student
         * Teacher
         * etc.
         */

        // ArrayList<? extends Human> hlist = new ArrayList<>();
        //
        // ArrayList<Student> stlist = new ArrayList<>();
        //
        // hlist = stlist;


        /*
         * Read as:
         *
         * "Anything that extends Human"
         *
         * Common use:
         * Reading data
         *
         * PECS Principle:
         *
         * Producer Extends
         *
         * If a collection PRODUCES data,
         * use extends.
         */


        // ==========================================================
        // LOWER BOUNDED WILDCARD
        // ==========================================================

        /*
         * Syntax:
         *
         * <? super Human>
         *
         * Means:
         * Human OR any parent of Human
         *
         * Allowed:
         * Human
         * Object
         */

        // ArrayList<? super Human> hlist = new ArrayList<>();
        //
        // ArrayList<Object> objlist = new ArrayList<>();
        //
        // hlist = objlist;


        /*
         * Read as:
         *
         * "Anything that is a supertype of Human"
         *
         * Common use:
         * Writing data
         *
         * PECS Principle:
         *
         * Consumer Super
         *
         * If a collection CONSUMES data,
         * use super.
         */


        // ==========================================================
        // PECS RULE (MOST ASKED INTERVIEW QUESTION)
        // ==========================================================

        /*
         * PECS
         *
         * P -> Producer
         * E -> Extends
         *
         * C -> Consumer
         * S -> Super
         *
         * Producer Extends
         * Consumer Super
         *
         * Example:
         *
         * Read Data:
         * List<? extends Human>
         *
         * Write Data:
         * List<? super Human>
         */
    }
}


/*
 * ==========================================================
 * INTERVIEW SUMMARY
 * ==========================================================
 *
 * 1. Generics provide Compile-Time Type Safety.
 *
 * 2. Generic Types are Invariant.
 *
 *    ArrayList<Student>
 *    is NOT a subtype of
 *    ArrayList<Human>.
 *
 * 3. Wildcards:
 *
 *    <?>
 *    -> Any Type
 *
 *    <? extends Human>
 *    -> Human and Child Classes
 *
 *    <? super Human>
 *    -> Human and Parent Classes
 *
 * 4. PECS Rule:
 *
 *    Producer -> Extends
 *    Consumer -> Super
 *
 * 5. Type parameters are removed at runtime
 *    through Type Erasure.
 */