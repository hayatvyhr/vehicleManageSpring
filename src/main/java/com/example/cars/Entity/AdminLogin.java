package com.example.cars.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "adminLogin")

public class AdminLogin {
    @Id
    @Column(name = "idAdmin", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int idAdmin;

    @Column(name = "username", length = 100)
    private String username;
    @Column(name = "password")
    private String password;

    public AdminLogin(String password, String username, int idAdmin) {
        this.password = password;
        this.username = username;
        this.idAdmin = idAdmin;
    }
    public AdminLogin(){

    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
}
