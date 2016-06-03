package by.epamlab.ejbs;

import java.io.File;
import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface ReservationCompSv extends EJBObject {
	String getReservationComponents(String code, File file) throws RemoteException;

	String getReservationComponents(String code, String componentTypeCode, File file) throws RemoteException;
}
