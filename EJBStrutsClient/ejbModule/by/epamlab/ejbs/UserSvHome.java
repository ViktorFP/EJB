package by.epamlab.ejbs;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface UserSvHome extends EJBHome {
	public UserSv create() throws RemoteException, CreateException;
}
