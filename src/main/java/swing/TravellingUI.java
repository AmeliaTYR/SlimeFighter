package main.java.swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TravellingUI extends JPanel{

    public int characterPosX = 0;
    public int characterPosY = 380;

    public int characterWidth = 60;
    public int characterHeight = 60;

    public int backgroundWidth = 740;
    public int backgroundHeight = 520;

    public boolean stillTravelling = true;


    public String travellerImageFileName = "src/main/resources/images/pathAssets/traveller.png";
    public String travelBackgroundImageFileName = "src/main/resources/images/pathAssets/pathBg.png";

    private Image travellerImage;
    private Image travelBgImage;

    private JLabel bgLabel;

    public TravellingUI() {
        travellerImage = loadImage(characterWidth, characterHeight, travellerImageFileName);
        travelBgImage = loadImage(backgroundWidth, backgroundHeight, travelBackgroundImageFileName);

        initUI();

    }

    private Image loadImage(int imageWidth, int imageHeight, String filename) {
        // get the traveller image to be rendered
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("image image file not read");
        }

        return img.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
    }

    private void initUI() {
        // define the panel
        setBounds(20,20,740,520);
        setBackground(Color.blue);
        setLayout(null);
        setVisible(true);


        // todo: render trees on different layers for parallax

        // todo: render button for keep going

        // todo: render button for check stats

        // todo: render button for retire

        // todo: render button for change gear (with current inventory) (take from ItemsUI gear management)

        // todo: render starting position of the user
        characterPosX = 0;






    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // add the background image first so it gets rendered at the back
        g.drawImage(travelBgImage, 0, 0, this);

        g.drawImage(travellerImage, characterPosX, characterPosY, this);






    }

    public void moveForward() {
        // check if still have room to move forward (otherwise do nothing)
        // generate number of steps to move forward
        // generate a random event based on the chance
        // move forward, repaint, then generate the exclamation mark when something happens
        // wait a second then trigger the event to happen (eg the window change)
        // if it is a treasure then open up the inventory ui on top of the current path ui
        // if it is a fight scene
    }





}
