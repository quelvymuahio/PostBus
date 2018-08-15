package com.project.quelvymuahio.postbus.Enum;

public enum TripStatus {

    RUNNING("A Decorrer"), CANCELED("Cancelado"), DONE("Efectuado"), SCHEDULED("Agendado");

    private String description;

    TripStatus() {

    }

    private TripStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
