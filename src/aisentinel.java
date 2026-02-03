import java.util.Scanner;

public class aisentinel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Powers of 2 Calculator");
        System.out.println("Enter a non-negative integer. Enter -1 to stop.");

        // This loop continues until the user enters the sentinel value (-1)
        while (true) {
            System.out.print("Enter power: ");

            // Check if the next input is not an integer
            if (!scanner.hasNextInt()) {
                String badInput = scanner.next(); // Read and discard the invalid input
                System.out.println("Invalid input: \"" + badInput + "\". Please enter an integer.");
                continue; // Skip the rest of the loop and ask again
            }

            int power = scanner.nextInt();

            // Check for the sentinel value to exit the program
            if (power == -1) {
                System.out.println("Exiting program.");
                break;
            }

            // Ensure the input is not negative (other than the sentinel)
            if (power < 0) {
                System.out.println("Power must be non-negative. Please try again.");
                continue;
            }

            // Use 'long' for the result to handle larger numbers (up to 2^62)
            long result = 1L;

            // Multiply 'result' by 2, 'power' times.
            // This loop doesn't run if power is 0, so result remains 1 (correct for 2^0)
            for (int i = 0; i < power; i++) {
                result *= 2; // Same as result = result * 2;
            }

            System.out.println("2^" + power + " = " + result);
        }

        scanner.close();
    }
}