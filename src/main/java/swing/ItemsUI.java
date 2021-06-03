package main.java.swing;

import main.java.listComponents.DNDList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemsUI {
    /**
     * Open the UI Frame for the storage-inventory shuffling
     */
    public static void openStorageUI() {
        DefaultListModel storage = new DefaultListModel();
        DefaultListModel inventory = new DefaultListModel();

        // todo: check how to get list elements directly from the array

        // todo: for each of the items in the Storage items array

        // populating to move from with strings
        for (int i = 3; i >= 0; i--) {
            storage.add(0, "apple");
        }
        for (int i = 4; i >= 0; i--) {
            storage.add(0, "chicken");
        }
        for (int i = 1; i >= 0; i--) {
            storage.add(0, "brocoli");
        }
        for (int i = 3; i >= 0; i--) {
            storage.add(0, "bread");
        }

        // todo: for each of the items in the inventory items array


        // populating list to move to with strings
        for (int i = 2; i >= 0; i--) {
            inventory.add(0, "cheese");
        }
        for (int i = 3; i >= 0; i--) {
            inventory.add(0, "water");
        }


        //////////// SET UP FRAME
        ImageIcon img = new ImageIcon("src/main/resources/images/SlimeFighterTransparent.png");
        JFrame frame = new JFrame("Access Storage");
        frame.setIconImage(img.getImage());

        //////////// SCROLL PANES PANEL
        JPanel scrollPanesPanel = new JPanel();
        scrollPanesPanel.setLayout(new GridLayout(1, 2));

        DNDList dndListFrom = new DNDList(storage);
        DNDList dndListTo = new DNDList(inventory);

        JScrollPane storageSP = new JScrollPane(dndListFrom);
        storageSP.setPreferredSize(new Dimension(200,400));
        JLabel storageSPHeader = new JLabel("Storage");
        storageSP.setColumnHeaderView(storageSPHeader);

        JScrollPane inventorySP = new JScrollPane(dndListTo);
        inventorySP.setPreferredSize(new Dimension(200,400));
        JLabel inventorySPHeader = new JLabel("Inventory");
        inventorySP.setColumnHeaderView(inventorySPHeader);

        scrollPanesPanel.add(storageSP);
        scrollPanesPanel.add(inventorySP);

        //////////// TEXT PANEL
        // say if add to many items cancel not successful
        // display area for the text below the box
        final JTextArea textArea = new JTextArea(5, 10);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JScrollPane textPanel = new JScrollPane(textArea);

        //////////// BUTTONS PANEL
        JLabel instructionLabel = new JLabel("<html>  Click and Drag  <br>  to move items  </html>");

        // create button for printing to the text area
        JButton confirmButton = new JButton("confirm");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // sort j list items back into array lists
                System.out.println("confirm clicked");
                textArea.append("confirm clicked");
                textArea.append(System.getProperty("line.separator"));
            }
        });

        JButton resetButton = new JButton("reset");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // reset lists
                System.out.println("reset clicked");
                textArea.append("reset clicked");
                textArea.append(System.getProperty("line.separator"));
            }
        });

        JButton clearTextButton = new JButton("clear text");
        clearTextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        // create the panel with the two rows of buttons
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        buttonPanel.add(instructionLabel);
        buttonPanel.add(confirmButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(clearTextButton);

        //////////// ADD TO PANE

        // add the button panels to the pane
        frame.getContentPane().add(scrollPanesPanel, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.EAST);
        frame.getContentPane().add(textPanel, BorderLayout.SOUTH);

        frame.setIconImage(img.getImage());
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        // todo: add on select, preview what the item does (get description from the SQL)
    }

    /**
     * Open UI Frame for the Inventory (using and tossing items)
     */
    public static void openInventoryUI() {

        String stuffs[] = new String[20];

        DefaultListModel from = new DefaultListModel();

        // todo: add the label to indicate the max inventory size

        // todo: add label to indicate the max number of items consumed

        //////////// SET UP FRAME
        ImageIcon img = new ImageIcon("src/main/resources/images/SlimeFighterTransparent.png");
        JFrame frame = new JFrame("Manage Inventory");
        frame.setIconImage(img.getImage());

        ////////////

        // populating to move from with strings
        for (int i = 0; i < 12; i++) {
            stuffs[i] = "Source item " + i;
            //            otherStuffs[otherStuffs.length] = "Target item " + i;
        }

        for (int i = 0; i < stuffs.length; i++){
            from.addElement(stuffs[i]);
        }

        JList itemList = new JList(from);
        itemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


        JScrollPane itemScrollpane = new JScrollPane(itemList);


        //////////// TEXT PANEL
        // say if add to many items cancel not successful
        // display area for the text below the box
        final JTextArea textArea = new JTextArea(5, 10);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JScrollPane textPanel = new JScrollPane(textArea);

        //////////// BUTTONS PANEL
        JLabel instructionLabel = new JLabel("Select items");

        // create button for printing to the text area
        JButton discardButton = new JButton("discard");
        discardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // sort j list items back into array lists
                System.out.println("discard clicked");
                textArea.append("discarded items");
                textArea.append(System.getProperty("line.separator"));

                int[] fromindex = itemList.getSelectedIndices();

                for(int i = (fromindex.length-1); i >=0; i--)
                {
                    textArea.append(from.get(fromindex[i]).toString());
                    textArea.append(System.getProperty("line.separator"));
                    from.remove(fromindex[i]);
                }

            }
        });

        JButton consumeButton = new JButton("consume");
        consumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("consume items");
                // for each item list consumed and stats affected
                textArea.append(System.getProperty("line.separator"));
                // TODO: add stats to stats list when used and remove aws well
            }
        });

        // create the panel with the two rows of buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        buttonPanel.add(instructionLabel);
        buttonPanel.add(discardButton);
        buttonPanel.add(consumeButton);

        //////////// ADD TO PANE

        // add the button panels to the pane
        frame.getContentPane().add(itemScrollpane, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.EAST);
        frame.getContentPane().add(textPanel, BorderLayout.SOUTH);

        frame.setIconImage(img.getImage());
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        // todo: check how to get list elements directly from the array and save on close
    }

    /**
     * Todo: create the UI for the treasure finding inventory management UI
     * (similar to storage, swap with items in the chest found)
     */


    /**
     * Todo: create the UI for the buying of weapons from the store (function with if else for each store
     */

    /**
     * Todo: create the buy mechanic of the merchant store
     */


    /**
     * Todo: create the sell mechanic of the merchant store
     */

}
