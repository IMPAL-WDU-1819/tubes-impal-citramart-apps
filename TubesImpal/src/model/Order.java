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
 * @author ybnun
 */
public class Order {
    
    private int id_karyawan, id_barang, id_suplier, jumlah;
    
    public Order(){
        
    }
    
    public Order(int id_barang, int id_karyawan, int id_suplier, int jumlah){
        this.id_karyawan = id_karyawan;
        this.id_barang = id_barang;
        this.id_suplier = id_suplier;
        this.jumlah = jumlah;
    }
    
    
    public boolean masukkanData() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement ps = null;
		int rowAffect = 0;
		String insertTableSQL = "INSERT INTO order_barang"
			+"(id_karyawan,id_barang,id_supplier,jumlah) VALUES" 
			+"(?,?,?,?)";
		try {
			KoneksiDB kdb = new KoneksiDB();
			kdb.bukaKoneksi();
			
			dbConnection = kdb.getConn();
			
			ps = dbConnection.prepareStatement(insertTableSQL);
                        ps.setInt(1, this.id_karyawan);
			ps.setInt(2, this.id_barang);
			ps.setInt(3, this.id_suplier);
			ps.setInt(4, this.jumlah);
			
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
		String viewTableSQL = "SELECT k.nama_karyawan, b.nama_barang, s.nama_supplier, o.tgl_order, o.jumlah "
                        + "FROM order_barang o join karyawan k on k.id_karyawan=o.id_karyawan "
                        + "join barang b on b.id_barang=o.id_barang "
                        + "join supplier s on s.id_supplier=o.id_supplier ";
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
