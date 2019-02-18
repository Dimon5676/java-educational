package semestr2.chm.lab1;

public class CHm {
    public static void main(String[] args) {
        zad1();
        zad2();
        zad3();
        zad4();
    }
    private static void zad1() {
        System.out.println("Задание 1");
        System.out.printf("%.18f\n", 0.00005/3.8945);
        System.out.println("========================");
    }
    
    private static void zad2() {
        System.out.println("Задание 2");
        double a = 0.001475;
        double a1 = 0.00148;
        double da = 0.000001;
        double pogrOkrug = Math.abs(a - a1);
        double absPogr = da + pogrOkrug;
        double otnosOkrug = pogrOkrug/a1;
        System.out.printf("Абсолютная погрешность:\t\t %.18f\nОтносительная погрешность:\t %.18f\n", absPogr, otnosOkrug);
        System.out.println("========================");
    }
    
    private static void zad3() {
        System.out.println("Задание 3");
        double d = 2.4;
        double V = Math.PI*Math.pow(d, 3)/6;
        double absPog = Math.abs(Math.pow(d, 3)/6) * 0.0016 + Math.abs(Math.pow(d, 2) * Math.PI/3) * 0.05;
        double otnosPog = absPog/V;
        System.out.printf("Абсолютная погрешность:\t\t %.18f\nОтносительная погрешность:\t %.18f\n", absPog, otnosPog);
        System.out.println("========================");
    }
    
    private static void zad4() {
        System.out.println("Задание 4");
        double a = 1.1234;
        double b = 0.7658;
        int n = 2;
        double delA = 0.0001;
        double delB = 0.0001;

        //+
        double absP = delA + delB;
        //-
        double absM = delA + delB;
        //*
        double absY = Math.abs(a)*delB + Math.abs(b)*delA;
        // /
        double absD = (Math.abs(a)*delB + Math.abs(b)*delA)/Math.pow(b, 2);
        // ^
        double absS = n * Math.pow(a, n-1) * delA;

        //+
        double otnosP = absP/(a+b);
        //-
        double otnosM = absP/(a-b);
        //*
        double otnosY = absY/(a*b);
        // /
        double otnosD = absD/(a/b);
        // ^
        double otnosS = absS/(Math.pow(a, n));
        
        System.out.printf("Абсолютная погрешность при сложении:\t%.18f\nАбсолютная погрешность при вычитании:\t%.18f\nАбсолютная погрешность при умножении:\t%.18f\nАбсолютная погрешность при делении:\t\t%.18f\nАбсолютная погрешность при возведении в степень:\t%.18f\n", absP, absM, absY, absD, absS);
        System.out.printf("Относительная погрешность при сложении:\t\t%.18f\nОтносительная погрешность при вычитании:\t%.18f\nОтносительная погрешность при умножении:\t%.18f\nОтносительная погрешность при делении:\t\t%.18f\nОтносительная погрешность при возведении в степень:\t%.18f\n", otnosP, otnosM, otnosY, otnosD, otnosS);
        System.out.println("========================");
    }
}
