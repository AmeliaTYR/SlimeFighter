package main.java.swing;

import main.java.constants.PanelNums;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UI {

    GameLogic gameLogic;

    JFrame frame;

    /** create an array of panels for the different scenes
     *  [0]home, [1]town, [2]paths, [3]travelling, [4]combat, [5]loot, [6]inventory, [7]story
     */
    public JPanel panels[] = new JPanel[8];

    // create an array of background labels for each of the scenes
    public JLabel backgrounds[] = new JLabel[8];


    public UI(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        createMainWindow();
        createHomeScene();
        createTownScene();
        frame.setVisible(true);
    }

    public void createMainWindow() {
        // set app icon
        ImageIcon img = new ImageIcon("src/main/resources/images/SlimeFighterTransparent.png");
        frame = new JFrame("Slime Fighters");

        frame.setIconImage(img.getImage());

        //create window to size
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
    }

    public void renderBg(int panelNum, String bgFileName){
        panels[panelNum] = new JPanel(); // recreate panel
        panels[panelNum].setBounds(20,20,740,520);
        panels[panelNum].setBackground(Color.blue);
        panels[panelNum].setLayout(null);
        panels[panelNum].setVisible(true);
        frame.add(panels[panelNum]);

        backgrounds[panelNum] = new JLabel();
        backgrounds[panelNum].setBounds(0,0,740,520);

        // get the image to be rendered
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(bgFileName));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Object image file not read");
        }

        Image dimg = img.getScaledInstance(backgrounds[panelNum].getWidth(), backgrounds[panelNum].getHeight(),
                Image.SCALE_SMOOTH);

        ImageIcon bgIcon = new ImageIcon(dimg);

//        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
        backgrounds[panelNum].setIcon(bgIcon);

    }

    /**
     *
     * @param panelNum the scene the object should be rendered on
     * @param posX position the object
     * @param posY position the object
     * @param width resize object
     * @param height resize object
     * @param fileName object image sprite file
     * @param objectText hint text for what clicking the object does
     * @param clickAction determines what to do if the object is clicked
     */
    public void renderObject(int panelNum, int posX, int posY, int width, int height,
                             String fileName, String objectText, String clickAction) {
        // create objects as labels (so they can be clicked)
        JLabel objLabel = new JLabel();
        objLabel.setBounds(posX, posY, width, height); //  ensure object appears in particular spot

        // get the image to be rendered
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Object image file not read");
        }

        Image dimg = img.getScaledInstance(objLabel.getWidth(), objLabel.getHeight(),
                Image.SCALE_SMOOTH);

        ImageIcon objIcon = new ImageIcon(dimg);

//        ImageIcon objIcon = new ImageIcon(getClass().getClassLoader().getResource(fileName));

        objLabel.setIcon(objIcon); // use the loaded sprite image

        objLabel.addMouseListener(new MouseListener() {
            // only need do something if user hovers over, stops hovering over or clicks object

            public void mouseClicked(MouseEvent e) { }
            public void mousePressed(MouseEvent e) {
                // on left mouse click
                if (SwingUtilities.isLeftMouseButton(e)){
                    // apply action
                    objectClicks.objectClicked(clickAction);
                }
            }
            public void mouseReleased(MouseEvent e) { }
            public void mouseEntered(MouseEvent e) { }
            public void mouseExited(MouseEvent e) { }
        });

        objLabel.setToolTipText(objectText);

        panels[panelNum].add(objLabel);

    }

    // [0]home, [1]town, [2]paths, [3]travelling, [4]combat, [5]loot, [6]inventory, [7]story
    public void createHomeScene() {
        renderBg(0, "src/main/resources/images/roomAssets/roomBg.png");

        renderObject(0, 600, 400,100,100,
                "src/main/resources/images/roomAssets/chest.png", "storage", "storage");
        renderObject(0, 130, 210,180,120,
                "src/main/resources/images/roomAssets/bed.png", "rest", "rest");
        renderObject(0, 450, 210,180,120,
                "src/main/resources/images/roomAssets/learningDesk.png", "guidebook", "guidebook");
        renderObject(0, 150, 320,60,40,
                "src/main/resources/images/roomAssets/saveBook.png", "diary", "diary");
        renderObject(0, 250, 60,200,150,
                "src/main/resources/images/roomAssets/window.png", "go out", "go out");
        renderObject(0, 210, 350,75,90,
                "src/main/resources/images/roomAssets/bag.png", "inventory", "inventory");

        // Todo: add snack bar to eat 2 snacks before a journey
        panels[0].add(backgrounds[0]);
    }

    public void createTownScene() {
        renderBg(1, "src/main/resources/images/townAssets/townBg.png");

        renderObject(1, 520, 300,160,140,
                "src/main/resources/images/townAssets/armourShop.png", "armour", "armour");
        renderObject(1, 100, 160,160,140,
                "src/main/resources/images/townAssets/weaponShop.png", "weapons", "weapons");
        renderObject(1, 300, 130,150,135,
                "src/main/resources/images/townAssets/merchant.png", "merchant", "merchant");
        renderObject(1, 500, 60,220,140,
                "src/main/resources/images/townAssets/forest.png", "paths", "paths");
        renderObject(1, 30, 370,80,160,
                "src/main/resources/images/townAssets/homeSign.png", "home", "home");
        // render the townsfolk to talk to

        panels[1].add(backgrounds[1]);
    }

}
