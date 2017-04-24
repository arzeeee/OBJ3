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
    
    public void animate() {
        model.setCount(model.getCount()+1);
        if (model.getCount() > 3) {
                model.setCount(1);
        }  
    }
    
    public void move() {
        //generate random movement
            if(getXModel() <= 50) {
                model.setDirection(2);
            }
            
            if (getXModel() >= 750) {
                model.setDirection(4);
            }
            
            if (model.getDirection() == 1) {
                view.loadImage("./img/dog/dog"+ model.getCount() + "down.png");
                view.getImageDimensions();
            }
        
            if (model.getDirection() == 2) {
                view.loadImage("./img/dog/dog"+ model.getCount() + "right.png");
                view.getImageDimensions();
                setXModel(getXModel()+5);
            }
        
            if (model.getDirection() == 3) {
                view.loadImage("./img/dog/dog"+ model.getCount() + "up.png");
                view.getImageDimensions();
            }
        
            if (model.getDirection() == 4) {
                view.loadImage("./img/dog/dog"+ model.getCount() + "left.png");
                view.getImageDimensions();
                setXModel(getXModel()-5);
            }
            
            
    }
}
