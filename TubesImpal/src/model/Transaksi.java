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
public class Transaksi {
    String id_transaksi;
    int id_barang, id_karyawan, jml, total_harga;
    
    public Transaksi(){
        
    }
    
    public Transaksi(String id_transaksi, int id_barang, int id_karyawan, int jml, int total_harga){
        this.id_transaksi = id_transaksi;
        this.id_barang = id_barang;
        this.id_karyawan = id_karyawan;
        this.jml = jml;
        this.total_harga = total_harga;
    }
    
    public boolean masukkanData() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement ps = null;
		int rowAffect = 0;
		String insertTableSQL = "INSERT INTO transaksi"
			+"(id_transaksi,id_barang,id_karyawan,jml,total_harga) VALUES" 
			+"(?,?,?,?,?)";
		try {
			KoneksiDB kdb = new KoneksiDB();
			kdb.bukaKoneksi();
			
			dbConnection = kdb.getConn();
			
			ps = dbConnection.prepareStatement(insertTableSQL);
                        ps.setString(1, this.id_transaksi);
			ps.setInt(2, this.id_barang);
			ps.setInt(3, this.id_karyawan);
			ps.setInt(4, this.jml);
                        ps.setInt(5, this.total_harga);
			
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
    
    public ResultSet lihatNData() throws SQLException  {
		KoneksiDB kdb = new KoneksiDB();
		
		Connection dbConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String viewTableSQL = "SELECT k.nama_karyawan, b.nama_barang, t.tgl, t.jml, t.total_harga "
                        + "FROM transaksi t join karyawan k on k.id_karyawan=t.id_karyawan "
                        + "join barang b on b.id_barang=t.id_barang ";
		try{
			kdb.bukaKoneksi();
			
			dbConnection = kdb.getConn();
			
			ps = dbConnection.prepareStatement(viewTableSQL);
			
			rs = ps.executeQuery();
			
			
		} catch (Exception e){
			System.out.println(e.getMessage());
		} finally {
			//ps.close();
		}
		return rs;
	}
}
