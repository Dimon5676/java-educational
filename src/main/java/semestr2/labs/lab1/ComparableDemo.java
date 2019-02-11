package semestr2.labs.lab1;

import java.util.Date;

public class ComparableDemo {
    public static void bubbleSort (Comparable[ ] arr) {
        boolean flag;
        for (int m=arr.length-1; m>0; m--){
            flag=true;
            for (int j=0; j<m; j++)
                if (arr[j].compareTo(arr[j+1])>0) {
                    Comparable b=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=b;
                    flag=false;
                }
            if (flag) break;
        }
    }

    public static void displayArr(Trip[] arr) {
        for (int i=0; i<arr.length; i++)
            System.out.printf ("%s, хэшкод: %d\n", arr[i], arr[i].hashCode());
    }
    public static void displayArr(TripExt[] arr) {
        for (int i=0; i<arr.length; i++)
            System.out.printf ("%s, хэшкод: %d\n", arr[i], arr[i].hashCode());
    }

    public static void main (String args[]){
        Trip[] arr = new Trip[6];
        arr[0] = new Trip("Москва", "Киев","Самолёт", new Date(), 4000);
        arr[1] = new Trip("Севастополь", "Керчь","Автобус", new Date(), 2000);
        arr[2] = new Trip("Москва", "Омск","Самолёт", new Date(), 6500);
        arr[3] = new Trip("Москва", "Краснодар","Самолёт", new Date(), 4000);
        arr[4] = new Trip("Москва", "Симферополь","Самолёт", new Date(), 6000);
        arr[5] = new Trip("Москва", "Киев","Самолёт", new Date(), 4000);
        System.out.println ("Массив Trip до сортировки:");
        displayArr(arr);
        //Сортировка:
        bubbleSort(arr);
        //Вывод массива после сортировки:
        System.out.println ("Массив Trip после сортировки:");
        displayArr(arr);
        //Создание массива крышек типа LidWithHandle
        TripExt[] arr1 = new TripExt[6];
        arr1[0] = new TripExt("Москва", "Киев","Самолёт", new Date(), 4000, 31);
        arr1[1] = new TripExt("Севастополь", "Керчь","Автобус", new Date(), 2000, 42);
        arr1[2] = new TripExt("Москва", "Омск","Самолёт", new Date(), 6500, 31);
        arr1[3] = new TripExt("Москва", "Краснодар","Самолёт", new Date(), 4000, 52);
        arr1[4] = new TripExt("Москва", "Симферополь","Самолёт", new Date(), 6000, 74);
        arr1[5] = new TripExt("Москва", "Киев","Самолёт", new Date(), 4000, 41);
        System.out.println ("Массив поездок до сортировки");
        displayArr(arr1);
        bubbleSort(arr1);
        System.out.println ("Массив поездок после сортировки");
        displayArr(arr1);
    }
}