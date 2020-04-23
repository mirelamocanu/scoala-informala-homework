import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorBooking {

    public static void main(String[] args) throws SQLException {

        Connection bookingConnection = connectToBooking("mysql", "localhost", "3306", "booking", "root", "2807");
        bookingConnection.close();
    }


    public static Connection connectToBooking(String type, String host, String port, String dbName, String user, String pw) {
        Connection conn = null;
        DriverManager.setLoginTimeout(60);
        try {
            String url = new StringBuilder()
                    .append("jdbc:")
                    .append(type)
                    .append("://")
                    .append(host)
                    .append(":")
                    .append(port)
                    .append("/")
                    .append(dbName)
                    .append("?user=")
                    .append(user)
                    .append("&password=")
                    .append(pw).toString();
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
        }
        return conn;

    }
}
