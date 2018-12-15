package avp.lab3;

import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Dynamic");
        System.out.println("2. Static");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int answ = scanner.nextInt();
        if (answ == 1) {
            while (true) {
                LStack<Integer> stack = new LStack<Integer>();
                System.out.println("============================");
                System.out.println("1. Push to stack");
                System.out.println("2. Stack pop");
                System.out.println("3. Stack top");
                System.out.println("4. Replace min with 0");
                System.out.println("----------------------------");
                stack.show();
                System.out.println("============================");
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("Enter number to add to stack");
                        stack.push(scanner.nextInt());
                        break;
                    case 2:
                        System.out.print("Stack pop: ");
                        System.out.println(stack.pop(scanner.nextInt()));
                        break;
                    case 3:
                        System.out.println("Stack top: " + stack.top());
                        break;
                    case 4:
                        stack.minToZero();
                        break;
                    default:
                        System.out.println("Choose one option from the list and enter a number");
                }
            }
        } else if (answ == 2) {
            System.out.println("How many elements do you need? ");
            LStackStat stack = new LStackStat(scanner.nextInt());
            while (true) {
                System.out.println("============================");
                System.out.println("1. Push to stack");
                System.out.println("2. Stack pop");
                System.out.println("3. Stack top");
                System.out.println("4. Replace min with 0");
                System.out.println("----------------------------");
                stack.show();
                System.out.println("============================");
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("Enter number to add to stack");
                        stack.push(scanner.nextInt());
                        break;
                    case 2:
                        System.out.print("Stack pop: ");
                        System.out.println(stack.pop(scanner.nextInt()));
                        break;
                    case 3:
                        System.out.println("Stack top: " + stack.top());
                        break;
                    case 4:
                        stack.minToZero();
                        break;
                    default:
                        System.out.println("Choose one option from the list and enter a number");
                }
            }
        }
    }
}
