package Shop;


import java.text.ParseException;

import static Shop.Product.AGE_RESTRICTION_ADULT_ONLY;
import static Shop.Product.AGE_RESTRICTION_TEENAGER_AND_ABOVE;

public class PurchaseManager {

    public static void processPurchase(Product product, Customer customer) throws ParseException {

        if ((customer.getBalance() - product.getPrice()) < 0) {
            System.out.println("Customer " + customer.getName() + " does not have enough money to buy " + product.getName() + " .");
            return;
        }

        if (product.getQuantity() < 1) {
            System.out.println("Product " + product.getName() + " is out of stock.");
            return;
        }

        if ((product.getAgeRestriction().equals(AGE_RESTRICTION_ADULT_ONLY))) {
            if (customer.getAge() < 18) {
                System.out.println("Customer " + customer.getName() + " does not have the legal age to purchase " + product.getName() + ".");
                return;
            }
        }
        if ((product.getAgeRestriction().equals(AGE_RESTRICTION_TEENAGER_AND_ABOVE))) {
            if (customer.getAge() < 14) {
                System.out.println("Customer " + customer.getName() + " does not have the legal age to purchase " + product.getName() + ".");
                return;
            }
        }

        customer.setBalance(customer.getBalance() - product.getPrice());
        product.setQuantity(product.getQuantity() - 1);

        System.out.println("\nTransaction successful! \nTransaction overview: Customer " + customer.getName() + " has bought " + product.getName() + " at the price of " + product.getPrice() + " .");
        System.out.println("Product overview:" + product.toString());
        System.out.println("Customer overview:" + customer.toString());
    }
}
