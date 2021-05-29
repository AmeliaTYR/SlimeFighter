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
                System.out.println("head to town");
                break;
            }
            case "inventory": {
                System.out.println("open inventory");
                break;
            }

            // town items
            case "armour": {
                // buy armour only
                System.out.println("go to armour shop");
                break;
            }
            case "weapons": {
                // buy weapons only
                System.out.println("visit weapons smith");
                break;
            }
            case "merchant": {
                // buy or sell
                System.out.println("trade with merchant");
                break;
            }
            case "paths": {
                System.out.println("explore paths");
                break;
            }
            case "home": {
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
