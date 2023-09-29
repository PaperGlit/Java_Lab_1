import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {

            System.out.print("1 - Task 1, 2 - Task 2, 3 - Task 3, 4 - Task 4, 5 - Task 5, 0 - exit: ");
            String r = scan.nextLine();

            switch (r) {
                case "0":
                    return;
                case "1":
                    Task1.calculate();
                    System.out.println();
                    break;
                case "2":
                    Task2.sort();
                    System.out.println();
                    break;
                case "3":
                    if (Task3.validateEmail()) {
                        System.out.println("The email is valid!\n");
                    }
                    else {
                    System.out.println("The email is invalid!\n");
                    }
                    break;
                case "4":
                    Task4.multiply();
                    System.out.println();
                    break;
                case "5":
                    Task5.mail();
                    System.out.println();
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
    }
}