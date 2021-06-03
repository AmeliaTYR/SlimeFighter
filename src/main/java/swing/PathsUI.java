package main.java.swing;

import main.java.Main;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PathsUI {

    public GameLogic gameLogic;

    public static String pathSelected = "meadow";

    public PathsUI(GameLogic gameLogic){
        this.gameLogic = gameLogic;
    }


    public static void openPathSelectionUI(GameLogic gameLogic) {
        // switch case for each of the levels
        // add labels to allow adding for each of the paths

        //////////// SET UP FRAME
        ImageIcon img = new ImageIcon("src/main/resources/images/SlimeFighterTransparent.png");
        JFrame frame = new JFrame("Explore Paths");
        frame.setIconImage(img.getImage());


        //////////// TEXT PANEL
        final JTextArea textArea = new JTextArea(4, 10);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JScrollPane textPanel = new JScrollPane(textArea);

        //////////// PATHS PANEL

        JPanel pathButtonsPanel = new JPanel(new FlowLayout());
        pathButtonsPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        // add first level path by default
        JButton level1PathBtn = new JButton("breezy meadow");
        level1PathBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // sort j list items back into array lists
                pathSelected = "breezy meadow";
                System.out.println("breezy meadow selected");
                textArea.setText("");
                textArea.append("Breezy meadow is a small calm place to explore near the village");
                textArea.append(System.getProperty("line.separator"));
            }
        });
        pathButtonsPanel.add(level1PathBtn);

        if (Main.currentUser.getLevel() > 10) {
            // add second level path by default
            JButton level2PathBtn = new JButton("softwood forest");
            level2PathBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // sort j list items back into array lists
                    pathSelected = "softwood forest";
                    System.out.println("softwood forest selected");
                    textArea.setText("");
                    textArea.append("Softwood forest is where the villagers go to gather wood");
                    textArea.append(System.getProperty("line.separator"));
                }
            });
            pathButtonsPanel.add(level2PathBtn);

            if (Main.currentUser.getLevel() > 20) {
                // add second level path by default
                JButton level3PathBtn = new JButton("somber woods");
                level3PathBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // sort j list items back into array lists
                        pathSelected = "somber woods";
                        System.out.println("somber woods selected");
                        textArea.setText("");
                        textArea.append("Somber woods has a dark past. Few villagers visit, fewer return.");
                        textArea.append(System.getProperty("line.separator"));
                    }
                });
                pathButtonsPanel.add(level3PathBtn);

                if (Main.currentUser.getLevel() > 30) {
                    // add second level path by default
                    JButton level4PathBtn = new JButton("tiptoe meadow");
                    level4PathBtn.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // sort j list items back into array lists
                            pathSelected = "tiptoe meadow";
                            System.out.println("tiptoe meadow selected");
                            textArea.setText("");
                            textArea.append("Many warn not to make a sound in tiptoe meadow.");
                            textArea.append(System.getProperty("line.separator"));
                        }
                    });
                    pathButtonsPanel.add(level4PathBtn);

                    if (Main.currentUser.getLevel() > 40) {
                        // add second level path by default
                        JButton level5PathBtn = new JButton("forgotten woods");
                        level5PathBtn.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                // sort j list items back into array lists
                                pathSelected = "forgotten woods";
                                System.out.println("forgotten woods");
                                textArea.setText("");
                                textArea.append("The forgotten woods is a place of lost memories");
                                textArea.append(System.getProperty("line.separator"));
                            }
                        });
                        pathButtonsPanel.add(level5PathBtn);
                    }
                }
            }
        }

        //////////// BUTTONS PANEL

        // create button for printing to the text area
        JButton turnBackButton = new JButton("Turn Back");
        turnBackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // sort j list items back into array lists
                System.out.println("Turn Back clicked");
                textArea.append("Return to village");
                textArea.append(System.getProperty("line.separator"));

                // close the current window for the path selector
                frame.dispose();



            }
        });

        JButton letsGoButton = new JButton("Let's go!");
        letsGoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Let's go! clicked");
//                textArea.append("Let's go!");
//                textArea.append(System.getProperty("line.separator"));

                // wait a while after updating text
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException interruptedException) {
//                    System.out.println("sleep interrupted");
//                }

                // todo: run function to start travel sequence passing the path as a parameter
                gameLogic.scenesController.changeToTravellingScene();

                // close the current window for the path selector
                frame.dispose();



            }
        });

        // create the panel with the two rows of buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2,1));
        buttonPanel.add(turnBackButton);
        buttonPanel.add(letsGoButton);

        //////////// ADD TO PANE

        // add the button panels to the pane
        frame.getContentPane().add(pathButtonsPanel, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.EAST);
        frame.getContentPane().add(textPanel, BorderLayout.SOUTH);

        frame.setIconImage(img.getImage());
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }




}
