package by.epamlab.factories;

import by.epamlab.beans.ifaces.IUserDAO;
import by.epamlab.impl.HardcodedUserImpl;

public class UserFactory {
	public static IUserDAO getClassFromFactory() {
		return new HardcodedUserImpl();
	}
}
