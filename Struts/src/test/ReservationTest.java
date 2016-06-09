package test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.xml.sax.SAXException;

import by.epamlab.beans.User;
import by.epamlab.beans.ifaces.IReservationDAO;
import by.epamlab.beans.reservations.ResComponent;
import by.epamlab.impl.EjbUserImpl;
import by.epamlab.impl.ReservationImplXml;
import by.epamlab.impl.ReservationImplXmlEjb;

public class ReservationTest {

	private IReservationDAO reservationDAO;

	@Test
	public void testGetResComponents() throws IOException, SAXException {
		// test with started servers

		// Arrange
		reservationDAO = spy(new ReservationImplXml());
		// Act
		List<ResComponent> components = getUser().getReservation().getResComponents("", "");
		// Assert
		assertNotNull(components);
		// -----
		// Arrange
		reservationDAO = spy(new ReservationImplXmlEjb());
		// Act
		components = getUser().getReservation().getResComponents("", "");
		// Assert
		assertNotNull(components);
	}

	private User getUser() throws IOException, SAXException {
		return spy(new User("user", reservationDAO.getReservation("0004257753")));
	}

	@Test
	public void testgetReservation_not_null() {
		// Arrange
		EjbUserImpl ejbUserImpl = mock(EjbUserImpl.class);
		when(ejbUserImpl.getUser(anyString(), anyString())).thenCallRealMethod();
		// Act
		User user = ejbUserImpl.getUser("user", "user");
		// Assert
		if (user != null) {
			assertThat(user.getReservation(), notNullValue());
		}
	}
}
