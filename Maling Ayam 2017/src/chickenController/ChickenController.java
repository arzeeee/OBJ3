/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chickenController;

import chicken.Chicken;
import chickenView.ChickenView;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Aya Aurora
 */
public class ChickenController{
    private Chicken model;
    private ChickenView view;
    
    public ChickenController(Chicken model, ChickenView view) {
        this.model = model;
        this.view = view;
    }
    
    public Chicken getModel() {
        return model;
    }
    
    public int getXModel() {
        return model.getX();
    }
    
    public int getYModel() {
        return model.getY();
    }
    
    public ChickenView getView() {
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
    
    //Setter Chicken
    public void setModel(Chicken model) {
        this.model = model;
    }
    
    public void setXModel(int x) {
        this.model.setX(x);
    }
    
    public void setYModel(int y) {
        this.model.setY(y);
    }
    
    //Setter ChickenView
    public void setView(ChickenView view) {
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
            int newX = getXModel() + (rand.nextInt(3) - 1);
            setXModel(newX);
            if (rand.nextInt(3) - 1 == 0) { //absis doesn't change
                int newY = getYModel() + (rand.nextInt(3) - 1); //change ordinat
                setYModel(newY);
            }
    }
}
