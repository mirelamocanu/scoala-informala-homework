package Shop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FoodProduct extends Product implements Expirable {
    String expirationDateString;


    public FoodProduct(String name, double price, int quantity, String ageRestriction, String expirationDateString) {
        super(name, price, quantity, ageRestriction);
        this.expirationDateString = expirationDateString;
    }

    public FoodProduct() {
    }

    @Override
    public Date getExpirationDate() throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(expirationDateString);
    }


    @Override
    public double getPrice() throws ParseException {
        Date currDate = new Date();
        if ((getExpirationDate().compareTo(addDays(currDate, 15))) < 0)
            return super.getPrice() * 0.7;
        return super.getPrice();
    }


    /**
     * This method is used to add a no. of days to a certain date.
     *
     * @param date is the actual date (Date object)
     * @param days is the number of days to be added (int variable)
     * @return returns the new date resulted from the addition of the elements above.
     */
    private Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
}
