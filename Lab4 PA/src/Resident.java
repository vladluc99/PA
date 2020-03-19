import java.util.Objects;

public class Resident {
    private String name;
    //private Hospital[] preferences; pentru aproachul fara maps

    public Resident(String name) {
        this.name = name;
    }

    /*public void setPreferences(Hospital[] preferences) {
        this.preferences = preferences;
    }

    public Hospital[] getPreferences() {
        return preferences;
    }*/

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resident resident = (Resident) o;
        return Objects.equals(this.getName(), resident.getName());
    }

    @Override
    public String toString() {
        return "Resident{" +
                "name='" + name + '\'' +
                '}';
    }
}
