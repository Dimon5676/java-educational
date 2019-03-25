package semestr2.labs.lab2;

import java.util.Date;

@SuppressWarnings("Duplicates")
public class ObjDemo {
    public static void bubbleSort (Comparable[ ] arr) {
        boolean flag;
        for (int m = arr.length-1; m > 0; m--){
            flag=true;
            for (int j = 0; j < m; j++)
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    Comparable b = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = b;
                    flag = false;
                }
            if (flag) break;
        }
    }

    public static void displayArr(Trip[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.printf ("%s, хэшкод: %d\n", arr[i], arr[i].hashCode());
    }
    public static void displayArr(Trip2[] arr) {
        for (int i=0; i < arr.length; i++)
            System.out.printf ("%s, хэшкод: %d\n", arr[i], arr[i].hashCode());
    }

    public static void main (String args[]){
        System.out.print("1)Демонстрируем работу методов toString(), equals()");
        System.out.println  ("и hashCode()для объектов класса Trip2");
        Trip2 trip21 = new Trip2("Севастополь", "Николаевка", "Автобус", 24351, new Date(46564), new Date(46564), new Date(4656432), new Date(4656432), 150);
        Trip2 trip22 = trip21;
        Trip2 trip23 = new Trip2(trip21);
        Trip2 trip24 = new Trip2("Николаевка", "Севастополь", "Автобус", 24351, new Date(46564), new Date(46564), new Date(4656432), new Date(4656432), 150);
        Trip2 trip25 = null;

        System.out.printf ("Trip21: %s, хэшкод: %d\n", trip21, trip21.hashCode());
        System.out.printf ("Trip22: %s, хэшкод: %d\n", trip22, trip22.hashCode());
        System.out.printf ("Trim23: %s, хэшкод: %d\n", trip23, trip23.hashCode());
        System.out.printf ("Trip24: %s, хэшкод: %d\n", trip24, trip24.hashCode());
        System.out.printf ("Trip25: %s\n", trip25);

        System.out.println ("Результаты сравнения на равенство");
        System.out.printf ("trip21==trip22: %s\n", trip21.equals(trip22));//true
        System.out.printf ("trip21==trip23: %s\n", trip21.equals(trip23));//true
        System.out.printf ("trip21==trip24: %s\n", trip21.equals(trip24));//false
        System.out.printf ("trip24==trip25: %s\n", trip24.equals(trip25));//false

        System.out.println();
        System.out.print ("2)Демонстрируем сортировку элементов массивов");
        System.out.println  (" arr1 и arr2 одним и тем же методом bubbleSort().");

        Trip[] arr = new Trip[6];
        arr[0] = new Trip("Москва", "Киев","Самолёт", new Date(), 4000);
        arr[1] = new Trip("Севастополь", "Керчь","Автобус", new Date(), 2000);
        arr[2] = new Trip("Москва", "Омск","Самолёт", new Date(), 6500);
        arr[3] = new Trip("Москва", "Краснодар","Самолёт", new Date(), 4000);
        arr[4] = new Trip("Москва", "Симферополь","Самолёт", new Date(), 6000);
        arr[5] = new Trip("Москва", "Киев","Самолёт", new Date(), 4000);
        System.out.println ("Массив Trip до сортировки:");
        displayArr(arr);
        bubbleSort(arr);
        System.out.println ("Массив Trip после сортировки:");
        displayArr(arr);

        Trip2[] arr1 = new Trip2[7];
        arr1[0] = new Trip2("Николаевка", "Севастополь", "Автобус", 24351, new Date(46564), new Date(46564), new Date(4656432), new Date(4656432), 150);
        arr1[1] = new Trip2("Севастополь", "Николаевка", "Автобус", 24351, new Date(46564), new Date(46564), new Date(4656432), new Date(4656432), 250);
        arr1[2] = new Trip2("Москва", "Симферополь", "Автобус", 24351, new Date(46564), new Date(46564), new Date(4656432), new Date(4656432), 130);
        arr1[3] = new Trip2("Киев", "Симферополь", "Поезд", 24361, new Date(46564), new Date(46564), new Date(4656432), new Date(4656432), 350);
        arr1[4] = new Trip2("Омск", "Симферополь", "Самолёт", 22351, new Date(46564), new Date(46564), new Date(4656432), new Date(4656432), 251);
        arr1[5] = new Trip2("Симферополь", "Севастополь", "Автобус", 24351, new Date(46564), new Date(46564), new Date(4656432), new Date(4656432), 1350);
        arr1[6] = new Trip2("Евпатория", "Севастополь", "Автобус", 24351, new Date(46564), new Date(46564), new Date(4656432), new Date(4656432), 154);

        System.out.println ("Массив Trip2 до сортировки:");
        displayArr(arr1);
        bubbleSort(arr1);
        System.out.println ("Массив Trip2 после сортировки:");
        displayArr(arr1);

        System.out.println();
        System.out.print ("3)Демонстрируем взаимодействие объектов при ");
        System.out.println  ("определении соответствия крышек и кастрюль.");

        Trip2 trip2 = new Trip2("Севастополь", "Николаевка", "Автобус", 24351, new Date(46564), new Date(46564), new Date(4656432), new Date(4656432), 150);

        Trip tr1 = new Trip("Москва", "Киев","Самолёт", new Date(), 4000);
        Trip tr2 = new Trip("Севастополь", "Керчь","Автобус", new Date(), 2000);
        Trip tr3 = new Trip("Москва", "Омск","Самолёт", new Date(), 6500);
        Trip tr4 = new Trip("Москва", "Краснодар","Самолёт", new Date(), 4000);
        Trip tr5 = new Trip("Москва", "Симферополь","Самолёт", new Date(), 6000);
        Trip tr6 = new Trip("Москва", "Киев","Самолёт", new Date(4656432), 4000);

        System.out.printf("pan: %s\n", trip2);

        System.out.printf("tr1: %s\n", tr1);
        System.out.printf("tr2: %s\n", tr2);
        System.out.printf("tr3: %s\n", tr3);
        System.out.printf("tr4: %s\n", tr4);
        System.out.printf("tr5: %s\n", tr5);
        System.out.printf("tr6: %s\n", tr6);
        // Выводим результаты сравнения
        System.out.printf("tr1.accord(trip2): %s\n", tr1.accord(trip2));
        System.out.printf("trip2.accord(tr1): %s\n", trip2.accord(tr1));
        System.out.printf("tr2.accord(trip2): %s\n", tr2.accord(trip2));
        System.out.printf("trip2.accord(tr2): %s\n", trip2.accord(tr2));
        System.out.printf("tr3.accord(trip2): %s\n", tr3.accord(trip2));
        System.out.printf("trip2.accord(tr3): %s\n", trip2.accord(tr3));
        System.out.printf("tr4.accord(trip2): %s\n", tr4.accord(trip2));
        System.out.printf("trip2.accord(tr4): %s\n", trip2.accord(tr4));
        System.out.printf("tr5.accord(trip2): %s\n", tr5.accord(trip2));
        System.out.printf("trip2.accord(tr5): %s\n", trip2.accord(tr5));
        System.out.printf("tr6.accord(trip2): %s\n", tr6.accord(trip2));
        System.out.printf("trip2.accord(tr6): %s\n", trip2.accord(tr6));

        tr6.setDepartureCity("Севастополь");
        tr6.setDestinationCity("Николаевка");
        tr6.setTransportType("Автобус");

        if (tr6.accord(trip2)) {
            System.out.printf("Объект %s\n", tr6);
            System.out.println("соответствует объекту");
            System.out.println(trip2);
        } else {
            System.out.printf("Объект %s\n", tr6);
            System.out.println("не соответствует объекту");
            System.out.println(trip2);
        }
    }
}
