import java.util.Scanner;

class BankAccount {
    long accountNumber;
    String accountHolderName;
    double balance;

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance is " + balance);
    }
}

public class Account {
    public static void main(String[] args) {

        BankAccount b = new BankAccount();
        b.accountHolderName = "Zaynab";
        b.accountNumber = 672312;
        b.balance = 10000.5;

        Scanner input = new Scanner(System.in);

        System.out.println("Hello Welcome! What would you like to do today?");
        System.out.println("1. Deposit Amount");
        System.out.println("2. Withdrawal Amount");
        System.out.println("3. Current Balance");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter amount:");
                double c = input.nextDouble();
                b.deposit(c);
                b.displayBalance();
                break;

            case 2:
                System.out.println("Enter amount:");
                double a = input.nextDouble();
                b.withdraw(a);
                b.displayBalance();
                break;

            case 3:
                b.displayBalance();
                break;

            default:
                System.out.println("Wrong choice.");
        }
    }
}
