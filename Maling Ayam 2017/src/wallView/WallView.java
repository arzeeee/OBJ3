/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wallView;

import spriteView.SpriteView;
/**
 *
 * @author Rizky Faramita
 */
public class WallView extends SpriteView {
    
    public WallView() {
        vis = true;
        imageName = "chicken.png";
        initWall(imageName);
    }
    
    private void initWall(String imageName) {
        loadImage(imageName);
        getImageDimensions();
    }
}
