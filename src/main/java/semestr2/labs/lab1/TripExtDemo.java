package semestr2.labs.lab1;

import java.util.Date;

public class TripExtDemo {

    public static void bubbleSort (TripExt[] arr) {
        boolean flag;
        for (int m=arr.length-1; m>0; m--){
            flag=true;
            for (int j=0; j<m; j++)
                if (arr[j].compareTo(arr[j+1])>0) {
                    TripExt b=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=b;
                    flag=false;
                }
            if (flag) break;
        }
    }

    public static void displayTrip(TripExt[] arr) {
        for (int i=0; i<arr.length; i++)
            System.out.printf ("%s, хэшкод: %d\n", arr[i], arr[i].hashCode());
    }

    public static void main (String args[]) {
        TripExt trip0 = new TripExt();
        trip0.setDate(new Date());
        trip0.setDepartureCity("Москва");
        trip0.setDestinationCity("Омск");
        trip0.setMaxPrice(6500);
        trip0.setTransportType("Поезд");
        trip0.setDuration(50);

        TripExt trip1 = new TripExt("Севастополь","Симферополь","Автобус", new Date(), 200, 41);
        TripExt trip2 = trip1; //создание псевдонима
        TripExt trip3 = new TripExt(trip1);//создание клона

        TripExt trip4 = new TripExt("Севастополь", "Николаевка","Автобус", new Date(), 148, 31);
        TripExt trip5 = null;

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

        TripExt[] arr = new TripExt[6];
        arr[0] = new TripExt("Москва", "Киев","Самолёт", new Date(), 4000, 31);
        arr[1] = new TripExt("Севастополь", "Керчь","Автобус", new Date(), 2000, 42);
        arr[2] = new TripExt("Москва", "Омск","Самолёт", new Date(), 6500, 31);
        arr[3] = new TripExt("Москва", "Краснодар","Самолёт", new Date(), 4000, 52);
        arr[4] = new TripExt("Москва", "Симферополь","Самолёт", new Date(), 6000, 74);
        arr[5] = new TripExt("Москва", "Киев","Самолёт", new Date(), 4000, 41);
        System.out.println ("Массив поездок до сортировки");
        displayTrip(arr);
        bubbleSort(arr);
        System.out.println ("Массив поездок после сортировки");
        displayTrip(arr);
    }
}

