package CoreJava;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class LegacyClassVector {

    public static void main(String[] args) {

        // ==========================================================
        // VECTOR
        // ==========================================================

        /*
         * Vector is a legacy collection class introduced in JDK 1.0.
         *
         * Characteristics:
         * 1. Dynamic array implementation.
         * 2. Maintains insertion order.
         * 3. Allows duplicate elements.
         * 4. Allows null values.
         * 5. Methods are synchronized (Thread Safe).
         * 6. Slower than ArrayList because of synchronization overhead.
         *
         * Before the Collection Framework (JDK 1.2),
         * Vector was one of the most commonly used data structures.
         *
         * After Collection Framework was introduced,
         * Vector was retrofitted to implement:
         *
         * Collection -> List -> Vector
         */

        Vector v = new Vector();


        // ==========================================================
        // ADDING ELEMENTS
        // ==========================================================

        /*
         * addElement()
         * ------------
         * Legacy method available since JDK 1.0.
         *
         * add()
         * -----
         * Introduced through Collection Framework.
         *
         * Both methods perform exactly the same operation:
         * Add an element at the end of the Vector.
         */

        v.add(200);
        v.addElement(300);


        // ==========================================================
        // ITERATION USING ITERATOR
        // ==========================================================

        /*
         * Iterator was introduced as part of the Collection Framework.
         *
         * Features:
         * 1. Forward traversal only.
         * 2. Universal cursor for all Collection classes.
         * 3. Supports remove().
         * 4. Fail-Fast in nature.
         */

        // Iterator it = v.iterator();
        //
        // while(it.hasNext()) {
        //     System.out.println(it.next());
        // }


        // ==========================================================
        // ENUMERATION (LEGACY CURSOR)
        // ==========================================================

        /*
         * Before Iterator was introduced,
         * Vector and Hashtable used Enumeration for traversal.
         *
         * Enumeration is a legacy cursor introduced in JDK 1.0.
         *
         * Methods:
         * hasMoreElements() -> checks whether more elements exist
         * nextElement()     -> returns next element
         *
         * Limitations:
         * 1. Only forward traversal.
         * 2. No remove() method.
         * 3. Read-only access.
         * 4. Not a universal cursor.
         *
         * Enumeration is mainly used with:
         * - Vector
         * - Hashtable
         */

        Enumeration e = v.elements();

        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }


        // ==========================================================
        // INTERVIEW COMPARISON
        // ==========================================================

        /*
         * Enumeration vs Iterator
         *
         * Enumeration
         * -----------
         * -> Legacy cursor (JDK 1.0)
         * -> Used with Vector and Hashtable
         * -> Forward traversal only
         * -> No remove() support
         * -> Read-only operations
         *
         * Iterator
         * --------
         * -> Introduced in Collection Framework (JDK 1.2)
         * -> Works with all Collection classes
         * -> Forward traversal only
         * -> Supports remove()
         * -> Preferred over Enumeration
         */


        // ==========================================================
        // VECTOR vs ARRAYLIST
        // ==========================================================

        /*
         * ArrayList
         * ---------
         * -> Not synchronized
         * -> Faster
         * -> Introduced in Collection Framework
         *
         * Vector
         * ------
         * -> Synchronized
         * -> Thread-safe
         * -> Slightly slower
         * -> Legacy class
         *
         * Modern applications generally prefer ArrayList.
         * Use Vector only when legacy compatibility is required.
         */
    }
}