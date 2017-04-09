/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

/**
 *
 * @author Aya Aurora
 */
public class Player {
    
    private int x;
    private int y;
    
    public Player() {
        this.x = -1;
        this.y = -1;
    }
    
    public Player(int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }

    public void setX(int _x) {
        this.x = _x;
    }

    public void setY(int _y){
        this.y = _y;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
