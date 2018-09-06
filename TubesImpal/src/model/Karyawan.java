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
public class Karyawan {
    private String nama_karyawan, jabatan, ttl, alamat, username, password;
    private String id_karyawan;
    
    public Karyawan(){
        
    }
    
    public Karyawan(String nama_karyawan, String jabatan, String ttl, String alamat, 
            String username, String password, String id_karyawan){
        this.id_karyawan = id_karyawan;
        this.jabatan = jabatan;
        this.ttl = ttl;
        this.alamat = alamat;
        this.username = username;
        this.password = password;
    }
    
    public  ResultSet lihatData (String id_karyawan) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id = this.id_karyawan=id_karyawan;
                int idK = Integer.parseInt(id);
		String viewTableSQL = "SELECT * FROM karyawan WHERE id_karyawan = ?";
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

        String viewTableSQL = "SELECT * FROM karyawan";
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
    
}
