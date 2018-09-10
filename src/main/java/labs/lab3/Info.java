package labs.lab3;

public class Info {
    public static void main(String[] args) {
        int a = 123;
        int b = 56;

        int c = a*b-(a+b/2)%7;

        /** Prints variables in different number systems*/
        System.out.printf("a = %s(2) = %x(16) = %o(8) = %d(10)\n", Integer.toBinaryString(a), a, a, a);
        System.out.printf("b = %s(2) = %x(16) = %o(8) = %d(10)\n", Integer.toBinaryString(b), b, b, b);
        System.out.printf("c = %s(2) = %x(16) = %o(8) = %d(10)\n", Integer.toBinaryString(c), c, c, c);
    }
}
