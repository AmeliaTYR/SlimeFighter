package main.java.items;

import java.util.ArrayList;

/**
 * Class to generate and store the items that appear
 * in the store between each trip and play session
 * fresh list every time the user logs in or returns from an adventure
 */
public class Stores {
    public boolean weaponsStoreGenerated = false;
    public boolean armourStoreGenerated = false;
    public boolean merchantStoreGenerated = false;

    public static ArrayList<Item> weaponsStoreItems = new ArrayList<>();
    public static ArrayList<Item> armourStoreItems = new ArrayList<>();
    public static ArrayList<Item> merchantStoreItems = new ArrayList<>();

    // Todo: create funtion to populate weapon store with some weapons of different rarity
    // depending on the level of the user


    // Todo: create funtion to populate armour store with some armour of different rarity
    // depending on the level of the user


    // Todo: create funtion to populate consumable store with some consumables of different rarity
    // depending on the level of the user



}
