/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spriteView;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
public abstract class SpriteView {
    protected int width;
    protected int height;
    protected boolean vis;
    protected Image image;
    protected String imageName;
    
    public void getImageDimensions() {
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    public Image getImage() {
        return image;
    }

    public int getWidthSprite() {
        return width;
    }
    
    public int getHeightSprite() {
        return height;
    }

    public boolean isVisible() {
        return vis;
    }

    public void setVisible(Boolean visible) {
        vis = visible;
    }
    
    public String getImageName() {
        return imageName;
    }
    
    public void setImageName(String input) {
        imageName = input;
    }
}
