package by.epamlab.factories;

import by.epamlab.beans.ifaces.IUserDAO;
import by.epamlab.impl.EjbUserImpl;

public class UserFactory {
	public static IUserDAO getClassFromFactory() {
		// return new HardcodedUserImpl();
		return new EjbUserImpl();
	}
}
