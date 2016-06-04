package by.epamlab.ejbs;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.ejb.EJBObject;

import by.epamlab.beans.reservations.ResComponent;

public interface ReservationCompSv extends EJBObject {
	ArrayList<ResComponent> getReservationComponents(String code, File file) throws RemoteException;

	ArrayList<ResComponent> getReservationComponents(String code, String componentTypeCode, File file) throws RemoteException;
}
