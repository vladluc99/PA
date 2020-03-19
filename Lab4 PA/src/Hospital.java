public class Hospital implements Comparable<Hospital>{
    private String name;
    int capacity;
    //private Resident[] preferences; pentru aproachul fara maps

    public Hospital(String name) {
        this.name = name;
    }

    /*public Resident[] getPreferences() {
        return preferences;
    }

    public void setPreferences(Resident[] preferences) {
        this.preferences = preferences;
    }*/

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Hospital o) {
        return this.getName().compareTo(o.getName());
    }
}
