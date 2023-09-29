public class Main {
    public static void main(String[] args) {

        Task1.calculate();
        System.out.println();
        Task2.sort();
        System.out.println();

        if (Task3.validateEmail()) {
            System.out.println("The email is valid!\n");
        }
        else {
           System.out.println("The email is invalid!\n");
        }

        Task4.multiply();
        System.out.println();
        Task5.mail();
    }
}