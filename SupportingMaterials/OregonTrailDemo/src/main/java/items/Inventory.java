package items;

import java.util.Random;

public enum Inventory {
    WHEEL,
    AXLE,
    MEDICINE,
    KNIFE,
    BLANKET;

    private static Inventory[] list = Inventory.values();

    public static Inventory getItem(int i) {
        return list[i];
    }

    public static Inventory getRandomItem(){
        Random rand = new Random();

        // Generate random int in range 0 to size of list
        int randomInt = rand.nextInt(list.length);

        return Inventory.getItem(randomInt);

    }
}
