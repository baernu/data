package test;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import banking_system.CheckingAccount;
import banking_system.Customer;
import banking_system.Transaction;

class TestCheckingAccount {

	private static Customer custom;
	private static CheckingAccount checkac;
	private static List<Transaction> list = new ArrayList<>(500);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		custom = new Customer("Bernhard", "Messerli", "Illiswilstrasse 11", "3033 Wohlen");
		checkac = new CheckingAccount(custom, 0.00f, list);
	}
	
	@BeforeEach
	void clearBalance() {
		checkac.clearBalance();
	}
	@Test
	void testInitialisation() {
		assertEquals(0.00f, TestCheckingAccount.checkac.getBalance(),0.001);
		
	}
	
	@Test
	void testWithdrawException() {
		assertThrows(IllegalArgumentException.class, () -> checkac.withdraw(500));
		
	}
	
	@Test
	void testdeposit() {
		TestCheckingAccount.checkac.deposit(2500.08f);
		assertEquals(2500.08, TestCheckingAccount.checkac.getBalance(), 0.001);
		
	}
	
	
}	

