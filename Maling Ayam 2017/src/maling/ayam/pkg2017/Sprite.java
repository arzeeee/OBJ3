package maling.ayam.pkg2017;

import java.awt.Image;
import java.awt.Rectangle;
import static java.lang.System.in;
import javax.swing.ImageIcon;

public class Sprite {

    protected int width;
    protected int height;
    protected boolean vis;
    protected Image image;
    
    public Sprite() {
        vis = true;
    }

    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    protected void loadImage(String imageName) {

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
}