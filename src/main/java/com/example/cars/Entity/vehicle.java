package com.example.cars.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="Car")
public class vehicle {
    @Id
    @Column(name ="idCar", length =50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCar;

    @Column(name = "carNumber", length = 20, nullable = false)
    private String carNumber;

    @Column(name = "carName", length = 50, nullable = false)
    private String carName;

    @Column(name = "carPicture", length = 255)
    private String carPicture;

    @Column(name = "ownerName", length = 100, nullable = false)
    private String ownerName;

    @Column(name = "ownerPhoneNumber", length = 15, nullable = false)
    private String ownerPhoneNumber;

    @Column(name = "whatsappNumber", length = 15, nullable = false)
    private String whatsappNumber;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "manufacturer", length = 150)
    private String manufacturer;

    @Column(name = "model", length = 150)
    private String model;

    @Column(name = "year")
    private int year;

    @Column(name = "color", length = 30, nullable = false)
    private String color;

    @Column(name = "vin", length = 17, nullable = false)
    private String vin; // Vehicle Identification Number
    @Column(name="type", length = 20, nullable = false)
    private String type;
    @Column(name = "price", length = 40, nullable = false)
    private double price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarPicture() {
        return carPicture;
    }

    public void setCarPicture(String carPicture) {
        this.carPicture = carPicture;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public String getWhatsappNumber() {
        return whatsappNumber;
    }

    public void setWhatsappNumber(String whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public vehicle(double price, String type, String vin, String color, int year, String model, String manufacturer, String email, String whatsappNumber, String ownerPhoneNumber, String ownerName, String carPicture, String carName, String carNumber, int idCar) {
        this.price = price;
        this.type = type;
        this.vin = vin;
        this.color = color;
        this.year = year;
        this.model = model;
        this.manufacturer = manufacturer;
        this.email = email;
        this.whatsappNumber = whatsappNumber;
        this.ownerPhoneNumber = ownerPhoneNumber;
        this.ownerName = ownerName;
        this.carPicture = carPicture;
        this.carName = carName;
        this.carNumber = carNumber;
        this.idCar = idCar;
    }

    public vehicle() {
    }
}
