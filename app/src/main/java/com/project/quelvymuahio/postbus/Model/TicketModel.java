package com.project.quelvymuahio.postbus.Model;

public class TicketModel {

    private String id, availableTickets, departueDate, arrivalDate, price, departureTime, expectedArrivalTime, tripStatus;
    private RouteModel route;

    public TicketModel(){
        // required a no-argument construtor
    }

    public TicketModel(String id, String availableTickets, String departueDate, String arrivalDate, String price, String departureTime, String expectedArrivalTime, String tripStatus, RouteModel route){
        this.id = id;
        this.price = price;
        this.departureTime = departureTime;
        this.expectedArrivalTime = expectedArrivalTime;
        this.availableTickets = availableTickets;
        this.departueDate = departueDate;
        this.arrivalDate = arrivalDate;
        this.tripStatus = tripStatus;
        this.route = route;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(String availableTickets) {
        this.availableTickets = availableTickets;
    }

    public String getDepartueDate() {
        return departueDate;
    }

    public void setDepartueDate(String departueDate) {
        this.departueDate = departueDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getExpectedArrivalTime() {
        return expectedArrivalTime;
    }

    public void setExpectedArrivalTime(String expectedArrivalTime) {
        this.expectedArrivalTime = expectedArrivalTime;
    }

    public String getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(String tripStatus) {
        this.tripStatus = tripStatus;
    }

    public RouteModel getRoute() {
        return route;
    }

    public void setRoute(RouteModel route) {
        this.route = route;
    }
}
