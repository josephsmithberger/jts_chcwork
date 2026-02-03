import java.util.Scanner;

public class sentinel {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Powers of 2 calculator");
		System.out.println("Enter a non-negative power. Enter -1 to stop");

		int n = 0; // the power the user enters
		boolean keepGoing = true;

		// Outer sentinel-controlled do-while loop
		do {
			System.out.print("power: ");
			n = in.nextInt();

			if (n == -1) {
				System.out.println("stop");
				keepGoing = false;
			} else {
				if (n >= 0) {
					int result = 1; // start at 1 so that multiplying by 2 n times gives 2^n
					int count = 0;

					if (n > 0) {
						// Inner do-while loop multiplies by 2, n times
						do {
							result = result * 2;
							count = count + 1;
						} while (count < n);
					}

					// For n == 0, result stays 1, which is 2^0
					System.out.println(result);
				} else {
					System.out.println("enter 0 or more, or -1 to stop");
				}
			}

		} while (keepGoing);

		in.close();
	}
}
