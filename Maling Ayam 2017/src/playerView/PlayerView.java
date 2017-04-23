/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playerView;

import spriteView.SpriteView;
import java.awt.event.KeyEvent;

public class PlayerView extends SpriteView {

    public PlayerView() {
        imageName = "craft.png";
        initPlayer(imageName);
        vis = true;
    }
    
    private void initPlayer(String imageName) {
        loadImage(imageName);
        getImageDimensions();
    }
}
