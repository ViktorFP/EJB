package test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import by.epamlab.beans.reservations.EjbReservation;
import by.epamlab.beans.reservations.ResComponent;
import by.epamlab.beans.reservations.Reservation;

public class ReservationTest {
	@Test
	public void testGetResComponents() throws Exception {
		// test with started servers

		// Arrange
		Reservation reservation = new Reservation();
		// Act
		List<ResComponent> components = reservation.getResComponents("", "");
		// Assert
		assertNotNull(components);

		// ------------
		// Arrange
		reservation = new EjbReservation();
		// Act
		components = reservation.getResComponents("", "");
		// Assert
		assertNotNull(components);
	}
}
