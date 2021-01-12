/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.productdeposit.dao;

import com.productdeposit.model.Stock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author munte
 */
public class StockDAOImpl implements StockDAO {
    
    private Connection con;

    public StockDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public boolean addStock(Stock stock) throws SQLException {
        boolean test = false;

        try {
            String query = "INSERT INTO stock (price_unit,quantity) "
                    + "VALUES (?,?)";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setFloat(1, stock.getPriceUnit());
            pst.setInt(2, stock.getQuantity());
            pst.executeUpdate();
            test = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return test;
    }

    @Override
    public void updateStock(Stock stock) throws SQLException {
       try {
            String query = "UPDATE stock SET price_unit=?, quantity=? "
                    + "WHERE stock_id=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setFloat(1, stock.getPriceUnit());
            pt.setInt(2, stock.getQuantity());
            pt.setInt(3, stock.getStockId());
            
            pt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Stock selectStock(int id) {
        Stock st = null;
        
        try {
            String query = "SELECT * FROM stock WHERE stock_id=?";
            
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            
            while (rs.next()) {
                int iid = rs.getInt("stock_id");
                float priceUnit = rs.getFloat("price_unit");
                int quantity = rs.getInt("quantity");
                st = new Stock(iid, priceUnit, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    @Override
    public List<Stock> getAllStocks() {
        List<Stock> stocks = new ArrayList<>();

        try {
            String query = null;
            Statement stmt = null;
            ResultSet rs = null;
            stmt = this.con.createStatement();
            query = "SELECT * FROM stock";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("stock_id");
                float priceUnit = rs.getFloat("price_unit");
                int quantity = rs.getInt("quantity");

                Stock row = new Stock(id, priceUnit, quantity);
                stocks.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stocks;
    }

    @Override
    public void deleteStock(int id) throws SQLException {
        try {
            String query = "DELETE FROM stock WHERE stock_id=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, id);
            pt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
