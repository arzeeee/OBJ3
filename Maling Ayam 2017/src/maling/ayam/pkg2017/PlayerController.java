/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maling.ayam.pkg2017;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author Aya Aurora
 */
public class PlayerController {
    
    private Player model;
    private PlayerView view;
    
    public PlayerController(Player model, PlayerView view) {
        this.model = model;
        this.view = view;
    }
    
    //Getter Player
    public Player getModelPlayer() {
        return model;
    }
    
    public int getXPlayer() {
        return model.getX();
    }

    public int getYPlayer() {
        return model.getY();
    }
    
    public int getDxPlayer() {
        return model.getDx();
    }

    public int getDyPlayer() {
        return model.getDy();
    }
    
    public int getDirectionPlayer() {
        return model.getDirection();
    }

    public int getCountPlayer() {
        return model.getCount();
    }
    
    public int getScorePlayer() {
        return model.getScore();
    }
    
    //Getter PlayerView
    public PlayerView getViewPlayer() {
        return view;
    }
    
    public void getImageDimensionsPlayer() {
        view.getImageDimensions();
    }

    protected void loadImagePlayer(String imageName) {
        view.loadImage(imageName);
    }

    public Image getImagePlayer() {
        return view.getImage();
    }

    public int getWidthSpritePlayer() {
        return view.getWidthSprite();
    }
    
    public int getHeightSpritePlayer() {
        return view.getHeightSprite();
    }

    public boolean isVisiblePlayer() {
        return view.isVisible();
    }
    
    //Setter Player   
    public void setModelPlayer(Player model) {
        this.model = model;
    }
    
    void setXPlayer(int x) {
        this.model.setX(x);
    }
    
    void setYPlayer(int y) {
        this.model.setY(y);
    }
    
    void setDxPlayer(int dx) {
        this.model.setDx(dx);
    }
    
    void setDyPlayer(int dy) {
        this.model.setDy(dy);
    }
    
    void setDirectionPlayer(int direction) {
        this.model.setDirection(direction);
    }
    
    void setCountPlayer(int count) {
        this.model.setCount(count);
    }
    
    void setScorePlayer(int score) {
        this.model.setScore(score);
    }
    
    //Setter PlayerView
    public void setViewPlayer(PlayerView view) {
        this.view = view;
    }
    
    public void setVisiblePlayer(Boolean visible) {
        view.setVisible(visible);
    }
    
    public Rectangle getBoundsPlayer() {
        return new Rectangle(model.getX(), model.getY(), view.getWidthSprite(), view.getHeightSprite());
    }
    
    public void animate() {
        model.setCount(model.getCount()+1);
        if (model.getCount() > 3) {
                model.setCount(1);
        }  
    }
    
    public void move() {

        model.setX(model.getX()+model.getDx());
        model.setY(model.getY()+model.getDy());
        
        if (model.getX() < 1) {
            model.setX(1);
        }

        if (model.getY() < 1) {
            model.setY(1);
        }
        
        if (model.getDirection() == 1) {
            view.loadImage("craft" + model.getCount() + "down.png");
            view.getImageDimensions();
        }
        
        if (model.getDirection() == 2) {
            view.loadImage("craft" + model.getCount() + "right.png");
            view.getImageDimensions();
        }
        
        if (model.getDirection() == 3) {
            view.loadImage("craft"+ model.getCount() + "up.png");
            view.getImageDimensions();
        }
        
        if (model.getDirection() == 4) {
            view.loadImage("craft" + model.getCount() + "left.png");
            view.getImageDimensions();
        }
    }
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            //Spasi
        }

        if (key == KeyEvent.VK_LEFT) {
            model.setDx(-2);
            model.setDirection(4);
        }

        if (key == KeyEvent.VK_RIGHT) {
            model.setDx(2);
            model.setDirection(2);
        }

        if (key == KeyEvent.VK_UP) {
            model.setDy(-2);
            model.setDirection(3);
        }

        if (key == KeyEvent.VK_DOWN) {
            model.setDy(2);
            model.setDirection(1);
        }
    }


    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            model.setDx(0);
            model.setDirection(1);
        }

        if (key == KeyEvent.VK_RIGHT) {
            model.setDx(0);
            model.setDirection(1);
        }

        if (key == KeyEvent.VK_UP) {
            model.setDy(0);
            model.setDirection(1);
        }

        if (key == KeyEvent.VK_DOWN) {
            model.setDy(0);
            model.setDirection(1);
        }
    }
}
