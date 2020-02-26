package com.morsstepan.musictastecover.image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CoverBuilder {
    public static BufferedImage joinImage(BufferedImage source,
                                                  BufferedImage image,
                                           int offset,
                                           JoinDirection joinDirection) {

        int width;
        int height;
        if(joinDirection == JoinDirection.UP || joinDirection == JoinDirection.DOWN) {
            width = source.getWidth();
            height = source.getHeight() + image.getHeight();
        } else {
            width = source.getWidth() + image.getWidth();
            height = source.getHeight();
        }
        BufferedImage newImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        Color oldColor = g2.getColor();
        g2.setPaint(Color.WHITE);
//        g2.fillRect(0, 0, width, height);
        g2.setColor(oldColor);
//        g2.drawImage(source, null, 0, 0);
//        g2.drawImage(image, null, 0, source.getHeight());
        switch(joinDirection) {
            case UP:
                g2.drawImage(source, null, 0, image.getHeight());
                g2.drawImage(image, null, 0, 0);
                break;
            case DOWN:
                g2.drawImage(source, null, 0, 0);
                g2.drawImage(image, null, 0, source.getHeight());
                break;
            case RIGHT:
                g2.drawImage(source, null, 0, 0);
                g2.drawImage(image, null, source.getWidth(), 0);
                break;
            case LEFT:
                g2.drawImage(source, null, source.getWidth(), 0);
                g2.drawImage(image, null, 0, 0);
                break;
        }

        g2.dispose();
        return newImage;
    }

    public void create() {

    }

}
