package by.epamlab.ejbs;

import java.io.File;
import java.rmi.RemoteException;

import javax.ejb.EJBObject;

import by.epamlab.beans.reservations.FareFamily;

public interface FareFamilySv extends EJBObject {
	public FareFamily getFareFamily(File file) throws RemoteException;
}
