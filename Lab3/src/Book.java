public class Book implements Item {
    private String name;
    private int price;
    private int pageNr;

    public Book(String name, int price, int pageNr) {
        this.name = name;
        this.price = price;
        this.pageNr = pageNr;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getValue() {
        return this.price;
    }

    @Override
    public double getWeight() {
        return this.pageNr / 100;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}

