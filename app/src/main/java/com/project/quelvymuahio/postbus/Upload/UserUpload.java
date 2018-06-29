package com.project.quelvymuahio.postbus.Upload;

public class UserUpload {

    private String name, username, password, contact, birthDate, imageUrl;

    //public UserUpload(){}

    public UserUpload(String name, String username, String password, String contact, String birthDate, String imageUrl) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.contact = contact;
        this.birthDate = birthDate;
        this.imageUrl = imageUrl;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
