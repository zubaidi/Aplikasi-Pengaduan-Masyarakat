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
 * @author GURU RPL
 */
public class TanggapiLaporanKontrol extends KoneksiDB{

    public TanggapiLaporanKontrol() {
        super.setKoneksi();
    }
    
    public void tampilLaporan(DefaultTableModel dtm) throws SQLException{
        String sql = "SELECT tbmasyarakat.nik AS nik, tbmasyarakat.nama AS nama, tbpengaduan.id_pengaduan AS IDP, "
                + "tbpengaduan.isi_laporan AS isi, tbpengaduan.tgl_pengaduan AS tgl, tbpengaduan.foto AS foto "
                + "FROM tbmasyarakat, tbpengaduan WHERE tbpengaduan.nik = tbmasyarakat.nik AND tbpengaduan.status = 'Proses'";
        rs = st.executeQuery(sql);
        Object data[] = new Object[5];
        int no = 1;
        while(rs.next()){
            data[0] = no++;
            data[1] = rs.getString("IDP");
            data[2] = rs.getString("nik");
            data[3] = rs.getString("nama");
            data[4] = rs.getString("tgl");
            dtm.addRow(data);
        }
    }
    
    public ResultSet setLaporan(String idLaporan) throws SQLException{
        String sql = "SELECT * FROM tbpengaduan WHERE `id_pengaduan`='"+idLaporan+"'";
        return rs = st.executeQuery(sql);
    }
    
    public void simpanTanggapan(int idTanggapan, int idPengaduan, String tanggal, String tanggapan, int idPetugas) throws SQLException{
        String sql = "INSERT INTO tbtanggapan VALUES('"+idTanggapan+"', '"+idPengaduan+"', '"+tanggal+"', '"+tanggapan+"', '"+idPetugas+"')";
        st.executeUpdate(sql);
    }
    
    public void updatestatus(int idpengaduan) throws SQLException{
        String sql = "UPDATE tbpengaduan set status = 'selesai' where id_pengaduan='"+idpengaduan+"' ";
        st.executeUpdate(sql);
    }
    
//    drunng kanggo
    public void updateTanggapan(int idTanggapan, int idPengaduan, String tanggal, String tanggapan, int idPetugas) throws SQLException{
        String sql = "UPDATE tbtanggapan SET "
                + "id_pengaduan = '"+idPengaduan+"', tgl_tanggapan = '"+tanggal+"', "
                + "tanggapan = '"+tanggapan+"', id_petugas = '"+idPetugas+"' "
                + " WHERE id_tanggapan = '"+idTanggapan+"'";
        st.executeUpdate(sql);
    }
    
    public void hapusTanggapan(int idTanggapan) throws SQLException{
        String sql = "DELETE FROM tbtanggapan WHERE id_tanggapan = '"+idTanggapan+"'";
        st.executeUpdate(sql);
    }
    
    public void tampilTanggapan(DefaultTableModel dtm) throws SQLException{
        String sql = "SELECT tbtanggapan.id_tanggapan AS idTanggapan, "
                + "tbtanggapan.id_pengaduan AS idPengaduan "
                + "FROM tbpengaduan, tbtanggapan ORDER BY id_tanggapan ASC LIMIT 0,5";
        rs = st.executeQuery(sql);
        Object data[] = new Object[3];
        int no = 1;
        while(rs.next()){
            data[0] = no++;
            data[1] = rs.getInt("idTanggapan");
            data[2] = rs.getInt("idPengaduan");
            dtm.addRow(data);
        }
    }
    
    public void tampilTanggapanPetugas(DefaultTableModel dtm) throws SQLException{
        String sql = "SELECT tbtanggapan.id_tanggapan AS idTanggapan, "
                + "tbtanggapan.id_pengaduan AS idPengaduan "
                + "FROM tbpengaduan, tbtanggapan ORDER BY id_tanggapan ASC";
        rs = st.executeQuery(sql);
        Object data[] = new Object[3];
        int no = 1;
        while(rs.next()){
            data[0] = no++;
            data[1] = rs.getInt("idTanggapan");
            data[2] = rs.getInt("idPengaduan");
            dtm.addRow(data);
        }
    }
}
