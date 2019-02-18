package test;

public class Test2 {

    public static void main(String[] args) {
        int maxNum = 1000000;
        int with = 0;
        int without = 0;

        for (int i = 1; i <= maxNum; i++) {
            if (hasOne(i)) {
                with++;
            } else {
                without++;
            }
        }
        System.out.printf("Числа с 1: %d\nЧисла без 1: %d\n", with, without);
    }

    private static boolean hasOne(int number) {
        while(number > 0) {
            if(number % 10 == 8) return true;
            number = number/10;
        }
        return false;
    }
}
