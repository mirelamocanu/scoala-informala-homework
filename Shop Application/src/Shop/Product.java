package Shop;

import java.text.ParseException;

public class Product implements Buyable {
    public static final String AGE_RESTRICTION_NONE = "none";
    public static final String AGE_RESTRICTION_TEENAGER_AND_ABOVE = "Teenager";
    public static final String AGE_RESTRICTION_ADULT_ONLY = "Adult";

    private String name;
    private double price;
    private int quantity;
    private String ageRestriction;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() throws ParseException {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(String ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public Product() {

    }

    public Product(String name, double price, int quantity, String ageRestriction) {
        this();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ageRestriction = ageRestriction;
    }

    @Override
    public String toString() {
        return "Product name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", ageRestriction='" + ageRestriction + '\''
                ;
    }

}
