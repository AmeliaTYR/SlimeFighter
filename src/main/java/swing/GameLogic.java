package main.java.swing;


public class GameLogic {

    public ItemManagementUI itemManagementUI = new ItemManagementUI(this);
    public UI ui = new UI(this);
    public ScenesController scenesController = new ScenesController(this);
    public ObjectClicks objectClicks = new ObjectClicks(this);


    public GameLogic(){

        // start first scene
    }

}
