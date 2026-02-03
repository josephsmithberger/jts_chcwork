import java.util.Scanner;

public class jsGrade {
    public static void main(String[] args) {
        // Initializations
        Scanner scanner = new Scanner(System.in);
        Double GPA;

        // Ask the user for the number of grades
        System.out.println("How many courses do you have?");
        int amountOfGrades = scanner.nextInt();
        scanner.nextLine(); // weird issue fix
        double grades[] = new double[amountOfGrades];
        String courses[] = new String[amountOfGrades];
        boolean honors[] = new boolean[amountOfGrades]; // Array to store honors status
        
        System.out.println("Let's define the classes, abbreviatons are preferred."); // they're preferred because then tabbing gets weird with long writing
        // Loop through each course
        for (int i = 0; i < amountOfGrades; i++) {
            System.out.print("What is course " + (i+1) + "? ");
            courses[i] = scanner.nextLine(); // Store the course name in the array
        }

        System.out.println("Next, let's specify if the classes are honors or not.");
        // Loop to ask if each course is honors
        for (int i = 0; i < amountOfGrades; i++) {
            System.out.println("Is " + courses[i] + " an honors class? (true/false)");
            honors[i] = scanner.nextBoolean(); // Store the honors status
        }

        System.out.println("Lastly, let's define the respective class grades.");
        // Loop through each grade
        for (int i = 0; i < amountOfGrades; i++) {
            System.out.println("What is your grade in " + courses[i] + "? ");
            grades[i] = scanner.nextDouble(); // Store the grade in the array
        }

        // Compute grades
        System.out.println("Is it 'true' that you'd like the GPA to be computed?");
        boolean calcGPA = scanner.nextBoolean();
        if (calcGPA) {
            processGPA(grades, honors);
        }

        // Output the grades
        scanner.close();
        System.out.println("Here are your grades:");
        System.out.println("Classes:");
        for (int i = 0; i < amountOfGrades; i++) {
            System.out.print("\t" + courses[i] + (honors[i] ? "🏅" : ""));
        }
        System.out.println();
        System.out.println("Grades:");
        for (int i = 0; i < amountOfGrades; i++) {
            System.out.print("\t" + grades[i]);
        }
    }

    public static double processGPA(double[] grades, boolean[] honors) {
        double total = 0.0;
        double honorsWeight = 0.5; // Additional GPA weight for honors classes
    
        for (int i = 0; i < grades.length; i++) {
            if (honors[i]) {
                total += grades[i] + honorsWeight; // Add honors weight
            } else {
                total += grades[i];
            }
        }
    
        double gpa = total / grades.length; // Calculate the weighted average GPA
        System.out.println("Your GPA is: " + gpa);
        return gpa;
    }
    
}
