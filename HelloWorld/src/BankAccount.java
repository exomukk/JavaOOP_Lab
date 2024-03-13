package com.bank;

public class BankAccount {
//	owner and balance are private members, meaning they can only be accessed within this class
	private String owner;
    private double balance;

//    debit and credit are public methods that can be accessed from outside this class. The debit method subtracts the specified amount from the balance, and the credit method adds the specified amount to the balance. If the debit amount is greater than the balance, it prints a message and returns the current balance without making any changes.
    public double debit(double amount) {
        if (balance < amount) {
            System.out.println("Insufficient balance!");
            return balance;
        }
        balance -= amount;
        return balance;
    }

    public double credit(double amount) {
        balance += amount;
        return balance;
    }
}
