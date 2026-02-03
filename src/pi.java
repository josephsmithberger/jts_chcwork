public class pi {
	public static void main(String[] args) {
		double sum = 0.0;        // this will hold the running total for pi/4
		int maxTerms = 4;        // we only need the first 4 partial sums

	System.out.println("Leibniz series for pi/4: 1 - 1/3 + 1/5 - 1/7 + ...");
		for (int n = 0; n < maxTerms; n++) {
			// term index n gives denominator (2n + 1) and sign alternates +, - , + , - ...
			double sign;
			if (n % 2 == 0) {
				sign = 1.0;
			} else {
				sign = -1.0;
			}
			double term = sign / (2 * n + 1);

			sum += term; // add this term to the running total

			// Print the partial sum after N = n + 1 terms (no formatting methods)
			System.out.println("N=" + (n + 1) + "  pi/4 " + sum);
		}

		// Multiply by 4 to approximate pi and compare with Math.PI
		double piApprox = sum * 4.0;
		System.out.println();
		System.out.println("approx pi = " + piApprox);
		System.out.println("Math.PI  = " + Math.PI);
	}
}
