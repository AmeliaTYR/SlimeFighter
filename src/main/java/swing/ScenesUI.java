package main.java.swing;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

public class ScenesUI {

    GameLogic gameLogic;

    TravellingUI travellingUI;

    JFrame frame;

    public JPanel panels[] = new JPanel[9];
    public JPanel bkPgPanels[] = new JPanel[3];

    // create an array of background labels for each of the scenes
    public JLabel backgrounds[] = new JLabel[9];
    public JLabel bkPagesBg = new JLabel();


    public ScenesUI(GameLogic gameLogic) {
        this.gameLogic = gameLogic;

        // create main scenes
        createMainWindow();
        createHomeScene();
        createTownScene();
        createTravellingScene();

        // create book window scenes
        createBkPgBg("src/main/resources/images/journalAssets/bookBg.png");
//        createBkPg0();
//        createBkPg1();
//        createBkPg2();

        // Todo: add create for all the other scenes
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

    public void renderBookBg(int panelNum){
        bkPgPanels[panelNum] = new JPanel(); // recreate panel
        bkPgPanels[panelNum].setBounds(20,20,740,520);
        bkPgPanels[panelNum].setBackground(Color.blue);
        bkPgPanels[panelNum].setLayout(null);
        bkPgPanels[panelNum].setVisible(true);
        frame.add(bkPgPanels[panelNum]);


    }

    public void createBkPgBg(String bgFileName) {
        bkPagesBg = new JLabel();
        bkPagesBg.setBounds(0,0,740,520);

        // get the image to be rendered
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(bgFileName));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Object image file not read");
        }

        Image dimg = img.getScaledInstance(bkPagesBg.getWidth(), bkPagesBg.getHeight(),
                Image.SCALE_SMOOTH);

        ImageIcon bgIcon = new ImageIcon(dimg);

        bkPagesBg.setIcon(bgIcon);
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
                             String fileName, String objectText, String clickAction, Boolean inMain) {
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

        objLabel.setIcon(objIcon); // use the loaded sprite image

        objLabel.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) { }
            public void mousePressed(MouseEvent e) {
                // on left mouse click
                if (SwingUtilities.isLeftMouseButton(e)){
                    // apply action
                    ObjectClicks.objectClicked(clickAction, gameLogic);
                }
            }
            public void mouseReleased(MouseEvent e) { }
            public void mouseEntered(MouseEvent e) { }
            public void mouseExited(MouseEvent e) { }
        });

        objLabel.setToolTipText(objectText);

        if (inMain){
            // render it in main page
            panels[panelNum].add(objLabel);
        } else {
            // render it in the book
            bkPgPanels[panelNum].add(objLabel);
        }


    }

    /**
     * Render in the objects in the home as well as the background
     */
    public void createHomeScene() {
        renderBg(0, "src/main/resources/images/roomAssets/roomBg.png");

        renderObject(0, 590, 400,110,90,
                "src/main/resources/images/roomAssets/chest.png", "storage", "storage", true);
        renderObject(0, 130, 210,180,120,
                "src/main/resources/images/roomAssets/bed.png", "rest", "rest", true);
        renderObject(0, 450, 210,180,120,
                "src/main/resources/images/roomAssets/learningDesk.png", "guidebook", "guidebook", true);
        renderObject(0, 150, 340,60,40,
                "src/main/resources/images/roomAssets/saveBook.png", "journal", "journal", true);
        renderObject(0, 250, 60,200,150,
                "src/main/resources/images/roomAssets/window.png", "go out", "go out", true);
        renderObject(0, 210, 350,75,90,
                "src/main/resources/images/roomAssets/bag.png", "inventory", "inventory", true);
        renderObject(0, 40, 390,100,100,
                "src/main/resources/images/roomAssets/combatGear.png", "armour", "armour", true);

        panels[0].add(backgrounds[0]);
    }

    /**
     * Create the objects in the town and add the background to the scene
     */
    public void createTownScene() {
        renderBg(1, "src/main/resources/images/townAssets/townBg.png");

        renderObject(1, 520, 300,160,140,
                "src/main/resources/images/townAssets/armourShop.png", "armoury", "armoury", true);
        renderObject(1, 100, 160,160,140,
                "src/main/resources/images/townAssets/weaponShop.png", "weapons", "weapons", true);
        renderObject(1, 300, 130,150,135,
                "src/main/resources/images/townAssets/merchant.png", "merchant", "merchant", true);
        renderObject(1, 500, 60,220,140,
                "src/main/resources/images/townAssets/forest.png", "explore paths", "paths", true);
        renderObject(1, 30, 370,80,160,
                "src/main/resources/images/townAssets/homeSign.png", "home", "home", true);
        // todo: render the townsfolk to talk to

        panels[1].add(backgrounds[1]);
    }

    /**
     * Create the scene where the player is moving across a forest on screen
     */
    public void createTravellingScene() {
        panels[3] = new TravellingUI();
        frame.add(panels[3]);
    }

    /** create an array of panels for the different scenes
     *  panels[]
     *  [0]home, [1]town, [2], [3]travelling,
     *  [4]combat, [5]loot, [6]conversation,
     *
     *  bookPanels[]
     *  book pages now as their own separate window!!!
     *  [0]bookPg1, [1]bookPg2, [2]bookPg3
     */
    public void createCombatScene() {
        renderBg(4, "src/main/resources/images/townAssets/townBg.png");

        renderObject(4, 520, 300,160,140,
                "src/main/resources/images/townAssets/armourShop.png", "armour", "armour", true);
        renderObject(4, 100, 160,160,140,
                "src/main/resources/images/townAssets/weaponShop.png", "weapons", "weapons", true);
        renderObject(4, 300, 130,150,135,
                "src/main/resources/images/townAssets/merchant.png", "merchant", "merchant", true);
        renderObject(4, 30, 370,80,160,
                "src/main/resources/images/townAssets/homeSign.png", "home", "home", true);
        // todo: render the townsfolk to talk to

        panels[4].add(backgrounds[4]);
    }

    /**
     * Create the first of the stats book pages (also the access point for saving if not travelling)
     */
    public void createBkPg0() {
        renderBookBg(0);

        renderObject(0, 520, 300,160,140,
                "src/main/resources/images/townAssets/armourShop.png", "armour", "toPg1", false);
        renderObject(0, 100, 160,160,140,
                "src/main/resources/images/townAssets/weaponShop.png", "weapons", "weapons", false);
        renderObject(0, 300, 130,150,135,
                "src/main/resources/images/townAssets/merchant.png", "merchant", "merchant", false);

        bkPgPanels[0].add(bkPagesBg);
    }

    /**
     * Create second of the stats book pages
     */
    public void createBkPg1() {
        renderBookBg(1);

        renderObject(1, 520, 300,160,140,
                "src/main/resources/images/townAssets/armourShop.png", "armour", "toPg0", false);
        renderObject(1, 100, 160,160,140,
                "src/main/resources/images/townAssets/weaponShop.png", "weapons", "toPg2", false);
        renderObject(1, 300, 130,150,135,
                "src/main/resources/images/townAssets/merchant.png", "merchant", "merchant", false);

        bkPgPanels[1].add(bkPagesBg);
    }

    /**
     * Create the third of the stats book pages
     */
    public void createBkPg2() {
        renderBookBg(2);

        renderObject(2, 520, 300,160,140,
                "src/main/resources/images/townAssets/armourShop.png", "armour", "toPg1", false);
        renderObject(2, 100, 160,160,140,
                "src/main/resources/images/townAssets/weaponShop.png", "weapons", "weapons", false);
        renderObject(2, 300, 130,150,135,
                "src/main/resources/images/townAssets/merchant.png", "merchant", "merchant", false);

        bkPgPanels[2].add(bkPagesBg);
    }






}
