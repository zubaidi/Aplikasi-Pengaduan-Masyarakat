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
public class PengaduanKontrol extends KoneksiDB{

    public PengaduanKontrol() {
        super.setKoneksi();
    }
    
    public void simpanPengaduan(int IDPengaduan, String tanggal, String nik, String isi, String foto) throws SQLException{
        String sql = "INSERT INTO `tbpengaduan`(`id_pengaduan`, `tgl_pengaduan`, `nik`, `isi_laporan`, `foto`, `status`) VALUES "
                + "('"+IDPengaduan+"','"+tanggal+"','"+nik+"','"+isi+"','"+foto+"','proses')";
        st.executeUpdate(sql);
    }
    
    public void updatePengaduan(int IDPengaduan, String isi, String foto) throws SQLException{
        String sql = "UPDATE tbpengaduan SET isi_laporan='"+isi+"', foto='"+foto+"' WHERE id_pengaduan ='"+IDPengaduan+"'";
        st.executeUpdate(sql);
    }
    
    public void hapusPengaduan(int IDPengaduan) throws SQLException{
        String sql = "DELETE FROM `tbpengaduan` WHERE `id_pengaduan`='"+IDPengaduan+"'";
        st.executeUpdate(sql);
    }
    
    public void tampilLaporanProses(DefaultTableModel model, String nik) throws SQLException{
        String sql = "SELECT * FROM `tbpengaduan` WHERE `status`='Proses' and nik='"+nik+"'";
        rs = st.executeQuery(sql);
        int no = 1;
        Object data[] = new Object[4];
        while(rs.next()){
            data[0] = no++;
            data[1] = rs.getString("nik");
            data[2] = rs.getString("id_pengaduan");
            data[3] = rs.getString("tgl_pengaduan");
            model.addRow(data);
        }
    }
    
    public void tampilLaporanSelesai(DefaultTableModel model, String nik) throws SQLException{
        String sql = "SELECT * FROM `tbpengaduan` WHERE `status`='Selesai' AND nik = '"+nik+"'";
        rs = st.executeQuery(sql);
        int no = 1;
        Object data[] = new Object[5];
        while(rs.next()){
            data[0] = no++;
            data[1] = rs.getString("nik");
            data[2] = rs.getString("id_pengaduan");
            data[3] = rs.getString("tgl_pengaduan");
            data[4] = rs.getString("foto");
            model.addRow(data);
        }
    }
    
    public void tampilLaporanSelesai(DefaultTableModel model) throws SQLException{
        String sql = "SELECT * FROM `tbpengaduan` WHERE `status`='Selesai'";
        rs = st.executeQuery(sql);
        int no = 1;
        Object data[] = new Object[5];
        while(rs.next()){
            data[0] = no++;
            data[1] = rs.getString("nik");
            data[2] = rs.getString("id_pengaduan");
            data[3] = rs.getString("tgl_pengaduan");
            data[4] = rs.getString("foto");
            model.addRow(data);
        }
    }
    
//    tampil data pada beranda
    public void tampilLaporanDitanggapi(DefaultTableModel model) throws SQLException{
        String sql = "SELECT tbtanggapan.id_tanggapan AS idTanggapan, tbpengaduan.id_pengaduan AS idPengaduan, tbmasyarakat.nama AS nama, tbpengaduan.tgl_pengaduan AS tanggal, tbpengaduan.isi_laporan AS isi, "
                + "tbpengaduan.foto AS foto, tbtanggapan.tanggapan AS tanggapan "
                + "FROM tbmasyarakat, tbpengaduan, tbtanggapan "
                + "WHERE tbmasyarakat.nik = tbpengaduan.nik and tbpengaduan.id_pengaduan = tbtanggapan.id_pengaduan ORDER BY id_tanggapan LIMIT 0,5";
        rs = st.executeQuery(sql);
        Object data[] = new Object[6];
        int no = 1;
        while(rs.next()){
            data[0] = no++;
            data[1] = rs.getString("idTanggapan");
            data[2] = rs.getString("idPengaduan");
            data[3] = rs.getString("nama");
            data[4] = rs.getString("tanggal");
            data[5] = rs.getString("foto");
            model.addRow(data);
        }
    }
    
    public void tampilLaporanDitanggapiPetugas(DefaultTableModel model) throws SQLException{
        String sql = "SELECT tbtanggapan.id_tanggapan AS idTanggapan, tbpengaduan.id_pengaduan AS idPengaduan, tbmasyarakat.nama AS nama, tbpengaduan.tgl_pengaduan AS tanggal, tbpengaduan.isi_laporan AS isi, "
                + "tbpengaduan.foto AS foto, tbtanggapan.tanggapan AS tanggapan "
                + "FROM tbmasyarakat, tbpengaduan, tbtanggapan "
                + "WHERE tbmasyarakat.nik = tbpengaduan.nik and tbpengaduan.id_pengaduan = tbtanggapan.id_pengaduan";
        rs = st.executeQuery(sql);
        Object data[] = new Object[6];
        int no = 1;
        while(rs.next()){
            data[0] = no++;
            data[1] = rs.getString("idTanggapan");
            data[2] = rs.getString("idPengaduan");
            data[3] = rs.getString("nama");
            data[4] = rs.getString("tanggal");
            data[5] = rs.getString("foto");
            model.addRow(data);
        }
    }
    
    public ResultSet isiLaporanPengaduan(String id) throws SQLException{
        String sql = "SELECT tbtanggapan.id_tanggapan AS idTanggapan, tbpengaduan.id_pengaduan AS idPengaduan, tbmasyarakat.nama AS nama, tbpengaduan.tgl_pengaduan AS tanggal, tbpengaduan.isi_laporan AS isi, "
                + "tbpengaduan.foto AS foto, tbtanggapan.tanggapan AS tanggapan "
                + "FROM tbmasyarakat, tbpengaduan, tbtanggapan "
                + "WHERE tbmasyarakat.nik = tbpengaduan.nik and tbpengaduan.id_pengaduan = tbtanggapan.id_pengaduan AND"
                + " tbtanggapan.id_tanggapan = '"+id+"'";
        return rs = st.executeQuery(sql);
    }
    
    public ResultSet setLaporan(String idLaporan) throws SQLException{
        String sql = "SELECT * FROM tbpengaduan WHERE `id_pengaduan`='"+idLaporan+"'";
        return rs = st.executeQuery(sql);
    }
    
    public ResultSet setAutoID() throws SQLException{
        String sql = "SELECT MAX(RIGHT(`id_pengaduan`,4)) AS ID FROM `tbpengaduan`";
        return rs = st.executeQuery(sql);
    }
    
    public ResultSet setLaporanProses(String nik) throws SQLException{
        String sql = "SELECT count(`id_pengaduan`) AS jumProses FROM `tbpengaduan` WHERE `nik`='"+nik+"' AND `status`='Proses'";
        return rs = st.executeQuery(sql);
    }
    
    public ResultSet setLaporanSukses(String nik) throws SQLException{
        String sql = "SELECT count(`id_pengaduan`) AS jumProses FROM `tbpengaduan` WHERE `nik`='"+nik+"' AND `status`='Selesai'";
        return rs = st.executeQuery(sql);
    }
    
}
