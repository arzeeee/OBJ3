/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dogController;

import dog.Dog;
import dogView.DogView;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Aya Aurora
 */
public class DogController{
    private Dog model;
    private DogView view;
    
    public DogController(Dog model, DogView view) {
        this.model = model;
        this.view = view;
    }
    
    public Dog getModel() {
        return model;
    }
    
    public int getXModel() {
        return model.getX();
    }
    
    public int getYModel() {
        return model.getY();
    }
    
    public DogView getView() {
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
    
    //Setter Dog
    public void setModel(Dog model) {
        this.model = model;
    }
    
    public void setXModel(int x) {
        this.model.setX(x);
    }
    
    public void setYModel(int y) {
        this.model.setY(y);
    }
    
    //Setter DogView
    public void setView(DogView view) {
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
                view.loadImage("./img/dog/dog1" + "down.png");
                view.getImageDimensions();
            }
        
            if (model.getDirection() == 2) {
                view.loadImage("./img/dog/dog1" + "right.png");
                view.getImageDimensions();
            }
        
            if (model.getDirection() == 3) {
                view.loadImage("./img/dog/dog1" + "up.png");
                view.getImageDimensions();
            }
        
            if (model.getDirection() == 4) {
                view.loadImage("./img/dog/dog1" + "left.png");
                view.getImageDimensions();
            }
            
            int newX = getXModel() + (rand.nextInt(3) - 1);
            do {
                newX = getXModel() + (rand.nextInt(3) - 1);
            } while (newX>790 || newX<=10);
            setXModel(newX);
            if (rand.nextInt(3) - 1 == 0) { //absis doesn't change
                int newY = getYModel() + (rand.nextInt(3) - 1); //change ordinat
                do {
                newY = getYModel() + (rand.nextInt(3) - 1);
                } while (newY>590 || newY<=20);
                setYModel(newY);
            }
            
    }
}
