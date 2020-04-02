import java.sql.*;

public class BookingInteraction {
    /**
     * This method makes inserts into the DB for the tables accommodation and room_fair with the parameters below.
     * It also links these tables to the accomodation_fair_relation table.
     *
     * @param type
     * @param bedType
     * @param maxGuests
     * @param description
     * @param value       The result should look like below:
     * @param season
     */

    public void insertAccommodationRoom(String type, String bedType, Integer maxGuests, String description, Double value, String season) {
        int accommodationID = 0;
        int roomFairID = 0;

        try (Connection bookingConnection = ConnectorBooking.connectToBooking("mysql", "localhost", "3306", "booking", "root", "2807")) {
            bookingConnection.setAutoCommit(false);
            PreparedStatement ps = bookingConnection.prepareStatement("select a.id,a.bed_type,rf.id,rf.season from accomodation a \n" +
                    "join  accomodation_fair_relation  af on a.id=af.id_accomodation\n" +
                    "join room_fair rf on rf.id=af.id_room_fair\n" +
                    "where bed_type like ? ;");
            ps.setString(1, bedType);
            ResultSet result = ps.executeQuery();
           // displayResultSet(result);

            boolean hasNext=result.next();

            if (hasNext) {
                do {
                    if (bedType.equalsIgnoreCase(result.getString("a.bed_type"))) {
                        if (season.equalsIgnoreCase(result.getString("rf.season"))) {
                            System.out.println("Already in the database");
                            return;
                        } else {
                            accommodationID = result.getInt("a.id");
                            roomFairID = insertRoomFair(value, season);
                        }
                    } else {
                        accommodationID = insertAccommodation(type, bedType, maxGuests, description);
                        roomFairID = insertRoomFair(value, season);
                    }
                } while (result.next());
            } else {
                accommodationID = insertAccommodation(type, bedType, maxGuests, description);
                roomFairID = insertRoomFair(value, season);
            }
            PreparedStatement ps3 = bookingConnection.prepareStatement("insert into accomodation_fair_relation (id_accomodation,id_room_fair) values (?,?);");
            if (accommodationID != 0 && roomFairID != 0) {
                ps3.setInt(1, accommodationID);
                ps3.setInt(2, roomFairID);
                ps3.executeUpdate();
                System.out.println("Database transaction done! ");
            }
            bookingConnection.commit();
            bookingConnection.setAutoCommit(true);
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());

        }

    }
    private int insertAccommodation(String type, String bedType, Integer maxGuests, String description) {
        int accommodationID = 0;
        try (Connection bookingConnection = ConnectorBooking.connectToBooking("mysql", "localhost", "3306", "booking", "root", "2807")) {
            PreparedStatement ps1 = bookingConnection.prepareStatement("insert into accomodation (type, bed_type, max_guests, description) values (?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
            ps1.setString(1, type);
            ps1.setString(2, bedType);
            ps1.setInt(3, maxGuests);
            ps1.setString(4, description);
            ps1.executeUpdate();
            ResultSet rs1 = ps1.getGeneratedKeys();
            if (rs1.next())
                accommodationID = rs1.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accommodationID;
    }

    private int insertRoomFair(Double value, String season) {
        int roomFairID = 0;
        try (Connection bookingConnection = ConnectorBooking.connectToBooking("mysql", "localhost", "3306", "booking", "root", "2807")) {
            PreparedStatement ps2 = bookingConnection.prepareStatement("insert into room_fair (value,season) values (?,?);", Statement.RETURN_GENERATED_KEYS);
            ps2.setDouble(1, value);
            ps2.setString(2, season);
            ps2.executeUpdate();

            ResultSet rs2 = ps2.getGeneratedKeys();

            if (rs2.next())
                roomFairID = rs2.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomFairID;
    }


    /**
     * This method selects all the available rooms/accommodation and displays the prices.
     * <p>
     * Bed Type                     Description       Value           Season
     * Villa          Villa for 10 to 15 people      4500.0        In season
     * Villa          Villa for 10 to 15 people      2500.0     Extra season
     * Apartment    Accommodation for 4 to 6 people  1200.0        In Season
     * Apartment    Accommodation for 4 to 6 people   700.0     Extra Season
     * Double     Double bed for families of 3/4      600.0        In Season
     * Double     Double bed for families of 3/4      400.0     Extra Season
     * Single                   Single bed for 1      350.0        In Season
     * Single                   Single bed for 1      250.0     Extra Season
     */


    public void getAccommodationPrice() {
        final String format = "%10s%35s%10s%17s\n";
        try (Connection bookingConnection = ConnectorBooking.connectToBooking("mysql", "localhost", "3306", "booking", "root", "2807")) {
            PreparedStatement ps = bookingConnection.prepareStatement("select a.bed_type,a.description,rf.value,rf.season from accomodation a \n" +
                    "join  accomodation_fair_relation  af on a.id=af.id_accomodation\n" +
                    "join room_fair rf on rf.id=af.id_room_fair" +
                    " order by value desc;");
            ResultSet result = ps.executeQuery();
            boolean hasNext = result.next();
            if (hasNext) {
                System.out.format(format, "Bed Type", "Description", "Value", "Season");
                do {
                    System.out.format(format,
                            result.getString("bed_type"),
                            result.getString("description"),
                            result.getString("value"),
                            result.getString("season")
                    );
                } while (result.next());
            } else {
                System.out.println("No results!");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("Showing ResultSet");
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
    }
}
