package main.java.miscJunk;

import javafx.application.Application;
import main.java.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class testCode {

    public static void main(String[] args) {
        BufferedImage img = null;
        Image image = null;

        try {
            File file = new File("src/main/resources/images/roomAssets/chest.png");
            image = ImageIO.read(file);
//            img = ImageIO.read(new File("main/resources/images/roomAssets/chest.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Object image file not read");
        }
    }
}
