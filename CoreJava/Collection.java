package CoreJava;

import java.util.ArrayList;
import java.util.ListIterator;

public class Collection {

    public static void main(String[] args) {

        // --------------------------------------------
        // Creating an ArrayList and adding elements
        // --------------------------------------------
        ArrayList list = new ArrayList();

        list.add(100);
        list.add(200);
        list.add(400);
        list.add(300);

        // ==========================================================
        // CASE 1: Modifying ArrayList while iterating using for-loop
        // ==========================================================

        /*
         * A normal for-loop does not track structural modifications
         * happening inside the collection.
         *
         * Therefore, adding elements while iterating does NOT throw
         * ConcurrentModificationException.
         *
         * However, since size() keeps increasing, the loop may never end
         * and can result in an infinite loop.
         */

        // for(int i = 0; i < list.size(); i++) {
        //     System.out.println(list.get(i));
        //     list.add(44);
        // }


        // ==========================================================
        // CASE 2: Modifying ArrayList while using Iterator
        // ==========================================================

        /*
         * Iterator is FAIL-FAST.
         *
         * When an Iterator is created, it internally remembers the
         * modification count (modCount) of the collection.
         *
         * If the collection is structurally modified after the iterator
         * is created (except through iterator.remove()),
         * Iterator detects the change and throws:
         *
         * ConcurrentModificationException
         */

        // Iterator it = list.iterator();
        //
        // while(it.hasNext()) {
        //     System.out.println(it.next());
        //
        //     // Structural modification
        //     list.add(44);
        // }
        //
        // Output:
        // ConcurrentModificationException


        // ==========================================================
        // LISTITERATOR
        // ==========================================================

        /*
         * ListIterator is a child interface of Iterator.
         *
         * Additional Features:
         * 1. Can move in both directions.
         * 2. Can iterate forward and backward.
         * 3. Can add, remove, and update elements.
         * 4. Works only with List implementations.
         */

        // Forward Traversal

        // ListIterator litr = list.listIterator();
        //
        // while(litr.hasNext()) {
        //     System.out.println(litr.next());
        // }


        // ==========================================================
        // Reverse Traversal using ListIterator
        // ==========================================================

        /*
         * To traverse in reverse order:
         * Start iterator at the last position by passing list.size()
         *
         * hasPrevious() -> checks if previous element exists
         * previous()    -> returns previous element
         */

        ListIterator litr = list.listIterator(list.size());

        while (litr.hasPrevious()) {
            System.out.println(litr.previous());
        }


        // ==========================================================
        // FAIL-FAST vs FAIL-SAFE COLLECTIONS
        // ==========================================================

        /*
         * FAIL-FAST COLLECTIONS
         * ---------------------
         * Examples:
         * - ArrayList
         * - HashMap
         * - HashSet
         *
         * These collections throw
         * ConcurrentModificationException
         * when modified during iteration.
         */


        /*
         * FAIL-SAFE COLLECTIONS
         * ---------------------
         * Example:
         * CopyOnWriteArrayList
         *
         * Instead of working on the original collection,
         * Iterator works on a separate snapshot (copy).
         *
         * Therefore, modifications can happen safely
         * while iteration is in progress.
         *
         * No ConcurrentModificationException occurs.
         */


        // CopyOnWriteArrayList al = new CopyOnWriteArrayList();
        //
        // al.add(400);
        // al.add(200);
        // al.add(300);
        //
        // Iterator it = al.iterator();
        //
        // while(it.hasNext()) {
        //
        //     // Iterating over snapshot copy
        //     System.out.println(it.next());
        //
        //     // Safe modification
        //     al.add(40);
        // }
        //
        // No ConcurrentModificationException


        // ==========================================================
        // INTERVIEW SUMMARY
        // ==========================================================

        /*
         * Iterator
         * --------
         * -> Forward traversal only
         * -> Works on all CoreJava.Collection classes
         * -> Fail-Fast
         *
         * ListIterator
         * ------------
         * -> Forward and Backward traversal
         * -> Works only with List implementations
         * -> Supports add(), remove(), set()
         * -> Fail-Fast
         *
         * CopyOnWriteArrayList
         * --------------------
         * -> Thread-safe collection
         * -> Fail-Safe iterator
         * -> Iterator works on snapshot copy
         * -> Suitable when reads are much more frequent than writes
         */
    }
}