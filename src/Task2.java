import java.util.Scanner;
import static java.lang.Character.isUpperCase;

public class Task2 {
    public static void sort() {

        System.out.print("Enter the amount of strings: ");
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        String[] strings = new String[n];
        int[] ucs = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the string #" + (i + 1) + ": ");
            strings[i] = scan.nextLine();
        }

        for (int i = 0; i < strings.length; i++) {

            String string = strings[i];
            int ucc = 0;

            for (int j = 0; j < string.length(); j++) {
                if (isUpperCase(string.charAt(j))) {
                    ucc++;
                }
            }

            ucs[i] = ucc;
        }

        for (int i = 0; i < ucs.length; i++) {
            for (int j = 0; j < ucs.length - 1; j++) {
               if (ucs[j] > ucs[i]) {
                   int tempI = ucs[j];
                   String tempS = strings[j];
                   ucs[j] = ucs[i];
                   ucs[i] = tempI;
                   strings[j] = strings[i];
                   strings[i] = tempS;
               }
            }
        }

        System.out.print("\nSorted strings: ");
        for (String s: strings) {
            System.out.print(s + ' ');
        }

        System.out.println();
    }
}
