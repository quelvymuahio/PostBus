package com.project.quelvymuahio.postbus.Model;

public class CarModel {

    private Integer id;
    private int image, seatingSeats;
    private String carRegistration;

    public CarModel(){

    }

    public CarModel(Integer id, int image, int seatingSeats, String carRegistration) {
        this.id = id;
        this.image = image;
        this.seatingSeats = seatingSeats;
        this.carRegistration = carRegistration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getSeatingSeats() {
        return seatingSeats;
    }

    public void setSeatingSeats(int seatingSeats) {
        this.seatingSeats = seatingSeats;
    }

    public String getCarRegistration() {
        return carRegistration;
    }

    public void setCarRegistration(String carRegistration) {
        this.carRegistration = carRegistration;
    }
}
