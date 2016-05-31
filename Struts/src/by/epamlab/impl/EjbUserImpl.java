package by.epamlab.impl;

import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import by.epamlab.beans.User;
import by.epamlab.beans.ifaces.IReservationDAO;
import by.epamlab.beans.ifaces.IUserDAO;
import by.epamlab.ejbs.UserSv;
import by.epamlab.ejbs.UserSvHome;
import by.epamlab.factories.ReservationFactory;
import by.epamlab.utilites.PropertiesUtil;

public class EjbUserImpl implements IUserDAO {

	@Override
	public User getUser(String login, String password) {
		try {
			// Get an initial context
			InitialContext jndiContext = PropertiesUtil.getInitialContext();
			// Get a reference to the Bean
			Object ref = jndiContext.lookup("UserSv");
			// Get a reference from this to the Bean's Home interface
			UserSvHome home = (UserSvHome) PortableRemoteObject.narrow(ref, UserSvHome.class);
			// Create an UserSv object from the Home interface
			UserSv user = home.create();
			String reservationFile = user.getReservation(login, password);
			if (!reservationFile.isEmpty()) {
				IReservationDAO reservationDAO = ReservationFactory.getClassFromFactory();
				return new User(login, reservationDAO.getReservation(reservationFile));
			}
		} catch (Exception e) {
			System.out.println("\nEjbUserImpl > getUser:\n" + e.getMessage() + "\n");
		}
		return null;
	}
}
