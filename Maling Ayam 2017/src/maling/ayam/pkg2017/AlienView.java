/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maling.ayam.pkg2017;

import static java.lang.Math.abs;
import java.util.Random;

public class AlienView extends Sprite {

    private final int INITIAL_X = 800;
    
    public AlienView() {
        super();

        initAlien();
    }

    private void initAlien() {

        loadImage("alien2.png");
        getImageDimensions();
    }
}