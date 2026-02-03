import java.util.*;
public class TelephoneNumberJTS
{
    /* This program is a telephone number validator. It scans an input
     telephone number String and validates it as a String in a standard
     format with parentheses, dashes and numbers (for example,
     (987)654-3210, where 987 is the area code, 654 is the exchange,
     and 3210 is the line number.
     The program performs the following operations on the input String:
     1. Remove all characters from the String which are not numeric or
     parenthesis or dash.
     2. Check to see that the new String is the correct length (13). If it
     is not, print an error message stating the wrong length.
     3. Check that the ( is in position 0, the ) is in position 4 and the
     dash is in position 8. If it is not, print an appropriate error message.
     4. Takes the valid format telephone number and divides it into
     its three components (area code, exchange, and line number) and
     prints each seperately.
     */
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        System.out.print("Please enter the original telephone number: ");
        String phoneNumber = console.nextLine();
        System.out.println();
        
        String cleanedNumber = cleanPhoneNumber(phoneNumber);
        System.out.println("Original input: " + phoneNumber);
        System.out.println("Corrected input: " + cleanedNumber);
        System.out.println();
        
        if (validateLength(cleanedNumber) && validateFormat(cleanedNumber)) {
            displayComponents(cleanedNumber);
        }
    }
    
    // Method 1: Removes all characters from the phone number that are not
    // numeric or parenthesis or dash.
    public static String cleanPhoneNumber(String phoneNumber) {
        String cleanedNumber = "";
        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);
            if ((c >= '0' && c <= '9') || c == '(' || c == ')' || c == '-') {
                cleanedNumber += c;
            }
        }
        return cleanedNumber;
    }
    
    // Method 2: Validates that the phone number has the correct length of 13 characters.
    public static boolean validateLength(String phoneNumber) {
        if (phoneNumber.length() != 13) {
            System.out.println("ERROR - phone number is of wrong length.");
            return false;
        }
        return true;
    }
    
    // Method 3: Validates that the special characters are in the correct positions.
    public static boolean validateFormat(String phoneNumber) {
        if (phoneNumber.charAt(0) != '(') {
            System.out.println("ERROR - misplaced '('");
            return false;
        }
        if (phoneNumber.charAt(4) != ')') {
            System.out.println("ERROR - misplaced ')'");
            return false;
        }
        if (phoneNumber.charAt(8) != '-') {
            System.out.println("ERROR - misplaced '-'");
            return false;
        }
        return true;
    }
    
    // Method 4: Divides a valid phone number into its three components and displays them.
    public static void displayComponents(String phoneNumber) {
        String areaCode = phoneNumber.substring(1, 4);
        String exchange = phoneNumber.substring(5, 8);
        String lineNumber = phoneNumber.substring(9);
        
        System.out.println("Area code:" + "\t" + areaCode);
        System.out.println("Exchange:" + "\t" + exchange);
        System.out.println("Line Number:" + "\t" + lineNumber);
    }
}