/*
Elif Berna Kuru
Orkun Hacılar
Neslihan Özgün
Serhat Çalışkan
 */

import java.util.HashMap;
import java.util.Map;

// SingleInstance --> Singleton Design Pattern
// Stock --> Command Design Pattern

public class Inventory {

    private static Inventory instance = new Inventory();
    private HashMap<Integer, Integer> inventory = new HashMap<>();
    private final int threshold = 20;

    private Inventory() {}

    public static Inventory getInstance() {
        return instance;
    }

    public void updateDatabase(int id, int value){
        if(inventory.keySet().contains(id)){
            inventory.put(id, inventory.get(id) + value);
            System.out.println("The restaurant with id " + id + " now has inventory of " + inventory.get(id));
            return;
        }

        System.out.println("There is no such restaurant with id " + id);
    }

    public void initialize(HashMap<Integer, Integer> invent) {

        for (Map.Entry<Integer, Integer> key : invent.entrySet()) {
            inventory.put(key.getKey(), key.getValue());
        }

    }

    public boolean isSupplyNeededFor(int ID){
        if(inventory.get(ID) < threshold)
            return true;

        return false;
    }

    public void makeDeliveryFor(int ID, int amount){
        inventory.put(ID, inventory.get(ID) - amount);

        System.out.println("The delivery of " + amount + " is made.");
        System.out.println("The restaurant with id = " + ID + " now has inventory of " + inventory.get(ID));
    }

    public void displayInventory(){
        for (Map.Entry<Integer, Integer> key : inventory.entrySet()) {
            System.out.println("ID = " + key.getKey() + " Inventory = " + key.getValue());
        }
    }
}
