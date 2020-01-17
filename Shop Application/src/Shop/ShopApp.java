package Shop;

import java.text.ParseException;

public class ShopApp {
    public static void main(String[] args) throws ParseException {

        FoodProduct milk = new FoodProduct("Napolact", 5.0, 100, Product.AGE_RESTRICTION_NONE, "2020-02-02");
        FoodProduct bread = new FoodProduct("Vel Pitar", 3, 0, Product.AGE_RESTRICTION_NONE, "2020-01-08");

        Computer comp1 = new Computer("Dell computer", 1500, 50, Product.AGE_RESTRICTION_TEENAGER_AND_ABOVE, 24);
        Computer comp2 = new Computer("Toshiba computer", 2500, 1100, Product.AGE_RESTRICTION_TEENAGER_AND_ABOVE, 24);


        Appliance toaster = new Appliance("Phillips Toaster", 300, 40, Product.AGE_RESTRICTION_ADULT_ONLY, 6);
        Appliance coffeeMaker = new Appliance("Krups Espresso Machine", 1000, 100, Product.AGE_RESTRICTION_ADULT_ONLY, 6);

        Customer Daniel = new Customer("Daniel", 30, 5000);
        Customer Ana = new Customer("Ana", 22, 100);
        Customer George = new Customer("George", 15, 500);
        Customer Irina = new Customer("Irina", 12, 1500);

        // All conditions met - For FoodProduct - returns 70% of the price if the product expires in 15 days time
        PurchaseManager.processPurchase(milk, Ana);

        //For appliance - returns 105% of the price if the quantity is less than 50
        PurchaseManager.processPurchase(toaster, Daniel);

        // For computer - returns 95% of the price if the quantity is over 1000.
        PurchaseManager.processPurchase(comp2, Daniel);

        //If the buyer does not have enough money
        PurchaseManager.processPurchase(coffeeMaker, Ana);

        //  If the buyer does not have permission to purchase the given product
        PurchaseManager.processPurchase(toaster, George);
        PurchaseManager.processPurchase(comp1, Irina);

        //  If the product is out of stock
        PurchaseManager.processPurchase(bread, George);
    }

}






