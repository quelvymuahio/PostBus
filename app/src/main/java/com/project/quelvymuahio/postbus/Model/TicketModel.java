package com.project.quelvymuahio.postbus.Model;

import com.project.quelvymuahio.postbus.Enum.TripStatus;

import java.util.Date;

public class TicketModel {

    private Integer id, availableTickets;
    private Date departueDate, arrivalDate;
    private String price, departureTime, expectedArrivalTime;
    private RouteModel route;
    private TripStatus tripStatus;

    public TicketModel(){

    }

    public TicketModel(Integer id, Integer availableTickets, String price, Date departueDate, Date arrivalDate, String departureTime, String expectedArrivalTime, RouteModel route, TripStatus tripStatus){
        this.id = id;
        this.availableTickets = availableTickets;
        this.price = price;
        this.departueDate = departueDate;
        this.arrivalDate = arrivalDate;
        this.departureTime = departureTime;
        this.expectedArrivalTime = expectedArrivalTime;
        this.route = route;
        this.tripStatus = tripStatus;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getDepartueDate() {
        return departueDate;
    }

    public void setDepartueDate(Date departueDate) {
        this.departueDate = departueDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
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

    public RouteModel getRoute() {
        return route;
    }

    public void setRoute(RouteModel route) {
        this.route = route;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    public Integer getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(Integer availableTickets) {
        this.availableTickets = availableTickets;
    }
}
