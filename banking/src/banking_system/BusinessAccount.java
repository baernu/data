package banking_system;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public final class BusinessAccount extends BankAccounts{
	
	private final float lowerLimit;
	private static Transaction_Type type;

	public BusinessAccount(Customer owner, float balance, List<Transaction> listOfTransactions, float lowerLimit) {
		super(owner, balance, listOfTransactions);
		this.lowerLimit = lowerLimit;
		
	}

	@Override
	public void withdraw(float amount) {
		
		if (this.lowerLimit > this.balance - amount) {
			
			throw new IllegalArgumentException ("balance would be under the lower limit, transaction is not possible!");
		}
		
		this.balance -= amount;
		type = Transaction_Type.withdraw;
		addTransaction();
	}

	public float getLowerLimit() {
		return lowerLimit;
	}

	@Override
	public void deposit(float amount) {
		
		this.balance += amount;
		type = Transaction_Type.deposit;
		addTransaction();
	}

	@Override
	public void yearlyClosing() {
		
	}


	private void addTransaction() {
	
		this.listOfTransactions.add(new Transaction(type, LocalDate.now(), this.getBalance())); // new Date()
		
	}

	public void clearBalance() {
		this.balance = 0;
		
	}



}
