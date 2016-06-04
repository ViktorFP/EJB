package by.epamlab.ejbs;

import java.io.File;
import java.rmi.RemoteException;

import javax.ejb.EJBObject;

import by.epamlab.beans.reservations.customer.Customer;

public interface CustomerSv extends EJBObject {
	public Customer getCustomer(File file) throws RemoteException;
}
