package T5;

@SuppressWarnings("ClassCanBeRecord")
public class Shipment {
    private final Item item;
    private final ReceivePoint receivePoint;
    private final DeparturePoint departurePoint;

    public Shipment(Item item, DeparturePoint departurePoint, ReceivePoint receivePoint) {
        this.item = item;
        this.departurePoint = departurePoint;
        this.receivePoint = receivePoint;
    }

    public Item getItem() {
        return item;
    }

    public ReceivePoint getReceivePoint() {
        return receivePoint;
    }

    public DeparturePoint getDeparturePoint() {
        return departurePoint;
    }

    public static boolean isViable(String departure) {

        for (String d : DeparturePoint.getCities()) {
            if (departure.equals(d)) {
                return true;
            }
        }

        return false;
    }

    public static String getType(double w, double v, String departure) {
        if (w <= 1 && v <= 1) {
            return "bicycle";
        }
        else if (w <= 10 && v <= 3 && isViable(departure)) {
            return "van";
        }
        else if (w <= 20 && v <= 5 && isViable(departure)) {
            return "truck";
        }
        else if (w <= 50 && v <= 7 && isViable(departure)) {
            return "train";
        }
        else {
            return null;
        }
    }
}

