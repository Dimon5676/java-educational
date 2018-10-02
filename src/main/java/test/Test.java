package test;

import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            FileWriter file = new FileWriter("Test.txt", false);
            for (long i = 79780000000L; i <= 79789999999L; i++) {
                file.write("+" + Long.toString(i) + "\n");
            }
            file.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
