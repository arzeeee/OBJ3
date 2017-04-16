/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maling.ayam.pkg2017;

import static java.lang.Math.abs;
import java.util.Random;

public class Alien extends Sprite {

    private final int INITIAL_X = 800;
    
    public Alien(int x, int y) {
        super(x, y);

        initAlien();
    }

    private void initAlien() {

        loadImage("alien2.png");
        getImageDimensions();
    }

    void setX(int _x) {
        x = _x;
    }

    
    void setY(int _y) {
        y = _y;
    }



}