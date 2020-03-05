/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ukk.aplikasi.pengaduan.masyarakat.kontrol;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author zubaidi
 */
public class KoneksiDB {
    
    Connection koneksi = null;
    Statement st;
    ResultSet rs;
    
    public KoneksiDB() {
    }
    
    public void setKoneksi(){
        try {
            Properties prop = new Properties();
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            String url = "jdbc:mysql://"+prop.getProperty("HOST")+":"+prop.getProperty("PORT")+"/"+prop.getProperty("DATABASE");
            String user = prop.getProperty("USERNAME");
            String password = prop.getProperty("PASSWORD");
            String className = "com.mysql.jdbc.Driver";
            Class.forName(className);
            koneksi = DriverManager.getConnection(url, user, password);
            st = koneksi.createStatement();
            System.out.println("Koneksi Oke");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error "+ex);
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error "+ex);
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        KoneksiDB dB = new KoneksiDB();
        dB.setKoneksi();
    }
    
}
