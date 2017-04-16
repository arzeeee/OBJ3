/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maling.ayam.pkg2017;

public class Alien extends Sprite {

    private final int INITIAL_X = 800;

    public Alien(int x, int y) {
        super(x, y);

        initAlien();
    }

    private void initAlien() {

        loadImage("alien.png");
        getImageDimensions();
    }

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }

        x -= 1;
    }
}