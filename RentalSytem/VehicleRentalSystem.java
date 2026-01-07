import java.util.List;
import java.util.ArrayList;

import store.Store;
class VehicleRentalSystem {
    List<Store> stores = new ArrayList<>();

    public List<Store> getStoreByCity(String city) {
        List<Store> result = new ArrayList<>();
        for(Store s : stores) {
            if(s.location.city.equalsIgnoreCase(city)) {
                result.add(s);
            }
        }
        return result;
    }

    public void addStore(Store store) {
        stores.add(store);
        System.out.println("Store with id: " + store.storeId + " city: " + store.location.city + " added to system");
    }
}