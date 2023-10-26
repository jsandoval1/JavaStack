public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;

    private static int accounts = 0;
    private static double totalMoney = 0; // refers to the sum of all bank account checking and savings balances

    // ! CONSTRUCTOR
    // Be sure to increment the number of accounts
    public BankAccount(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        accounts++; // * Increments the number of accounts whenever a new BankAccount object is
                    // created
        totalMoney += checkingBalance + savingsBalance;
    }

    // ! GETTERS
    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    //* static method BankAccount.getAccountsCount() returns the value of the
    //* accounts variable
    public static int getAccountsCount() {
        return accounts;
    }

    public static double getTotalMoneyCount() {
        return totalMoney;
    }

    // ! METHODS
    // * deposit
    public void depositCheckingBalance(double money) {
        checkingBalance += money; // *This is the correct way because primitve data type
        totalMoney += money; // Update the totalMoney as well
        // ! I was trying to do this based off CoffeeAssign but that was different
        // ! because that was an array
        // checkingBalance.add(money);
    }

    public void depositSavingsBalance(double money) {
        savingsBalance += money;
        totalMoney += money;
        // ! Tried doing the same concept here
        // savingsBalance.add(money);
    }

    // * withdraw
    public void withdrawCheckingBalance(double money) {
        if (money <= checkingBalance) { // - do not allow them to withdraw money if there are insufficient funds
            checkingBalance -= money;
            totalMoney -= money;
        } else {
            System.out.println("Insufficient funds in checking account.");
        }
    }

    public void withdrawSavingsBalance(double money) {
        if (money <= savingsBalance) {
            savingsBalance -= money;
            totalMoney -= money;
        } else {
            System.out.println("Insufficient funds in savings account.");
        }
    }

    // * getBalance
    public double getBalance() {
        return checkingBalance + savingsBalance;
    }

}
