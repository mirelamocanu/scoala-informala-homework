public class MainClassDB {

    public static void main(String[] args) {

        BookingInteraction booking = new BookingInteraction();

        booking.insertAccommodationRoom("D", "Double", 4, "Double bed for families of 3/4", 600.00, "In Season");
        booking.insertAccommodationRoom("D", "Double", 4, "Double bed for families of 3/4", 400.00, "Extra Season");
        booking.insertAccommodationRoom("S", "Single", 1, "Single bed for 1", 350.00, "In Season");
        booking.insertAccommodationRoom("S", "Single", 1, "Single bed for 1", 250.00, "Extra Season");
        booking.insertAccommodationRoom("A", "Apartment", 6, "Accommodation for 4 to 6 people", 1200.00, "In Season");
        booking.insertAccommodationRoom("A", "Apartment", 6, "Accommodation for 4 to 6 people", 700.00, "Extra Season");
        booking.insertAccommodationRoom("V", "Villa", 15, "Villa for 10 to 15 people", 4500.00, "In season");
        booking.insertAccommodationRoom("V", "Villa", 15, "Villa for 10 to 15 people", 2500.00, "Extra season");

        booking.getAccommodationPrice();

    }
}
