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
public class Barang {
    private String nama_barang, expired, id_barang;
    private int harga_beli, harga_jual, stok;
   
    
    public Barang(String nama_barang, int harga_beli, int harga_jual, String expired, int stok){
        this.nama_barang = nama_barang;
        this.harga_beli = harga_beli;
        this.harga_jual = harga_jual;
        this.expired = expired;
        this.stok = stok;
    }
    
    public Barang(){
        
    }
    
    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public String getId_barang() {
        return id_barang;
    }

    public void setId_barang(String id_barang) {
        this.id_barang = id_barang;
    }

    public int getHarga_beli() {
        return harga_beli;
    }

    public void setHarga_beli(int harga_beli) {
        this.harga_beli = harga_beli;
    }

    public int getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(int harga_jual) {
        this.harga_jual = harga_jual;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    
    public  ResultSet lihatData (String id_barang) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id = this.id_barang=id_barang;
                int idK = Integer.parseInt(id);
		String viewTableSQL = "SELECT * FROM barang WHERE id_barang = ?";
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

        String viewTableSQL = "SELECT * FROM barang";
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
		String insertTableSQL = "INSERT INTO barang"
			+"(nama_barang, harga_beli, harga_jual, expired, stok) VALUES" 
			+"(?,?,?,?,?)";
		try {
			KoneksiDB kdb = new KoneksiDB();
			kdb.bukaKoneksi();
			
			dbConnection = kdb.getConn();
			
			ps = dbConnection.prepareStatement(insertTableSQL);
                        ps.setString(1, nama_barang);
                        ps.setInt(2, harga_beli);
                        ps.setInt(3, harga_jual);
                        ps.setString(4, expired);
                        ps.setInt(5, stok);
                        
			
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
