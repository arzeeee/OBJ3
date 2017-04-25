/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalView;

import spriteView.SpriteView;

/**
 *
 * @author Rizky Faramita
 */
public class AnimalView extends SpriteView {
    
    public AnimalView() {
        vis = true;
        imageName = "chicken.png";
        initAnimal(imageName);
    }
    
    private void initAnimal(String imageName) {
        loadImage(imageName);
        getImageDimensions();
    }
}
