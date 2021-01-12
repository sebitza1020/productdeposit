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
@Table(name = "stock")
public class Stock implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockId;
    @Column(name = "price_unit")
    private float priceUnit;
    @Column(name = "quantity")
    private int quantity;

    public Stock(int stockId, float priceUnit, int quantity) {
        this.stockId = stockId;
        this.priceUnit = priceUnit;
        this.quantity = quantity;
    }

    public Stock(float priceUnit, int quantity) {
        this.priceUnit = priceUnit;
        this.quantity = quantity;
    }

    public Stock() {
    }
    

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
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
    
    
}
