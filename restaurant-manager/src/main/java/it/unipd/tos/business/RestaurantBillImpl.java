////////////////////////////////////////////////////////////////////
// [Davide] [Liu] [1140717]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

public class RestaurantBillImpl implements RestaurantBill {

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException{
        double price=0;
        int nPizze=0;
        double chipestPizza=-1;
        if(itemsOrdered.size()>20) {
            throw new RestaurantBillException();
        }
        for(MenuItem m: itemsOrdered) {
            price+=m.getPrice();
            if(m.getItemType().equals(MenuItem.itemType.Pizze)) {
                nPizze++;
                if(chipestPizza==-1) {
                    chipestPizza=m.getPrice();
                }
                if(m.getPrice()<chipestPizza) {
                    chipestPizza=m.getPrice();
                }
            }
        }
        if(nPizze>10) {
           price-=chipestPizza;
        }
        if(price>100) {
            price=price*95/100;
        }
        return price;
    }
}
