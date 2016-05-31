package by.epamlab.impl;

import java.io.File;

import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import by.epamlab.beans.ifaces.IReservationDAO;
import by.epamlab.beans.reservations.EjbReservation;
import by.epamlab.beans.reservations.Reservation;
import by.epamlab.ejbs.ReservationSv;
import by.epamlab.ejbs.ReservationSvHome;
import by.epamlab.utilites.PropertiesUtil;

public class ReservationImplXmlEjb implements IReservationDAO {

	public Reservation getReservation(String fileName) {
		try {
			InitialContext jndiContext = PropertiesUtil.getInitialContext();
			Object ref = jndiContext.lookup("ReservationSv");
			ReservationSvHome home = (ReservationSvHome) PortableRemoteObject.narrow(ref, ReservationSvHome.class);
			ReservationSv reservation = home.create();
			File file = reservation.getFile(fileName);
			return new EjbReservation(reservation.getCode(file), reservation.getDescription(file), file);
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>ERROR>>>>>>>>>>>>\nReservationImplXmlEjb > getReservation:\n" + e.getMessage() + "\n");
		}
		return null;
	}
}
