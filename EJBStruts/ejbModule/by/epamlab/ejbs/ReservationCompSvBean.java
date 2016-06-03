package by.epamlab.ejbs;

import java.io.File;
import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

import by.epamlab.Constants;

public class ReservationCompSvBean implements SessionBean {

	private static final long serialVersionUID = 1L;

	public String getReservationComponents(String code, File file) {
		String components = "";
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(file);
			Element root = document.getRootElement();
			if (root.getAttributeValue("Code").equals(code)) {
				List<Element> list = root.getChildren("ResComponent", Namespace.getNamespace(Constants.NAMESPACE));
				StringBuilder sb = new StringBuilder();
				for (Element e : list) {
					sb.append(e.getAttributeValue("ComponentTypeCode") + Constants.DELIMITER
							+ e.getAttributeValue("CreateDateTime") + Constants.DELIMITER
							+ e.getAttributeValue("InternalStatus") + Constants.DELIMITER
							+ e.getAttributeValue("Sequence") + Constants.DELIMITER);
				}
				components = sb.toString();				
			}
		} catch (Exception e) {
			System.out.println(
					">>>>>>>ERROR>>>>>>\nReservationCompSvBean: getReservationComponents\n" + e.getMessage() + "\n");
		}
		return components;
	}

	public String getReservationComponents(String code, String componentTypeCode, File file) {
		String components = "";
		// сформировать строку с разделителем
		// ;//////////////////////////////////////////////////////
		return components;
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