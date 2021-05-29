package main.java.constants;

import java.util.HashMap;
import java.util.Map;

public enum PanelNums {
    HOME(0),
    TOWN(1),
    PATHS(2),
    TRAVELLING(3),
    COMBAT(4),
    LOOT(5),
    INVENTORY(6),
    STORY(7);


    private int value;

    private static Map map = new HashMap<>();

    private PanelNums(int value) {
        this.value = value;
    }

    static {
        for (PanelNums pageType : PanelNums.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static PanelNums valueOf(int pageType) {
        return (PanelNums) map.get(pageType);
    }

    public int getValue() {
        return value;
    }
}
