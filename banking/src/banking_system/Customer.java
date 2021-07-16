package banking_system;

public class Customer {
	


	private String FirstName;
	private String LastName;
	private String StreetAndNumber;
	private String City;
	
	
	public Customer(String firstName, String lastName, String streetAndNumber, String city) {
		super();
		FirstName = firstName;
		LastName = lastName;
		StreetAndNumber = streetAndNumber;
		City = city;
	}
	
	/**
	 * getter method for the first name
	 * @return the first name
	 */
	public String getFirstName() {
		return FirstName;
	}
	
	/**
	 * getter method for the last name
	 * @return the last name
	 */
	public String getLastName() {
		return LastName;
	}
	
	/**
	 * getter method for the street and number
	 * @return the street and number
	 */
	public String getStreetAndNumber() {
		return StreetAndNumber;
	}
	
	/**
	 * getter method for the city
	 * @return the city
	 */
	public String getCity() {
		return City;
	}
	
	@Override
	public String toString() {
		return "Customer [FirstName: " + getFirstName() + ", LastName: " + getLastName() + ", StreetAndNumber: " + getStreetAndNumber()
				+ ", City: " + getCity() + "]";
	}

}
