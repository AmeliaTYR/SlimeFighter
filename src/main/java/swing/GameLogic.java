package main.java.swing;


public class GameLogic {

    public ItemManagementUI itemManagementUI = new ItemManagementUI(this);
    public UI ui = new UI(this);
    public ScenesController scenesController = new ScenesController(this);
    public ObjectClicks objectClicks = new ObjectClicks(this);


    public GameLogic(){
        // start first scene

        // todo: save user basic data (eg level, exp, coins etc)

        // todo: save user statusEffects data

        // todo: save user inventory

        // todo: save user storage

        // todo:  save user gear

        // todo: create alert to show that save was complete
    }

}
