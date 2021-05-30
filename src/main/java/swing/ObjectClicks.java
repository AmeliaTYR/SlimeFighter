package main.java.swing;

import main.java.Main;
import main.java.items.Inventory;
import main.java.items.StatusEffectList;
import main.java.items.StorageItems;

import javax.swing.JOptionPane;

import static main.java.swing.ItemsUI.openInventoryUI;
import static main.java.swing.ItemsUI.openStorageUI;

public class ObjectClicks {

    GameLogic gameLogic;

    public ObjectClicks(GameLogic gameLogic){
        this.gameLogic = gameLogic;
    }

    public static void objectClicked(String action, GameLogic gameLogic) {

        switch(action){

            // user room items
            case "rest": {
                // restore currentPlayer hp and mp to max
                int dialogButton = JOptionPane.YES_NO_OPTION;
                dialogButton = JOptionPane.showConfirmDialog(null, "Rest restores hp & mp AND clears stats. Rest?","Warning", dialogButton);

                if (dialogButton == JOptionPane.YES_OPTION) {
                    // restore currentUser hp and mp to max based on level
                    // clear stats array
                    System.out.println("user choose to rest");
                    StatusEffectList.restClearAllStats();
                } else {
                    System.out.println("user did not rest");
                }

                break;
            }
            case "storage": {
                System.out.println("opened storage");
                openStorageUI();
                break;
            }
            case "guidebook": {
//                StorageItems.addWater(); // for testing db
                System.out.println("Go to guidebook");
                break;
            }
            case "journal": {
                System.out.println("go to in game stats page");

                // todo: move save options to inside book
                Main.currentUser.savePlayerDataToDB();
                StatusEffectList.saveCurrentStats();
                Inventory.saveInventorytoDB();
                StorageItems.saveStorageToDB();
                gameLogic.gear.saveUserGeartoDB();

                // todo: create alert to show that save was complete
                System.out.println("save complete");
                break;
            }
            case "go out": {
                // switch scene to town scene
                System.out.println("head to town");
                gameLogic.scenesController.changeToTownScene();
                System.out.println("made it to town");
                break;
            }
            case "inventory": {
                // bring up option for take or store
                System.out.println("open inventory");
                openInventoryUI();

                break;
            }
            case "armour": {
                System.out.println("change armour");
                break;
            }

            // town items (double value when buy)
            case "armoury": {
                // buy armour only
                // open shop interface for armour
                System.out.println("go to armour shop");
                break;
            }
            case "weapons": {
                // buy weapons only
                // open shop interface for weapons
                System.out.println("visit weapons smith");
                break;
            }
            case "merchant": {
                // buy or sell
                // open option for either buy or sell
                System.out.println("trade with merchant");
                break;
            }
            case "paths": {
                // switch scene to paths scene
                System.out.println("explore paths");
                break;
            }
            case "home": {
                // switch scene to home scene
                System.out.println("go back home");
                gameLogic.scenesController.changeToHomeScene();
                System.out.println("scene changed to home");
                break;
            }

            // fight clicks

            // no item detected
            default:{
                System.out.println("No action matched");
            }
        }
    }


}
