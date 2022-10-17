/*
Elif Berna Kuru
Orkun Hacılar
Neslihan Özgün
Serhat Çalışkan
 */

import java.util.ArrayList;

// Adaptee
public class MobileDevice implements Device{

    public static void display(ArrayList<Restaurant> restaurants){
        int count = 1;
        for(Restaurant restaurant: restaurants){
            System.out.println(count + ". Name = " + restaurant.getName());
            count++;
        }
    }

    public static void main(String[] args){

        Restaurant restaurant1 = new Restaurant("Domino's", 4, 5);
        Restaurant restaurant2 = new Restaurant("Pizza", 1, 1);
        Restaurant restaurant3 = new Restaurant("Ceaser's", 2, 3);
        Restaurant restaurant4 = new Restaurant("Kent Pizaa", 0, 4);

        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);
        restaurants.add(restaurant4);

        DistributorCenter distributorCenter = new DistributorCenter(restaurants);
        distributorCenter.addTruckDriver();
        distributorCenter.addTruckDriver();
        distributorCenter.addTruckDriver();

        restaurant1.setDistributorCenter(distributorCenter);
        restaurant2.setDistributorCenter(distributorCenter);
        restaurant3.setDistributorCenter(distributorCenter);
        restaurant4.setDistributorCenter(distributorCenter);

        restaurant1.delivery(20);
        restaurant1.delivery(40);
        restaurant1.delivery(20);
        restaurant1.delivery(10);
        restaurant2.delivery(70);

        distributorCenter.inventoryObj.displayInventory();
    }
}

// Adapter
interface Device{
    static void display(ArrayList<Restaurant> restaurants) {}
}
