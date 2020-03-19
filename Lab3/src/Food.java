public class Food implements Item{
    private String name;
    private int calories;
    private int weight;

    public Food(String name, int calories, int weight) {
        this.name = name;
        this.calories = calories;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getValue() {
        return this.calories;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                '}';
    }
}
