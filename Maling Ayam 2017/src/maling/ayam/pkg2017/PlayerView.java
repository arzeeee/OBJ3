/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maling.ayam.pkg2017;

import java.awt.event.KeyEvent;

public class PlayerView extends Sprite {

    public PlayerView() {
        super();
        initCraft();
    }

    private void initCraft() {
        loadImage("craft.png");
        getImageDimensions();
    }    
}
