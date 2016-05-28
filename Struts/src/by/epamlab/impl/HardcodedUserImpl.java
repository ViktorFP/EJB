package by.epamlab.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.xml.sax.SAXException;

import by.epamlab.beans.User;
import by.epamlab.beans.ifaces.IReservationDAO;
import by.epamlab.beans.ifaces.IUserDAO;
import by.epamlab.factories.ReservationFactory;

public class HardcodedUserImpl implements IUserDAO {

	private static Map<String, Map<String, User>> users = new HashMap<>();

	static {
		Map<String, User> user = new HashMap<>();
		IReservationDAO reservationDAO = ReservationFactory
				.getClassFromFactory();
		try {
			user.put(
					"user",
					new User("user", reservationDAO
							.getReservation("0004257753")));
			users.put("user", user);
		} catch (IOException | SAXException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUser(String login, String password) {
		if (users.containsKey(login)) {
			Map<String, User> map = users.get(login);
			if (map.containsKey(password)) {
				return map.get(password);
			}
		}
		return null;
	}
}
