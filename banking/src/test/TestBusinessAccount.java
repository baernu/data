package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import banking_system.BusinessAccount;
import banking_system.Customer;
import banking_system.Transaction;

class TestBusinessAccount {

	private static Customer custom;
	private static BusinessAccount busiac;
	private static List<Transaction> list = new ArrayList<>(500);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		custom = new Customer("Bernhard", "Messerli", "Illiswilstrasse 11", "3033 Wohlen");
		busiac = new BusinessAccount(custom, 0.00f, list, -2500.00f);
	}
	
	@BeforeEach
	void clearBalance() {
		busiac.clearBalance();
	}
	@Test
	void testInitialisation() {
		assertEquals(0.00f, TestBusinessAccount.busiac.getBalance(),0.001);
		
	}
	
	@Test
	void testWithdrawException() {
		//busiac.withdraw(2600.00f);
		assertThrows(IllegalArgumentException.class, () -> busiac.withdraw(2600.00f));
		
		
	}
	
	@Test
	void testLowerLimit() {
		assertEquals(-2500.00f, TestBusinessAccount.busiac.getLowerLimit(), 0.001);
		
	}
	
	@Test
	void testdeposit() {
		TestBusinessAccount.busiac.deposit(2500.08f);
		assertEquals(2500.08, TestBusinessAccount.busiac.getBalance(), 0.001);
		
	}
}
