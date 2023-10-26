public class BankTest {
    public static void main(String[] args) {
        // Create 3 bank accounts
        BankAccount account1 = new BankAccount(1000, 2000);
        BankAccount account2 = new BankAccount(1500, 2500);
        BankAccount account3 = new BankAccount(2000, 3000);

        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        // - each deposit should increase the amount of totalMoney
        account1.depositCheckingBalance(500); // Deposit $500 into checking account
        account2.depositSavingsBalance(750);  // Deposit $750 into savings account
        account3.depositCheckingBalance(1000); // Deposit $1000 into checking account

        // Display account balances after deposits
        System.out.println("Account 1 Balance: " + account1.getBalance());
        System.out.println("Account 2 Balance: " + account2.getBalance());
        System.out.println("Account 3 Balance: " + account3.getBalance());

        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney
        account1.withdrawCheckingBalance(200); // Withdraw $200 from checking account
        account2.withdrawSavingsBalance(300);  // Withdraw $300 from savings account
        account3.withdrawCheckingBalance(400); // Withdraw $400 from checking account

        // Display account balances after withdrawals
        System.out.println("Account 1 Balance after Withdrawal: " + account1.getBalance());
        System.out.println("Account 2 Balance after Withdrawal: " + account2.getBalance());
        System.out.println("Account 3 Balance after Withdrawal: " + account3.getBalance());

        // Static Test (print the number of bank accounts and the totalMoney)
        System.out.println("Number of Bank Accounts: " + BankAccount.getAccountsCount());
        System.out.println("Total Money across all Accounts: " + BankAccount.getTotalMoneyCount());
    }
}
