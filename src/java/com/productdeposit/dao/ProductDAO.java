/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.productdeposit.dao;

import com.productdeposit.model.Product;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author munte
 */
public interface ProductDAO {
    public boolean addProduct(Product product) throws SQLException;
    public void updateProduct(Product product) throws SQLException;
    public Product selectProduct(Integer id);
    public List<Product> getAllProducts(String aData);
    public void deleteProduct(Integer id) throws SQLException;
}
