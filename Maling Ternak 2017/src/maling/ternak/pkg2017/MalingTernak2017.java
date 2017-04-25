/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maling.ternak.pkg2017;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class MalingTernak2017 extends JFrame {

    public MalingTernak2017() throws FileNotFoundException {
        
        initUI();
    }
    
    private void initUI() throws FileNotFoundException {
        
        //add(new Board());
        add(new MainMenu());
        setResizable(false);
        pack();
        
        setTitle("M A L I N G   T E R N A K    2 0 1 7");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MalingTernak2017 ex = null;
                try {
                    ex = new MalingTernak2017();
                } catch (FileNotFoundException ex1) {
                    Logger.getLogger(MalingTernak2017.class.getName()).log(Level.SEVERE, null, ex1);
                }
                ex.setVisible(true);
            }
        });
    }
}
