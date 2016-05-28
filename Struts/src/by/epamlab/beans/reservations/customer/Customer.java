package by.epamlab.beans.reservations.customer;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String  customerDocID;
	private String firstName;
	private String lastName;
	private int sequence;
	private Email email;
	private Phone phone;
	private List<Payment>payments;
	
	public Customer() {
	}

	public Customer(String customerDocID, String firstName, String lastName,
			String sequence) {
		this.customerDocID = customerDocID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sequence = Integer.parseInt(sequence);
		payments=new ArrayList<Payment>();
	}

	
	public String getCustomerDocID() {
		return customerDocID;
	}

	public void setCustomerDocID(String customerDocID) {
		this.customerDocID = customerDocID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

}
