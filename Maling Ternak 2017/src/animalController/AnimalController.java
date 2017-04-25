/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalController;

import animal.Animal;
import animalView.AnimalView;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Aya Aurora
 */
public class AnimalController{
    private Animal model;
    private AnimalView view;
    
    public AnimalController(Animal model, AnimalView view) {
        this.model = model;
        this.view = view;
    }
    
    public Animal getModel() {
        return model;
    }
    
    public int getXModel() {
        return model.getX();
    }
    
    public int getYModel() {
        return model.getY();
    }
    
    public AnimalView getView() {
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
    public void setModel(Animal model) {
        this.model = model;
    }
    
    public void setXModel(int x) {
        this.model.setX(x);
    }
    
    public void setYModel(int y) {
        this.model.setY(y);
    }
    
    //Setter ChickenView
    public void setView(AnimalView view) {
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
                view.loadImage("./img/chicken/chicken"+ model.getTipe() + "down.png");
                view.getImageDimensions();
            }
        
            if (model.getDirection() == 2) {
                view.loadImage("./img/chicken/chicken"+ model.getTipe() + "right.png");
                view.getImageDimensions();
            }
        
            if (model.getDirection() == 3) {
                view.loadImage("./img/chicken/chicken"+ model.getTipe() + "up.png");
                view.getImageDimensions();
            }
        
            if (model.getDirection() == 4) {
                view.loadImage("./img/chicken/chicken"+ model.getTipe() + "left.png");
                view.getImageDimensions();
            }
            
            int newX = getXModel() + (rand.nextInt(3) - 1);
            do {
                newX = getXModel() + (rand.nextInt(3) - 1);
            } while (newX>780||newX<10);
            setXModel(newX);
            if (rand.nextInt(3) - 1 == 0) { //absis doesn't change
                int newY = getYModel() + (rand.nextInt(3) - 1); //change ordinat
                do {
                    newY = getYModel() + (rand.nextInt(3) - 1);
                } while (newY>580||newY<10);
                setYModel(newY);
            }
            
    }
}
