/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bebekView;

import spriteView.SpriteView;

/**
 *
 * @author Rizky Faramita
 */
public class BebekView extends SpriteView {
    
    public BebekView() {
        vis = true;
        imageName = "chicken.png";
        initBebek(imageName);
    }
    
    private void initBebek(String imageName) {
        loadImage(imageName);
        getImageDimensions();
    }
}
