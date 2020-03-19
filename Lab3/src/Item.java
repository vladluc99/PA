public interface Item extends Comparable<Item> {
    String getName();
    int getValue();
    double getWeight();
    default double profitFactor(){
        return getValue()/getWeight();
    }
    @Override
    default int compareTo(Item o) {
        return getName().compareTo(o.getName());
    }


}
