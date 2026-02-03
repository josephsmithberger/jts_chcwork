public class JSpiggyBank {
    private int myPennies;
    private int myNickels;
    private int myDimes;
    private int myQuarters;
    private double myTotal;

    // ---------- constructors ----------
    public JSpiggyBank() {                         // empty bank
        myPennies = myNickels = myDimes = myQuarters = 0;
        myTotal = 0.0;
    }

    public JSpiggyBank(int pennies, int nickels, int dimes, int quarters) {
        myPennies  = pennies;
        myNickels  = nickels;
        myDimes    = dimes;
        myQuarters = quarters;
        myTotal    = getTotal();
    }

    // start with a dollar amount 
    public JSpiggyBank(double amount) {
        myPennies = myNickels = myDimes = myQuarters = 0;  // initialise
        addAmount(amount);                                 // convert dollars → coins
    }

    // ---------- individual adders ----------
    public void addPennies(int pennies)   { myPennies  += pennies;  myTotal = getTotal(); }
    public void addNickels(int nickels)   { myNickels  += nickels;  myTotal = getTotal(); }
    public void addDimes(int dimes)       { myDimes    += dimes;    myTotal = getTotal(); }
    public void addQuarters(int quarters) { myQuarters += quarters; myTotal = getTotal(); }

    // add a mix at once
    public void deposit(int pennies, int nickels, int dimes, int quarters) {
        myPennies  += pennies;
        myNickels  += nickels;
        myDimes    += dimes;
        myQuarters += quarters;
        myTotal     = getTotal();
    }

    // add a plain dollar amount
    public void addAmount(double amount) {
        int cents = (int) Math.round(amount * 100);   // dollars to cents

        int addQuarters = cents / 25; cents %= 25;
        int addDimes    = cents / 10; cents %= 10;
        int addNickels  = cents / 5;  cents %= 5;
        int addPennies  = cents;

        myQuarters += addQuarters;
        myDimes    += addDimes;
        myNickels  += addNickels;
        myPennies  += addPennies;
        myTotal     = getTotal();
    }

    // ---------- getters ----------
    public int    getPennies()  { return myPennies;  }
    public int    getNickels()  { return myNickels;  }
    public int    getDimes()    { return myDimes;    }
    public int    getQuarters() { return myQuarters; }

    // dollar value
    public double getTotal() {
        myTotal = myPennies  * 0.01
                + myNickels  * 0.05
                + myDimes    * 0.10
                + myQuarters * 0.25;
        return myTotal;
    }

    // to string
    public String toString() {
        double rounded = Math.round(getTotal() * 100) / 100.0;  // round to two decimals
        return "PiggyBank: " + myPennies  + " pennies, "
                             + myNickels  + " nickels, "
                             + myDimes    + " dimes, "
                             + myQuarters + " quarters — $" + rounded;
    }
}