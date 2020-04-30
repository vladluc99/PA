package app;


import entity.Artist;
import repo.AlbumRepository;
import repo.ArtistRepository;

public class AlbumManager {
    public static void main(String[] args){
        ArtistRepository art = new ArtistRepository();
        AlbumRepository alb = new AlbumRepository();
        Artist pavarotti = new Artist();
        pavarotti.setName("Pavarotii");
        pavarotti.setCountry("Italia");
        art.create(pavarotti);
    }
}
