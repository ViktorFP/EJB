package by.epamlab.ejbs;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.jdom2.JDOMException;

import by.epamlab.Constants;
import by.epamlab.Utilites;

public class ReservationSvBean implements SessionBean {

	private static final long serialVersionUID = 1L;

	public File getFile(String fileName) {
		File file = null;
		try {
			file = new File(Constants.DATA_FOLDER + fileName + ".xml");
		} catch (Exception e) {
			System.out.println(">>>>>>>ERROR>>>>>>\nReservationSvBean: getFile\n" + e.getMessage() + "\n");
		}
		return file;
	}

	public String getCode(File file) {
		String result = null;
		try {
			result = getAttributeValue(file, "Code");
		} catch (Exception e) {
			System.out.println(">>>>>>>ERROR>>>>>>\nReservationSvBean: getCode\n" + e.getMessage() + "\n");
		}
		return result;
	}

	public String getDescription(File file) {
		String result = null;
		try {
			result = getAttributeValue(file, "Description");
		} catch (Exception e) {
			System.out.println(">>>>>>>ERROR>>>>>>\nReservationSvBean: getDescription\n" + e.getMessage() + "\n");
		}
		return result;
	}

	private String getAttributeValue(File file, String attr) throws JDOMException, IOException {
		return Utilites.getRoot(file).getAttributeValue(attr);
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