package banking_system;

import java.time.LocalDate;
import java.time.LocalDateTime;



public class Transaction {
	
	private Transaction_Type kindOfTransaction;
	private LocalDate dateOfTransaction;
	private float newBalance;

	
	
	
	public Transaction(Transaction_Type kindOfTransaction, LocalDate dateOfTransaction, float newBalance) {
		
		this.kindOfTransaction = kindOfTransaction;
		this.dateOfTransaction = dateOfTransaction;
		this.newBalance = newBalance;
		
	}

	/**
	 * getter method for the type of the transaction
	 * @return the type of the transaction
	 */
	public Transaction_Type getKindOfTransaction() {
		return kindOfTransaction;
	}
	
	/**
	 * getter method for the date and time of the transaction
	 * @return the local date and time
	 */
	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}
	
	/**
	 * getter method for the balance
	 * @return the new balance
	 */
	public float getNewBalance() {
		return newBalance;
	}
	
	/**
	 * toString method for a transaction
	 * @return the string of the transaction
	 */
	@Override
	public String toString() {
		return "Transaction [kindOfTransaction: " + kindOfTransaction.toString() + ", dateOfTransaction: " + dateOfTransaction.toString()
				+ ", newBalance = " + newBalance + "]";
	}
	
	
}
