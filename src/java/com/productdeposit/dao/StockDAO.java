/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.productdeposit.dao;

import com.productdeposit.model.Stock;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author munte
 */
public interface StockDAO {
    public boolean addStock(Stock stock) throws SQLException;
    public void updateStock(Stock stock) throws SQLException;
    public Stock selectStock(int id);
    public List<Stock> getAllStocks();
    public void deleteStock(int id) throws SQLException;
    
}
