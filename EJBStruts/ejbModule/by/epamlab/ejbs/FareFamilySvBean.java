package by.epamlab.ejbs;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.jdom2.Element;
import org.jdom2.Namespace;

import by.epamlab.Constants;
import by.epamlab.Utilites;
import by.epamlab.beans.reservations.AncillaryAirComponent;
import by.epamlab.beans.reservations.FareFamily;

public class FareFamilySvBean implements SessionBean {

	private static final long serialVersionUID = 1L;

	public FareFamily getFareFamily(File file) {
		FareFamily fareFamily = new FareFamily();
		try {
			Element root = Utilites.getRoot(file);
			Element element = root.getChild("FareFamily", Namespace.getNamespace(Constants.NAMESPACE));
			fareFamily.setFareFamilyCode(element.getAttributeValue("FareFamilyCode"));
			List<Element> listComponents = element.getChildren("AncillaryAirComponent",
					Namespace.getNamespace(Constants.NAMESPACE));
			ArrayList<AncillaryAirComponent> components = new ArrayList<>();
			for (Element e : listComponents) {
				components.add(new AncillaryAirComponent(e.getAttributeValue("AncillaryAirComponentCode")));
			}
			fareFamily.setAncillaryAirComponent(components);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fareFamily;
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