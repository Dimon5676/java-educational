package semestr2.labs.lab2;

import java.util.Date;

public class Trip2 implements Comparable<Trip2> {
    private String departureCity;
    private String destinationCity;
    private String transportType;
    private int transportCode;
    private Date dateOtpr;
    private Date timeOtpr;
    private Date datePri;
    private Date timePri;
    private int price;
    final private String FORMATED_STRING = "Город отправления: %s, город прибытия: %s, тип транспорта: %s, код транспорта: %d, дата отправления: %tc, время отправления: %tc, дата прибытия: %tc, время прибытия: %tc, цена: %d\n";

    public Trip2() {
        this.departureCity = "";
        this.destinationCity = "";
        this.transportType = "";
        this.transportCode = 0;
        this.dateOtpr = new Date(0);
        this.timeOtpr = new Date(0);
        this.datePri = new Date(0);
        this.timePri = new Date(0);
        this.price = 0;
    }

    public Trip2(String departureCity, String destinationCity, String transportType, int transportCode, Date dateOtpr, Date timeOtpr, Date datePri, Date timePri, int price) {
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.transportType = transportType;
        this.transportCode = transportCode;
        this.dateOtpr = dateOtpr;
        this.timeOtpr = timeOtpr;
        this.datePri = datePri;
        this.timePri = timePri;
        this.price = price;
    }

    public Trip2(Trip2 trip) {
        this.departureCity = trip.departureCity;
        this.destinationCity = trip.destinationCity;
        this.transportType = trip.transportType;
        this.transportCode = trip.transportCode;
        this.dateOtpr = trip.dateOtpr;
        this.timeOtpr = trip.timeOtpr;
        this.datePri = trip.datePri;
        this.timePri = trip.timePri;
        this.price = trip.price;
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

    public int getTransportCode() {
        return transportCode;
    }

    public void setTransportCode(int transportCode) {
        this.transportCode = transportCode;
    }

    public Date getDateOtpr() {
        return dateOtpr;
    }

    public void setDateOtpr(Date dateOtpr) {
        this.dateOtpr = dateOtpr;
    }

    public Date getTimeOtpr() {
        return timeOtpr;
    }

    public void setTimeOtpr(Date timeOtpr) {
        this.timeOtpr = timeOtpr;
    }

    public Date getDatePri() {
        return datePri;
    }

    public void setDatePri(Date datePri) {
        this.datePri = datePri;
    }

    public Date getTimePri() {
        return timePri;
    }

    public void setTimePri(Date timePri) {
        this.timePri = timePri;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip2 trip = (Trip2) o;
        return this.departureCity.equals(trip.departureCity) && this.destinationCity.equals(trip.destinationCity) && this.transportType.equals(trip.transportType) && this.transportCode == trip.transportCode && this.dateOtpr.equals(trip.dateOtpr) && this.timeOtpr.equals(trip.timeOtpr) && this.datePri.equals(trip.datePri) && this.timePri.equals(trip.timePri) && this.price == trip.price;
    }

    @Override
    public int hashCode() {
        return 3 * this.departureCity.hashCode() + 7 * this.destinationCity.hashCode() + 11 * this.transportType.hashCode() + 11 * new Integer(transportCode).hashCode() + 13 * this.dateOtpr.hashCode() + 17 * this.timeOtpr.hashCode() + 19 * this.datePri.hashCode() + 23 * this.timePri.hashCode()+ 29 * new Integer(this.price).hashCode();
    }

    public int compareTo(Trip2 trip) {
        if (departureCity.compareTo(trip.departureCity) < 0) return -1;
        if ((departureCity.compareTo(trip.departureCity) == 0) && (destinationCity.compareTo(trip.destinationCity) < 0)) return -1;
        if ((departureCity.compareTo(trip.departureCity) == 0) && (destinationCity.compareTo(trip.destinationCity) == 0) && (transportType.compareTo(trip.transportType) < 0)) return -1;
        if ((departureCity.compareTo(trip.departureCity) == 0) && (destinationCity.compareTo(trip.destinationCity) == 0) && (transportType.compareTo(trip.transportType) == 0) && (transportCode < trip.transportCode)) return -1;
        if ((departureCity.compareTo(trip.departureCity) == 0) && (destinationCity.compareTo(trip.destinationCity) == 0) && (transportType.compareTo(trip.transportType) == 0) && (transportCode == trip.transportCode) && (dateOtpr.compareTo(trip.dateOtpr) < 0)) return -1;
        if ((departureCity.compareTo(trip.departureCity) == 0) && (destinationCity.compareTo(trip.destinationCity) == 0) && (transportType.compareTo(trip.transportType) == 0) && (transportCode == trip.transportCode) && (dateOtpr.compareTo(trip.dateOtpr) == 0) && (timeOtpr.compareTo(trip.timeOtpr) < 0)) return -1;
        if ((departureCity.compareTo(trip.departureCity) == 0) && (destinationCity.compareTo(trip.destinationCity) == 0) && (transportType.compareTo(trip.transportType) == 0) && (transportCode == trip.transportCode) && (dateOtpr.compareTo(trip.dateOtpr) == 0) && (timeOtpr.compareTo(trip.timeOtpr) == 0) && (datePri.compareTo(trip.datePri) < 0)) return -1;
        if ((departureCity.compareTo(trip.departureCity) == 0) && (destinationCity.compareTo(trip.destinationCity) == 0) && (transportType.compareTo(trip.transportType) == 0) && (transportCode == trip.transportCode) && (dateOtpr.compareTo(trip.dateOtpr) == 0) && (timeOtpr.compareTo(trip.timeOtpr) == 0) && (datePri.compareTo(trip.datePri) == 0) && (timePri.compareTo(trip.timePri) < 0)) return -1;
        if ((departureCity.compareTo(trip.departureCity) == 0) && (destinationCity.compareTo(trip.destinationCity) == 0) && (transportType.compareTo(trip.transportType) == 0) && (transportCode == trip.transportCode) && (dateOtpr.compareTo(trip.dateOtpr) == 0) && (timeOtpr.compareTo(trip.timeOtpr) == 0) && (datePri.compareTo(trip.datePri) == 0) && (timePri.compareTo(trip.timePri) == 0) && (price < trip.price)) return -1;
        if ((departureCity.compareTo(trip.departureCity) == 0) && (destinationCity.compareTo(trip.destinationCity) == 0) && (transportType.compareTo(trip.transportType) == 0) && (transportCode == trip.transportCode) && (dateOtpr.compareTo(trip.dateOtpr) == 0) && (timeOtpr.compareTo(trip.timeOtpr) == 0) && (datePri.compareTo(trip.datePri) == 0) && (timePri.compareTo(trip.timePri) == 0) && (price == trip.price)) return 0;
        return 1;
    }

    @Override
    public String toString() {
        return String.format(FORMATED_STRING, departureCity, destinationCity, transportType, transportCode, dateOtpr, timeOtpr, datePri, timeOtpr, price);
    }

    public boolean accord(Trip trip) {
        if (trip.getDepartureCity().equals(departureCity) && trip.getDestinationCity().equals(destinationCity) && trip.getTransportType().equals(transportType) && trip.getDate().equals(datePri) && trip.getMaxPrice() >= price) return true;
        return false;
    }
}
