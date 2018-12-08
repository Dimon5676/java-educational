package labs.lab10;

public class LibClass {

    public static int summUnc(int[] a, int length) {
        if (length == 0) {
            return a[0];
        } else if (a[length] % 2 != 0) {
            return a[length] + summUnc(a, length-1);
        } else {
            return summUnc(a, length-1);
        }
    }

    public static int summBet(int[] mass, int a, int b) {
        int sum = 0;
        for (int i = 0; i < mass.length-1; i++) {
            if (mass[i] >= a && mass[i] <= b) {
                sum += mass[i];
            }
        }
        return sum;
    }
}
