/*
Elif Berna Kuru
Orkun Hacılar
Neslihan Özgün
Serhat Çalışkan
 */

import java.util.ArrayList;

// Target for Adapter Design pattern

public class TruckDriver {

    // attributes
    Order order;
    private boolean isAvailable;
    static int staticID = 1;
    private int id;
    Route route;
    Device mobileDevice;


    public TruckDriver(){
        isAvailable = true;
        id = staticID;
        staticID++;

        mobileDevice = new MobileDevice();
    }

    public boolean getIsAvailable(){
        return isAvailable;
    }

    public void order(Order order){

        isAvailable = false;

        this.order = order;
        ArrayList<Restaurant> restaurantsToVisit = this.order.supplyOrder(new TCP()); // TCP is the initial value
        Device.display(restaurantsToVisit);

        for(Restaurant restaurant: restaurantsToVisit){
            restaurant.setIsInvNeeded(false);
        }

        isAvailable = true;
    }

    public int getId() {
        return id;
    }
}


interface Order{
    ArrayList<Restaurant> supplyOrder(Route route);
}

class DistributeOrders implements Order{

    int amount;
    ArrayList<Restaurant> restaurants;
    ArrayList<Integer> locX;
    ArrayList<Integer> locY;

    public DistributeOrders(int amount, ArrayList<Restaurant> restaurantss){
        this.amount = amount;
        restaurants = new ArrayList<>();
        for(Restaurant restaurant: restaurantss)
            restaurants.add(restaurant);
    }

    @Override
    public ArrayList<Restaurant> supplyOrder(Route route) {


        /*
        for(Restaurant restaurant: restaurants){
            locX.add(restaurant.getLocX());
            locY.add(restaurant.getLocY());
        }

         */

        ArrayList<Restaurant> restaurantsss = route.calculateRoute(restaurants, locX, locY);
        return restaurantsss;

    }
}


