package avp.lab4;

import java.util.ArrayList;

public class Lab4 {

    public static void main(String[] args) {
        new Lab4();
    }

    private Lab4() {
        //Создание и заполнение матрицы инцидентности случайными значениями
        int[][] matrixInc = new int[5][10];

        ArrayList<String> rebroS = new ArrayList<String>();
        for (int i = 0; i < matrixInc[0].length; i++) {
            int rand = (int)(Math.random()*5);
            matrixInc[rand][i] = (int)((Math.random()*99)+1);
            int rand2 = (int)(Math.random()*5);
            while (rand == rand2) {
                rand2 = (int)(Math.random()*5);
            }
            matrixInc[rand2][i] = -matrixInc[rand][i];

            if (i == 0) {
                rebroS.add(String.valueOf(rand) + rand2);
            }

            while (rebroS.contains(String.valueOf(rand) + rand2)) {
                matrixInc[rand][i] = 0;
                matrixInc[rand2][i] = 0;
                rand = (int)(Math.random()*5);
                matrixInc[rand][i] = (int)((Math.random()*99)+1);
                rand2 = (int)(Math.random()*5);
                while (rand == rand2) {
                    rand2 = (int)(Math.random()*5);
                }
                matrixInc[rand2][i] = -matrixInc[rand][i];
            }

            rebroS.add(String.valueOf(rand) + rand2);
        }

        for (int i = 0; i < rebroS.size(); i++) {
            System.out.println(rebroS.get(i));
        }

        //Выврд матрицы инцидетности
        System.out.println("Матрица инцидентности:");
        displayMatrixInc(matrixInc);

        //Пространстно между выводами
        System.out.println();

        //Создание матрицы смежности
        int[][] matrixSme = new int[matrixInc.length][matrixInc.length];

        //Преобразование матрицы инцидентности в матрицу смежности
        int from = 0;
        int to = 0;
        int val = 0;

        for (int i = 0; i < matrixInc[0].length; i++) {
            for (int j = 0; j < matrixInc.length; j++) {
                if (matrixInc[j][i] != 0) {
                    if (matrixInc[j][i] > 0) {
                        from = j;
                        val = matrixInc[j][i];
                    }
                    if (matrixInc[j][i] < 0) {
                        to = j;
                    }
                }
            }
            matrixSme[from][to] = val;
            from = 0;
            to = 0;
        }

        //Вывод матрицы смежности
        System.out.println("Матрица смежности:");
        displayMatrixSme(matrixSme);
    }

    //Метод вывода матрицы инцидентности
    private void displayMatrixInc(int[][] arr) {
        System.out.println("\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < arr[0].length; j++) {
                if (j == arr[0].length-1) {
                    System.out.print(arr[i][j] + "\n");
                } else {
                    System.out.print(arr[i][j] + "\t");
                }
            }
        }
    }

    //Метод вывода матрицы смежности
    private void displayMatrixSme(int[][] arr) {
        System.out.println("\t0\t1\t2\t3\t4");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < arr[0].length; j++) {
                if (j != arr[0].length-1) {
                    System.out.print(arr[i][j] + "\t");
                } else {
                    System.out.print(arr[i][j] + "\n");
                }
            }
        }
    }
}
