/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dogView;

import spriteView.SpriteView;

public class DogView extends SpriteView {
    
    public DogView() {
        vis = true;
        imageName = "./img/dog/dog.png";
        initDog(imageName);
    } 
    
    private void initDog(String imageName) {
        loadImage(imageName);
        getImageDimensions();
    }
}