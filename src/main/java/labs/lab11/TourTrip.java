package labs.lab11;

import java.util.Date;

public class TourTrip {
    private String startCity;
    private String destCity;
    private String transportType;
    private Date dateOfArrival;
    private int maxPrice;

    public TourTrip() {

    }

    public TourTrip(String startCity, String destCity, String transportType, Date dateOfArrival, int maxPrice) {
        this.startCity = startCity;
        this.destCity = destCity;
        this.transportType = transportType;
        this.dateOfArrival = dateOfArrival;
        this.maxPrice = maxPrice;
    }

    public String getStartCity() {
        return startCity;
    }

    public String getDestCity() {
        return destCity;
    }

    public String getTransportType() {
        return transportType;
    }

    public Date getDateOfArrival() {
        return dateOfArrival;
    }

    public int getMaxPrice() {
        return maxPrice;
    }
    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public void setDestCity(String destCity) {
        this.destCity = destCity;
    }

    public void setTransportType(String transportType) {
        this.transportType  = transportType;
    }

    public void setDateOfArrival(Date dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public void setMaxPrice(int maxPrice){
        this.maxPrice = maxPrice;
    }

    public String toString() {
        return "Tour trip by " + this.transportType + " from " + this.startCity + " to " + this.destCity + " max price: " + this.maxPrice + " arrives: " + this.dateOfArrival;
    }

    public boolean equals(TourTrip a) {
        if (this == a) return true;
        if (this.transportType == a.transportType && this.dateOfArrival == a.dateOfArrival && this.maxPrice == a.maxPrice && this.destCity == a.destCity && this.startCity == a.startCity) return true;
        return false;
    }
}
