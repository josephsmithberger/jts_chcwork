import java.util.Scanner;
public class JSname {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        System.out.println("Format should be [Last, First Middle]");
        String name = scanner.nextLine();
        String lastName = name.substring(0, name.indexOf(","));
        String firstName = name.substring(name.indexOf(",") + 2, name.lastIndexOf(" "));
        char middleIntial = name.charAt(name.lastIndexOf(' ') + 1);
        System.out.println("Hello, " + firstName + " " + middleIntial + " " + lastName + "!");
        scanner.close();
    }
}
