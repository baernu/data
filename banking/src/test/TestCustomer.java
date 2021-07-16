package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import banking_system.Customer;

class TestCustomer {
	
	private static Customer custom;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		custom = new Customer("Bernhard", "Messerli", "Illiswilstrasse 11", "3033 Wohlen");
	}

	@Test
	void test() {
		assertEquals( "Customer [FirstName: " + "Bernhard" + ", LastName: " + "Messerli" + ", StreetAndNumber: " + "Illiswilstrasse 11"
				+ ", City: " + "3033 Wohlen" + "]", TestCustomer.custom.toString());
	}

}
