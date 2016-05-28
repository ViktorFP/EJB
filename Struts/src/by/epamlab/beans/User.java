package by.epamlab.beans;

import by.epamlab.beans.reservations.Reservation;

public class User {
	private String name;
	private Reservation reservation;

	public User() {
	}

	public User(String name, Reservation reservation) {
		this.name = name;
		this.reservation = reservation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}
