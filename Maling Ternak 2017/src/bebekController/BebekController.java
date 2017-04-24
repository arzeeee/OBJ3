/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bebekController;

import bebek.Bebek;
import bebekView.BebekView;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Aya Aurora
 */
public class BebekController{
    private Bebek model;
    private BebekView view;
    
    public BebekController(Bebek model, BebekView view) {
        this.model = model;
        this.view = view;
    }
    
    public Bebek getModel() {
        return model;
    }
    
    public int getXModel() {
        return model.getX();
    }
    
    public int getYModel() {
        return model.getY();
    }
    
    public BebekView getView() {
        return view;
    }
    
    public void getImageDimensions() {
        view.getImageDimensions();
    }
    
    public void loadImage(String imageName) {
        view.loadImage(imageName);
    }
    
    public Image getImage() {
        return view.getImage();
    }
    
    public int getWidthSprite() {
        return view.getWidthSprite();
    }
    
    public int getHeightSprite() {
        return view.getHeightSprite();
    }

    public boolean isVisible() {
        return view.isVisible();
    }
    
    //Setter Kalkun
    public void setModel(Bebek model) {
        this.model = model;
    }
    
    public void setXModel(int x) {
        this.model.setX(x);
    }
    
    public void setYModel(int y) {
        this.model.setY(y);
    }
    
    //Setter BebekView
    public void setView(BebekView view) {
        this.view = view;
    }
    
    public void setVisible(Boolean visible) {
        view.setVisible(visible);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(getXModel(), getYModel(), getWidthSprite(), getHeightSprite());
    }
    
    public void move() {
        //generate random movement
            Random rand = new Random();
            model.setDirection(rand.nextInt(4)+1);
            if (model.getDirection() == 1) {
                view.loadImage("./img/chicken/chicken" + "down.png");
                view.getImageDimensions();
            }
        
            if (model.getDirection() == 2) {
                view.loadImage("./img/chicken/chicken" + "right.png");
                view.getImageDimensions();
            }
        
            if (model.getDirection() == 3) {
                view.loadImage("./img/chicken/chicken" + "up.png");
                view.getImageDimensions();
            }
        
            if (model.getDirection() == 4) {
                view.loadImage("./img/chicken/chicken" + "left.png");
                view.getImageDimensions();
            }
            
            int newX = getXModel() + (rand.nextInt(3) - 1);
            setXModel(newX);
            if (rand.nextInt(3) - 1 == 0) { //absis doesn't change
                int newY = getYModel() + (rand.nextInt(3) - 1); //change ordinat
                setYModel(newY);
            }
            
    }
}
