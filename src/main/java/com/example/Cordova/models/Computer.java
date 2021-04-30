package com.example.Cordova.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    // what other criteria is going in here? CPU, GPU, RAM,
    public int price;
    public String computerIMG;
    public String description;
    //public String nothing;

    public Computer(String name, int price, String computerIMG, String description) {
        this.name = name;
        this.price = price;
        this.computerIMG = computerIMG;
        this.description = description;
    }

    public Computer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getComputerIMG() {
        return computerIMG;
    }

    public void setComputerIMG(String computerIMG) {
        this.computerIMG = computerIMG;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
