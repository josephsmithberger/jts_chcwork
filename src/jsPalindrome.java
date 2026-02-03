import java.util.Scanner;

public class jsPalindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What do you want to check for a palindrome? ");
        String unfiltered = input.nextLine();
        String filtered = "";

        for (int i = 0; i < unfiltered.length(); i++) { 
            if (Character.isLetter(unfiltered.charAt(i))) { // Check if the character is a letter
                filtered += unfiltered.charAt(i);
            }
        }
        String reversed = "";
        for (int i = filtered.length() - 1; i >= 0; i--) {
            reversed += filtered.charAt(i);
        }
        reversed = reversed.toLowerCase();
        filtered = filtered.toLowerCase();
        if (reversed.equals(filtered)){
            System.out.println("It's a palindrome!!");
        }
        else{
            System.out.println("Nope, it's not a palindrome");
            System.out.println(filtered + "is not the same as " + reversed);
        }
        input.close();
    }
}