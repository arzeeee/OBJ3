/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keeper;
import movingSprites.MovingSprite;
/**
 *
 * @author Aya Aurora
 */
public class Keeper extends MovingSprite{
    private int tipe;
    
    public Keeper(int x, int y,int tipe) {
        this.x = x;
        this.y = y;
        this.count = 1;
        this.direction = 1;
        this.tipe = tipe;
    }

    public int getTipe() {
        return tipe;
    }
    
    public void setTipe(int input) {
        this.tipe = input;
    }
}
