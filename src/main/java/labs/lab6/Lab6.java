package labs.lab6;

import java.util.Scanner;

public class Lab6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x:");
        double x = sc.nextDouble();
        System.out.println(g(x) + z(x));

        System.out.println("Enter credits:");
        switch (sc.nextInt()) {
            case 1: case 2:
                System.out.println("Ознакомительная");
                break;
            case 3: case 4:
                System.out.println("Общеобразовательная");
                break;
            case 5: case 6: case 7:
                System.out.println("Специализированная");
                break;
            case 8: case 9:
                System.out.println("Углублённо изучаемая");
                break;
            default:
                System.out.println("Неправильно задано число кредитов");
                break;
        }

    }

    private static double g(double x) {
        return x <= 0 ? Math.sqrt(1 + Math.abs(x)) : 2 + Math.pow(1 + x, 1.0/3);
    }

    private static double z(double x) {
        double y = 0;
        if (x < 0) {
            y = 1 + ((3 + x)/(1 + x*x));
        } else if (x >= 0 && x < 1) {
            y = Math.sqrt(1 + Math.pow(1-x, 2));
        } else if (x >= 1) {
            y = (1 + x)/(1 + Math.pow(Math.cos(x), 2));
        }
        return y;
    }
}
