import java.util.Scanner;

public class whileloop {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("What number do you want to count to?");
        int end = s.nextInt();
        System.out.println("And where would you like to start?");
        int i = s.nextInt(); // lcv - loop control variable
        System.out.println("Increment by how much?");
        int increment = s.nextInt();
        while (i != end) {
            System.out.println("Not there yet, value = " + i);
            i += increment;
        }
        System.out.println("Value = " + i + ", Great!");
    }
}
