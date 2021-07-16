package banking_system;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public final class CheckingAccount extends BankAccounts{

	private static Transaction_Type type;

	public CheckingAccount(Customer owner, float balance, List<Transaction> listOfTransactions) {
		super(owner, balance, listOfTransactions);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void withdraw(float amount) {
		
		if ( this.balance < amount) {
			
			throw new IllegalArgumentException ("the balance become negative, transaction is not possible!");
		}
		this.balance -= amount;
		type = Transaction_Type.withdraw;
		addTransaction();
	}

	@Override
	public void deposit(float amount) {
		this.balance += amount;
		type = Transaction_Type.deposit;
		addTransaction();
	}

	@Override
	protected void yearlyClosing() {
		
	}

	/**
	 * This method add the details of a transaction to the transaction-list
	 */
	private void addTransaction() {
		
		this.listOfTransactions.add(new Transaction(type, LocalDate.now(), this.getBalance()));
		
	}

	public void clearBalance() {
		this.balance = 0.00f;
		
	}
	

	

	

}
