package by.epamlab.ejbs;

import java.io.File;
import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface ReservationSv extends EJBObject {
	public File getFile(String fileName) throws RemoteException;

	public String getCode(File file) throws RemoteException;

	public String getDescription(File file) throws RemoteException;
}
