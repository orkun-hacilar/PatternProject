/*
Elif Berna Kuru
Orkun Hacılar
Neslihan Özgün
Serhat Çalışkan
 */

import java.util.ArrayList;

// SmallFactories --> factory design pattern

public interface Route {
    ArrayList<Restaurant> calculateRoute(ArrayList<Restaurant> restaurants, ArrayList<Integer> coordinatesX, ArrayList<Integer> coordinatesY);
}

class TCP implements Route{

    @Override
    public ArrayList<Restaurant> calculateRoute(ArrayList<Restaurant> restaurants, ArrayList<Integer> coordinatesX, ArrayList<Integer> coordinatesY) {
        System.out.println("TCP calculated the route");

        return restaurants;
    }
}

class GEN implements Route{

    @Override
    public ArrayList<Restaurant> calculateRoute(ArrayList<Restaurant> restaurants, ArrayList<Integer> coordinatesX, ArrayList<Integer> coordinatesY) {
        System.out.println("GEN calculated the route");

        return restaurants;
    }
}