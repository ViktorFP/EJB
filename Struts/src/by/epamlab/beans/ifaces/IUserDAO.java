package by.epamlab.beans.ifaces;

import by.epamlab.beans.User;

public interface IUserDAO {
	public User getUser(String login, String password);
}
