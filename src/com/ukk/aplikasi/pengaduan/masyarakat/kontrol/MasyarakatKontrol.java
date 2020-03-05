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
public class MasyarakatKontrol extends KoneksiDB{

    public MasyarakatKontrol() {
        super.setKoneksi();
    }
    
    public void simpanDataMasyarakat(String nik, String nama, String username, String pass, String telp) throws SQLException{
        String sql = "INSERT INTO `tbmasyarakat`(`nik`, `nama`, `username`, `password`, `telp`) VALUES ('"+nik+"','"+nama+"','"+username+"','"+pass+"','"+telp+"')";
        st.executeUpdate(sql);
    }
    
    public void updateDataMasyarakat(String nik, String nama, String username, String pass, String telp) throws SQLException{
        String sql = "UPDATE `tbmasyarakat` SET `nama`='"+nama+"',`username`='"+username+"',`password`='"+pass+"',`telp`='"+telp+"' WHERE `nik`='"+nik+"'";
        st.executeUpdate(sql);
    }
    
    public void hapusDataMasyarakat(String nik) throws SQLException{
        String sql = "DELETE FROM tbmasyarakat WHERE nik = '"+nik+"'";
        st.executeUpdate(sql);
    }
    
    public void tampilData(DefaultTableModel dtm) throws SQLException{
        String sql = "SELECT `nik`, `nama`, `username`, `password`, `telp` FROM `tbmasyarakat`";
        rs = st.executeQuery(sql);
        Object data[] = new Object[6];
        int no = 1;
        while(rs.next()){
            data[0] = no++;
            data[1] = rs.getString("nik");
            data[2] = rs.getString("nama");
            data[3] = rs.getString("username");
            data[4] = rs.getString("password");
            data[5] = rs.getString("telp");
            dtm.addRow(data);
        }
    }
    
    public ResultSet tampilData(String nik) throws SQLException{
        String sql = "SELECT `nik`, `nama`, `username`, `password`, `telp` FROM `tbmasyarakat` WHERE `nik` = '"+nik+"'";
        return rs = st.executeQuery(sql);
    }
    
    public void cariDataMasyarakat(DefaultTableModel dtm, String cari) throws SQLException{
        String sql = "SELECT `nik`, `nama`, `username`, `password`, `telp` FROM `tbmasyarakat` WHERE `nik` = '"+cari+"'";
        rs = st.executeQuery(sql);
        Object data[] = new Object[6];
        int no = 1;
        while(rs.next()){
            data[0] = no++;
            data[1] = rs.getString("nik");
            data[2] = rs.getString("nama");
            data[3] = rs.getString("username");
            data[4] = rs.getString("password");
            data[5] = rs.getString("telp");
            dtm.addRow(data);
        }
    }
    
    public ResultSet setLoginMk(String username, String pass) throws SQLException{
        String sql = "SELECT * FROM `tbmasyarakat` WHERE `username` = '"+username+"' AND `password` = '"+pass+"'";
        return rs = st.executeQuery(sql);
    }
    
    public ResultSet setNIK(String nik) throws SQLException{
        String SQL = "SELECT nik FROM tbmasyarakat where nik = '"+nik+"'";
        return rs = st.executeQuery(SQL);
    }
    
}
