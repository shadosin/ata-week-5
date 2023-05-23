package abilities;

import items.Inventory;

import java.util.ArrayList;
import java.util.List;

public interface Trading {
    //you can have static variables
    static final List<String> AvailableSupplies = new ArrayList<>();

    //abstract method - must implement
    String trade(int food);


    //you can have provided functions - can be static or default
    static Inventory getInventoryItem(){
        return Inventory.getRandomItem();
    }


}
