/**
 * 1. Added myDoughSupply instance variable initialized to 400 ounces
 * 2. Added overloaded methods to order multiple pizzas of each type
 * 3. Added an overloaded constructor with interactive input
 * 4. Added functionality to order more supplies when thresholds are exceeded
 * 5. Added Hawaiian pizza option (new pizza type)
 * 6. Added mutator methods to update a PizzaParlor created by default constructor
 * 7. Added toString method to print PizzaParlor's state
 * 8. Added unique feature: Lent Friday check to prevent meat pizzas on Fridays during Lent
 */

 import java.util.Calendar;
 
 // PizzaParlor class to simulate a pizza restaurant
 class PizzaParlor {
   // instance variables
   private int myNumCheesePizzas;     // # of cheese pizzas
   private int myNumPeppPizzas;       // # of pepperoni pizzas
   private int myNumVegPizzas;        // # of veggie pizzas
   private int myNumHawaiianPizzas;   // # of Hawaiian pizzas (new pizza type)
   private int myCheeseSupply;        // ounces of cheese
   private int myPepperoniSupply;     // ounces of pepperoni
   private int myVeggieSupply;        // ounces of veggies
   private int myPineappleSupply;     // ounces of pineapple (for Hawaiian)
   private int myDoughSupply;         // ounces of dough
   private double myRevenue;          // dollars collected
   private double myOrigAcctBal;      // original bank account balance
   
   // Constants for thresholds and refill amounts
   private static final int CHEESE_THRESHOLD = 100;
   private static final int PEPPERONI_THRESHOLD = 50;
   private static final int VEGGIE_THRESHOLD = 50;
   private static final int PINEAPPLE_THRESHOLD = 50;
   private static final int DOUGH_THRESHOLD = 100;
   
   private static final int CHEESE_REFILL = 300;
   private static final int PEPPERONI_REFILL = 150;
   private static final int VEGGIE_REFILL = 150;
   private static final int PINEAPPLE_REFILL = 150;
   private static final int DOUGH_REFILL = 300;
   
   // default constructor
   PizzaParlor() {
     myNumCheesePizzas = 0;
     myNumPeppPizzas = 0;
     myNumVegPizzas = 0;
     myNumHawaiianPizzas = 0;
     myCheeseSupply = 400;
     myPepperoniSupply = 200;
     myVeggieSupply = 200;
     myPineappleSupply = 150;
     myDoughSupply = 400;
     myRevenue = 0;
     myOrigAcctBal = 1000;
   }
   
   // overloaded constructor that takes initial values
   PizzaParlor(int cheeseSupply, int pepperoniSupply, int veggieSupply, 
               int pineappleSupply, int doughSupply, double acctBal) {
     myNumCheesePizzas = 0;
     myNumPeppPizzas = 0;
     myNumVegPizzas = 0;
     myNumHawaiianPizzas = 0;
     myCheeseSupply = cheeseSupply;
     myPepperoniSupply = pepperoniSupply;
     myVeggieSupply = veggieSupply;
     myPineappleSupply = pineappleSupply;
     myDoughSupply = doughSupply;
     myRevenue = 0;
     myOrigAcctBal = acctBal;
   }
   
   // Lent Friday check - unique feature
   public boolean isLentFriday() {
     Calendar calendar = Calendar.getInstance();
     int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
     int month = calendar.get(Calendar.MONTH);
     
     // Check if it's Friday (Calendar.FRIDAY is 6) and in Lent season (usually Feb-April)
     return dayOfWeek == Calendar.FRIDAY && (month == Calendar.FEBRUARY || 
            month == Calendar.MARCH || month == Calendar.APRIL);
   }
   
   // Check if supplies are available for a pizza type
   private boolean hasSuppliesForCheese() {
     return myCheeseSupply >= 12 && myDoughSupply >= 11;
   }
   
   private boolean hasSuppliesForPepperoni() {
     return myCheeseSupply >= 8 && myPepperoniSupply >= 6 && myDoughSupply >= 11;
   }
   
   private boolean hasSuppliesForVeggie() {
     return myCheeseSupply >= 8 && myVeggieSupply >= 12 && myDoughSupply >= 11;
   }
   
   private boolean hasSuppliesForHawaiian() {
     return myCheeseSupply >= 8 && myPineappleSupply >= 10 && myDoughSupply >= 11;
   }
   
   // Methods to check and order supplies if below threshold
   private void checkAndOrderSupplies() {
     boolean ordered = false;
     
     if (myCheeseSupply < CHEESE_THRESHOLD) {
       myCheeseSupply += CHEESE_REFILL;
       myOrigAcctBal -= 30.0; // Cost of cheese refill
       ordered = true;
     }
     
     if (myPepperoniSupply < PEPPERONI_THRESHOLD) {
       myPepperoniSupply += PEPPERONI_REFILL;
       myOrigAcctBal -= 25.0; // Cost of pepperoni refill
       ordered = true;
     }
     
     if (myVeggieSupply < VEGGIE_THRESHOLD) {
       myVeggieSupply += VEGGIE_REFILL;
       myOrigAcctBal -= 20.0; // Cost of veggie refill
       ordered = true;
     }
     
     if (myPineappleSupply < PINEAPPLE_THRESHOLD) {
       myPineappleSupply += PINEAPPLE_REFILL;
       myOrigAcctBal -= 22.0; // Cost of pineapple refill
       ordered = true;
     }
     
     if (myDoughSupply < DOUGH_THRESHOLD) {
       myDoughSupply += DOUGH_REFILL;
       myOrigAcctBal -= 15.0; // Cost of dough refill
       ordered = true;
     }
   }
   
   // Methods to order single pizzas
   void orderCheese() {
     if (hasSuppliesForCheese()) {
       myNumCheesePizzas++;
       myRevenue += 8; // cheese pizza price: $8
       myCheeseSupply -= 12; // cheese needed per cheese pizza
       myDoughSupply -= 11; // dough needed per pizza
       checkAndOrderSupplies();
     } else {
       System.out.println("Sorry, not enough supplies for a cheese pizza.");
     }
   }
   
   void orderPepperoni() {
     if (isLentFriday()) {
       System.out.println("Sorry, we don't serve meat pizzas on Fridays during Lent.");
       return;
     }
     
     if (hasSuppliesForPepperoni()) {
       myNumPeppPizzas++;
       myRevenue += 10; // pepperoni pizza price: $10
       myCheeseSupply -= 8; // cheese needed per pepperoni pizza
       myPepperoniSupply -= 6; // pepperoni needed per pepperoni pizza
       myDoughSupply -= 11; // dough needed per pizza
       checkAndOrderSupplies();
     } else {
       System.out.println("Sorry, not enough supplies for a pepperoni pizza.");
     }
   }
   
   void orderVeggie() {
     if (hasSuppliesForVeggie()) {
       myNumVegPizzas++;
       myRevenue += 11; // veggie pizza price: $11
       myCheeseSupply -= 8; // cheese needed per veggie pizza
       myVeggieSupply -= 12; // veggies needed per veggie pizza
       myDoughSupply -= 11; // dough needed per pizza
       checkAndOrderSupplies();
     } else {
       System.out.println("Sorry, not enough supplies for a veggie pizza.");
     }
   }
   
   void orderHawaiian() {
     if (isLentFriday()) {
       System.out.println("Sorry, we don't serve Hawaiian pizzas (contains ham) on Fridays during Lent.");
       return;
     }
     
     if (hasSuppliesForHawaiian()) {
       myNumHawaiianPizzas++;
       myRevenue += 12; // Hawaiian pizza price: $12
       myCheeseSupply -= 8; // cheese needed per Hawaiian pizza
       myPineappleSupply -= 10; // pineapple needed per Hawaiian pizza
       myDoughSupply -= 11; // dough needed per pizza
       checkAndOrderSupplies();
     } else {
       System.out.println("Sorry, not enough supplies for a Hawaiian pizza.");
     }
   }
   
   // Overloaded methods to order multiple pizzas
   void orderCheese(int quantity) {
     for (int i = 0; i < quantity; i++) {
       orderCheese();
     }
   }
   
   void orderPepperoni(int quantity) {
     for (int i = 0; i < quantity; i++) {
       orderPepperoni();
     }
   }
   
   void orderVeggie(int quantity) {
     for (int i = 0; i < quantity; i++) {
       orderVeggie();
     }
   }
   
   void orderHawaiian(int quantity) {
     for (int i = 0; i < quantity; i++) {
       orderHawaiian();
     }
   }
   
   // Getter methods
   int getNumCheesePizzas() {
     return myNumCheesePizzas;
   }
   
   int getNumPepperoniPizzas() {
     return myNumPeppPizzas;
   }
   
   int getNumVeggiePizzas() {
     return myNumVegPizzas;
   }
   
   int getNumHawaiianPizzas() {
     return myNumHawaiianPizzas;
   }
   
   int getCheeseSupply() {
     return myCheeseSupply;
   }
   
   int getPepperoniSupply() {
     return myPepperoniSupply;
   }
   
   int getVeggieSupply() {
     return myVeggieSupply;
   }
   
   int getPineappleSupply() {
     return myPineappleSupply;
   }
   
   int getDoughSupply() {
     return myDoughSupply;
   }
   
   double getRevenueTotal() {
     return myRevenue;
   }
   
   double getBankAccountBalance() {
     return myOrigAcctBal + myRevenue;
   }
   
   // Setter methods (mutators)
   void setCheeseSupply(int amount) {
     myCheeseSupply = amount;
   }
   
   void setPepperoniSupply(int amount) {
     myPepperoniSupply = amount;
   }
   
   void setVeggieSupply(int amount) {
     myVeggieSupply = amount;
   }
   
   void setPineappleSupply(int amount) {
     myPineappleSupply = amount;
   }
   
   void setDoughSupply(int amount) {
     myDoughSupply = amount;
   }
   
   void setAccountBalance(double amount) {
     myOrigAcctBal = amount;
   }
   
   // toString method to print the PizzaParlor's state
   public String toString() {
     String result = "\n==== Pizza Parlor Status ====\n";
     result += "Pizzas Sold:\n";
     result += "  Cheese: " + myNumCheesePizzas + "\n";
     result += "  Pepperoni: " + myNumPeppPizzas + "\n";
     result += "  Veggie: " + myNumVegPizzas + "\n";
     result += "  Hawaiian: " + myNumHawaiianPizzas + "\n";
     result += "Current Supplies:\n";
     result += "  Cheese: " + myCheeseSupply + " oz\n";
     result += "  Pepperoni: " + myPepperoniSupply + " oz\n";
     result += "  Veggies: " + myVeggieSupply + " oz\n";
     result += "  Pineapple: " + myPineappleSupply + " oz\n";
     result += "  Dough: " + myDoughSupply + " oz\n";
     result += "Finances:\n";
     result += "  Revenue: $" + myRevenue + "\n";
     result += "  Bank Account Balance: $" + getBankAccountBalance() + "\n";
     return result;
   }
 }
 
 // PizzaTester class to test the PizzaParlor class
 public class PizzaTester {
   public static void main(String[] args) {
     // Create a PizzaParlor with the default constructor
     System.out.println("=== Testing PizzaParlor ===");
     PizzaParlor diner = new PizzaParlor();
     
     // Order some pizzas
     diner.orderCheese();
     diner.orderCheese();
     diner.orderPepperoni();
     diner.orderCheese();
     diner.orderPepperoni();
     diner.orderVeggie();
     diner.orderCheese();
     diner.orderVeggie();
     diner.orderPepperoni();
     diner.orderCheese();
     
     // Display the state after ordering
     System.out.println("\n--- Pizza Order Results ---");
     System.out.println("# of Cheese ordered is " + diner.getNumCheesePizzas());
     System.out.println("# of Pepperoni ordered is " + diner.getNumPepperoniPizzas());
     System.out.println("# of Veggie ordered is " + diner.getNumVeggiePizzas());
     System.out.println("# of Hawaiian ordered is " + diner.getNumHawaiianPizzas());
     
     System.out.print("\nRemaining supply of cheese in ounces is: ");
     System.out.println(diner.getCheeseSupply());
     System.out.print("Remaining supply of pepperoni in ounces is: ");
     System.out.println(diner.getPepperoniSupply());
     System.out.print("Remaining supply of veggies in ounces is: ");
     System.out.println(diner.getVeggieSupply());
     System.out.print("Remaining supply of pineapple in ounces is: ");
     System.out.println(diner.getPineappleSupply());
     System.out.print("Remaining supply of dough in ounces is: ");
     System.out.println(diner.getDoughSupply());
     
     System.out.println("\nRevenue is $" + diner.getRevenueTotal());
     System.out.println("Bank balance is now $" + diner.getBankAccountBalance());
     
     // Test overloaded methods to order multiple pizzas
     System.out.println("\n=== Testing Multiple Pizza Orders ===");
     PizzaParlor diner2 = new PizzaParlor();
     
     // Order multiple pizzas at once
     diner2.orderCheese(3);
     diner2.orderPepperoni(2);
     diner2.orderVeggie(2);
     diner2.orderHawaiian(1);
     
     // Display the state using toString
     System.out.println(diner2);
     
     // Test the Lent Friday feature
     System.out.println("\n=== Testing Lent Friday Feature ===");
     PizzaParlor lentDiner = new PizzaParlor();
     
     // Check if today is a Lent Friday
     boolean isLentFriday = lentDiner.isLentFriday();
     System.out.println("Ordering a pepperoni pizza:");
     if (isLentFriday) {
       System.out.println("Today is a Lent Friday - meat pizzas should be prohibited.");
     } else {
       System.out.println("Today is not a Lent Friday - all pizzas should be available.");
     }
     
     // Try ordering a pepperoni pizza
     lentDiner.orderPepperoni();
     
     // Try ordering a veggie pizza (always allowed)
     lentDiner.orderVeggie();
     System.out.println("Veggie pizzas are always allowed, even during Lent.");
   }
 }