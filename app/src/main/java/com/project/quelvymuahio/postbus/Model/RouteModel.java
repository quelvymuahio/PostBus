package com.project.quelvymuahio.postbus.Model;

public class RouteModel {

    private CarModel car;
    private String id, name, distance;

    public RouteModel(){
        // required a no-argument construtor
    }

    public RouteModel(String id, CarModel car, String name, String distance) {
        this.id = id;
        this.car = car;
        this.name = name;
        this.distance = distance;
    }

    public CarModel getCar() {
        return car;
    }

    public void setCar(CarModel car) {
        this.car = car;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
