package com.example.EcoTaxi.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "offers" )
public class TaxiOffers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String route;
    private int price;
    private String imageUrl;


    public TaxiOffers() {
    }

    public TaxiOffers(String route, int price, String imageUrl) {
        this.route = route;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
