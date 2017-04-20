/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maling.ayam.pkg2017;

import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author Aya Aurora
 */
public class AnimalController {
    private Animal model;
    private AnimalView view;
    
    public AnimalController(Animal model, AnimalView view) {
        this.model = model;
        this.view = view;
    }
    
    //Getter Animal
    public Animal getModelAnimal() {
        return model;
    }
    
    public int getXAnimal() {
        return model.getX();
    }
    
    public int getYAnimal() {
        return model.getY();
    }
    
    //Getter AnimalView
    public AnimalView getViewAnimal() {
        return view;
    }
    
    public void getImageDimensionsAnimal() {
        view.getImageDimensions();
    }

    protected void loadImageAnimal(String imageName) {
        view.loadImage(imageName);
    }

    public Image getImageAnimal() {
        return view.getImage();
    }

    public int getWidthSpriteAnimal() {
        return view.getWidthSprite();
    }
    
    public int getHeightSpriteAnimal() {
        return view.getHeightSprite();
    }

    public boolean isVisibleAnimal() {
        return view.isVisible();
    }
    
    //Setter Animal
    public void setModelAnimal(Animal model) {
        this.model = model;
    }
    
    public void setXAnimal(int x) {
        this.model.setX(x);
    }
    
    public void setYAnimal(int y) {
        this.model.setY(y);
    }
    
    //Setter AnimalView
    public void setViewAnimal(AnimalView view) {
        this.view = view;
    }
    
    public void setVisibleAnimal(Boolean visible) {
        view.setVisible(visible);
    }
    
    public Rectangle getBoundsAnimal() {
        return new Rectangle(model.getX(), model.getY(), view.getWidthSprite(), view.getHeightSprite());
    }
}
