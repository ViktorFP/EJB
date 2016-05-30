package by.epamlab.impl;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import by.epamlab.beans.User;
import by.epamlab.beans.ifaces.IReservationDAO;
import by.epamlab.beans.ifaces.IUserDAO;
import by.epamlab.ejbs.UserSv;
import by.epamlab.ejbs.UserSvHome;
import by.epamlab.factories.ReservationFactory;

public class EjbUserImpl implements IUserDAO {

	@Override
	public User getUser(String login, String password) {
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		properties.put(Context.PROVIDER_URL, "localhost:1099");
		try {
			// Get an initial context
			InitialContext jndiContext = new InitialContext(properties);
			// Get a reference to the Bean
			Object ref = jndiContext.lookup("UserSv");
			// Get a reference from this to the Bean's Home interface
			UserSvHome home = (UserSvHome) PortableRemoteObject.narrow(ref, UserSvHome.class);
			// Create an UserSv object from the Home interface
			UserSv user = home.create();
			if (user != null) {
				IReservationDAO reservationDAO = ReservationFactory.getClassFromFactory();
				return new User(login, reservationDAO.getReservation(user.getReservation(login, password)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
