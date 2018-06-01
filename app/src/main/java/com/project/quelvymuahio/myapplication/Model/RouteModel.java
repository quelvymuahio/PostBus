package com.project.quelvymuahio.myapplication.Model;

public class RouteModel {

    private Integer id;
    private CarModel car;
    private String name;
    private double distance;

    public RouteModel(){

    }

    public RouteModel(Integer id, CarModel car, String name, double distance) {
        this.id = id;
        this.car = car;
        this.name = name;
        this.distance = distance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CarModel getCar() {
        return car;
    }

    public void setCar(CarModel car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
