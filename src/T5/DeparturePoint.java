package T5;

public class DeparturePoint {
    String name;
    static String[] cities = {"Lviv", "Kyiv", "Odesa", "Kharkiv"};

    public DeparturePoint(String name) {
        this.name = name;
    }

    public static String[] getCities() {
        return cities;
    }
}
