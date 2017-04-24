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
    
    public Keeper(int x, int y) {
        this.x = x;
        this.y = y;
        this.count = 1;
        this.direction = 1;
    }

    public void setDirection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
