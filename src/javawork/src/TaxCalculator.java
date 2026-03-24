import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter marital status (1=single, 2=married): ");
        int status = input.nextInt();
        System.out.print("Enter taxable income: $ ");
        double income = input.nextDouble();
        
        double tax = 0;
        //hello world blah
        if (status == 1) { // Single
            if (income <= 27050) {
                tax = income * 0.15;
            } else if (income <= 65550) {
                tax = 4057.50 + (income - 27050) * 0.275;
            } else if (income <= 136750) {
                tax = 14645.00 + (income - 65550) * 0.305;
            } else if (income <= 297350) {
                tax = 36361.00 + (income - 136750) * 0.355;
            } else {
                tax = 93374.00 + (income - 297350) * 0.391;
            }
        } else { // Married
            if (income <= 45200) {
                tax = income * 0.15;
            } else if (income <= 109250) {
                tax = 6780.00 + (income - 45200) * 0.275;
            } else if (income <= 166500) {
                tax = 24393.75 + (income - 109250) * 0.305;
            } else if (income <= 297350) {
                tax = 41855.00 + (income - 166500) * 0.355;
            } else {
                tax = 88306.75 + (income - 297350) * 0.391;
            }
        }
        
        System.out.printf("Your Federal tax = $ %,.2f%n", tax);
        
        input.close();
    }
}