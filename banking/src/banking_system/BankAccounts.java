package banking_system;

import java.util.List;

public abstract class BankAccounts {
	
	protected Customer owner;
	protected float balance;
	protected List<Transaction> listOfTransactions;
	
	
	
	public BankAccounts(Customer owner, float balance, List<Transaction> listOfTransactions) {
		this.owner = owner;
		this.balance = balance;
		this.listOfTransactions = listOfTransactions;
	}

	/**
	 * method for withdraw money
	 * @param amount is the sum which is removed from the account
	 * @throws Exception 
	 */
	protected abstract void withdraw(float amount) throws Exception;
	
	/**
	 * method for deposit money
	 * @param amount is the sum which is added to the account
	 * @throws Exception 
	 */
	protected abstract void deposit(float amount) throws Exception;
	
	/**
	 * every end of year the balance is added with the interestRate
	 */
	protected abstract void yearlyClosing();
	
	/**
	 * getter method for the balance of the account
	 * @return the balance of the account
	 */
	public float getBalance() {
		return balance;
	}
	
	
	
	
	
	
	
	
}
