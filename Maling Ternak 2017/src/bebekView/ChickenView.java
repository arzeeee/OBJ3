/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chickenView;

import spriteView.SpriteView;

/**
 *
 * @author Rizky Faramita
 */
public class ChickenView extends SpriteView {
    
    public ChickenView() {
        vis = true;
        imageName = "chicken.png";
        initChicken(imageName);
    }
    
    private void initChicken(String imageName) {
        loadImage(imageName);
        getImageDimensions();
    }
}
