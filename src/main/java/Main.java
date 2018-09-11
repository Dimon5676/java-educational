
public class Main{

    public static void main(String[] args) {
        PList list = new PList();
        for (int i = 0; i <= 10; i++) {
            list.addToEnd(i);
        }
        list.show();
        list.removeFromBegin();
        list.removeFromN(3);
        list.removeFromEnd();
        list.addToEnd(999);
        list.addToN(1, 3123123);
        list.move(8, 2);
        list.show();

        list.build(list, 4, 10);
    }
}
