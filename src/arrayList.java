import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class arrayList {
    // Create static ArrayList list1
    public static ArrayList<Integer> list1 = new ArrayList<>();
    public static ArrayList<Integer> list2 = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isEditing = true;
        
        // Initialize list1 with some values
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        
        // Interactive input for list2
        System.out.println("How many ints?");
        int arrayLength = scanner.nextInt();
        
        // Initialize list2 with zeros
        for (int i = 0; i < arrayLength; i++) {
            list2.add(0);
        }
        
        while (isEditing) {
            System.out.println("What index would you like to edit? (1 to " + arrayLength + ")");
            int tempEdit = scanner.nextInt();
            System.out.println("And what would you like to assign there?");
            assignToList(tempEdit, scanner.nextInt());
            System.out.println("Would you like to continue? (1=Yes, 0=No)");
            int continueChoice = scanner.nextInt();
            isEditing = (continueChoice == 1);
        }
        
        // Sort the ArrayLists
        Collections.sort(list1);
        Collections.sort(list2);
        
        System.out.println("\n=== Sorted ArrayLists ===");
        System.out.println("list1:");
        printList(list1);
        System.out.println("list2:");
        printList(list2);
        
        // Menu for operations
        boolean continueOperations = true;
        while (continueOperations) {
            System.out.println("\n=== Operations Menu ===");
            System.out.println("1. Insert an element");
            System.out.println("2. Delete an element");
            System.out.println("3. Calculate average");
            System.out.println("4. Print ArrayLists");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Which ArrayList? (1 for list1, 2 for list2)");
                    int listChoice = scanner.nextInt();
                    System.out.println("Enter value to insert:");
                    int valueToInsert = scanner.nextInt();
                    if (listChoice == 1) {
                        insertElement(list1, valueToInsert);
                        System.out.println("Inserted into list1.");
                    } else {
                        insertElement(list2, valueToInsert);
                        System.out.println("Inserted into list2.");
                    }
                    break;
                    
                case 2:
                    System.out.println("Which ArrayList? (1 for list1, 2 for list2)");
                    listChoice = scanner.nextInt();
                    if (listChoice == 1) {
                        System.out.println("Enter index to delete (1 to " + list1.size() + "):");
                        int indexToDelete = scanner.nextInt();
                        deleteElement(list1, indexToDelete);
                    } else {
                        System.out.println("Enter index to delete (1 to " + list2.size() + "):");
                        int indexToDelete = scanner.nextInt();
                        deleteElement(list2, indexToDelete);
                    }
                    break;
                    
                case 3:
                    System.out.println("Average of list1: " + averageList(list1));
                    System.out.println("Average of list2: " + averageList(list2));
                    break;
                    
                case 4:
                    System.out.println("list1:");
                    printList(list1);
                    System.out.println("list2:");
                    printList(list2);
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

    static void assignToList(int index, int value) {
        // Convert from 1-based user input to 0-based index
        int listIndex = index - 1;
        if (listIndex < 0 || listIndex >= list2.size()) {
            System.out.println("Out of bounds. Try again.");
            return;
        }
        list2.set(listIndex, value);
        System.out.println("Success!");
    }
    
    // Method to print the ArrayList
    static void printList(ArrayList<Integer> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    // Method to insert an element to the ArrayList
    static void insertElement(ArrayList<Integer> list, int value) {
        list.add(value);
    }
    
    // Method to delete an element from the ArrayList
    static void deleteElement(ArrayList<Integer> list, int index) {
        // Convert from 1-based user input to 0-based index
        int listIndex = index - 1;
        if (listIndex < 0 || listIndex >= list.size()) {
            System.out.println("Out of bounds. Cannot delete.");
            return;
        }
        list.remove(listIndex);
    }
    
    // Method to average the elements in the ArrayList
    static double averageList(ArrayList<Integer> list) {
        if (list.size() == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return (double) sum / list.size();
    }
}
