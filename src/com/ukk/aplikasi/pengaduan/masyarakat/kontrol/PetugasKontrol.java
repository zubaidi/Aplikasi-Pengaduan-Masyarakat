/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ukk.aplikasi.pengaduan.masyarakat.kontrol;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zubaidi
 */
public class PetugasKontrol extends KoneksiDB{

    public PetugasKontrol() {
        super.setKoneksi();
    }
    
    public void simpanDataPetugas(int idPetugas, String nama, String username, String pass, String telp) throws SQLException{
        String sql = "INSERT INTO `tbpetugas`(`id_petugas`, `nama_petugas`, `username`, `password`, `telp`, `level`) VALUES "
                + "('"+idPetugas+"','"+nama+"','"+username+"','"+pass+"','"+telp+"','petugas')";
        st.executeUpdate(sql);
    }
    
    public void updateDataPetugas(int idPetugas, String nama, String username, String pass, String telp) throws SQLException{
        String sql = "UPDATE `tbpetugas` SET `nama_petugas`='"+nama+"',`username`='"+username+"',`password`='"+pass+"',"
                + "`telp`='"+telp+"' WHERE `id_petugas`='"+idPetugas+"'";
        st.executeUpdate(sql);
    }
    
    public void hapusDataPetugas(int idPetugas) throws SQLException{
        String sql = "DELETE FROM `tbpetugas` WHERE `id_petugas`='"+idPetugas+"'";
        st.executeUpdate(sql);
    }
    
    public void tampilDataPetugas(DefaultTableModel dtm) throws SQLException{
        String sql = "SELECT `id_petugas`, `nama_petugas`, `username`, `password`, `telp`, `level` FROM `tbpetugas`";
        rs = st.executeQuery(sql);
        Object data[] = new Object[6];
        int no = 1;
        while(rs.next()){
            data[0] = no++;
            data[1] = rs.getInt("`id_petugas`");
            data[2] = rs.getString("`nama_petugas`");
            data[3] = rs.getString("username");
            data[4] = rs.getString("password");
            data[5] = rs.getString("telp");
            data[5] = rs.getString("level");
            dtm.addRow(data);
        }
    }
    
    public void cariDataPetugas(DefaultTableModel dtm, String cari) throws SQLException{
        String sql = "SELECT `id_petugas`, `nama_petugas`, `username`, `password`, `telp`, `level` FROM `tbpetugas` WHERE `id_petugas` = '"+cari+"'";
        rs = st.executeQuery(sql);
        Object data[] = new Object[6];
        int no = 1;
        while(rs.next()){
            data[0] = no++;
            data[1] = rs.getInt("`id_petugas`");
            data[2] = rs.getString("`nama_petugas`");
            data[3] = rs.getString("username");
            data[4] = rs.getString("password");
            data[5] = rs.getString("telp");
            data[5] = rs.getString("level");
            dtm.addRow(data);
        }
    }
    
    public ResultSet loginPetugas(String username, String password) throws SQLException{
        String sql = "SELECT * FROM `tbpetugas` WHERE `username` = '"+username+"' AND `password` = '"+password+"'";
        return rs = st.executeQuery(sql);
    }
    
    public ResultSet setPetugas(String id) throws SQLException{
        String sql = "SELECT * FROM `tbpetugas` WHERE `id_petugas` = '"+id+"'";
        return rs = st.executeQuery(sql);
    }
    
    public ResultSet setID(String nik) throws SQLException{
        String sql = "SELECT id_petugas FROM tbpetugas WHERE nik = '"+nik+"'";
        return rs = st.executeQuery(sql);
    }
    
}
