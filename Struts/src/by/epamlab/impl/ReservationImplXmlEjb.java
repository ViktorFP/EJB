package by.epamlab.impl;

import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.SAXException;

import by.epamlab.beans.ifaces.IReservationDAO;
import by.epamlab.beans.reservations.EjbReservation;
import by.epamlab.beans.reservations.Reservation;

public class ReservationImplXmlEjb implements IReservationDAO {

	@Override
	public Reservation getReservation(String fileName) throws IOException, SAXException {
		try {
			SAXBuilder builder = new SAXBuilder();
			fileName = this.getClass().getClassLoader().getResource("").getPath() + fileName + ".xml";
			String space = "%20";
			if (fileName.contains(space)) {
				String[] elements = fileName.split(space);
				StringBuilder sb = new StringBuilder();
				for (String s : elements) {
					sb.append(s + " ");
				}
				fileName = sb.toString();
			}
			File file = new File(fileName);
			Document document = builder.build(file);
			Element root = document.getRootElement();
			return new EjbReservation(root.getAttributeValue("Code"), root.getAttributeValue("Description"), file);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		/*
		 * XMLReader reader = XMLReaderFactory.createXMLReader(); DataHandler
		 * dataHandler = new DataHandler();
		 * reader.setContentHandler(dataHandler);
		 * reader.parse(this.getClass().getClassLoader().getResource("").getPath
		 * ()+fileName+".xml"); return dataHandler.getReservation();
		 */
		return null;
	}

}
