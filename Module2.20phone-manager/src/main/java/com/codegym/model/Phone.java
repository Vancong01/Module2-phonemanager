package com.codegym.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private LocalDate dateOfPurchase;
    private Long price;
    private String description;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Phone(String name, LocalDate dateOfPurchase, Long price, String description, String image) {
        this.name = name;
        this.dateOfPurchase = dateOfPurchase;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public Phone() {
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

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
