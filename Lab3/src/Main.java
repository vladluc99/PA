import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Weapon w1 = new Weapon(weaponType.dagger,13,6);
        Weapon w2 = new Weapon(weaponType.sword, 10, 5);
        Book book1 = new Book("Dragon Rising", 5, 300);
        Book book2 = new Book("A blade in the Dark", 5, 300);
        Food food1 = new Food("Cabbage", 5, 10);
        Food food2 = new Food("Rabbit", 2, 4);

        Knapsack k1 = new Knapsack(10);

        List<Item> items = new ArrayList<>();
        items.add(w1);
        items.add(book2);
        items.add(food2);
        items.add(w2);
        items.add(book1);
        items.add(food1);

        System.out.println("Inainte de sortare :");
        System.out.println(items);

        Collections.sort(items);

        System.out.println("\nDupa sortare :");
        System.out.println(items);

        /*Collections.sort(items,new profitComparator());
        System.out.println(items);*/
        Greedy g = new Greedy(k1, items);
        System.out.println(g.getMaxValue());
        Dinamic d = new Dinamic(k1,items);
        System.out.println(d.getMaxValue());
    }
}
