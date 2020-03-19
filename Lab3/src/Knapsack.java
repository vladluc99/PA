import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knapsack {
    private int capacity;
    private List<Item> items = new ArrayList<>();

    public Knapsack(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addItem(Item item){
        items.add(item);
    }

}
