package com.example.demo.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voiture {
    private int id;
    private String marque;
    private int price;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public String getString(){return this.marque;}

    public int getPrice(){return this.price;}

    public void setId(int id) {
        this.id = id;
    }

    public void setString(String str){this.marque = str;}

    public void setPrice(int n_price){this.price = n_price;}


    @Override
    public String toString() {
        return "Voiture{" +
                "id=" + id +
                '}';
    }
}
