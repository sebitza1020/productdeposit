/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.productdeposit.dao;

import com.productdeposit.model.Product;
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
public class ProductDAOImpl implements ProductDAO {

    Connection con;

    public ProductDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public boolean addProduct(Product product) throws SQLException {
        boolean test = false;

        try {
            String query = "INSERT INTO product (nume,unit,price_unit,quantity) "
                    + "VALUES (?,?,?,?)";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, product.getName());
            pst.setString(2, product.getUnit());
            pst.setDouble(3, product.getPriceUnit());
            pst.setInt(4, product.getQuantity());
            pst.executeUpdate();
            test = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        try {
            String query = "UPDATE product SET nume=?, unit=?, price_unit=?, quantity=? "
                    + "WHERE id=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, product.getName());
            pt.setString(2, product.getUnit());
            pt.setDouble(3, product.getPriceUnit());
            pt.setInt(4, product.getQuantity());
            pt.setInt(5, product.getId());
            
            pt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product selectProduct(int id) {
        Product pr = null;
        
        try {
            String query = "SELECT * FROM product WHERE id=?";
            
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            
            while (rs.next()) {
                int iid = rs.getInt("id");
                String name = rs.getString("nume");
                String unit = rs.getString("unit");
                float priceUnit = rs.getFloat("price_unit");
                int quantity = rs.getInt("quantity");
                pr = new Product(iid, name, unit, priceUnit, quantity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }

    @Override
    public List<Product> getAllProducts(String aData) {
        List<Product> products = new ArrayList<>();

        try {
            String query = null;
            Statement st = null;
            ResultSet rs = null;
            st = this.con.createStatement();
            String data = aData;
            if(data!=null){
                query = "SELECT * FROM product WHERE nume LIKE '%"+data+"%' "
                        + "OR unit LIKE '%"+data+"%' ";
            }
            if("".equals(data) || data == null) {
                query = "SELECT * FROM product ORDER BY nume, unit";
            }
            rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("nume");
                String unit = rs.getString("unit");
                float priceUnit = rs.getFloat("price_unit");
                int quantity = rs.getInt("quantity");

                Product row = new Product(id, name, unit, priceUnit, quantity);
                products.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
        try {
            String query = "DELETE FROM product WHERE id=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, id);
            pt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
}

    
    

