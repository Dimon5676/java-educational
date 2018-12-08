package avp.lab3;

import java.util.Scanner;

public class Lab3 {

    static private Scanner sc = new Scanner(System.in);

    private static Data [] a = new Data[100];
    final static private int c = 1;
    final static private int d = 2;
    final static private int f = 3;
    private static boolean mayBeEnough = false;

    public static void main(String[] args) {
        int key;
        int i;
        int hash;
        String data;
        while (!mayBeEnough) {
            display();
            System.out.println("============================");
            System.out.println("1. Add element to table");
            System.out.println("2. Find element");
            System.out.println("3. Remove element");
            System.out.println("4. Exit");
            System.out.println("============================");
            switch (sc.nextInt()) {
                case 1:
                    i = 0;
                    System.out.println("Enter key:");
                    key = sc.nextInt();
                    System.out.println("Enter data:");
                    data = sc.next();
                    hash = myHash(key);
                    if (a[hash] != null) {
                        while (a[hash] != null) {
                            hash = myHash(key) + (i*c + d*i*i + f*i);
                            i++;
                        }
                        a[hash] = new Data(key, data);
                    } else {
                        a[hash] = new Data(key, data);
                    }
                    break;
                case 2:
                    System.out.println("Enter key to find:");
                    key = sc.nextInt();
                    hash = myHash(key);
                    if (hash >= a.length) {
                        System.out.println("Hash is out of range");
                        break;
                    }
                    for (hash = myHash(key), i = 0; hash < a.length; hash = myHash(key) + (i*c + d*i*i + f*i), i++) {
                        if (a[hash] == null) {
                            System.out.println("Item not found.");
                            break;
                        }
                        if (a[hash].key == key) {
                            System.out.println("Found: Key: " + a[hash].key + " Data: " + a[hash].data);
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter key to remove");
                    key = sc.nextInt();
                    hash = myHash(key);
                    i = 0;
                    if (a[hash] == null) {
                        System.out.println("There is no such element");
                        break;
                    }
                    if (a[hash].key == key) {
                        a[hash] = null;
                        break;
                    } else {
                        while (a[hash].key != key) {
                            hash = myHash(key) + (i*c + d*i*i + f*i);
                            i++;
                        }
                        if (a[hash].key == key) {
                            a[hash] = null;
                            break;
                        }
                    }
                    break;
                case 4:
                    mayBeEnough = true;
                    break;
            }
        }
    }

    private static int myHash(int key) {
        return Math.abs(key) % a.length;
    }

    private static void display() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                System.out.println("Key: " + a[i].key + "\tData: " + a[i].data);
            }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private static class Data {
        private int key;
        private String data;

        private Data(int key, String data) {
            this.key = key;
            this.data = data;
        }
    }
}
