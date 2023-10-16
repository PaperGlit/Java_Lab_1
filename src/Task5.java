import T5.Shipment;
import T5.Customer;

import java.util.Scanner;
import static java.lang.Integer.parseInt;

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
