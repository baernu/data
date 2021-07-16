package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import banking_system.Customer;
import banking_system.SavingAccount;
import banking_system.Transaction;

class TestSavingAccount {

	private static Customer custom;
	private static SavingAccount saveac;
	private static List<Transaction> list = new ArrayList<>(500);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		custom = new Customer("Bernhard", "Messerli", "Illiswilstrasse 11", "3033 Wohlen");
		saveac = new SavingAccount(custom, 0.00f, list, 0.08f, 3);
	}
	
	@BeforeEach
	void clearBalance() {
		saveac.clearBalance();
	}
	@Test
	void testInitialisation() {
		assertEquals(0.00f, TestSavingAccount.saveac.getBalance(),0.001);
		
	}
	
	@Test
	void testWithdrawException() {
		saveac.deposit(200);
		saveac.deposit(200);
		saveac.deposit(200);
		assertThrows(IllegalArgumentException.class, () -> saveac.withdraw(500));
		
	}
	
	@Test
	void testdeposit() {
		TestSavingAccount.saveac.deposit(2500.08f);
		assertEquals(2500.08, TestSavingAccount.saveac.getBalance(), 0.001);
		
	}
	
	@Test
	void testYearlyClosing() {
		TestSavingAccount.saveac.deposit(2500.08f);
		TestSavingAccount.saveac.yearlyClosing();
		assertEquals((2500.08f + 2500.08f*0.08f), TestSavingAccount.saveac.getBalance(), 0.001);
		assertEquals(0, saveac.getCounterofTransactions());
		
	}

}
