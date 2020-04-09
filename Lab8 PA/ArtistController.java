package vlad.ArtistDAO;
import vlad.dbConnection.*;
import java.sql.*;

public class ArtistController {
    public void create (String name, String country) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO artists (id,name,country) VALUES(seq_arists.nextval,?,?)"; //typo la arists, my bad
        PreparedStatement pstmt = Database.getConnection().prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setString(2,country);
        pstmt.executeUpdate();
    }
    public int findByName(String name) throws SQLException, ClassNotFoundException {
        String sql = "SELECT id FROM artists WHERE name=?";
        PreparedStatement pstmt = Database.getConnection().prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.executeUpdate();
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        return rs.getInt("id");
    }
}
