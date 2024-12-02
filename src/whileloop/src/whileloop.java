import java.util.Scanner;

public class whileloop {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("What number do you want to count to?");
        int end = s.nextInt();
        System.out.println("And where would you like to start?");
        int i = s.nextInt();
        System.out.println("Counting up? true/false");
        boolean countdir = s.nextBoolean();
        System.out.println(countdir);

        while ((countdir && i < end) || (!countdir && i > end)) {
            System.out.println("Not there yet, value = " + i);
            if (countdir) {
                i++;
            } else {
                i--;
            }
        }
        
        System.out.println("Value = " + i);
        System.out.print("done!");
    }
}
