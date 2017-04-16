/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maling.ayam.pkg2017;

import java.awt.event.KeyEvent;

public class Player extends Sprite {

    private int dx;
    private int dy;
    private int direction;
    private int count;

    public Player(int x, int y) {
        super(x, y);

        initCraft();
    }

    private void initCraft() {
        
        loadImage("craft.png");
        getImageDimensions();
        direction = 1;
        count = 1;
    }
    
    public void animate() {
        count++;
        if (count >3) {
                count = 1;
            }
        
    }
    
    public void move() {

        x += dx;
        y += dy;
        
        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
        
        
        if (direction == 1) {
            loadImage("craft" + count + "down.png");
            getImageDimensions();
        }
        
        if (direction == 2) {
            loadImage("craft" + count + "right.png");
            getImageDimensions();
        }
        
        if (direction == 3) {
            loadImage("craft"+ count + "up.png");
            getImageDimensions();
        }
        
        if (direction == 4) {
            loadImage("craft" + count + "left.png");
            getImageDimensions();
        }
    }

    
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            //Spasi
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
            direction = 4;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
            direction = 2;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -2;
            direction = 3;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
            direction = 1;
        }
    }


    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
            direction = 1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
            direction = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
            direction = 1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
            direction = 1;
        }
    }
    public int getDir() {
        return direction;
    }
    
    public int getCount() {
        return count;
    }
}
