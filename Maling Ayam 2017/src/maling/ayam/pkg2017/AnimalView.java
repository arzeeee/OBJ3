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
public class AnimalView extends Sprite {

    private final int INITIAL_X = 800;
    
    public AnimalView() {
        super();
        initAnimal();
    }

    private void initAnimal() {
        loadImage("chicken.png");
        getImageDimensions();
    }
}
