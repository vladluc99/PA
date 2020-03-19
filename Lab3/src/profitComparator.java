import java.util.Comparator;

public class profitComparator implements Comparator<Item> {
    @Override
    public int compare(Item item, Item t1) {
        return Double.compare(t1.profitFactor(), item.profitFactor());
    }

}
