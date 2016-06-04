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
import by.epamlab.beans.reservations.customer.Customer;
import by.epamlab.beans.reservations.customer.Email;
import by.epamlab.beans.reservations.customer.Payment;
import by.epamlab.beans.reservations.customer.Phone;
import by.epamlab.beans.reservations.customer.Status;

public class CustomerSvBean implements SessionBean {

	private static final long serialVersionUID = 1L;

	public Customer getCustomer(File file) {
		Customer customer = null;
		try {
			Element root = Utilites.getRoot(file);
			Element element = root.getChild("Customer", Namespace.getNamespace(Constants.NAMESPACE));
			customer = new Customer(element.getAttributeValue("CustomerDocID"), element.getAttributeValue("FirstName"),
					element.getAttributeValue("LastName"), element.getAttributeValue("Sequence"));
			// Email
			Element child = element.getChild("Email", Namespace.getNamespace(Constants.NAMESPACE));
			customer.setEmail(new Email(child.getAttributeValue("Default"), child.getAttributeValue("EmailAddress"),
					child.getAttributeValue("EmailType"), child.getAttributeValue("Sequence"),
					Enum.valueOf(Status.class, child.getAttributeValue("SyncStatus"))));
			// Phone
			child = element.getChild("Phone", Namespace.getNamespace(Constants.NAMESPACE));
			customer.setPhone(new Phone(child.getAttributeValue("Default"), child.getAttributeValue("PhoneNumber"),
					child.getAttributeValue("PhoneType"), child.getAttributeValue("Sequence"),
					child.getAttributeValue("SyncStatus")));
			// Payments
			List<Element> listPayments = element.getChildren("Payment", Namespace.getNamespace(Constants.NAMESPACE));
			ArrayList<Payment> payments = new ArrayList<>();
			for (Element e : listPayments) {
				payments.add(new Payment(e.getAttributeValue("AmountPaid"),
						e.getAttributeValue("FormOfPaymentTypeCode"), e.getAttributeValue("CurrencyCode")));
			}
			customer.setPayments(payments);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
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