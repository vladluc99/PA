public class Weapon implements Item {
    private weaponType type;
    private int value;
    private int weight;

    public Weapon(weaponType type, int value, int weight) {
        this.type = type;
        this.value = value;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return this.type.name();
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "type=" + type +
                '}';
    }
}
