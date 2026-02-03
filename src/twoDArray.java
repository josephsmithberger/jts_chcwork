import java.util.Scanner;
public class twoDArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int [5][5];
        for (int row = 0; row < array.length; row++){
            for (int column = 0; column < array[row].length; column++){
                System.out.println("What's the value of row " + row + " column " + column + "?");
                array[row][column] = scanner.nextInt();
            }
        }
        int finalValue = 0;
        for (int row = 0; row < array.length; row++){
            for (int column = 0; column < array[row].length; column++){
                finalValue += array[row][column];
            }
        }
        System.out.println("The 2D array adds to " + finalValue);
    }
}
