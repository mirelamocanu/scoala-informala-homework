package Shop;

import java.text.ParseException;

public class Computer extends ElectronicProduct {


    public Computer() {
    }

    public Computer(String name, double price, int quantity, String ageRestriction, int guaranteePeriod) {
        super(name, price, quantity, ageRestriction, 24);
      //  setGuaranteePeriod(24);
    }


    @Override
    public double getPrice() throws ParseException {
       if ( getQuantity()>1000)
           return super.getPrice()*0.95;
       return  super.getPrice();
    }
}
