package vlad.AlbumDao;
import vlad.dbConnection.*;
import java.sql.*;

public class AlbumController {
    public void create (String name,int artistID, int release_year) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO albums (id,name,artist_id,release_year) VALUES(seq_albums.nextval,?,?,?)"; //typo la arists, my bad
        PreparedStatement pstmt = Database.getConnection().prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setInt(3,release_year);
        pstmt.setInt(2,artistID);
        pstmt.executeUpdate();
    }

    public int findByArtist(int artistId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT id FROM albums WHERE artist_id=?";
        PreparedStatement pstmt = Database.getConnection().prepareStatement(sql);
        pstmt.setInt(1,artistId);
        pstmt.executeUpdate();
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        return rs.getInt("id");
    }
}
