package semestr2.labs.lab1;

import java.util.Date;

public class TripExt extends Trip {
    private int duration;
    private String FORMATED_STR = "%s, длительность: %d";

    public TripExt() {
        super();
        duration = 0;
    }

    public TripExt(String departureCity, String destinationCity, String transportType, Date date, int maxPrice, int duration) {
        super(departureCity, destinationCity, transportType, date, maxPrice);
        this.duration = duration;
    }

    public TripExt(TripExt obj) {
        super(obj);
        this.duration = obj.duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        TripExt ob = (TripExt) o;
        return duration == ob.duration;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 19 * new Integer(duration).hashCode();
    }

    public int compareTo(TripExt ob) {
        if (super.compareTo(ob) < 0) return -1;
        if ((super.compareTo(ob) == 0) && (duration < ob.duration)) return -1;
        if ((super.compareTo(ob) == 0) && (duration == ob.duration)) return 0;
        return 1;
    }

    @Override
    public String toString() {
        return String.format(FORMATED_STR, super.toString(), duration);
    }
}
