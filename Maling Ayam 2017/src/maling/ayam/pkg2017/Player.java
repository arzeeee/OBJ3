/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maling.ayam.pkg2017;

/**
 *
 * @author Aya Aurora
 */
public class Player {
    
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int direction;
    private int count;
    private int score;
    
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.direction = 1;
        this.count = 1;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
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
    
    public int getScore() {
        return score;
    }
    
    void setX(int x) {
        this.x = x;
    }
    
    void setY(int y) {
        this.y = y;
    }
    
    void setDx(int dx) {
        this.dx = dx;
    }
    
    void setDy(int dy) {
        this.dy = dy;
    }
    
    void setDirection(int direction) {
        this.direction = direction;
    }
    
    void setCount(int count) {
        this.count = count;
    }
    
    void setScore(int score) {
        this.score = score;
    }
}
