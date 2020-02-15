public class Country {

    private String countryName;
    private String countryCode;

    public Country() {

    }

    public Country(String countryName, String countryCode) {
        this();
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Country: "
                + countryName + '\'' +
                ", countryCode='" + countryCode + '\'';
    }
}
