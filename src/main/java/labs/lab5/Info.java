package labs.lab5;

public class Info {
    public static void main(String[] args) {
        //variable c
        char c = 'A';
        //variable d
        char d = '%';

        //ternary conditional operation
        char a = Character.isLetter(c) && (Character.toLowerCase(c) == 'a' && d == '%' ? Character.toUpperCase(c) : d;
        //print chars and codes
        System.out.println(a + " " +  c + " " + d);
        System.out.println((int)a + " " +(int)c + " " + (int)d);
    }
}
