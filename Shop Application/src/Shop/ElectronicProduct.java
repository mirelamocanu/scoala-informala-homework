package Shop;

public class ElectronicProduct extends Product {
    private int guaranteePeriod;

    public int getGuaranteePeriod() {

        return guaranteePeriod;
    }

    public void setGuaranteePeriod(int guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }


    public ElectronicProduct(int guaranteePeriod) {

        this.guaranteePeriod = guaranteePeriod;
    }

    public ElectronicProduct() {

    }

    public ElectronicProduct(String name, double price, int quantity, String ageRestriction, int guaranteePeriod) {
        super(name, price, quantity, ageRestriction);
        this.guaranteePeriod = guaranteePeriod;
    }

    @Override
    public String toString() {
        return super.toString() +
                " ,guaranteePeriod='" + guaranteePeriod + '\'';
    }
}
