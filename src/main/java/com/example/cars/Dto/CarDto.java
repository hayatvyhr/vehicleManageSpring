package com.example.cars.Dto;

import org.springframework.web.multipart.MultipartFile;

public class CarDto {
    private int idCar;
    private String carNumber;
    private String carName;
    private MultipartFile carPicture;
    private String ownerName;
    private String ownerPhoneNumber;
    private String whatsappNumber;
    private String email;
    private String manufacturer;
    private String model;
    private int year;
    private String color;
    private String vin;
    private String type;
    private double price;
private String Pic;

    public String getPic() {
        return Pic;
    }

    public void setPic(String pic) {
        Pic = pic;
    }

    public CarDto() {
    }

    public CarDto(double price, String type, String vin, String color, int year, String model, String manufacturer, String email, String whatsappNumber, String ownerPhoneNumber, String ownerName, MultipartFile carPicture, String carName, String carNumber, int idCar) {
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

    public CarDto(int idCar, String carNumber, String carName, String ownerName, String ownerPhoneNumber, String whatsappNumber, String email, String manufacturer, String model, int year, String color, String vin, String type, double price, String pic) {
        this.idCar = idCar;
        this.carNumber = carNumber;
        this.carName = carName;
        this.ownerName = ownerName;
        this.ownerPhoneNumber = ownerPhoneNumber;
        this.whatsappNumber = whatsappNumber;
        this.email = email;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
        this.type = type;
        this.price = price;
        Pic = pic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWhatsappNumber() {
        return whatsappNumber;
    }

    public void setWhatsappNumber(String whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public MultipartFile getCarPicture() {
        return carPicture;
    }

    public void setCarPicture(MultipartFile carPicture) {
        this.carPicture = carPicture;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

}
