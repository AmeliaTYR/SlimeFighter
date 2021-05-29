package main.java.swing;


import main.java.items.UserGear;
import main.java.items.Inventory;
import main.java.items.StatusEffectList;
import main.java.items.StorageItems;

public class GameLogic {

    public ItemManagementUI itemManagementUI = new ItemManagementUI(this);
    public UI ui = new UI(this);
    public ScenesController scenesController = new ScenesController(this);
    public ObjectClicks objectClicks = new ObjectClicks(this);

    public StatusEffectList statusEffectList = new StatusEffectList();
    public StorageItems storageItems = new StorageItems();
    public Inventory inventory = new Inventory();
    public UserGear gear = new UserGear();


    public GameLogic(){
        // start first scene

        // user basic data (eg level, exp, coins etc) to currentUser already on login

        // todo: get user statusEffects data
        StatusEffectList.getAllEffectsFromSaveData();

        // todo: get user inventory
        Inventory.getAllItemsFromDB();

        // todo: get user storage
        StorageItems.getAllItemsFromDB();

        // todo: get user gear
        this.gear.getGearFromDB();

        // todo: create alert to show that load was successful
        System.out.println("load successful");
    }

}
