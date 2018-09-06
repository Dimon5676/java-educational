import java.util.ArrayList;
import java.util.List;

public class PList {
    List<Integer> list = new ArrayList();

    /**
     *
     * @param i element to add in the beginning of the list
     */
    void addToBegin(int i) {
        list.add(0, i);
        System.out.println("Element " + i + " is added to the beginning");
    }
    /**
     *
     * @param n index in which element will be inserted
     * @param i element to insert
     */
    void addToN(int n, int i) {
        list.add(n, i);
        System.out.println("Element " + i + " is added at " + n + " position");
    }

    /**
     *
     * @param i element to add in the end of the list
     */
    void addToEnd(int i) {
        list.add(i);
        System.out.println("Element " + i + " is added in the ending of the list");
    }

    /**
     *
     * @param i element to find in the list
     */
    void find(int i) {
        if (list.contains(i)) {
            System.out.println("Found: " + i );
        }
    }

    /**
     * Removes the first element of the list
     */
    void removeFromBegin() {
        list.remove(0);
        System.out.println("First element of the list has been removed");
    }

    /**
     *
     * @param n index of element which will be removed
     */
    void removeFromN(int n) {
        list.remove(n);
        System.out.println("Element with index " + n + " has been removed");
    }

    /**
     * Removes last element from the list
     */
    void removeFromEnd () {
        list.remove(list.size()-1);
        System.out.println("Last element of the list has been removed");
    }

    /**
     * Moves element with index 'k' back on 'n' positions
     * @param k index of element
     * @param n quantity of positions
     */
    void move(int k, int n) {
        addToN(k-n, k);
        removeFromN(k);
        System.out.println("Element with index " + k + " has been moved back on " + n + " positions");
    }

    /**
     * Displays all elements of the list
     */
    void show() {
        for (int i:list) {
            System.out.println(i);
        }
    }
}
