package semestr2.labs.lab1;

import java.util.Date;

public class Trip implements Comparable<Trip> {
    private String departureCity;
    private String destinationCity;
    private String transportType;
    private Date date;
    private int maxPrice;
    final private String FORMATED_STRING = "Город отправления: %s, город прибытия: %s, тип транспорта: %s, дата: %tc, максимальная цена: %d\n";

    public Trip() {
        this.departureCity = "";
        this.destinationCity = "";
        this.transportType = "";
        this.date = new Date(0);
        this.maxPrice = 0;
    }

    public Trip(String departureCity, String destinationCity, String transportType, Date date, int maxPrice) {
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.transportType = transportType;
        this.date = date;
        this.maxPrice = maxPrice;
    }

    public Trip(Trip trip) {
        this.departureCity = trip.departureCity;
        this.destinationCity = trip.destinationCity;
        this.transportType = trip.transportType;
        this.date = trip.date;
        this.maxPrice = trip.maxPrice;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int doubleMaxPrice() {
        return this.maxPrice * 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return this.departureCity.equals(trip.departureCity) && this.destinationCity.equals(trip.destinationCity) && this.transportType.equals(trip.transportType) && this.date.equals(trip.date) && this.maxPrice == trip.maxPrice;
    }

    @Override
    public int hashCode() {
        return 3 * this.departureCity.hashCode() + 7 * this.destinationCity.hashCode() + 11 * this.transportType.hashCode() + 13 * this.date.hashCode() + 17 * new Integer(this.maxPrice).hashCode();
    }

    public int compareTo(Trip trip) {
        if (departureCity.compareTo(trip.departureCity) < 0) return -1;
        if ((departureCity.compareTo(trip.departureCity) == 0) && (destinationCity.compareTo(trip.destinationCity) < 0)) return -1;
        if ((departureCity.compareTo(trip.departureCity) == 0) && (destinationCity.compareTo(trip.destinationCity) == 0) && (transportType.compareTo(trip.transportType) < 0)) return -1;
        if ((departureCity.compareTo(trip.departureCity) == 0) && (destinationCity.compareTo(trip.destinationCity) == 0) && (transportType.compareTo(trip.transportType) == 0) && (date.compareTo(trip.date) < 0)) return -1;
        if ((departureCity.compareTo(trip.departureCity) == 0) && (destinationCity.compareTo(trip.destinationCity) == 0) && (transportType.compareTo(trip.transportType) == 0) && (date.compareTo(trip.date) == 0) && (maxPrice < trip.maxPrice)) return -1;
        if ((departureCity.compareTo(trip.departureCity) == 0) && (destinationCity.compareTo(trip.destinationCity) == 0) && (transportType.compareTo(trip.transportType) == 0) && (date.compareTo(trip.date) == 0) && (maxPrice == trip.maxPrice)) return 0;
        return 1;
    }

    @Override
    public String toString() {
        return String.format(FORMATED_STRING, departureCity, destinationCity, transportType, date, maxPrice);
    }


}
