package banking_system;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public final class SavingAccount extends BankAccounts{
	
	private static int maximalNumbersOfTransaction;
	private float interestRate;
	private static Transaction_Type type;
	private int counterofTransactions = 0;
	

	public SavingAccount(Customer owner, float balance, List<Transaction> listOfTransactions, 
			float interestRate, int maximalNumberOfTransactions) {
		super(owner, balance, listOfTransactions);
		this.interestRate = interestRate;
		SavingAccount.maximalNumbersOfTransaction = maximalNumberOfTransactions;
	}

	public SavingAccount(Customer owner, float balance, List<Transaction> listOfTransactions) {
		super(owner, balance, listOfTransactions);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void withdraw(float amount) {
		if (this.counterofTransactions >= maximalNumbersOfTransaction) {
			
			throw new IllegalArgumentException("the maximum of transactions is reached, no more transaction possible");
		}
		this.balance -= amount;
		this.counterofTransactions++;
		type = Transaction_Type.withdraw;
		addTransaction();
	}

	@Override
	public void deposit(float amount) {
		if (this.counterofTransactions > maximalNumbersOfTransaction) {
			
			throw new IllegalArgumentException("the maximum of transactions is reached, no more transaction possible");
		}
		this.balance += amount;
		counterofTransactions++;
		type = Transaction_Type.deposit;
		addTransaction();
		
	}

	
	public int getCounterofTransactions() {
		return counterofTransactions;
	}

	public void yearlyClosing() {
		this.balance += interestRate * this.balance;
		this.counterofTransactions = 0;
	}

	
	private void addTransaction() {
		
		this.listOfTransactions.add(new Transaction(type, LocalDate.now(), this.getBalance()));
		
	}
	
	public void clearBalance() {
		this.balance = 0;
	}

	
}
