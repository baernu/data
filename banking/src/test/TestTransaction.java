package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
//import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import banking_system.Transaction;
import banking_system.Transaction_Type;

class TestTransaction {
	
	private static Transaction transact;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		transact = new Transaction(Transaction_Type.withdraw, LocalDate.now(), 5232.12f);
	}

	@Test
	void test() {
		assertEquals("Transaction [kindOfTransaction: withdraw" + ", dateOfTransaction: " + LocalDate.now().toString()
		+ ", newBalance = " + 5232.12f + "]", TestTransaction.transact.toString() );
	}

}
