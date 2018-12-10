////////////////////////////////////////////////////////////////////
// [Davide] [Liu] [1140717]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Test;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

public class RestaurantBillImplTest {

	@Test(expected = RestaurantBillException.class)
    public void MoreThan20Elements() throws RestaurantBillException {
        ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
        MenuItem item;
        for(int i = 0 ; i < 21;i++) {
            item = new MenuItem(MenuItem.itemType.Pizze, "Viennese", 7);
            menu.add(item);
        } 
        RestaurantBillImpl rb = new RestaurantBillImpl();
        rb.getOrderPrice(menu);
    }
    @Test
    public void ShowItemNameString() {
        ArrayList<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem(MenuItem.itemType.Pizze, "Diavola", 8));
        assertEquals("Diavola",menu.get(0).getName()); 
    }
    @Test
    public void LessThan10PizzasAndLessThan100TotalPrice() throws RestaurantBillException{
        ArrayList<MenuItem> menu = new ArrayList<>();
        MenuItem item;
        for(int i = 0 ; i < 3;i++) {
            item = new MenuItem(MenuItem.itemType.Pizze, "Margherita", 5);
            menu.add(item);
        }
        RestaurantBillImpl r = new RestaurantBillImpl();
        assertEquals(15, r.getOrderPrice(menu),0.0f);
    }
    
    @Test
    public void MoreThan10PizzasAndLessThan100TotalPrice() throws RestaurantBillException{
        ArrayList<MenuItem> menu = new ArrayList<>();
        MenuItem item;
        for(int i = 0 ; i < 10;i++) {
            item = new MenuItem(MenuItem.itemType.Pizze, "Viennese", 7);
            menu.add(item);
        }
        menu.add(new MenuItem(MenuItem.itemType.Pizze, "Margherita", 5));
        RestaurantBillImpl r = new RestaurantBillImpl();
        assertEquals(70, r.getOrderPrice(menu),0.0f);
    }
    
    @Test
    public void LessThan10PizzasAndMoreThan100TotalPrice() throws RestaurantBillException{
        ArrayList<MenuItem> menu = new ArrayList<>();
        MenuItem item;
        for(int i = 0 ; i < 3;i++) {
            item = new MenuItem(MenuItem.itemType.Pizze, "Margherita", 5);
            menu.add(item);
        }
        for(int i = 0 ; i < 10;i++) {
            item = new MenuItem(MenuItem.itemType.Primi, "Spaghetti al ragu'", 10);
            menu.add(item);
        }
        RestaurantBillImpl r = new RestaurantBillImpl();
        assertEquals(109.25, r.getOrderPrice(menu),0.0f);
    }
    
    @Test
    public void MoreThan10PizzasAndMoreThan100TotalPrice() throws RestaurantBillException{
        ArrayList<MenuItem> menu = new ArrayList<>();
        MenuItem item;
        for(int i = 0 ; i < 11;i++) {
            item = new MenuItem(MenuItem.itemType.Pizze, "Margherita", 5);
            menu.add(item);
        }
        for(int i = 0 ; i < 5;i++) {
            item = new MenuItem(MenuItem.itemType.Primi, "Spaghetti alle vongole", 20);
            menu.add(item);
        }
        RestaurantBillImpl r = new RestaurantBillImpl();
        assertEquals(142.5, r.getOrderPrice(menu),0.0f);
    }
}