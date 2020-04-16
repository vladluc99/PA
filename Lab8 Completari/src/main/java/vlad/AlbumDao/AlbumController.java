package vlad.AlbumDao;
import com.github.javafaker.Faker;
import vlad.dbConnection.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumController {
    public void create (String name,int artistID, int release_year) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO albums (id,name,artist_id,release_year) VALUES(seq_albums.nextval,?,?,?)";
        PreparedStatement pstmt = Database.getConnection().prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setInt(3,release_year);
        pstmt.setInt(2,artistID);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public List<Album> findByArtist(int artistId) throws SQLException, ClassNotFoundException {
        List<Album> albumsList = new ArrayList<>();
        String sql = "SELECT * FROM albums WHERE artist_id=?";
        PreparedStatement pstmt = Database.getConnection().prepareStatement(sql);
        pstmt.setInt(1,artistId);
        pstmt.executeUpdate();
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            albumsList.add(new Album(rs.getInt("id"),rs.getString("name"),rs.getInt("artist_id"),rs.getInt("release_year")));
        }
        pstmt.close();
        return albumsList;
    }
    public void generateAlbums(int count) throws SQLException, ClassNotFoundException {
        for(int i=0; i< count; i++)
        {
            Faker faker = new Faker();
            String sql = "INSERT INTO albums (id,name,artist_id,release_year) VALUES(seq_albums.nextval,?,?,?)";
            PreparedStatement pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.setString(1, faker.color().name()+" "+ faker.pokemon().name()); //nu era albums sau songs asa ca a trebuit sa fiu creativ
            pstmt.setInt(3,faker.number().numberBetween(1909,2020));
            pstmt.setInt(2,faker.number().numberBetween(6,15));
            pstmt.executeUpdate();
            pstmt.close();
        }
    }
}
