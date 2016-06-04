package by.epamlab.ejbs;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface CustomerSvHome extends EJBHome {
	public CustomerSv create() throws RemoteException, CreateException;
}
