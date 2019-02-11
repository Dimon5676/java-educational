package semestr1.labs.lab7;

public class Lab7 {

    public static void main(String[] args) {
        System.out.println ("Начало табулирования");
        /*
            Входные значения изменены т.к. дроьные числа с целой частью
            дают неправильное значение корня по формуле, что приводит к значениям NaN и Infinity
         */
        go(0.1,0.9,0.5);
        System.out.println ("Табулирование окончено");
    }

    private static double root(double x) {
        return 1.0/Math.pow(x, 1.0/4);
    }

    private static double rootIter(double x, int n) {
        double y=0;
        for (int i=1; i<=n; i++){
            y = y + 0.25*(y - x * Math.pow(y, 5));
            System.out.printf("x=%10.6f, y=%10.6f, i=%4d\n",x,y,i);
        }
        return y;
    }

    private static void go(double startX, double endX, double deltaX){
        double x=startX,yt,yn,e;
        int n=12;
        while (x<=endX){
            yt=root(x);
            yn=rootIter(x,n);
            e=Math.abs(yt-yn);
            System.out.printf("x=%10.6f, yt=%10.6f, yn=%10.6f, e=%10.6f\n", x,yt,yn,e);
            x=x+deltaX;
        }
    }
}
