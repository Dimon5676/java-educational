
import java.util.LinkedList;
import java.util.List;

public class PList {
    List<Integer> list = new LinkedList<Integer>();

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
        } else {
            System.out.println(i + " is not found");
        }
    }

    /** Remove the first element of the list */
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

    /** Remove last element from the list */
    void removeFromEnd () {
        list.remove(list.size()-1);
        System.out.println("Last element of the list has been removed");
    }

    /**
     * Move element with index 'k' back on 'n' positions
     * @param k index of element
     * @param n quantity of positions
     */
    void move(int k, int n) {
        addToN(k-n, k);
        removeFromN(k);
        System.out.println("Element with index " + k + " has been moved back on " + n + " positions");
    }

    /**
     *  Build and displays two lists that contain values in range
     *  from n to m and don't contain values from that range from base list
     * @param list base list
     * @param n from value
     * @param m til value
     */
    void build(PList list, int n, int m) {
        //list that doesn't contain elements from range
        PList list1 = new PList();
        //list that contains elements from range
        PList list2 = new PList();
        //rage
        List<Integer> range = new LinkedList<Integer>();
        for (int i = n; i <= m; i++) {
            range.add(i);
        }
        //check if current element belongs to range
        for (int i = 0; i < list.length(); i++){
            if (range.contains(valueOf(i))) {
                list2.addToEnd(list.valueOf(i));
            } else {
                list1.addToEnd(list.valueOf(i));
            }
        }
        //print two lists
        System.out.printf("List don't contain values in range from %d to %d\n", n, m);
        list1.show();
        System.out.printf("List contains values in range from %d to %d\n", n, m);
        list2.show();
    }
    /** Display all elements of the list */
    void show() {
        for (int i:list) {
            System.out.println(i);
        }
    }
    int valueOf(int n) {
        return list.get(n);
    }
    int length() {
        return list.size();
    }
}
