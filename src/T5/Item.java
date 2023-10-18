package T5;

@SuppressWarnings("ClassCanBeRecord")
public class Item {
    private final String name;
    private final double weight;
    private final double volume;

    public Item(String name, double weight, double volume) {
        this.name = name;
        this.weight = weight;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }
}