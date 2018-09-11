package labs.lab4;

public class Info {
    public static void main(String[] args) {
        //Print variant
        int var = 12%14;
        System.out.printf("Вариант: %d\n", var);

        float r = 0.12f;
        int z = 10;

        double t = Math.sin(Math.PI*r)/(Math.pow(10, 3)+r*z);

        double numerator1 = Math.exp(5*t);
        double numerator2 = Math.exp(-5 * t);

        double denominator1 = Math.exp(z*t);
        double denominator2 = Math.exp(-z*t);
        double temp = (numerator1-numerator2)/(denominator1-denominator2);


        double m = 180 * Math.atan(temp);

        System.out.println("m = " + m);
        System.out.println("Значение переменной а в формате IEEE 754: ");
        System.out.println(Long.toBinaryString(Double.doubleToLongBits(m)));
    }
}
