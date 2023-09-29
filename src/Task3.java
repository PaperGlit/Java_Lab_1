import java.util.Scanner;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

public class Task3 {

    private static boolean isLetterOrDigit (char c) {
        return (isDigit(c) || isLetter(c));
    }

    private static boolean isValidSymbol (char c) {
        return (c == '!' || c == '#' || c == '$' || c == '%' || c == '&'
                || c == '\'' || c == '*' || c == '+' || c == '-' || c == '/'
                || c == '=' || c == '?' || c == '^' || c == '_' || c == '`'
                || c == '{' || c == '|' || c == '}' || c == '~');
    }

    // Local : is a digit, letter or a valid symbol and has no more than 64 characters and no 2 or more '.'s next to each other
    // Has '@' symbol to divide the local and domain parts
    // Domain : each part is no longer than 63 characters, has at least a single letter for each '.', while only having letters, digits and '-'s as long as they aren't the first or last character
    public static boolean validateEmail() {

        System.out.print("Write an email: ");
        Scanner scan = new Scanner(System.in);
        String email = scan.nextLine();


        int i = 0, j = 0, k = 0;
        boolean hasLetter = false;

        //Local part check

        while(i <= 64 && i < email.length() && email.charAt(i) != '@') {

            char c = email.charAt(i);
            char cm1 = ' ', cp1 = ' ';

            if (!(i == email.length() - 1)) {
                cp1 = email.charAt(i+1);
            }

            if (i != 0) {
                cm1 = email.charAt(i - 1);
            }

            if(!(isLetterOrDigit(c) || isValidSymbol(c) ||
                    (c == '.' && (cp1 != '.' || cm1 != '.')))) {
                return false;
            }

            i++;
        }

        //"'@' Symbol check

        try {
            if (email.charAt(i) == '@') {
                i++;
            }
            else {
                return false;
            }
        }
        catch(Exception e) {
            return false;
        }

        //Domain part check

        while (i < email.length()) {

            char c = email.charAt(i);
            char cm1 = email.charAt(i-1);
            char cf = ' ';

            if (cm1 == '@' || cm1 == '.') {
                cf = c;
            }

            if (k > 253) {
                return false;
            }

            if ((c == '.' && (j > 63 || !hasLetter)) ||
                    !(isLetterOrDigit(c) || c == '.' || c == '-') || (cf == '-' || (c == '.' && cm1 == '-'))) {
                return false;
            }

            else if (c == '.') {
                j = 0;
                hasLetter = false;
            }

            else if (isLetterOrDigit(c) || c == '-') {
                if (isLetter(c)) {
                    hasLetter = true;
                }
                j++;
            }

            k++;
            i++;
        }

        return true;
    }
}
