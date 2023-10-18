package T5;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Customer {
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
            Item item = new Item(n, w, v);
            DeparturePoint departurePoint = new DeparturePoint(departure);
            ReceivePoint receivePoint = new ReceivePoint(receive);
            return new Shipment(item, departurePoint, receivePoint);
        } else {
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
                    System.out.println("#" + (i + 1) + " " + s.getItem().getName() + " (" + s.getDeparturePoint().getName() + " - " + s.getReceivePoint().getName() + ") weight: " + s.getItem().getWeight() + "kg volume: " + s.getItem().getVolume() + "m^3");
                }
                i++;
            }

            System.out.print("Choose the number of the shipment to delete it: ");
            Scanner scan = new Scanner(System.in);
            int n = parseInt(scan.nextLine());
            try {
                shipments[n - 1] = null;
                System.out.println("The shipment #" + n + " was successfully deleted.");
            } catch (Exception e) {
                System.out.println("Error: this shipment doesn't exist");
            }
        } else {
            System.out.println("There are no shipments en route right now.");
        }
    }
}
