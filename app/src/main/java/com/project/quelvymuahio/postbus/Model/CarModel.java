package com.project.quelvymuahio.postbus.Model;

public class CarModel {

    private String id, imageUrl, seatingSeats, carRegistration, diverName;

    public CarModel(){
        //required no-argument construtor
    }

    public CarModel(String id, String motorista, String imagem_url, String assentos, String matricula) {
        this.id = id;
        this.diverName = motorista;
        this.imageUrl = imagem_url;
        this.seatingSeats = assentos;
        this.carRegistration = matricula;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSeatingSeats() {
        return seatingSeats;
    }

    public void setSeatingSeats(String seatingSeats) {
        this.seatingSeats = seatingSeats;
    }

    public String getCarRegistration() {
        return carRegistration;
    }

    public void setCarRegistration(String carRegistration) {
        this.carRegistration = carRegistration;
    }

    public String getDiverName() {
        return diverName;
    }

    public void setDiverName(String diverName) {
        this.diverName = diverName;
    }
}
