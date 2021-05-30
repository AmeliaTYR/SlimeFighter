package main.java.items;

import java.util.ArrayList;

public class ItemFns {
    public static int getFirstItemIndexByName(String yourString, ArrayList<Item> itemList) {
        for (int i = 0; i < itemList.size(); i++) {
            String itemName = itemList.get(i).getItemName();
            if (itemName.equals(yourString)) {
                return i;
            }
        }
        return -1;

    }
}
