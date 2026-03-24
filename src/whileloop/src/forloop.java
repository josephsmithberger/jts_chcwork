import java.util.Scanner;

public class forloop {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("What number do you want to count to?");
        int end = s.nextInt();
        System.out.println("And where would you like to start?");
        int lcv = s.nextInt(); // lcv - loop control variable
        System.out.println("Increment by how much?");
        int increment = s.nextInt();
        for (int i = lcv; i <= end; i += increment) { 
        System.out.println("Value = " + i);
        }
        System.out.println("Done!");
        s.close();
    }
}
