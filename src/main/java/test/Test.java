package test;

public class Test {
    public static void main(String[] args) {
        LList<Integer> list = new LList<Integer>();
        list.addToBegin(1);
        list.addToBegin(2);
        list.addToBegin(3);
        list.addToBegin(4);
        list.addToBegin(5);
        list.show();
    }
}
