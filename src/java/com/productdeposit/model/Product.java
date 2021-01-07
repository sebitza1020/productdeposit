/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.productdeposit.model;

/**
 *
 * @author munte
 */
public class Product {

    private int id;
    private String name;
    private String unit;
    private float priceUnit;
    private int quantity;

    public Product(int id, String name, String unit, float priceUnit, int quantity) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.priceUnit = priceUnit;
        this.quantity = quantity;
    }

    public Product(String name, String unit, float priceUnit, int quantity) {
        this.name = name;
        this.unit = unit;
        this.priceUnit = priceUnit;
        this.quantity = quantity;
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

    public float getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(float priceUnit) {
        this.priceUnit = priceUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product[" + "id=" + id + ", name=" + name + ", unit=" + unit
                + ", priceUnit=" + priceUnit + ", quantity=" + quantity + ']';
    }
}
