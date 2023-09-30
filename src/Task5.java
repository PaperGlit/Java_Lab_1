import java.util.Scanner;
import static java.lang.Integer.parseInt;

class Item {
    String name;
    double weight;
    double volume;

    public Item(String name, double weight, double volume) {
        this.name = name;
        this.weight = weight;
        this.volume = volume;
    }
}

class Shipment {
    Item item;
    ReceivePoint receivePoint;
    DeparturePoint departurePoint;

    public Shipment(Item item, DeparturePoint departurePoint, ReceivePoint receivePoint) {
        this.item = item;
        this.departurePoint = departurePoint;
        this.receivePoint = receivePoint;
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

class Customer {
    public static Shipment sendPackage() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the departure point: ");
        String departure = scan.nextLine();

        System.out.print("Enter the receive point: ");
        String receive = scan.nextLine();

        System.out.print("Enter the item's name: ");
        String n = scan.nextLine();

        System.out.print("Enter the item's weight (kg): ");
        double w = Double.parseDouble(scan.nextLine());

        System.out.print("Enter the item's volume (m^3): ");
        double v = Double.parseDouble(scan.nextLine());

        String s = Shipment.getType(w, v, departure);

        if (s != null) {
            System.out.println("Your item will be delivered by a " + s);
            return new Shipment(new Item(n, w, v), new DeparturePoint(departure), new ReceivePoint(receive));
        }
        else {
            System.out.println("Error: your item can not be delivered");
            return null;
        }
    }

    public static void cancelPackage(Shipment[] shipments) {
        if (shipments.length != 0) {
            int i = 0;
            System.out.println("Select which shipment should be canceled: ");

            for (Shipment s : shipments) {
                if (s != null) {
                    System.out.println("#" + (i + 1) + " " + s.item.name + " (" + s.departurePoint.name + " - " + s.receivePoint.name + ") weight: " + s.item.weight + "kg volume: " + s.item.volume + "m^3");
                }
                i++;
            }

            System.out.print("Choose the number of the shipment to delete it: ");
            Scanner scan = new Scanner(System.in);
            int n = parseInt(scan.nextLine());
            try {
                shipments[n - 1] = null;
                System.out.println("The shipment #" + n + " was successfully deleted.");
            }
            catch (Exception e) {
                System.out.println("Error: this shipment doesn't exist");
            }
        }
        else {
            System.out.println("There are no shipments en route right now.");
        }
    }
}

class DeparturePoint {
    String name;
    static String[] cities = {"Lviv", "Kyiv", "Odesa", "Kharkiv"};
    public DeparturePoint(String name) {
        this.name = name;
    }
    public static String[] getCities() {
        return cities;
    }
}

class ReceivePoint {
    String name;
    public ReceivePoint(String name) {
        this.name = name;
    }
}

public class Task5 {
    public static void mail() {
        Shipment[] shipments = new Shipment[0];
        while (true) {
            String k;
            Scanner scan = new Scanner(System.in);
            System.out.print("1 - Create new shipments, 2 - remove shipments, anything else - exit: ");
            k = scan.nextLine();

            switch (k) {
                case "1":
                    System.out.print("Enter the number of shipments: ");
                    int n = parseInt(scan.nextLine());
                    shipments = new Shipment[n];

                    for (int i = 0; i < n; i++) {
                        shipments[i] = (Customer.sendPackage());
                    }
                    break;

                case "2":
                    Customer.cancelPackage(shipments);
                    break;

                default:
                    return;
            }
        }
    }
}
