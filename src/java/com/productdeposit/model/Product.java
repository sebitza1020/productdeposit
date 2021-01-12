/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.productdeposit.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author munte
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nume")
    private String name;
    @Column(name = "unit")
    private String unit;

    public Product(int id, String name, String unit) {
        this.id = id;
        this.name = name;
        this.unit = unit;
    }

    public Product(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Product[" + "id=" + id + ", name=" + name + ", unit=" + unit
                +  ']';
    }
}
