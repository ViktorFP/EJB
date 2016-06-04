package by.epamlab.ejbs;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface FareFamilySvHome  extends EJBHome {
	public FareFamilySv create() throws RemoteException, CreateException;
}
