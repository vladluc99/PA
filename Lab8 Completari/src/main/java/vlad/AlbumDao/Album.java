package vlad.AlbumDao;

public class Album {
    private int id;
    private String name;
    private int artistID;
    private int release_year;

    public Album(int id, String name, int artistID, int release_year) {
        this.id = id;
        this.name = name;
        this.artistID = artistID;
        this.release_year = release_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
}
