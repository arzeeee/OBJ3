/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maling.ayam.pkg2017;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainMenu extends JPanel implements ActionListener, Runnable {

    private Timer timer;
    private boolean ingame;
    private boolean startgame;
    private int phase;
    private int choice;
    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private final int B_WIDTH = 800;
    private final int B_HEIGHT = 600;
    private final int DELAY = 15;
    
    public MainMenu() {

        initMainMenu();
    }
    
    private void showIntroButton(Graphics gd) {
        gd.setColor(new Color(0, 32, 48));
        gd.fillRect(B_WIDTH - 500, B_HEIGHT - 425, 200, 50);
        gd.setColor(Color.white);
        gd.drawRect(B_WIDTH - 500, B_HEIGHT - 425, 200, 50);

        String s = "Play";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);

        gd.setColor(Color.white);
        gd.setFont(small);
        gd.drawString(s, (B_WIDTH - metr.stringWidth(s)) / 2, B_HEIGHT - 395); 
    }
    
    private void showHighScoreButton(Graphics gd) {
        gd.setColor(new Color(0, 32, 48));
        gd.fillRect(B_WIDTH - 500, B_HEIGHT - 275, 200, 50);
        gd.setColor(Color.white);
        gd.drawRect(B_WIDTH - 500, B_HEIGHT - 275, 200, 50);

        String s = "HighScore";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);

        gd.setColor(Color.white);
        gd.setFont(small);
        gd.drawString(s, (B_WIDTH - metr.stringWidth(s)) / 2, B_HEIGHT - 245); 
    }
    
    private void showCreditsButton(Graphics gd) {
        gd.setColor(new Color(0, 32, 48));
        gd.fillRect(B_WIDTH - 500, B_HEIGHT - 350, 200, 50);
        gd.setColor(Color.white);
        gd.drawRect(B_WIDTH - 500, B_HEIGHT - 350, 200, 50);

        String s = "Credits";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);

        gd.setColor(Color.white);
        gd.setFont(small);
        gd.drawString(s, (B_WIDTH - metr.stringWidth(s)) / 2, B_HEIGHT - 320); 
    }
    
    private void showInstructionButton(Graphics gd) {
        gd.setColor(new Color(0, 32, 48));
        gd.fillRect(B_WIDTH - 500, B_HEIGHT - 200, 200, 50);
        gd.setColor(Color.white);
        gd.drawRect(B_WIDTH - 500, B_HEIGHT - 200, 200, 50);

        String s = "Instruction";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);

        gd.setColor(Color.white);
        gd.setFont(small);
        gd.drawString(s, (B_WIDTH - metr.stringWidth(s)) / 2, B_HEIGHT - 170); 
    }

    private void initMainMenu() {
        //setLayout(null);
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.black);
        ingame = true;
        phase = 0;
        choice = 0;
        startgame = false;        
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        timer = new Timer(DELAY, this);
        timer.start();
    }
   
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (ingame) {
            if (startgame) {
                
            } else {
                if (phase == 0) {
                    drawIntro(g);
                    drawChoice(g);
                } else if (phase == 1) {
                    drawCredits(g);
                } else if (phase == 2) {
                    drawHighScore(g);
                } else if (phase == 3){
                    drawInstruction(g);
                }
            }
        } else {
            Board panel;
            add(panel = new Board());
            panel.setBounds(0,0,B_WIDTH,B_HEIGHT);
            panel.addKeyListener(panel.TAdapter);
            panel.setFocusable(true);
            setFocusable(false);
        } 
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawIntro(Graphics g) {        
        showIntroButton(g);
        showHighScoreButton(g);
        showCreditsButton(g);
        showInstructionButton(g);
    }
    
    private void drawChoice(Graphics gd) {
        int height = 0;
        gd.setColor(Color.blue);
        switch (choice) {
            case 0:
                height = 425;
                break;
            case 1:
                height = 350;
                break;
            case 2:
                height = 275;
                break;
            case 3 :
                height = 200;
                break;
            default:
                height = 425;
        }
        gd.setColor(Color.blue);
        gd.drawRect(B_WIDTH - 500, B_HEIGHT - height, 200, 50);
    }
        
    private void drawCredits(Graphics g) {

        int ii;
        String msg = "Credits";
        Font med = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics fm = getFontMetrics(med);

        g.setColor(Color.white);
        g.setFont(med);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2 - 50);
        
        String [] person = new String[4];
        person[0] = "Mahdiar Naufal - 13515022";
        person[1] = "Rizky Faramita - 13515050";
        person[2] = "Aya Aurora Rimbamorani - 13515098";
        person[3] = "Aulia Ichsan Rifkyano - 13515100";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics pfm = getFontMetrics(small);
        
        for (ii = 0 ; ii < person.length; ii++) {
            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(person[ii], (B_WIDTH - pfm.stringWidth(person[ii])) / 2,
                B_HEIGHT / 2 - 30 + 14*ii);
        }
    }
    
    private void drawHighScore(Graphics g) {

        String msg = "HighScore";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
    }
    
    private void drawInstruction(Graphics g) {

        int ii;
        String msg = "Instruction";
        Font med = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics fm = getFontMetrics(med);

        g.setColor(Color.white);
        g.setFont(med);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2 - 50);
        
        String [] ins = new String[8];
        ins[0] = "(Enter) Game Play";
        ins[1] = "(BackSpace) Back";
        ins[2] = "(S) Show HighScore";
        ins[3] = "(C) Show Credits";
        ins[4] = "(Up) Move up";
        ins[5] = "(Down) Move down";
        ins[6] = "(Left) Move left";
        ins[7] = "(Right) Move right";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics pfm = getFontMetrics(small);
        
        for (ii = 0 ; ii < ins.length; ii++) {
            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(ins[ii], (B_WIDTH - pfm.stringWidth(ins[ii])) / 2,
                B_HEIGHT / 2 - 30 + 14*ii);
        }
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        inGame();
        repaint();
    }

    private void inGame() {        
        if (!ingame) {
            timer.stop();
        }
    }
        
    @Override
    public void addNotify() {
        super.addNotify();        
    }
    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();
        while (true) {
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }
            beforeTime = System.currentTimeMillis();
        }
    }

    private class TAdapter extends KeyAdapter{        
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_ENTER:
                    if (phase == 0) {
                    switch (choice) {
                        case 0:
                            //startgame = true;
                            ingame=false;
                            break;
                        case 1:
                            phase = 1;
                            break;
                        case 2:
                            phase = 2;
                            break;
                        case 3:
                            phase = 3;
                            break;
                        default:
                            break;
                        }
                    }
                    break;
                case KeyEvent.VK_BACK_SPACE:
                    phase = 0;
                    choice = 0;
                    break;
                case KeyEvent.VK_Q:
                    if (phase == 0) {
                        phase = 3;
                    }   break;
                case KeyEvent.VK_UP :
                    if (phase==0) choice--;
                    if (choice<0) choice=3;
                    break;
                case KeyEvent.VK_DOWN :
                    if (phase==0) choice++;
                    if (choice>3) choice = 0;
                    break;
                default:
                    break;
            }
        }
    };
}