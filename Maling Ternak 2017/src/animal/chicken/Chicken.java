/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal.chicken;

import movingSprites.MovingSprite;
/**
 *
 * @author Aya Aurora
 */
public class Chicken extends MovingSprite{    
    private int tipe;
    
    public Chicken(int x, int y,int tipe) {
        this.x = x;
        this.y = y;
        this.count = 1;
        this.tipe = tipe;
    }   ;
    
    public int getTipe() {
        return tipe;
    };
    
    public void setTipe(int input) {
        tipe = input;
    }
    
}
