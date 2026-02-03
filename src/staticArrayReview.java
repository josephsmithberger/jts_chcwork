import java.util.Arrays;
import java.util.Scanner;

public class staticArrayReview {
    // Create static initalizer array list1
    // create a static array of ints called list 2 w/ interactive inputs
    // sort the arrays .sort()
    public static int[] list1 = {1, 2, 3, 4, 5};
    public static int [] list2;
    
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        boolean isEditing = true;
        // interactive
        int tempEdit;
        System.out.println("How many ints?");
        int arrayLength = scanner.nextInt();
        list2 = new int[arrayLength];
        while (isEditing){
            System.out.println("What index would you like to edit? (1 to " + arrayLength + ")");
            tempEdit = scanner.nextInt();
            System.out.println("And what would you to assign there?");
            assignToArray(tempEdit, scanner.nextInt()); 
            System.out.println("Would you like to continue? (1=Yes, 0=No)");
            int continueChoice = scanner.nextInt();
            isEditing = (continueChoice == 1);
        }
        
        // Sort the arrays
        Arrays.sort(list1);
        Arrays.sort(list2);
        
        System.out.println("\n=== Sorted Arrays ===");
        System.out.println("list1:");
        printArray(list1);
        System.out.println("list2:");
        printArray(list2);
        
        // Menu for operations
        boolean continueOperations = true;
        while (continueOperations) {
            System.out.println("\n=== Operations Menu ===");
            System.out.println("1. Insert an element");
            System.out.println("2. Delete an element");
            System.out.println("3. Calculate average");
            System.out.println("4. Print arrays");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Which array? (1 for list1, 2 for list2)");
                    int arrayChoice = scanner.nextInt();
                    System.out.println("Enter value to insert:");
                    int valueToInsert = scanner.nextInt();
                    if (arrayChoice == 1) {
                        list1 = insertElement(list1, valueToInsert);
                        System.out.println("Inserted into list1.");
                    } else {
                        list2 = insertElement(list2, valueToInsert);
                        System.out.println("Inserted into list2.");
                    }
                    break;
                    
                case 2:
                    System.out.println("Which array? (1 for list1, 2 for list2)");
                    arrayChoice = scanner.nextInt();
                    if (arrayChoice == 1) {
                        System.out.println("Enter index to delete (1 to " + list1.length + "):");
                        int indexToDelete = scanner.nextInt();
                        list1 = deleteElement(list1, indexToDelete);
                    } else {
                        System.out.println("Enter index to delete (1 to " + list2.length + "):");
                        int indexToDelete = scanner.nextInt();
                        list2 = deleteElement(list2, indexToDelete);
                    }
                    break;
                    
                case 3:
                    System.out.println("Average of list1: " + averageArray(list1));
                    System.out.println("Average of list2: " + averageArray(list2));
                    break;
                    
                case 4:
                    System.out.println("list1:");
                    printArray(list1);
                    System.out.println("list2:");
                    printArray(list2);
                    break;
                    
                case 5:
                    continueOperations = false;
                    System.out.println("Exiting...");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        
        scanner.close();
    }

    static void assignToArray(int index, int value) {
        // Convert from 1-based user input to 0-based array index
        int arrayIndex = index - 1;
        if (arrayIndex < 0 || arrayIndex >= list2.length){
            System.out.println("Out of bounds. Try again.");
            return;
        }
        if (list2[arrayIndex] != 0){
            
        }
        list2[arrayIndex] = value;
        System.out.println("Success!");
    }
    
    // Method to print the array
    static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    // Method to insert an element to the array
    static int[] insertElement(int[] arr, int value) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[arr.length] = value;
        return newArr;
    }
    
    // Method to delete an element from the array
    static int[] deleteElement(int[] arr, int index) {
        // Convert from 1-based user input to 0-based array index
        int arrayIndex = index - 1;
        if (arrayIndex < 0 || arrayIndex >= arr.length) {
            System.out.println("Out of bounds. Cannot delete.");
            return arr;
        }
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != arrayIndex) {
                newArr[j] = arr[i];
                j++;
            }
        }
        return newArr;
    }
    
    // Method to average the elements in the array
    static double averageArray(int[] arr) {
        if (arr.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum / arr.length;
    }
    
}
