import vlad.ArtistDAO.*;
import vlad.AlbumDao.*;
import vlad.dbConnection.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        try {
            ArtistController art = new ArtistController();
            AlbumController alb = new AlbumController();
            //art.create("Vasile","Romania");
            //art.create("Gica","Belgia");
            //alb.create("Album 2020",7,2020);
            System.out.println(art.findByName("Vasile"));
            System.out.println(alb.findByArtist(7));
            Database.closeConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
