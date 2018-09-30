package test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        LList<Integer> list = new LList<Integer>();
        Scanner scanner = new Scanner(System.in);
        list.addToEnd(0);
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);
        list.addToEnd(4);
        list.addToEnd(5);
        list.show();
        while (true) {
            System.out.println("============================");
            System.out.println("1. Add to begin");
            System.out.println("2. Add to n");
            System.out.println("3. Add to end");
            System.out.println("4. Remove from begin");
            System.out.println("5. Remove from n");
            System.out.println("6. Remove from end");
            System.out.println("7. Find");
            System.out.println("----------------------------");
            list.show();
            System.out.println("============================");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Enter number to add to begin");
                    list.addToBegin(scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Enter number, then n");
                    list.addToN(scanner.nextInt(), scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Enter number to add to end");
                    list.addToEnd(scanner.nextInt());
                    break;
                case 4:
                    System.out.println("Remove from begin");
                    list.removeFromBegin();
                    break;
                case 5:
                    System.out.println("Enter n to remove");
                    list.removeFromN(scanner.nextInt());
                    break;
                case 6:
                    System.out.println("Remove from end");
                    list.removeFromEnd();
                    break;
                case 7:
                    System.out.println("Enter value to find");
                    list.find(scanner.nextInt());
                    break;
                default:
                    System.out.println("Choose one option from the list and enter a number");
            }
        }
    }
}
