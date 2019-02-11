package semestr1.labs.lab8;

public class lab8 {

    public static void main(String[] args) {

        int a = (int)'K';
        int b = (int)'f';
        System.out.println("A = " + a + " B = " + b + "\n");

        char[] first = {'U', 'G', 'm', 'q', 'K', 'q', 'f', 'U', 'N', 'H'};
        char[] second = {'j', '\\', 'x', 'f', 'F', ']', 'G', 'x', 'a', 'u', 'K', 'D'};

        System.out.print("First massive: ");
        display(first);
        System.out.print("Second massive: ");
        display(second);

        System.out.println();

        System.out.println("First from A to B: " + amount(first, a, b));
        System.out.println("Second from A to B: " + amount(second, a, b));

        System.out.println();

        System.out.print("First massive sorted: ");
        display(bubbleSort(first));
        System.out.print("Second massive sorted: ");
        display(bubbleSort(second));

        System.out.println();

        System.out.print("First massive processed: ");
        display(task(first, a, b));
        System.out.print("Second massive processed: ");
        display(task(second, a, b));
    }

    private static int amount(char[] massive, int a, int b) {
        int amount = 0;
        for (char i:massive) {
            if (i >= a && i <= b) amount++;
        }
        return amount;
    }

    private static char[] bubbleSort(char[] massive) {
        char[] sorted = massive.clone();
        int t = 1;
        for (int i = 0; i < sorted.length-1; i++) {
            for (int j = 0; j < sorted.length-t; j++) {
                if (sorted[j] > sorted[j+1]) {
                    char temp = sorted[j];
                    sorted[j] = sorted[j+1];
                    sorted[j+1] = temp;
                }
            }
            t++;
        }
        return sorted;
    }

    private static char[] task(char[] result, int a, int b) {
        for (int i = 0; i < result.length; i++) {
            if (result[i] == a) {
                result[i] = result[0];
                result[0] = (char) a;
            }
            if (result[i] == b) {
                result[i] = result[result.length-1];
                result[result.length-1] = (char) b;
            }
        }
        return result;
    }

    private static void display(char[] massive) {
        for (char i : massive) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
