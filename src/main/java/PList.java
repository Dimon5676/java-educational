import java.util.ArrayList;
import java.util.List;

public class PList {
    List<Integer> list = new ArrayList();

    void add_to_begin(int i) {
        list.add(0, i);
    }
    void add_to_n(int n, int i) {
        list.add(n, i);
    }
    void add_to_end(int i) {
        list.add(i);
    }
    void find(int i) {
        if (list.contains(i)) {
            System.out.println("Found: " + i );
        }
    }
    void remove_from_begin() {
        list.remove(0);
    }
    void remove_from_n(int n) {
        list.remove(n);
    }
    void remove_from_end () {
        list.remove(list.size()-1);
    }
    void move(int k, int n) {
        add_to_n(k-n, k);
        remove_from_n(k);
    }
    void show() {
        for (int i:list) {
            System.out.println(i);
        }
    }
}
