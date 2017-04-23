/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keeperView;

import spriteView.SpriteView;

public class KeeperView extends SpriteView {
    
    public KeeperView() {
        vis = true;
        imageName = "alien2.png";
        initKeeper(imageName);
    } 
    
    private void initKeeper(String imageName) {
        loadImage(imageName);
        getImageDimensions();
    }
}