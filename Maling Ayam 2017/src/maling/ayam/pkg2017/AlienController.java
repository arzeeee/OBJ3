/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maling.ayam.pkg2017;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Aya Aurora
 */
public class AlienController {
    
    private Alien model;
    private AlienView view;
    
    public AlienController(Alien model, AlienView view) {
        this.model = model;
        this.view = view;
    }
    
    //Getter dari Alien
    public Alien getModelAlien() {
        return model;
    }
    
    public int getXAlien() {
        return model.getX();
    }
    
    public int getYAlien() {
        return model.getY();
    }
    
    //Getter dari AlienView
    public AlienView getViewAlien() {
        return view;
    }
    
    public void getImageDimensionsAlien() {
        view.getImageDimensions();
    }

    protected void loadImageAlien(String imageName) {
        view.loadImage(imageName);
    }

    public Image getImageAlien() {
        return view.getImage();
    }

    public int getWidthSpriteAlien() {
        return view.getWidthSprite();
    }
    
    public int getHeightSpriteAlien() {
        return view.getHeightSprite();
    }

    public boolean isVisibleAlien() {
        return view.isVisible();
    }

    
    //Setter Alien
    public void setModelAlien(Alien model) {
        this.model = model;
    }
    
    public void setXAlien(int x) {
        this.model.setX(x);
    }
    
    public void setYAlien(int y) {
        this.model.setY(y);
    }
    
    //Setter AlienView
    public void setViewAlien(AlienView view) {
        this.view = view;
    }
    
    public void setVisibleAlien(Boolean visible) {
        view.setVisible(visible);
    }
    
    public Rectangle getBoundsAlien() {
        return new Rectangle(model.getX(), model.getY(), view.getWidthSprite(), view.getHeightSprite());
    }
}
