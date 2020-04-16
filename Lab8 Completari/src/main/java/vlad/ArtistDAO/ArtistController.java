package vlad.ArtistDAO;

import com.github.javafaker.Faker;
import vlad.dbConnection.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ArtistController {
    public void create(String name, String country) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO artists (id,name,country) VALUES(seq_arists.nextval,?,?)"; //typo la arists, my bad
        PreparedStatement pstmt = Database.getConnection().prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, country);
        pstmt.executeUpdate();
    }

    public List<Artist> findByName(String name) throws SQLException, ClassNotFoundException { //deoarece campul nume nu este unic, pot exista duplicate, de aceea am pus lista
        List<Artist> artistsList = new ArrayList<>();
        String sql = "SELECT * FROM artists WHERE name=?";
        PreparedStatement pstmt = Database.getConnection().prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.executeUpdate();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            artistsList.add(new Artist(rs.getInt("id"), rs.getString("name"), rs.getString("country")));
        }
        return artistsList;
    }

    public void generateArtists(int count) throws SQLException, ClassNotFoundException {
        for(int i=0; i< count; i++)
        {
            Faker faker = new Faker();
            String sql = "INSERT INTO artists (id,name,country) VALUES(seq_arists.nextval,?,?)"; //typo la arists, my bad
            PreparedStatement pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.setString(1, faker.artist().name());
            pstmt.setString(2, faker.country().name());
            pstmt.executeUpdate();
            pstmt.close();
        }

    }
}
