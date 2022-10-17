/*
Elif Berna Kuru
Orkun Hacılar
Neslihan Özgün
Serhat Çalışkan
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Restaurant {

    private int ID;
    private String name;
    private boolean isInvNeeded;
    private int locX;
    private int locY;
    static int staticID = 1;
    private DistributorCenter distributorCenter; // observer

    public Restaurant(String name, int locX, int locY) {
        ID = staticID;
        staticID++;
        this.name = name;
        this.locX = locX;
        this.locY = locY;
        isInvNeeded = false;
    }

    public void setIsInvNeeded(boolean isInvNeeded){
        this.isInvNeeded = isInvNeeded;
    }

    public boolean getIsInvNeeded(){
        return isInvNeeded;
    }

    public void notifyObserver(int amount){
        System.out.println("Distributor Center is notified for the inventory change for " + amount);
        distributorCenter.updateRestaurant(ID, amount);
    }

    public int getID(){
        return ID;
    }


    public int getLocX() {
        return locX;
    }

    public int getLocY() {
        return locY;
    }

    public String getName() {
        return name;
    }

    public void delivery(int amount){
        System.out.println("Restaurant " + name + " will do a delivery using " + amount + " supplies.");
        notifyObserver(amount);

        System.out.println("Delivery is successful\n\n\n");
    }


    public void setDistributorCenter(DistributorCenter distributorCenter) {
        this.distributorCenter = distributorCenter;
    }
}

// Observer --> Observer Design pattern
// Factory --> Factory Design pattern
// CommandManager --> Command Design Pattern

class DistributorCenter {

    // attributes
    Inventory inventoryObj = Inventory.getInstance();
    private ArrayList<Restaurant> restaurants;
    private ArrayList<TruckDriver> truckDrivers = new ArrayList<>();

    public DistributorCenter(ArrayList<Restaurant> restaurants){
        this.restaurants = restaurants;

        HashMap<Integer, Integer> invt = new HashMap<>();

        for(Restaurant restaurant: restaurants){
            invt.put(restaurant.getID(), 100);
        }
        inventoryObj.initialize(invt);
    }

    public void updateRestaurant(int id, int amount){
        inventoryObj.makeDeliveryFor(id, amount);

        for(Restaurant restaurant: restaurants){
            if(restaurant.getID() == id && inventoryObj.isSupplyNeededFor(id)){
                // supply
                System.out.println("The restaurant " + restaurant.getName() + " needs supply.");
                for(TruckDriver truckDriver: truckDrivers){
                    if(truckDriver.getIsAvailable()){
                        System.out.println("Truck Driver with ID " + truckDriver.getId() + " is called.");
                        truckDriver.order(new DistributeOrders(50, restaurants));
                        break;
                    }
                }

                // database update
                inventoryObj.updateDatabase(restaurant.getID(), 50);
            }
        }
    }

    public void addTruckDriver(){
        truckDrivers.add(new TruckDriver());
    }

}

