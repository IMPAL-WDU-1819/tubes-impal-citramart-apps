/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Indira Yulita
 */
public class KoneksiDB {
    public static KoneksiDB data;
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/supermarket";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "";

    private Connection connection;
    
    public static KoneksiDB getInstances() {
        if (data == null) {
                data = new KoneksiDB();
        }
        return data;
    }
    
    public KoneksiDB() {
		System.out.println("-------- MySQL JDBC Connection Demo ------------");
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL JDBC Driver not found !!");
			return;
		}
		System.out.println("MySQL JDBC Driver Registered!");

		try {
			connection = (Connection) DriverManager.getConnection(DB_URL, USER,
					PASS);
			System.out.println("SQL Connection to database established!");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			return;
		}
	}
    
    public void bukaKoneksi(){
		boolean flag = false;
		try{
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			flag = true;
		} 
		if(!flag){
			try{
				connection = DriverManager.getConnection(DB_URL, USER, PASS);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public Connection getConn(){
		return connection;
	}
}
