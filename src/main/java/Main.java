
public class Main{

    public static void main(String[] args) {
        PList list = new PList();
        for (int i = 0; i <= 10; i++) {
            list.add_to_end(i);
        }
        list.remove_from_begin();
        list.remove_from_n(3);
        list.remove_from_end();
        list.add_to_end(999);
        list.add_to_n(1, 3123123);
        list.move(8, 2);
        list.show();
    }
}
