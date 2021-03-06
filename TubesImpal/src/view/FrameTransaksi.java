/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Barang;
import model.Karyawan;
import model.Order;
import model.Temp_Transaksi;
import model.Transaksi;

/**
 *
 * @author Indira Yulita
 */
public class FrameTransaksi extends javax.swing.JFrame {

    /**
     * Creates new form FrameTransaksi
     */
    public FrameTransaksi() {
        initComponents();
    }
    
    public void tampilDataKombo() throws SQLException {
		ResultSet rs = null;
		Karyawan dm = new Karyawan();
		boolean status = false;
		
		try{
			rs = dm.isiDataKombo();
			while(rs.next()){
				comNamaKar.addItem(rs.getString(1));
			}
		}catch (Exception ex){
			Logger.getLogger(FrameTransaksi.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
    
    public void tampilDataKomboBar() throws SQLException {
		ResultSet rs = null;
		Barang brg = new Barang();
		boolean status = false;
		
		try{
			rs = brg.isiDataKombo();
			while(rs.next()){
				comIdBar.addItem(rs.getString(1));
			}
		}catch (Exception ex){
			Logger.getLogger(FrameTransaksi.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdTrans = new javax.swing.JTextField();
        comNamaKar = new javax.swing.JComboBox();
        comIdBar = new javax.swing.JComboBox();
        txtNamaBar = new javax.swing.JTextField();
        txtJum = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotBay = new javax.swing.JTextField();
        btBeli = new javax.swing.JButton();
        btClear = new javax.swing.JButton();
        btBack = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblHargaSat = new javax.swing.JLabel();
        txtNamaKar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Form Transaksi Pembelian");

        jLabel2.setText("Id Transaksi");

        jLabel3.setText("Nama Karyawan");

        jLabel4.setText("Nama Barang");

        jLabel5.setText("Jumlah");

        comNamaKar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comNamaKarActionPerformed(evt);
            }
        });

        comIdBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comIdBarActionPerformed(evt);
            }
        });

        txtNamaBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaBarActionPerformed(evt);
            }
        });

        txtJum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumActionPerformed(evt);
            }
        });

        jLabel6.setText("Total Bayar");

        btBeli.setText("Beli");
        btBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBeliActionPerformed(evt);
            }
        });

        btClear.setText("Clear");

        btBack.setText("Back");
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });

        jLabel7.setText("@");

        lblHargaSat.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btBack))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btBeli, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(txtIdTrans)
                            .addComponent(txtJum)
                            .addComponent(txtTotBay)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(comNamaKar, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comIdBar, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNamaBar)
                                    .addComponent(txtNamaKar))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblHargaSat, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comNamaKar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaKar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comIdBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(lblHargaSat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtJum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTotBay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btBeli)
                    .addComponent(btClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btBack))
        );

        try{
            tampilDataKombo();
        }catch (SQLException ex){
            Logger.getLogger(FrameTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }

        jPanel1.add(comNamaKar);
        jPanel1.add(comNamaKar, new java.awt.GridBagConstraints());
        try{
            tampilDataKomboBar();
        }catch (SQLException ex){
            Logger.getLogger(FrameTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }

        jPanel1.add(comIdBar);
        jPanel1.add(comIdBar, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarActionPerformed

    private void comIdBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comIdBarActionPerformed
        // TODO add your handling code here:
        ResultSet rs = null;
        String x = (String)comIdBar.getSelectedItem();

        
            Barang brg = new Barang();
            boolean status = false;

            try {
                rs = brg.lihatData(x);
                if (rs.next()) {
                    txtNamaBar.setText(rs.getString(2));
                    lblHargaSat.setText(rs.getString(3));

                } else {
                    //JOptionPane.showMessageDialog(this, "View Gagal", "Status", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrameOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_comIdBarActionPerformed

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        // TODO add your handling code here:
        FrameHome fh = new FrameHome();
        fh.setVisible(true);
    }//GEN-LAST:event_btBackActionPerformed

    private void btBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBeliActionPerformed
        // TODO add your handling code here:
        String idTrans = txtIdTrans.getText();
        String namaKar = (String)comNamaKar.getSelectedItem();
        String idBar = (String)comIdBar.getSelectedItem();
        String tot = txtTotBay.getText();
        String jum = txtJum.getText();
        
        int idK = Integer.parseInt(namaKar);
        int idB = Integer.parseInt(idBar);
        int jml = Integer.parseInt(jum);
        int total = Integer.parseInt(tot);
        
        boolean status = false;
        
        try{
                Transaksi tr = new Transaksi(idTrans, idB, idK, jml, total);
                status = tr.masukkanData();
                
                Temp_Transaksi tt = new Temp_Transaksi(idTrans, idB, idK, jml);
                status = tt.masukkanData();
        } catch (SQLException ex) {
                Logger.getLogger(FrameOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(status){
                JOptionPane.showMessageDialog(this, "Transaksi Berhasil","status",JOptionPane.INFORMATION_MESSAGE);
                txtIdTrans.setText("");
                txtJum.setText("");
                txtNamaBar.setText("");
                txtNamaKar.setText("");
                txtTotBay.setText("");
        }else{
                JOptionPane.showMessageDialog(this, "Transaksi Gagal","status",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btBeliActionPerformed

    private void txtJumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumActionPerformed
        // TODO add your handling code here:
        String jum = txtJum.getText();
        String sat = lblHargaSat.getText();
        int jml = Integer.parseInt(jum);
        int satuan = Integer.parseInt(sat);
        int tot = jml * satuan;
        txtTotBay.setText(""+tot);
    }//GEN-LAST:event_txtJumActionPerformed

    private void comNamaKarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comNamaKarActionPerformed
        // TODO add your handling code here:
        ResultSet rs = null;
        String x = (String)comNamaKar.getSelectedItem();

        
            Karyawan kar = new Karyawan();
            boolean status = false;

            try {
                rs = kar.lihatData(x);
                if (rs.next()) {
                    txtNamaKar.setText(rs.getString(2));

                } else {
                    //JOptionPane.showMessageDialog(this, "View Gagal", "Status", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrameTransaksi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_comNamaKarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack;
    private javax.swing.JButton btBeli;
    private javax.swing.JButton btClear;
    private javax.swing.JComboBox comIdBar;
    private javax.swing.JComboBox comNamaKar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblHargaSat;
    private javax.swing.JTextField txtIdTrans;
    private javax.swing.JTextField txtJum;
    private javax.swing.JTextField txtNamaBar;
    private javax.swing.JTextField txtNamaKar;
    private javax.swing.JTextField txtTotBay;
    // End of variables declaration//GEN-END:variables
}
