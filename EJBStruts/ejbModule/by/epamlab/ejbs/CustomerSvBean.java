package by.epamlab.ejbs;

import java.io.File;
import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import by.epamlab.beans.reservations.customer.Customer;

public class CustomerSvBean implements SessionBean {

	private static final long serialVersionUID = 1L;

	public Customer getCustomer(File file){
		///////////////////////////////////////////////////////
		return null;
	}

	public void ejbCreate() throws EJBException {
	}

	@Override
	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

}