/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sejahterahoutfit;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;
import java.awt.*;
/**
 *
 * @author Hp
 */
public class produk extends javax.swing.JFrame {
    DefaultTableModel tabModel;
    ResultSet RsProduk=null;
    /**
     * Creates new form produk
     */
    public produk() {
        initComponents();
        
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize=this.getSize();
        if(frameSize.height > screenSize.height){
        frameSize.height=screenSize.height;
        }
        if(frameSize.width > screenSize.width){
        frameSize.width=screenSize.width;
        }
        this.setLocation((screenSize.width - frameSize.width) / 2,
        (screenSize.height = screenSize.height) / 20); 
        
        //fungsi Tampil data dan set edit off dijalankan saat aplikasi di run
        tampilData();
        SetEditOff();
    }
    
    //fungsi untuk menampilkan data produk ke dalam tabel
    private void tampilData(){
        try{
            Object[] judul_kolom = {"Kode Barang", "Nama Barang", "Satuan", "Harga", "Stok", "Create Date"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            TabelProduk.setModel(tabModel);
            
            Connection conn=(Connection)koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsProduk=stt.executeQuery("SELECT * from produk ");  
            while(RsProduk.next()){
                Object[] data={
                    RsProduk.getString("KodeProduk"),
                    RsProduk.getString("NamaProduk"),
                    RsProduk.getString("Satuan"),
                    RsProduk.getString("Harga"),
                    RsProduk.getString("Stok"),
                    RsProduk.getString("CreateDate")         
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
        // disable button
        jButtonSave.setEnabled(false);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        jButtonCancel.setEnabled(false);
    }
   
    //menampilkan data ke form saat data pada tabel di klik 
   void tblKeForm(){
        jTextKodeProduk.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),0)+"");
        jTextNama.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),1)+"");
        jComboBoxSatuan.setSelectedItem(tabModel.getValueAt(TabelProduk.getSelectedRow(),2)+"");
        jTextHarga.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),3)+"");
        jTextStok.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),4)+"");
        
        jButtonUpdate.setEnabled(true);
        jButtonDelete.setEnabled(true);
        jButtonCancel.setEnabled(true);
        jButtonSave.setEnabled(false);
    }
   
   //membersihkan form
   private void BersihData(){
        jTextKodeProduk.setText("");
        jTextNama.setText("");
        jComboBoxSatuan.setSelectedIndex(0);
        jTextHarga.setText(""); 
        jTextStok.setText("");
    } 
   
   //disable form
   private void SetEditOff(){
        jTextKodeProduk.setEnabled(false);
        jTextNama.setEnabled(false);
        jComboBoxSatuan.setEnabled(false);
        jTextHarga.setEnabled(false);
        jTextStok.setEnabled(false);
   }
   
   
   private void seteditOn(){
        jTextKodeProduk.setEnabled(true);
        jTextNama.setEnabled(true);
        jComboBoxSatuan.setEnabled(true);
        jTextHarga.setEnabled(true);
        jTextStok.setEnabled(true);
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelHeader = new javax.swing.JLabel();
        jLabelKodeProduk = new javax.swing.JLabel();
        jTextKodeProduk = new javax.swing.JTextField();
        jLabelNama = new javax.swing.JLabel();
        jTextNama = new javax.swing.JTextField();
        jLabelSatuan = new javax.swing.JLabel();
        jComboBoxSatuan = new javax.swing.JComboBox();
        jLabelHarga = new javax.swing.JLabel();
        jTextHarga = new javax.swing.JTextField();
        jLabelStok = new javax.swing.JLabel();
        jTextStok = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelProduk = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelHeader.setBackground(new java.awt.Color(0, 0, 51));
        jLabelHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelHeader.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHeader.setText("SEJAHTERAH OUTFIT");
        jLabelHeader.setOpaque(true);

        jLabelKodeProduk.setText("Kode Produk");

        jTextKodeProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextKodeProdukActionPerformed(evt);
            }
        });

        jLabelNama.setText("Nama");

        jTextNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNamaActionPerformed(evt);
            }
        });

        jLabelSatuan.setText("Satuan");

        jComboBoxSatuan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pcs", "Dus", "Kg" }));

        jLabelHarga.setText("Harga");

        jTextHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextHargaActionPerformed(evt);
            }
        });

        jLabelStok.setText("Stok");

        jButtonAdd.setText("AddNew");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update");
        jButtonUpdate.setMaximumSize(new java.awt.Dimension(57, 23));
        jButtonUpdate.setMinimumSize(new java.awt.Dimension(57, 23));
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.setMaximumSize(new java.awt.Dimension(73, 23));
        jButtonDelete.setMinimumSize(new java.awt.Dimension(73, 23));
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        TabelProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabelProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelProdukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelProduk);

        jLabel1.setBackground(new java.awt.Color(0, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("NAMA : ABID TAUHID ISLAMUDDIN");

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("STAMBUK : 13020150070");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNama)
                            .addComponent(jLabelSatuan)
                            .addComponent(jLabelStok)
                            .addComponent(jLabelKodeProduk))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextStok, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextKodeProduk, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextNama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))))
                    .addComponent(jLabelHarga))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAdd)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSave)
                            .addComponent(jLabelKodeProduk)
                            .addComponent(jTextKodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNama)))))
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButtonCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSatuan)
                            .addComponent(jComboBoxSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelHarga)
                            .addComponent(jTextHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelStok)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //menangani proses saat button add di klik
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        BersihData();
        jTextKodeProduk.requestFocus();
        jButtonSave.setEnabled(true);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        seteditOn();
    }//GEN-LAST:event_jButtonAddActionPerformed

    //menangani proses saat button save di klik
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
        String KodeProduk=jTextKodeProduk.getText();
        String NamaProduk=jTextNama.getText();
        String Satuan=jComboBoxSatuan.getSelectedItem().toString();
        String Harga=jTextHarga.getText();
        String Stok=jTextStok.getText();

        java.util.Date tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String CreateDate=TanggalFormat.format(tanggal);

        if (KodeProduk.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Kode produk tidak boleh kosong");
            jTextKodeProduk.requestFocus();
        }else if (NamaProduk.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Nama produk tidak boleh kosong");
            jTextNama.requestFocus();
        }else if (Satuan.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Satuan produk tidak boleh kosong");
            jComboBoxSatuan.requestFocus();
        }else if (Harga.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Harga produk tidak boleh kosong");
            jTextHarga.requestFocus();
        }else if (Stok.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Stok produk tidak boleh kosong");
            jTextStok.requestFocus();
        }
        else if (!(new Scanner(Harga).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Harga produk harus angka");
            jTextHarga.requestFocus();
        }else if (!(new Scanner(Stok).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Stok produk harus angka");
            jTextStok.requestFocus();
        }else{
            try{
                Connection conn=(Connection)koneksi.koneksiDB();
                Statement stt=conn.createStatement();
                stt.executeUpdate("insert into produk(KodeProduk,NamaProduk,Satuan,Harga,Stok,CreateDate)"+
                    "VALUES('"+KodeProduk+"','"+NamaProduk+"','"+Satuan+"','"+Harga+"','"+Stok+"','"+CreateDate+"')");
                BersihData();
                tampilData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButtonSaveActionPerformed

    //menangani proses saat button Update di klik
    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        String KodeProduk=jTextKodeProduk.getText();
        String NamaProduk=jTextNama.getText();
        String Satuan=jComboBoxSatuan.getSelectedItem().toString();
        String Harga=jTextHarga.getText();
        String Stok=jTextStok.getText();

        java.util.Date tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String CreateDate=TanggalFormat.format(tanggal);

        if (KodeProduk.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Kode produk tidak boleh kosong");
            jTextKodeProduk.requestFocus();
        }else if (NamaProduk.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Nama produk tidak boleh kosong");
            jTextNama.requestFocus();
        }else if (Satuan.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Satuan produk tidak boleh kosong");
            jComboBoxSatuan.requestFocus();
        }else if (Harga.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Harga produk tidak boleh kosong");
            jTextHarga.requestFocus();
        }else if (Stok.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Stok produk tidak boleh kosong");
            jTextStok.requestFocus();
        }
        else if (!(new Scanner(Harga).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Harga produk harus angka");
            jTextHarga.requestFocus();
        }else if (!(new Scanner(Stok).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Stok produk harus angka");
            jTextStok.requestFocus();
        }else{
            try{
                Connection conn=(Connection)koneksi.koneksiDB();
                Statement stt=conn.createStatement();
                stt.executeUpdate("UPDATE produk SET NamaProduk='"+NamaProduk+"', Satuan='"+Satuan+"', Harga='"+Harga+"',"+
                    "Stok='"+Stok+"' WHERE KodeProduk='"+KodeProduk+"'");
                BersihData();
                tampilData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil diubah","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Ubah data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButtonUpdateActionPerformed

    //menangani proses saat button delete di klik
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        String KodeProduk=jTextKodeProduk.getText();

        if (KodeProduk.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Kode produk tidak boleh kosong");
            jTextKodeProduk.requestFocus();
        }else if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan menghapus data ini?",
            "Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
        try{
            Connection conn=(Connection)koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            stt.executeUpdate("DELETE FROM produk WHERE KodeProduk='"+KodeProduk+"'");
            BersihData();
            tampilData();
            SetEditOff();
            JOptionPane.showMessageDialog(this,"Data berhasil di hapus","Success",JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Delete data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    //menangani proses saat button cancel di klik
    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        BersihData();
        jButtonSave.setEnabled(false);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        SetEditOff();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    //menangani proses saat tabel produk di klik
    private void TabelProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelProdukMouseClicked
        // TODO add your handling code here:
        seteditOn();
        jTextKodeProduk.setEnabled(false);
        tblKeForm();
    }//GEN-LAST:event_TabelProdukMouseClicked

    private void jTextKodeProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextKodeProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextKodeProdukActionPerformed

    private void jTextNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNamaActionPerformed

    private void jTextHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextHargaActionPerformed

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
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new produk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelProduk;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox jComboBoxSatuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelHarga;
    private javax.swing.JLabel jLabelHeader;
    private javax.swing.JLabel jLabelKodeProduk;
    private javax.swing.JLabel jLabelNama;
    private javax.swing.JLabel jLabelSatuan;
    private javax.swing.JLabel jLabelStok;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextHarga;
    private javax.swing.JTextField jTextKodeProduk;
    private javax.swing.JTextField jTextNama;
    private javax.swing.JTextField jTextStok;
    // End of variables declaration//GEN-END:variables
}
