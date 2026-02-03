import java.util.Scanner;
public class JScalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's the equation you'de like to calculate?");
        String equation = scanner.nextLine();
        
        
    }
    public static double add (double a, double b){
        return (a + b);
    }
    public static double subtract (double a, double b){
        return (a - b);
    }
    public static double multiply (double a, double b){
        return (a * b);
    }
    public static double divide (double a, double b){
        return (a / b);
    }



}
