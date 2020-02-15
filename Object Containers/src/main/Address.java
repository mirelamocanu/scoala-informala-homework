public class Address {

    private String street;
    Country country;

    public Address(String street, Country country) {
        this.street = street;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "street='" + street + '\'' +
                country;
    }
}
