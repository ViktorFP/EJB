package by.epamlab.factories;

import by.epamlab.beans.ifaces.IReservationDAO;
import by.epamlab.impl.ReservationImplXmlEjb;

public class ReservationFactory {
	public static IReservationDAO getClassFromFactory() {
		// return new ReservationImplXml();
		return new ReservationImplXmlEjb();
	}
}
