package com.morsstepan.musictastecover;

import com.morsstepan.musictastecover.image.CoverBuilder;
import com.morsstepan.musictastecover.image.JoinDirection;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class ImagePlayground {
    private static final String HARD_DAYS_NIGHT_COVER_NAME = "hard-days-night.jpg";
    private static final String HELP_COVER_NAME = "help.jpg";

    @Test
    public void mergeImages() {


        ClassLoader classLoader = getClass().getClassLoader();
        File file1 = new File(classLoader.getResource(HARD_DAYS_NIGHT_COVER_NAME).getFile());
        File file2 = new File(classLoader.getResource(HELP_COVER_NAME).getFile());
        try {

//            BufferedImage img1 = ImageIO.read(file1);
            BufferedImage img1 = ImageIO.read(new File("merged.jpg"));
            BufferedImage img2 = ImageIO.read(file2);
            BufferedImage fin = CoverBuilder.joinImage(img1, img2, 0, JoinDirection.RIGHT);
            ImageIO.write(fin, "png", new File("merged.jpg"));
            System.out.println("test");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static BufferedImage joinBufferedImage(BufferedImage img1,
                                                  BufferedImage img2) {
        //int offset = 2;
        int width = img1.getWidth();
        int height = img1.getHeight() + img2.getHeight();
        BufferedImage newImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        Color oldColor = g2.getColor();
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, width, height);
        g2.setColor(oldColor);
        g2.drawImage(img1, null, 0, 0);
        g2.drawImage(img2, null, 0, img1.getHeight());
        g2.dispose();
        return newImage;
    }
}
