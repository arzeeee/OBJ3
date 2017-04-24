/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingSprites;
import sprite.Sprite;
/**
 *
 * @author user
 */
public abstract class MovingSprite extends Sprite {
    protected int dx;
    protected int dy;
    protected int direction;
    protected int count;
    

    
    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
    
    public int getDirection() {
        return direction;
    }

    public int getCount() {
        return count;
    }
    
    public void setDx(int dx) {
        this.dx = dx;
    }
    
    public void setDy(int dy) {
        this.dy = dy;
    }
    
    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    
}
