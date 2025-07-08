import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    
    private double balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println("Deposit: " + amount + ", Balance: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawal: " + amount + ", Balance: " + balance);
            } else {
                System.out.println("Insufficient funds for withdrawal");
            }
        } finally {
            lock.unlock();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        // Creating deposit threads
        Thread depositThread1 = new Thread(() -> account.deposit(200));
        Thread depositThread2 = new Thread(() -> account.deposit(300));

        // Creating withdrawal threads
        Thread withdrawThread1 = new Thread(() -> account.withdraw(150));
        Thread withdrawThread2 = new Thread(() -> account.withdraw(400));

        // Start all threads
        depositThread1.start();
        depositThread2.start();
        withdrawThread1.start();
        withdrawThread2.start();

        // Wait for all threads to finish
        try {
            depositThread1.join();
            depositThread2.join();
            withdrawThread1.join();
            withdrawThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}