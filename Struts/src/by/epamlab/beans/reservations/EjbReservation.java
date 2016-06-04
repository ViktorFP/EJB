package by.epamlab.beans.reservations;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import by.epamlab.beans.reservations.customer.Customer;
import by.epamlab.ejbs.CustomerSv;
import by.epamlab.ejbs.CustomerSvHome;
import by.epamlab.ejbs.ReservationCompSv;
import by.epamlab.ejbs.ReservationCompSvHome;
import by.epamlab.utilites.PropertiesUtil;

public class EjbReservation extends Reservation {
	private File file;

	public EjbReservation() {
	}

	public EjbReservation(String code, String description, File file) {
		super(code, description, null);
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public Customer getCustomer() {
		Customer customer = super.getCustomer();
		if (customer == null) {
			try {
				InitialContext jndiContext = PropertiesUtil.getInitialContext();
				Object ref = jndiContext.lookup("CustomerSv");
				CustomerSvHome home = (CustomerSvHome) PortableRemoteObject.narrow(ref, CustomerSvHome.class);
				CustomerSv customerSv = home.create();
				customer = customerSv.getCustomer(file);
			} catch (Exception e) {
				System.out.println(
						">>>>>>>>>>>ERROR>>>>>>>>>>>>\nEjbReservation > getCustomer():\n" + e.getMessage() + "\n");
			}
		}
		return customer;
	}

	@Override
	public List<ResComponent> getResComponents() {
		return getComponents(super.getCode(), null);
	}

	public List<ResComponent> getResComponents(String code, String componentTypeCode) {
		return getComponents(code, componentTypeCode);
	}

	private List<ResComponent> getComponents(String code, String componentTypeCode) {
		List<ResComponent> resComponents = super.getResComponents();
		try {
			if (resComponents == null) {
				resComponents = new ArrayList<ResComponent>();
				InitialContext jndiContext = PropertiesUtil.getInitialContext();
				Object ref = jndiContext.lookup("ReservationCompSv");
				ReservationCompSvHome home = (ReservationCompSvHome) PortableRemoteObject.narrow(ref,
						ReservationCompSvHome.class);
				ReservationCompSv components = home.create();
				String componentsData = "";
				if (componentTypeCode == null) {
					componentsData = components.getReservationComponents(code, file);
				} else {
					componentsData = components.getReservationComponents(code, componentTypeCode, file);
				}
				if (!componentsData.isEmpty()) {
					String[] componentsS = componentsData.split(";");
					for (int i = 0; i < componentsS.length;) {
						resComponents.add(new ResComponent(componentsS[i++], componentsS[i++], componentsS[i++],
								componentsS[i++]));
					}
				}
			}
		} catch (Exception e) {
			System.out.println(
					">>>>>>>>>>>ERROR>>>>>>>>>>>>\nEjbReservation > getComponents():\n" + e.getMessage() + "\n");
		}
		return resComponents;
	}
}
