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
import by.epamlab.beans.reservations.ResComponent;

public class ReservationCompSvBean implements SessionBean {

	private static final long serialVersionUID = 1L;

	public ArrayList<ResComponent> getReservationComponents(String code, File file) {
		return getDataComponents(code, null, file);
	}

	public ArrayList<ResComponent> getReservationComponents(String code, String componentTypeCode, File file) {
		return getDataComponents(code, componentTypeCode, file);
	}

	private ArrayList<ResComponent> getDataComponents(String code, String componentTypeCode, File file) {
		ArrayList<ResComponent> components = new ArrayList<>();
		try {			
			Element root = Utilites.getRoot(file);
			if (root.getAttributeValue("Code").equals(code)) {
				List<Element> list = root.getChildren("ResComponent", Namespace.getNamespace(Constants.NAMESPACE));
				for (Element e : list) {
					if (componentTypeCode == null) {
						addComponent(components, e);
					} else {
						if (e.getAttributeValue("ComponentTypeCode").equals(componentTypeCode)) {
							addComponent(components, e);
						}
					}
				}
			}
		} catch (Exception e) {
			System.out
					.println(">>>>>>>ERROR>>>>>>\nReservationCompSvBean: getDataComponents\n" + e.getMessage() + "\n");
		}
		return components;
	}

	private void addComponent(List<ResComponent> components, Element e) {
		components.add(new ResComponent(e.getAttributeValue("ComponentTypeCode"), e.getAttributeValue("CreateDateTime"),
				e.getAttributeValue("InternalStatus"), e.getAttributeValue("Sequence")));
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