/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maling.ternak.pkg2017;

import playerController.PlayerController;
import keeperController.KeeperController;
import animalController.chickenController.AnimalController;
import dogController.DogController;
import dogView.DogView;
import dog.Dog;
import keeper.Keeper;
import animal.chicken.Animal;
import player.Player;
import animalView.chickenView.AnimalView;
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
    private PlayerController player;
    private ArrayList<KeeperController> keepers;
    private ArrayList<DogController> dogs;
    private ArrayList<AnimalController> chickens;
    private ArrayList<AnimalController> bebeks;
    private ArrayList<AnimalController> angsas;
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
        {790, 500}
    };
    
    private final int[][] initPosDog = {
        {790, 550}, {10, 20}
    };

    private final int[][] initPosChicken = {
        {100, 29}, {200, 59}, {300, 89},
        {780, 109}, {580, 139}, {680, 239},
        {790, 259}, {760, 50}, {790, 150},
        {400, 209}, {560, 45}, {510, 70},
        {400, 159}, {590, 80}, {530, 60},
        {400, 59}, {400, 30}, {400, 200},
        {400, 259}, {660, 50}, {540, 90},
        {100, 220}, {100, 20}, {740, 180},
        {700, 120}, {760, 20}, {600, 180},
        {200, 100}, {60, 800}, {100, 580}
    };

    private final int[][] initPosBebek = {
        {100, 29}, {200, 59}, {300, 89},
        {780, 109}, {580, 139}, {680, 239},
        {790, 259}, {760, 50}, {790, 150},
        {400, 209}, {560, 45}, {510, 70},
        {400, 159}, {590, 80}, {530, 60},
        {400, 59}, {400, 30}, {400, 200},
        {400, 259}, {660, 50}, {540, 90},
        {100, 220}, {100, 20}, {740, 180},
        {700, 120}, {760, 20}, {600, 180},
        {200, 100}, {60, 800}, {100, 580}
    };

    private final int[][] initPosAngsa = {
        {100, 29}, {200, 59}, {300, 89},
        {780, 109}, {580, 139}, {680, 239},
        {790, 259}, {760, 50}, {790, 150},
        {400, 209}, {560, 45}, {510, 70},
        {400, 159}, {590, 80}, {530, 60},
        {400, 59}, {400, 30}, {400, 200},
        {400, 259}, {660, 50}, {540, 90},
        {100, 220}, {100, 20}, {740, 180},
        {700, 120}, {760, 20}, {600, 180},
        {200, 100}, {60, 800}, {100, 580}
    };
            
    private final int[][] initPosWall = {
        {180,100} , {600,100}
    };
    
    public Board() {
        initBoard();
    }

    private void initBoard() {   
        ImageIcon ii = new ImageIcon("./img/tile.png");
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

        player = new PlayerController(model, view);

        initKeepers();
        initDogs();
        initChickens();
        initBebek();
        initAngsa();
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
    
    public void initDogs() {
        dogs = new ArrayList<>();
        for (int[] p : initPosDog) {
            Dog model = new Dog(p[0], p[1]);
            DogView view = new DogView();
            dogs.add(new DogController(model,view));
        }
    }

    public void moveKeeper() {
        for (int i = 0; i < keepers.size(); i++) {
            KeeperController keeper = keepers.get(i);
            keeper.move(player);
        }        
    }
    
    public void moveDog() {
        for (int i = 0; i < dogs.size(); i++) {
            DogController dog = dogs.get(i);
            dog.move();
        }        
    }
        
    public void initChickens() {
        chickens = new ArrayList<>();
        for (int[] p : initPosChicken) {
            Animal model = new Animal(p[0], p[1],1);
            AnimalView view = new AnimalView();
            chickens.add(new AnimalController(model,view));
        }
    }

    public void moveChicken() {        
        for (int i = 0; i < chickens.size(); i++) {
            AnimalController chicken = chickens.get(i);
            chicken.move();
        }
    }  
 
    public void initBebek() {
        bebeks = new ArrayList<>();
        for (int[] p : initPosBebek) {
            Animal model = new Animal(p[0], p[1],2);
            AnimalView view = new AnimalView();
            bebeks.add(new AnimalController(model,view));
        }
    }

    public void moveBebek() {        
        for (int i = 0; i < bebeks.size(); i++) {
            AnimalController bebek = bebeks.get(i);
            bebek.move();
        }
    }  

    public void initAngsa() {
        angsas = new ArrayList<>();
        for (int[] p : initPosAngsa) {
            Animal model = new Animal(p[0], p[1],3);
            AnimalView view = new AnimalView();
            angsas.add(new AnimalController(model,view));
        }
    }

    public void moveAngsa() {        
        for (int i = 0; i < angsas.size(); i++) {
            AnimalController angsa = angsas.get(i);
            angsa.move();
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
        if (player.isVisiblePlayer()) {            
            g.drawImage(player.getImagePlayer(), player.getXPlayer(), player.getYPlayer(),
                    this);            
        }
        for (KeeperController keeper : keepers) {
            if (keeper.isVisible()) {
                g.drawImage(keeper.getImage(), keeper.getXModel(), keeper.getYModel(), this);
            }
        }        
        for (DogController dog : dogs) {
            if (dog.isVisible()) {
                g.drawImage(dog.getImage(), dog.getXModel(), dog.getYModel(), this);
            }
        }
        for (AnimalController chicken : chickens) {
            if (chicken.isVisible()) {
                g.drawImage(chicken.getImage(), chicken.getXModel(), chicken.getYModel(), this);
            }
        }    
        for (AnimalController bebek : bebeks) {
            if (bebek.isVisible()) {
                g.drawImage(bebek.getImage(), bebek.getXModel(), bebek.getYModel(), this);
            }
        }  
        for (AnimalController angsa : angsas) {
            if (angsa.isVisible()) {
                g.drawImage(angsa.getImage(), angsa.getXModel(), angsa.getYModel(), this);
            }
        }  
        for (WallController wall : walls) {
            if (wall.isVisible()) {
                g.drawImage(wall.getImage(), wall.getXModel(), wall.getYModel(), this);
            }
        }    
        g.setColor(Color.WHITE);
        g.drawString("Time: " + time + "s", 5, 15);
        g.drawString("Score: " + player.getScorePlayer(), 100, 15);
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
        updateBebeks();
        updateAngsas();
        updateDogs();
        checkCollisions();
        repaint();
    }

    private void inGame() {        
        if (!ingame) {
            timer.stop();
        }
    }

    private void updateCraft() {
        if (player.isVisiblePlayer()) {
            player.move();
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
        if (bebeks.isEmpty() && chickens.isEmpty() && angsas.isEmpty()) {
            ingame = false;
            return;
        }
        for (int i = 0; i < chickens.size(); i++) {
            AnimalController chicken = chickens.get(i);
            if (chicken.isVisible()) {
                moveChicken();
            } else {
                chickens.remove(i);
            }
        }
    }

    private void updateBebeks() {
        if (bebeks.isEmpty() && chickens.isEmpty() && angsas.isEmpty()) {
            ingame = false;
            return;
        }
        for (int i = 0; i < bebeks.size(); i++) {
            AnimalController bebek = bebeks.get(i);
            if (bebek.isVisible()) {
                moveBebek();
            } else {
                bebeks.remove(i);
            }
        }
    }
    
    private void updateAngsas() {
        if (bebeks.isEmpty() && chickens.isEmpty() && angsas.isEmpty()) {
            ingame = false;
            return;
        }
        for (int i = 0; i < angsas.size(); i++) {
            AnimalController angsa = angsas.get(i);
            if (angsa.isVisible()) {
                moveAngsa();
            } else {
                angsas.remove(i);
            }
        }
    }
    
    private void updateDogs() {
        if (dogs.isEmpty()) {
            ingame = false;
            return;
        }
        for (int i = 0; i < dogs.size(); i++) {
            DogController dog = dogs.get(i);
            if (dog.isVisible()) {
                moveDog();
            } else {
                dogs.remove(i);
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
        Rectangle r3 = player.getBoundsPlayer();
        for (AnimalController chicken : chickens) {
            Rectangle r1 = chicken.getBounds();
            if (r3.intersects(r1)) {
                chicken.setVisible(false);
                int score = player.getScorePlayer() + 5;
                player.setScorePlayer(score);
            }
        }
        for (AnimalController bebek : bebeks) {
            Rectangle r1 = bebek.getBounds();
            if (r3.intersects(r1)) {
                bebek.setVisible(false);
                int score = player.getScorePlayer() + 10;
                player.setScorePlayer(score);
            }
        }
        for (AnimalController angsa : angsas) {
            Rectangle r1 = angsa.getBounds();
            if (r3.intersects(r1)) {
                angsa.setVisible(false);
                int score = player.getScorePlayer() + 15;
                player.setScorePlayer(score);
            }
        }        
        for (WallController wall : walls) {
            Rectangle r4 = wall.getBounds();
            if (r3.intersects(r4)) {
                if (player.getXPlayer() < wall.getXModel()) {
                    player.setXPlayer(player.getXPlayer()-3);
                    player.setDxPlayer(0);
                } else 
                if (player.getXPlayer() > wall.getXModel()) {
                    player.setXPlayer(player.getXPlayer()+3);
                    player.setDxPlayer(0);
                } else
                if (player.getYPlayer() < wall.getXModel()) {
                    player.setYPlayer(player.getYPlayer()-3);
                    player.setDyPlayer(0);
                } else
                if (player.getYPlayer() > wall.getXModel()) {
                    player.setYPlayer(player.getYPlayer()+3);
                    player.setDyPlayer(0);
                }
            }
            
            for (AnimalController chicken : chickens) {
                Rectangle r1 = chicken.getBounds();
                if (r1.intersects(r4)) {
                    if (chicken.getXModel() < wall.getXModel()) {
                        chicken.setXModel(chicken.getXModel()-3);
                    }
                    if (chicken.getXModel() > wall.getXModel()) {
                        chicken.setXModel(chicken.getXModel()+3);
                    }
                    if (chicken.getYModel() < wall.getXModel()) {
                        chicken.setYModel(chicken.getYModel()-3);
                    }
                    if (chicken.getYModel() > wall.getYModel()) {
                        chicken.setYModel(chicken.getYModel()+3);
                    }
                }
            }

            for (AnimalController bebek : bebeks) {
                Rectangle r1 = bebek.getBounds();
                if (r1.intersects(r4)) {
                    if (bebek.getXModel() < wall.getXModel()) {
                        bebek.setXModel(bebek.getXModel()-3);
                    }
                    if (bebek.getXModel() > wall.getXModel()) {
                        bebek.setXModel(bebek.getXModel()+3);
                    }
                    if (bebek.getYModel() < wall.getXModel()) {
                        bebek.setYModel(bebek.getYModel()-3);
                    }
                    if (bebek.getYModel() > wall.getYModel()) {
                        bebek.setYModel(bebek.getYModel()+3);
                    }
                }
            }

            for (AnimalController angsa : angsas) {
                Rectangle r1 = angsa.getBounds();
                if (r1.intersects(r4)) {
                    if (angsa.getXModel() < wall.getXModel()) {
                        angsa.setXModel(angsa.getXModel()-3);
                    }
                    if (angsa.getXModel() > wall.getXModel()) {
                        angsa.setXModel(angsa.getXModel()+3);
                    }
                    if (angsa.getYModel() < wall.getXModel()) {
                        angsa.setYModel(angsa.getYModel()-3);
                    }
                    if (angsa.getYModel() > wall.getYModel()) {
                        angsa.setYModel(angsa.getYModel()+3);
                    }
                }
            }
            
            for (KeeperController keeper : keepers) {
                Rectangle r2 = keeper.getBounds();
                if (r2.intersects(r4)) {
                    if (keeper.getXModel() < wall.getXModel()) {
                        keeper.setXModel(keeper.getXModel()-3);
                        keeper.setYModel(keeper.getYModel()+3);
                    }
                    if (keeper.getXModel() > wall.getXModel()) {
                        keeper.setXModel(keeper.getXModel()+3);
                        keeper.setYModel(keeper.getYModel()+3);
                    }
                    if (keeper.getYModel() < wall.getXModel()) {
                        keeper.setYModel(keeper.getYModel()-3);
                    }
                    if (keeper.getYModel() > wall.getYModel()) {
                        keeper.setYModel(keeper.getYModel()+3);
                    }
                }
                if (r2.intersects(r3)) {
                    ingame = false;
                }
            } 
            
            for (DogController dog : dogs) {
                Rectangle r5 = dog.getBounds();
                if (r5.intersects(r3)) {
                    ingame = false;
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
            player.animate();
            
            for (int i = 0; i < dogs.size(); i++) {
                DogController dog = dogs.get(i);    
                dog.animate();
            }        
            for (int i = 0; i < keepers.size(); i++) {
                KeeperController keeper = keepers.get(i);    
                keeper.animate();
            }    
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;
            if (sleep < 0) {
                sleep = 2;
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }
            beforeTime = System.currentTimeMillis();
        }
    }

    public KeyAdapter TAdapter = new KeyAdapter() {

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    };
}