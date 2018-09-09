package labs.lab2;

public class Format {
    public static void main(String[] args) {
        String str = "Лозыченко ИВТ/б-11-о:";
        int a = 10425;
        short b = 26;
        byte c = 11;
        double d = 43.16542;
        float f = 412.4322f;
        System.out.printf("Привет, %s a=%x, b=%5d, c=%o, d=%+5.3f, f=%07.2f!\n", str, a, b, c, d, f);
    }
}
