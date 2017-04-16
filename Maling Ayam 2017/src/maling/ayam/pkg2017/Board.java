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
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener, Runnable {

    private Timer timer;
    private Player craft;
    private ArrayList<Alien> aliens;
    private ArrayList<Animal> chickens;
    private boolean ingame;
    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private final int B_WIDTH = 800;
    private final int B_HEIGHT = 600;
    private final int DELAY = 15;
    private Thread animator;
    
    private final int[][] initPosAlien = {
        {820, 128}
    };

    private final int[][] initPosAnimal = {
        {2380, 29}, {2500, 59}, {1380, 89},
        {780, 109}, {580, 139}, {680, 239},
        {790, 259}, {760, 50}, {790, 150},
        {980, 209}, {560, 45}, {510, 70},
        {930, 159}, {590, 80}, {530, 60},
        {940, 59}, {990, 30}, {920, 200},
        {900, 259}, {660, 50}, {540, 90},
        {810, 220}, {860, 20}, {740, 180},
        {700, 120}, {760, 20}, {600, 180},
        {200, 100}, {60, 800}, {100, 580}
    };
    
    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        ingame = true;

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        craft = new Player(ICRAFT_X, ICRAFT_Y);

        initAliens();
        initAnimals();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void initAliens() {
        aliens = new ArrayList<>();

        for (int[] p : initPosAlien) {
            aliens.add(new Alien(p[0], p[1]));
        }
    }

    public void moveAlien() {

        for (int i = 0; i < aliens.size(); i++) {

            Alien alien = aliens.get(i);

            //non-random movement to catch player
            int deltaX = Math.abs(alien.getX() - craft.getX());
            int deltaY = Math.abs(alien.getY() - craft.getY());
            if (deltaX == 0) { //absis parallel move closer to ordinat
                if (alien.getY() > craft.getY()) {
                    alien.setY(alien.getY() - 2);//move faster when parallel
                } else {
                    alien.setY(alien.getY() + 2);
                }
            } else if (deltaY == 0) { //ordinat parallel move closer to absis
                if (alien.getX() > craft.getX()) {
                    alien.setX(alien.getX() - 2);
                } else {
                    alien.setX(alien.getX() + 2);
                }            
            } else if (deltaX != 0 && deltaY != 0) {
                //find nearest path to get its absis parallel
                if (alien.getX() > craft.getX()) {
                    alien.setX(alien.getX() - 1);//move slower when not parallel
                } else {
                    alien.setX(alien.getX() + 1);
                }
            }
        }        

    }
        
    public void initAnimals() {
        chickens = new ArrayList<>();

        for (int[] p : initPosAnimal) {
            chickens.add(new Animal(p[0], p[1]));
        }
    }

    public void moveChicken() {
        
        for (int i = 0; i < chickens.size(); i++) {

            Animal chicken = chickens.get(i);
            //generate random movement
            Random rand = new Random();
            int newX = chicken.getX() + (rand.nextInt(3) - 1);
            chicken.setX(newX);
            if (rand.nextInt(3) - 1 == 0) { //absis doesn't change
                int newY = chicken.getY() + (rand.nextInt(3) - 1); //change ordinat
                chicken.setY(newY);
            }
        }
    }  
        
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (ingame) {

            drawObjects(g);

        } else {

            drawGameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g) {

        if (craft.isVisible()) {
            
            g.drawImage(craft.getImage(), craft.getX(), craft.getY(),
                    this);            
        }

        for (Alien alien : aliens) {
            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
            }
        }

        for (Animal chicken : chickens) {
            if (chicken.isVisible()) {
                g.drawImage(chicken.getImage(), chicken.getX(), chicken.getY(), this);
            }
        }
                
        g.setColor(Color.WHITE);
        g.drawString("Direction: " + craft.getDir(), 5, 15);
        g.drawString("Score: " + craft.getScore(), 100, 15);
    }

    private void drawGameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inGame();

        updateCraft();
        updateAliens();
        updateChickens();
        checkCollisions();

        repaint();
    }

    private void inGame() {
        
        if (!ingame) {
            timer.stop();
        }
    }

    private void updateCraft() {

        if (craft.isVisible()) {
            craft.move();
        }
    }

    private void updateAliens() {

        if (aliens.isEmpty()) {

            ingame = false;
            return;
        }

        for (int i = 0; i < aliens.size(); i++) {

            Alien alien = aliens.get(i);
            if (alien.isVisible()) {
                moveAlien();
            } else {
                aliens.remove(i);
            }
        }
    }

    private void updateChickens() {

        if (chickens.isEmpty()) {

            ingame = false;
            return;
        }

        for (int i = 0; i < chickens.size(); i++) {

            Animal chicken = chickens.get(i);
            if (chicken.isVisible()) {
                moveChicken();
            } else {
                chickens.remove(i);
            }
        }
    }
        
    public void checkCollisions() {

        Rectangle r3 = craft.getBounds();

        for (Alien alien : aliens) {
            Rectangle r2 = alien.getBounds();

            if (r3.intersects(r2)) {
                craft.setVisible(false);
                alien.setVisible(false);
                ingame = false;
            }
        }
        
        for (Animal chicken : chickens) {
            Rectangle r1 = chicken.getBounds();

            if (r3.intersects(r1)) {
                chicken.setVisible(false);
                int score = craft.getScore() + 5;
                craft.setScore(score);
            }
        }
    }

    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }

    
    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {
            craft.animate();

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

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }
}