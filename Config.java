/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author acer
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
    private static Connection mysqlconfig;

    public static Connection configDB() throws SQLException {
        try {
            // Define database URL, username, and password
            String url = "jdbc:mysql://localhost:3306/db";
            String user = "root";
            String pass = "";

            // Register MySQL JDBC driver (use the updated driver class)
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Establish connection to the database
            mysqlconfig = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            throw e; // Rethrow exception for calling method to handle
        } catch (Exception e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        }
        return mysqlconfig;
       
    }
    
    public static void main(String[] args){
        try{
            
            configDB();
        }catch (SQLException e){
            
            System.err.print("Error di main: " + e.getMessage());
        }
        
    }
}
