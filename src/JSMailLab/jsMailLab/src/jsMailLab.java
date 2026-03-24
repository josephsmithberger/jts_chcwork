import java.util.Scanner;

public class jsMailLab {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double dim1, dim2, dim3, weight;
        
        // Get dimensions
        System.out.println("Enter three dimensions of the package:");
        System.out.print("First dimension: ");
        dim1 = input.nextDouble();
        System.out.print("Second dimension: ");
        dim2 = input.nextDouble();
        System.out.print("Third dimension: ");
        dim3 = input.nextDouble();
        
        // Get weight
        System.out.print("Enter the weight of the package in pounds: ");
        weight = input.nextDouble();
        // Compare dim2 and dim1
        if (dim2 > dim1) {
            double temp = dim1;
            dim1 = dim2;
            dim2 = temp;
        }
        
        // Compare dim3 and dim1
        if (dim3 > dim1) {
            double temp = dim1;
            dim1 = dim3;
            dim3 = temp;
        }
        // Calculate perimeter around height and width
        double girth = 2 * (dim2 + dim3);
        
        // Calculate size (length + girth)
        double size = dim1 + girth;
        
        // Check conditions and print appropriate message
        boolean isTooLarge = size > 100;
        boolean isTooHeavy = weight > 70;
        
        if (isTooLarge && isTooHeavy) {
            System.out.println("Package is too large and too heavy.");
        } else if (isTooLarge) {
            System.out.println("Package is too large.");
        } else if (isTooHeavy) {
            System.out.println("Package is too heavy.");
        } else {
            System.out.println("Package is acceptable.");
        }
        
        input.close();
    }
}