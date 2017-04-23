/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maling.ayam.pkg2017;

import playerController.PlayerController;
import keeperController.KeeperController;
import chickenController.ChickenController;
import keeper.Keeper;
import chicken.Chicken;
import player.Player;
import chickenView.ChickenView;
import keeperView.KeeperView;
import playerView.PlayerView;
import wall.Wall;
import wallView.WallView;
import wallController.WallController;
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

public class Board extends JPanel implements ActionListener, Runnable {

    private Timer timer;
    private PlayerController craft;
    private ArrayList<KeeperController> keepers;
    private ArrayList<ChickenController> chickens;
    private ArrayList<WallController> walls;
    private boolean ingame;
    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private final int B_WIDTH = 800;
    private final int B_HEIGHT = 600;
    private final int DELAY = 15;
    private Thread animator;
    private int time = 300;
    private Image tile;
    private int tileWidth;
    private int tileHeight;
    
    private final int[][] initPosKeeper = {
        {820, 128}
    };

    private final int[][] initPosChicken = {
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
    
    private final int[][] initPosWall = {
        {400,300}  
    };
    
    public Board() {
        initBoard();
    }

    private void initBoard() {   
        ImageIcon ii = new ImageIcon("tile.png");
        tile = ii.getImage();
        tileWidth = tile.getWidth(null);
        tileHeight = tile.getHeight(null);
        new Thread(new Runnable() {
        public void run() {
            while (true) {
            try {
                java.lang.Thread.sleep(1000);
                time--;
            }
            catch(Exception e) { }
            }
        }
        }).start();
        
        Player model = new Player(ICRAFT_X, ICRAFT_Y);
        PlayerView view = new PlayerView();
        addKeyListener(TAdapter);
        setFocusable(true);
        setBackground(Color.BLACK);
        ingame = true;

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        craft = new PlayerController(model, view);

        initKeepers();
        initChickens();
        initWalls();
        
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void initKeepers() {
        keepers = new ArrayList<>();
        for (int[] p : initPosKeeper) {
            Keeper model = new Keeper(p[0], p[1]);
            KeeperView view = new KeeperView();
            keepers.add(new KeeperController(model,view));
        }
    }

    public void moveKeeper() {
        for (int i = 0; i < keepers.size(); i++) {
            KeeperController keeper = keepers.get(i);
            keeper.move(craft);
        }        
    }
        
    public void initChickens() {
        chickens = new ArrayList<>();
        for (int[] p : initPosChicken) {
            Chicken model = new Chicken(p[0], p[1]);
            ChickenView view = new ChickenView();
            chickens.add(new ChickenController(model,view));
        }
    }

    public void moveChicken() {        
        for (int i = 0; i < chickens.size(); i++) {
            ChickenController chicken = chickens.get(i);
            chicken.move();
        }
    }  
    
    public void initWalls() {
        walls = new ArrayList<>();
        for (int[] p : initPosWall){
            Wall model = new Wall(p[0], p[1]);
            WallView view = new WallView();
            walls.add(new WallController(model,view));
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        if (ingame) {
            for (int y = 0; y < B_HEIGHT; y += tileHeight) {
                for (int x = 0; x < B_WIDTH; x += tileWidth) {
                    g2d.drawImage(tile, x, y, this);
                }
            }
            g2d.dispose();
            drawObjects(g);
        } else {
            drawGameOver(g);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g) {
        if (craft.isVisiblePlayer()) {            
            g.drawImage(craft.getImagePlayer(), craft.getXPlayer(), craft.getYPlayer(),
                    this);            
        }
        for (KeeperController keeper : keepers) {
            if (keeper.isVisible()) {
                g.drawImage(keeper.getImage(), keeper.getXModel(), keeper.getYModel(), this);
            }
        }
        for (ChickenController chicken : chickens) {
            if (chicken.isVisible()) {
                g.drawImage(chicken.getImage(), chicken.getXModel(), chicken.getYModel(), this);
            }
        }    
        for (WallController wall : walls) {
            if (wall.isVisible()) {
                g.drawImage(wall.getImage(), wall.getXModel(), wall.getYModel(), this);
            }
        }    
        g.setColor(Color.WHITE);
        g.drawString("Time: " + time + "s", 5, 15);
        g.drawString("Score: " + craft.getScorePlayer(), 100, 15);
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
        updateTime();
        updateCraft();
        updateKeepers();
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
        if (craft.isVisiblePlayer()) {
            craft.move();
        }
    }

    private void updateKeepers() {
        if (keepers.isEmpty()) {
            ingame = false;
            return;
        }
        for (int i = 0; i < keepers.size(); i++) {
            KeeperController keeper = keepers.get(i);
            if (keeper.isVisible()) {
                moveKeeper();
            } else {
                keepers.remove(i);
            }
        }
    }

    private void updateChickens() {
        if (chickens.isEmpty()) {
            ingame = false;
            return;
        }
        for (int i = 0; i < chickens.size(); i++) {
            ChickenController chicken = chickens.get(i);
            if (chicken.isVisible()) {
                moveChicken();
            } else {
                chickens.remove(i);
            }
        }
    }
    
    private void updateTime() {
        if (time==0) {
            ingame = false;
            return;
        }
    }
        
    public void checkCollisions() {
        Rectangle r3 = craft.getBoundsPlayer();
        /*for (KeeperController keeper : keepers) {
            Rectangle r2 = keeper.getBounds();
            if (r3.intersects(r2)) {
                craft.setVisiblePlayer(false);
                keeper.setVisible(false);
                ingame = false;
            }
        }        */
        for (ChickenController chicken : chickens) {
            Rectangle r1 = chicken.getBounds();
            if (r3.intersects(r1)) {
                chicken.setVisible(false);
                int score = craft.getScorePlayer() + 5;
                craft.setScorePlayer(score);
            }
        }
        
        for (WallController wall : walls) {
            Rectangle r4 = wall.getBounds();
            if (r3.intersects(r4)) {
                if (craft.getXPlayer() < wall.getXModel()) {
                    craft.setXPlayer(craft.getXPlayer()-3);
                    craft.setDxPlayer(0);
                } else 
                if (craft.getXPlayer() > wall.getXModel()) {
                    craft.setXPlayer(craft.getXPlayer()+3);
                    craft.setDxPlayer(0);
                } else
                if (craft.getYPlayer() < wall.getXModel()) {
                    craft.setYPlayer(craft.getYPlayer()-3);
                    craft.setDyPlayer(0);
                } else
                if (craft.getYPlayer() > wall.getXModel()) {
                    craft.setYPlayer(craft.getYPlayer()+3);
                    craft.setDyPlayer(0);
                }
            }
            
            for (ChickenController chicken : chickens) {
                Rectangle r1 = chicken.getBounds();
                if (r1.intersects(r4)) {
                    if (chicken.getXModel() < wall.getXModel()) {
                        chicken.setXModel(chicken.getXModel()-1);
                    }
                    if (chicken.getXModel() > wall.getXModel()) {
                        chicken.setXModel(chicken.getXModel()+1);
                    }
                    if (chicken.getYModel() < wall.getXModel()) {
                        chicken.setYModel(chicken.getYModel()-1);
                    }
                    if (chicken.getYModel() > wall.getYModel()) {
                        chicken.setYModel(chicken.getYModel()+1);
                    }
                }
            }
            
            for (KeeperController keeper : keepers) {
                Rectangle r2 = keeper.getBounds();
                if (r2.intersects(r4)) {
                    if (keeper.getXModel() < wall.getXModel()) {
                        keeper.setXModel(keeper.getXModel()-3);
                    }
                    if (keeper.getXModel() > wall.getXModel()) {
                        keeper.setXModel(keeper.getXModel()+3);
                    }
                    if (keeper.getYModel() < wall.getXModel()) {
                        keeper.setYModel(keeper.getYModel()-3);
                    }
                    if (keeper.getYModel() > wall.getYModel()) {
                        keeper.setYModel(keeper.getYModel()+3);
                    }
                }
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

    public KeyAdapter TAdapter = new KeyAdapter() {

        @Override
        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    };
}