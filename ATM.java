// Here's a basic implementation of the described functionality:

// ```java

import java.util.Scanner;

class ATM 
{
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.executeTransaction();
    }

    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) 
    {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() 
    {
        System.out.println("Welcome to the ATM.");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void executeTransaction() 
    {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        System.out.println("Thank you for using the ATM.");
    }

    private void checkBalance() 
    {
        System.out.println("Your balance is: $" + account.getBalance());
    }

    private void deposit() 
    {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful.");
    }

    private void withdraw() 
    {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        }
    }
}

class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance) 
    {
        balance = initialBalance;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void deposit(double amount) 
    {
        balance += amount;
    }

    public boolean withdraw(double amount) 
    {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}


//  This code provides a simple ATM simulation. It creates classes for the ATM and the user's bank account.
// The ATM class has methods for displaying the menu and executing transactions. The user can check their balance, deposit money, withdraw money, and exit the ATM. The code also validates user input and displays appropriate messages based on the success or failure of transactions.
