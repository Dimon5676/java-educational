package labs.lab2;

/**
 * Test class for the second lab of programming course
 * in Sevastopol State University
 */
public class Format {
    /**
     * Main method
     * @param args array of args
     */
    public static void main(String[] args) {
        /** last name and group code of student */
        String str = "Лозыченко ИВТ/б-11-о:";
        /** integer variable */
        int a = 10425;
        /** short variable */
        short b = 26;
        /** byte variable */
        byte c = 11;
        /** double variable */
        double d = 43.16542;
        /** float variable */
        float f = 412.4322f;
        /** Prints formatted string */
        System.out.printf("Привет, %s a=%x, b=%5d, c=%o, d=%+5.3f, f=%07.2f!\n", str, a, b, c, d, f);
    }
}
