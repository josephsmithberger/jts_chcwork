import java.util.Scanner;
public class substringCounterJS {
    public static void main(String[] args){
        System.out.println("Input your text.");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine().toLowerCase();
        System.out.println("Input your reoccurring text.");
        String findThis = s.nextLine().toLowerCase();
        int occurences = 0;
        for (int i = 0; i <= input.length() - findThis.length(); i++){
            if (input.substring(i, i + findThis.length()).equals(findThis)){
                System.out.println("Found at position " + i);
                occurences++;
            }
        }
        System.out.println("There are " + occurences + " occurences of " + findThis + " in " + input + ".");
        
    }
}
