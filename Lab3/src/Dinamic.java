import java.util.List;

public class Dinamic implements Algorithm {
    private Knapsack rucsac;
    private List<Item> items;

    public Dinamic(Knapsack rucsac, List<Item> items) {
        this.rucsac = rucsac;
        this.items = items;
    }

    @Override
    public int getMaxValue() {            //algoritmul corespunzator programarii dinamice calculeaza pentru fiecare greutate, valoare maxima
        int i, w;                                //care poate fi obtinuta
        int[][] K = new int[items.size() + 1][rucsac.getCapacity() + 1];
        for (i = 0; i <= items.size(); i++) {
            for (w = 0; w <= rucsac.getCapacity(); w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (items.get(i - 1).getWeight() <= w)
                    K[i][w] = Math.max(items.get(i - 1).getValue() + K[i - 1][(int) (w - items.get(i - 1).getWeight())], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
        return K[items.size()][rucsac.getCapacity()];
    }
}
