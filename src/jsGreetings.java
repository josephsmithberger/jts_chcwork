import java.util.Scanner;

public class jsGreetings // fileName.java must match the class name
{
    public static void main(String[] args) // this line is always needed
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What's the first number of your calculation? ");
        int number1 = scanner.nextInt();
        
        System.out.print("What type of operation? Type the sign: +, -, /, * ");
        String operation = scanner.next(); // next() for reading a single symbol
        
        System.out.print("And the second number? ");
        int number2 = scanner.nextInt();
        
        // calculation
        if (operation.equals("+")) {
            System.out.println(number1 + number2);
        } else if (operation.equals("-")) {
            System.out.println(number1 - number2);
        } else if (operation.equals("*")) {
            System.out.println(number1 * number2);
        } else if (operation.equals("/")) {
            System.out.println(number1 / number2);
        } else {
            System.out.println("Invalid operation");
        }

        scanner.close();
    }
}