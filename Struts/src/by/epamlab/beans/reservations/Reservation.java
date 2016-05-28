package by.epamlab.beans.reservations;

import java.util.List;

import by.epamlab.beans.reservations.customer.Customer;

public class Reservation{
	private String code;
	private String description;
	private List<ResComponent> resComponent;
	private Customer customer;
	private FareFamily fareFamily;

	public Reservation() {
	}

	public Reservation(String code, String description,
			List<ResComponent> resComponent) {
		this.code = code;
		this.description = description;
		this.resComponent = resComponent;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ResComponent> getResComponent() {
		return resComponent;
	}

	public void setResComponent(List<ResComponent> resComponent) {
		this.resComponent = resComponent;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public FareFamily getFareFamily() {
		return fareFamily;
	}

	public void setFareFamily(FareFamily fareFamily) {
		this.fareFamily = fareFamily;
	}
}
