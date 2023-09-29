import java.util.Scanner;

import static java.lang.Character.isDigit;

public class Task1 {
    public static void calculate() {

        System.out.print("Write an equation: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        double num1 = 0, num2;
        int j = 0;
        char sign = ' ';
        char[] num = new char[256];
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            while (c == ' ') {
                c = input.charAt(i++);
            }

            if (isDigit(c) || c == '.') {
                num[j] = c;
                j++;
            }

            else if ((sign == ' ') && (c == '+' || c == '-'
                    || c == '*' || c == '/' || c == '^')) {

                sign = c;

                for (char n : num) {
                    if (n != 0) {
                        temp.append(n);
                    }
                    else {
                        break;
                    }
                }

                num1 = Double.parseDouble(temp.toString());

                j = 0;
                num = new char[256];
                temp = new StringBuilder();
            }

            else {
                System.out.println("Error : Wrong symbol detected");
                return;
            }
        }

        for (char n : num) {
            if (isDigit(n) || n == '.') {
                temp.append(n);
            }
            else if (n == 0) {
                break;
            }
            else {
                System.out.println("Error : Wrong symbol detected");
                return;
            }
        }

        if (temp.isEmpty()) {
            System.out.println("Error : no second number was detected");
            return;
        }
        else {
            num2 = Double.parseDouble(temp.toString());
        }

        if (sign == ' ') {
            System.out.println("Error : No operator sign was detected");
            return;
        }
        else if (sign == '/' && num2 == 0) {
            System.out.println("Error : Division by zero detected");
            return;
        }

        System.out.println("Result : " + operate(num1, sign, num2));
    }

    private static double operate(double num1, char sign, double num2) {
        return switch (sign) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            case '^' -> Math.pow(num1, num2);
            default -> 0;
        };
    }
}
