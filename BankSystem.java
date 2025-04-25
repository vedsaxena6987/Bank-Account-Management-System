import java.util.InputMismatchException;
import java.util.Scanner;

// User-defined exception for invalid amounts
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

// User-defined exception for insufficient funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Bank Account class
class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("Deposited: ₹" + amount);
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance. Available: ₹" + balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: ₹" + amount);
    }

    public void viewBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        try {
            System.out.print("Enter account holder's name: ");
            String name = scanner.nextLine();
            account = new BankAccount(name);

            boolean running = true;
            while (running) {
                System.out.println("\n1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. View Balance");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice;
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.nextLine(); // clear invalid input
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        try {
                            double deposit = scanner.nextDouble();
                            account.deposit(deposit);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a numeric value.");
                            scanner.nextLine(); // clear buffer
                        } catch (InvalidAmountException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        try {
                            double withdrawal = scanner.nextDouble();
                            account.withdraw(withdrawal);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a numeric value.");
                            scanner.nextLine(); // clear buffer
                        } catch (InvalidAmountException | InsufficientFundsException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 3:
                        account.viewBalance();
                        break;

                    case 4:
                        running = false;
                        System.out.println("Thank you for using our service.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please select 1–4.");
                }
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            
            System.out.println("Thankyou / See you next tiem --> Terminated.");
        }
        scanner.close();

    }
}
