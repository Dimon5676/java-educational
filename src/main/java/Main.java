public class Main{

    public static void main(String[] args) {
        List list = new List();
        for (int i = 10; i >=0; i--) {
            list.add_to_begin(i);
        }
        list.remove_from_begining();
        list.remove_from_end();
        list.add_to_n(100, 3);
        list.add_to_end(999);
        list.find(4);
        list.remove_from_n(6);
        list.move(9, 2);
        list.printMe();
    }
}
