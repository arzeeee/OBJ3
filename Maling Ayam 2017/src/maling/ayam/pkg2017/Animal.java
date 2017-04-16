/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maling.ayam.pkg2017;

import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.Random;

/**
 *
 * @author Rizky Faramita
 */
public class Animal extends Sprite {

    private final int INITIAL_X = 800;
    
    public Animal(int x, int y) {
        super(x, y);
        initAnimal();
    }

    private void initAnimal() {
        loadImage("chicken.png");
        getImageDimensions();
    }

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }
        //generate random movement
        Random rand = new Random();
        x += (rand.nextInt(3) - 1) * 2;
        if (rand.nextInt(3) - 1 == 0) {
            y += (rand.nextInt(3) - 1) * 2;
        }
    }    
}
