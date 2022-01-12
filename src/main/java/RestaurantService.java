import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName){
        boolean foundRestaurant=false;
        for(Restaurant restaurant :restaurants) {
            if (restaurant.getName().equals(restaurantName)) {
                foundRestaurant = true;
                return restaurant;
            }
            if (!foundRestaurant) {
                try {
                    throw new restaurantNotFoundException("Restaurant could not be found");
                } catch (restaurantNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
        return null;

    }
    //ADDED CODE FOR FIND RESTAURANT BY NAME ABOVE



    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
