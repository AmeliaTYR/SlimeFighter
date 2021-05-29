package main.java.swing;

public class objectClicks {

    GameLogic gameLogic;

    public objectClicks(GameLogic gameLogic){
        this.gameLogic = gameLogic;
    }

    public static void objectClicked(String action) {
        switch(action){

            // user room items
            case "rest": {
                // restore currentPlayer hp and mp to max
                System.out.println("User is resting");
                break;
            }
            case "storage": {
                System.out.println("opened inventory");
                break;
            }
            case "guidebook": {
                System.out.println("Go to guidebook");
                break;
            }
            case "diary": {
                System.out.println("go to user page");
                break;
            }
            case "go out": {
                // switch scene to town scene
                System.out.println("head to town");
                break;
            }
            case "inventory": {
                // bring up option for take or store
                System.out.println("open inventory");
                break;
            }

            // town items (double value when buy)
            case "armour": {
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
