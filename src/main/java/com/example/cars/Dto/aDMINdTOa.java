package com.example.cars.Dto;

public class aDMINdTOa {
    private int idAdmin;
    private String username;
    private String password;
    public aDMINdTOa() {

    }
    public aDMINdTOa(int idAdmin, String Username, String Password) {
        this.idAdmin = idAdmin;
        this.username = Username;
        this.password = Password;
    }

    public String getPassword() {
        return password;
    }



    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password; // Corrected
    }

    public void setUsername(String username) {
        this.username = username; // Corrected
    }


    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
}
