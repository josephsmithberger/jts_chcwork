import java.util.Scanner;
public class firstThree {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three side lengths, separated by spaces:");
        String input = scanner.nextLine();
        double[] numbers = parseInput(input);
        scanner.close();
        checkForRight(numbers);
    }
    // This method takes a string input and returns an array of three doubles
    static double[] parseInput(String input) {
        // Split the input by spaces
        String[] tokens = input.trim().split(" ");
        if (tokens.length < 3) {
            System.out.println("Please enter three numbers separated by spaces.");
            return null;
        }
        // Check if all tokens are numbers
        for (int i = 0; i < 3; i++) {
            if (!isNumber(tokens[i])) {
                System.out.println("Invalid input. Please type only numbers.");
                return null;
            }
        }
        double a = Double.parseDouble(tokens[0]);
        double b = Double.parseDouble(tokens[1]);
        double c = Double.parseDouble(tokens[2]);
        System.out.println("You entered: " + a + ", " + b + ", " + c);
        return new double[]{a, b, c};
    }

    // Helper method to check if a string is a number
    static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!((ch >= '0' && ch <= '9') || ch == '.' || ch == '-')) {
                return false;
            }
        }
        return true;
    }

    // This method checks if the three sides can form a right triangle
    static void checkForRight(double[] numbers) {
        if (numbers != null) {
            System.out.println("Checking for right triangle...");
            double a = numbers[0];
            double b = numbers[1];
            double c = numbers[2];
            // Check all combinations for the Pythagorean theorem using an if / else-if chain
            if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                System.out.println("These sides can form a right triangle (c is hypotenuse).");
            } else if (Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2)) {
                System.out.println("These sides can form a right triangle (b is hypotenuse).");
            } else if (Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2)) {
                System.out.println("These sides can form a right triangle (a is hypotenuse).");
            } else {
                System.out.println("These sides cannot form a right triangle.");
            }
        }
    }
}

