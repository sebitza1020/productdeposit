/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.productdeposit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author munte
 */
public class ConnectionDAO {
    private static Connection con;
    public final static String connectionURL = "jdbc:derby://localhost:1527/product";

    public static Connection getCon() throws SQLException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con=DriverManager.getConnection(connectionURL, "app", " ");
        }catch (Exception ex) {
            ex.printStackTrace();
        } 
        return con;
    }
}
