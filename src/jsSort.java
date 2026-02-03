import java.util.Arrays;

public class jsSort {
    public static void main(String[] args) {
        int size = 10;
        int min = 0;
        int max = 100;
        int[] list = new int[size];

        // Populate the list with random numbers between min and max
        for (int i = 0; i < size; i++) {
            list[i] = (int) (Math.random() * (max - min + 1)) + min;
        }

        // Sort the list
        Arrays.sort(list);
        System.out.println("Sorted List: " + Arrays.toString(list));

        // Separate even and odd numbers
        int[] even = new int[size];
        int[] odd = new int[size];
        int evenIndex = 0, oddIndex = 0;

        for (int i = 0; i < list.length; i++) {
            if (list[i] % 2 == 0) {
                even[evenIndex++] = list[i];
            } else {
                odd[oddIndex++] = list[i];
            }
        }
        System.out.println("Your even numbers are: \t Your odd numbers are:");
        // Print the even numbers
        
        for (int i = 0; i < evenIndex; i++) {
            System.out.println("\t" + even[i]);
        }

        // Print the odd numbers
        for (int i = 0; i < oddIndex; i++) {
            System.out.println("\t \t \t \t" + odd[i]);
        }
    }
}

