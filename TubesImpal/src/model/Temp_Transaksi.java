/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.KoneksiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Indira Yulita
 */
public class Temp_Transaksi {
    String id_transaksi;
    int id_barang, id_karyawan, jml;
    
    public Temp_Transaksi(String id_transaksi, int id_barang, int id_karyawan, int jml){
        this.id_transaksi = id_transaksi;
        this.id_barang = id_barang;
        this.id_karyawan = id_karyawan;
        this.jml = jml;
    }
    
    public boolean masukkanData() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement ps = null;
		int rowAffect = 0;
		String insertTableSQL = "INSERT INTO temp_transaksi"
			+"(id_transaksi,id_barang,id_karyawan,jml) VALUES" 
			+"(?,?,?,?)";
		try {
			KoneksiDB kdb = new KoneksiDB();
			kdb.bukaKoneksi();
			
			dbConnection = kdb.getConn();
			
			ps = dbConnection.prepareStatement(insertTableSQL);
                        ps.setString(1, this.id_transaksi);
			ps.setInt(2, this.id_barang);
			ps.setInt(3, this.id_karyawan);
			ps.setInt(4, this.jml);
			
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
