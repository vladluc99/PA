package entity;

import javax.persistence.*;

@Entity
@Table(name = "ALBUMS", schema = "STUDENT")
@NamedQueries(
        {
                @NamedQuery(name = "Album.findByName",
                        query = "SELECT a FROM Album a WHERE a.name=:name"),
                @NamedQuery(name = "Album.findByArtist",
                        query = "SELECT a FROM Album a WHERE a.artist.id=:id")
        }
)
public class Album {
    private long id;
    private String name;
    private Long releaseYear;
    private int artist_id;

    @Id
    @SequenceGenerator(name="ID",sequenceName = "SEQ_ALBUMS",initialValue = 1, allocationSize = 50)
    @GeneratedValue (generator = "ID")
    /*public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }*/

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "RELEASE_YEAR")
    public Long getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Long releaseYear) {
        this.releaseYear = releaseYear;
    }

    @JoinColumn(name = "ARTIST_ID",referencedColumnName = "ID")
    @ManyToOne
    private Artist artist;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (id != album.id) return false;
        if (name != null ? !name.equals(album.name) : album.name != null) return false;
        if (releaseYear != null ? !releaseYear.equals(album.releaseYear) : album.releaseYear != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (releaseYear != null ? releaseYear.hashCode() : 0);
        return result;
    }*/
}
