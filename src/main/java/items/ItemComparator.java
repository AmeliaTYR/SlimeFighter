package main.java.items;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o1.getItemName().compareTo(o2.getItemName());
    }
}
