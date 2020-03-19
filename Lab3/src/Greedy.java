import java.util.List;

public class Greedy implements Algorithm {
    private Knapsack rucsac;
    private List<Item> items;

    public Greedy(Knapsack rucsac, List<Item> items) {
        this.rucsac = rucsac;
        this.items = items;
    }

    @Override
    public int getMaxValue() {
        int maxVal=0;
        double greutate=0;
        items.sort(new profitComparator()); //vectorul este sortat pentru a se pune cele mai avantajoase obiecte in rucsac (daca incap)
        int i=0;
        while(i<items.size())
        {
            if(greutate+items.get(i).getWeight()<=rucsac.getCapacity())
            {
                maxVal=maxVal+items.get(i).getValue();
                greutate=  greutate+items.get(i).getWeight();
            }
            i++;
        }
        return maxVal;
    }
}
