import java.util.Scanner;

public class quadraticFormula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the values of a, b, and c
        System.out.print("Enter the value of a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter the value of b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter the value of c: ");
        double c = scanner.nextDouble();

        // Calculate the discriminant
        double discriminant = b * b - 4 * a * c;

        // Check if the discriminant is positive, zero, or negative
        if (discriminant > 0) {
            // Two real roots
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The roots are: " + root1 + " and " + root2);
        } else if (discriminant == 0) {
            // One real root
            double root = -b / (2 * a);
            System.out.println("The root is: " + root);
        } else {
            // No real roots
            System.out.println("The equation has no real roots.");
        }

        scanner.close();
    }
}