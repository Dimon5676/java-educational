package semestr1.labs.lab11;

import java.util.Date;

public class Lab11 {

    public static void main(String[] args) {

        TourTrip tt1 = new TourTrip("Sevastopol", "Simferopol", "Bus", new Date(2018, 2, 11), 500);
        TourTrip ttNick = tt1;
        TourTrip copyTT = new TourTrip();
        System.out.println(tt1.equals(ttNick));
        System.out.println(tt1.equals(tt1));
        System.out.println(tt1.equals(copyTT));
        System.out.println(tt1.toString());
    }
}
