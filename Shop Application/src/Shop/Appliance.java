package Shop;

import java.text.ParseException;

public class Appliance extends ElectronicProduct {
    public Appliance(String name, double price, int quantity, String ageRestriction, int guaranteePeriod) {
        super(name, price, quantity, ageRestriction, 6);
    }

    @Override
    public double getPrice() throws ParseException {
        if (getQuantity()<50)
            return super.getPrice()*1.05;

        return super.getPrice();
    }
}
