package T5;

@SuppressWarnings("ClassCanBeRecord")
public class DeparturePoint {
    private final static String[] cities = {"Lviv", "Kyiv", "Odesa", "Kharkiv"};
    private final String name;

    public DeparturePoint(String name) {
        this.name = name;
    }

    public static String[] getCities() {
        return cities;
    }

    public String getName() {
        return name;
    }
}
