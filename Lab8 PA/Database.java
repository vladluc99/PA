package vlad.dbConnection;
import java.sql.*;

public class Database {
    private static Connection con;

    private Database() {
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (con == null) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "STUDENT");
        }
        return con;
    }

    public static void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
