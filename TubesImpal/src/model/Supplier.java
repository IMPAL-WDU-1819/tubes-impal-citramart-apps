/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.KoneksiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Indira Yulita
 */
public class Supplier {
    private String id_supplier;
    private String nama_supplier, alamat;
    private int no_telfon;
    
    public Supplier (String id_supplier, String nama_supplier, int no_telfon, String alamat){
        this.id_supplier = id_supplier;
        this.nama_supplier = nama_supplier;
        this.no_telfon = no_telfon;
        this.alamat = alamat;
        
    }
    
    public Supplier(){
        
    }

    public Supplier(String nama_supplier, String alamat, int no_telfon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public String getId_supplier() {
        return id_supplier;
    }
    
    public void setId_supplier(String id_supplier){
        this.id_supplier = id_supplier;
    }
    
    public String getNama_supplier(){
        return nama_supplier;
    }
    
    public void setNama_supplier(String nama_supplier){
        this.nama_supplier = nama_supplier;
    }
    
    public int getNo_telfon(){
        return no_telfon;
    }
    
    public void setNo_telfon(int no_telfon){
        this.no_telfon = no_telfon;
    }
    
    public String getAlamat(){
        return alamat;
    }
    
    public void setAlamat (String alamat){
        this.alamat = alamat;
    }
    public Supplier(String id_suplier, String nama_suplier, String alamat){
        this.id_supplier = id_supplier;
        this.nama_supplier = nama_supplier;
        this.alamat = alamat;
    }
    
    public  ResultSet lihatData (String id_suplier) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id = this.id_supplier=id_supplier;
                int idK = Integer.parseInt(id);
		String viewTableSQL = "SELECT * FROM supplier WHERE id_supplier = ?";
		try{
			KoneksiDB kdb = new KoneksiDB();
			kdb.bukaKoneksi();
			
			dbConnection = kdb.getConn();
			
			ps = dbConnection.prepareStatement(viewTableSQL);
			ps.setInt(1, idK);
			
			rs = ps.executeQuery();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			//ps.close();
		}
		return rs;
	}
    
    public ResultSet isiDataKombo() throws SQLException {
        Connection dbConnection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String viewTableSQL = "SELECT * FROM supplier";
        try {
            		
            KoneksiDB kdb = new KoneksiDB();
            kdb.bukaKoneksi();
            dbConnection = kdb.getConn();
            ps = dbConnection.prepareStatement(viewTableSQL);
            rs = ps.executeQuery();
			
          
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            
        }
		return rs;
    }
        public boolean masukkanData() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement ps = null;
		int rowAffect = 0;
		String insertTableSQL = "INSERT INTO supplier"
			+"(nama_supplier, alamat, no_telfon) VALUES" 
			+"(?,?,?,?,?)";
		try {
			KoneksiDB kdb = new KoneksiDB();
			kdb.bukaKoneksi();
			
			dbConnection = kdb.getConn();
			
			ps = dbConnection.prepareStatement(insertTableSQL);
                        ps.setString(1, nama_supplier);
                        ps.setString(2, alamat);
                        ps.setInt(3, no_telfon);
			
			rowAffect = ps.executeUpdate();
			
		} catch (Exception e){
			System.out.println(e.getMessage());
		} finally {
			//ps.close();
		}
		if(rowAffect > 0){
			return true;
		}
		else
		{
			return false;
		}
	}
}

