package by.epamlab.ejbs;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface ReservationCompSvHome  extends EJBHome {
	public ReservationCompSv create() throws RemoteException, CreateException;
}
