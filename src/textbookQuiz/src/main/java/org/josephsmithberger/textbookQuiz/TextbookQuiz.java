package org.josephsmithberger.textbookQuiz;
import java.util.Scanner;

public class TextbookQuiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many 'Be Prepared' books would you like?");
        int bp = scanner.nextInt();
        System.out.println("And how many 'Next Best' books would you like?");
        int nb = scanner.nextInt();
        int totalcopies = bp + nb;
        double price;
        if (totalcopies >= 3){
            if (totalcopies >= 12){
                price = totalcopies * 12.75;
            }
            else{
                price = totalcopies * 13.95;
            }
        }
        else if (nb == 1 && bp == 1){
            price = 35.95;
        }
        else{
            price = (bp * 15.95) + (nb * 21.95);
        }
        System.out.print("Your total order comes to $");
        System.out.printf("%.2f", price);
        System.out.println();
    }
}
