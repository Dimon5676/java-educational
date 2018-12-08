package labs.lab10;

public class MainClass {

    public static void main(String[] args) {
        int[] massive = new int[10];
        for (int i = 0; i < massive.length; i++) {
            massive[i] = (int)(Math.random()*10);
        }
        LibClass.display(massive);
        System.out.println(LibClass.summUnc(massive, massive.length-1));
        System.out.println(LibClass.summBet(massive, 3, 5));
    }
}
