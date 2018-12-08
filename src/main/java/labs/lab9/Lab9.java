package labs.lab9;

public class Lab9 {

    public static void main(String[] args) {
        double a[][] = new double[10][10];
        double b[][] = new double[10][10];

        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a.length; j++) {
                a[i][j] = Math.random()*20-10;
                b[i][j] = Math.random()*20-10;
            }
        }

        for (int i = 0; i < a.length; i++) {
            a[2][i] = Math.abs(a[2][i]);
            b[2][i] = Math.abs(b[2][i]);
        }

        display(a);
        System.out.println("--------------------");
        display(b);
        System.out.println();
        System.out.printf("%1.4f\n", scal(a));
        System.out.printf("%1.4f\n", scal(b));
        System.out.println();
        display(vec(a));
        display(vec(b));
        System.out.println();
        display(prod(a));
        System.out.println("------------------");
        display(prod(b));
    }

    private static void display(double[][] a) {
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a.length; j++) {
                if (j == a.length-1) {
                    System.out.printf("%+3.4f\n", a[i][j]);
                } else {
                    System.out.printf("%+3.4f\t", a[i][j]);
                }
            }
        }
    }

    private static void display(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static double scal(double[][] a) {
        for (int i = a.length-1; i >= 0; i--){
            for (int j = i-1; j >= 0; j--) {
                if (a[i][j] >= 0) {
                    return a[i][j];
                }
            }
        }
        return 0;
    }

    private static int[] vec(double[][] a) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] < 0) res[i] = 1;
            }
        }
        return res;
    }

    public static double[][] prod(double[][] a) {
        int n = a.length;
        double[][] c = new double[n][n];
        double[][] b = a.clone();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
}
