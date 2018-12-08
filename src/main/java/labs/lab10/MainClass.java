package labs.lab10;

import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {
        int[] massive = new int[10];
        for (int i = 0; i < massive.length; i++) {
            massive[i] = (int)(Math.random()*10);
        }
        System.out.println(Arrays.toString(massive));
        System.out.println(LibClass.summUnc(massive, massive.length-1));
        System.out.println(LibClass.summBet(massive, 3, 5));
    }
}
