/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ukk.aplikasi.pengaduan.masyarakat.form;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JDesktopPane;

/**
 *
 * @author zubaidi
 */
public class DesktopPaneBackground extends JDesktopPane{
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(204,204,204));
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
