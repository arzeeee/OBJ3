/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maling.ayam.pkg2017;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class MalingAyam2017 extends JFrame {

    public MalingAyam2017() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        //add(new MainMenu());
        setResizable(false);
        pack();
        
        setTitle("MALING AYAM 2017");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MalingAyam2017 ex = new MalingAyam2017();
                ex.setVisible(true);
            }
        });
    }
}