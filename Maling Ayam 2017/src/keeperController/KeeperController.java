/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keeperController;

import keeper.Keeper;
import keeperView.KeeperView;
import java.awt.Image;
import java.awt.Rectangle;
import playerController.PlayerController;
/**
 *
 * @author Aya Aurora
 */
public class KeeperController{
    
    private Keeper model;
    private KeeperView view;
    
    public KeeperController(Keeper model, KeeperView view) {
        this.model = model;
        this.view = view;
    }
    public Keeper getModel() {
        return model;
    }
    
    public int getXModel() {
        return model.getX();
    }
    
    public int getYModel() {
        return model.getY();
    }
    
    public KeeperView getView() {
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
    public void setModel(Keeper model) {
        this.model = model;
    }
    
    public void setXModel(int x) {
        this.model.setX(x);
    }
    
    public void setYModel(int y) {
        this.model.setY(y);
    }
    
    //Setter ChickenView
    public void setView(KeeperView view) {
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
    
    public void move (PlayerController craft) {
        //non-random movement to catch player
            int deltaX = Math.abs(getXModel() - craft.getXPlayer());
            int deltaY = Math.abs(getYModel() - craft.getYPlayer());
            if (deltaX == 0) { //absis parallel move closer to ordinat
                if (getYModel() > craft.getYPlayer()) {
                    setYModel(getYModel() - 2);//move faster when parallel
                } else {
                    setYModel(getYModel() + 2);
                }
            } else if (deltaY == 0) { //ordinat parallel move closer to absis
                if (getXModel() > craft.getXPlayer()) {
                    setXModel(getXModel() - 2);
                } else {
                    setXModel(getXModel() + 2);
                }            
            } else if (deltaX != 0 && deltaY != 0) {
                //find nearest path to get its absis parallel
                if (getXModel() > craft.getXPlayer()) {
                    setXModel(getXModel() - 1);//move slower when not parallel
                } else {
                    setXModel(getXModel() + 1);
                }
            }
    }
}
