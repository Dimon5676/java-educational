package semestr2.labs.lab1;

import java.util.Date;

public class TripDemo {

    public static void bubbleSort (Trip[] arr) {
        boolean flag;
        for (int m=arr.length-1; m>0; m--){
            flag=true;
            for (int j=0; j<m; j++)
                if (arr[j].compareTo(arr[j+1])>0) {
                    Trip b=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=b;
                    flag=false;
                }
            if (flag) break;
        }
    }

    public static void displayTrip(Trip[] arr) {
        for (int i=0; i<arr.length; i++)
            System.out.printf ("%s, хэшкод: %d\n", arr[i], arr[i].hashCode());
    }

    public static void main (String args[]) {
        Trip trip0 = new Trip();
        trip0.setDate(new Date());
        trip0.setDepartureCity("Москва");
        trip0.setDestinationCity("Омск");
        trip0.setMaxPrice(6500);
        trip0.setTransportType("Поезд");

        Trip trip1 = new Trip("Севастополь","Симферополь","Автобус", new Date(), 200);
        Trip trip2 = trip1; //создание псевдонима
        Trip trip3 = new Trip(trip1);//создание клона

        Trip trip4 = new Trip("Севастополь", "Николаевка","Автобус", new Date(), 148);
        Trip trip5 = null;

        System.out.printf ("trip1: %s, хэшкод: %d\n", trip1, trip1.hashCode());
        System.out.printf ("trip2: %s, хэшкод: %d\n", trip2, trip2.hashCode());
        System.out.printf ("trip3: %s, хэшкод: %d\n", trip3, trip3.hashCode());
        System.out.printf ("trip4: %s, хэшкод: %d\n", trip4, trip4.hashCode());
        System.out.printf ("trip5: %s\n", trip5);

        System.out.println ("Результаты сравнения на равенство");
        System.out.printf ("trip1==trip2: %s\n", trip1.equals(trip2));//true
        System.out.printf ("trip1==trip3: %s\n", trip1.equals(trip3));//true
        System.out.printf ("trip1==trip4: %s\n", trip1.equals(trip4));//false
        System.out.printf ("trip4==trip5: %s\n", trip4.equals(trip5));//false

        Trip[] arr = new Trip[6];
        arr[0] = new Trip("Москва", "Киев","Самолёт", new Date(), 4000);
        arr[1] = new Trip("Севастополь", "Керчь","Автобус", new Date(), 2000);
        arr[2] = new Trip("Москва", "Омск","Самолёт", new Date(), 6500);
        arr[3] = new Trip("Москва", "Краснодар","Самолёт", new Date(), 4000);
        arr[4] = new Trip("Москва", "Симферополь","Самолёт", new Date(), 6000);
        arr[5] = new Trip("Москва", "Киев","Самолёт", new Date(), 4000);
        System.out.println ("Массив поездок до сортировки");
        displayTrip(arr);
        bubbleSort(arr);
        System.out.println ("Массив поездок после сортировки");
        displayTrip(arr);
    }
}

