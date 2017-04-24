/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;
import movingSprites.MovingSprite;
/**
 *
 * @author Aya Aurora
 */
public class Player extends MovingSprite{
   
    private int score;
    
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.direction = 1;
        this.count = 1;
    }
     
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
}
