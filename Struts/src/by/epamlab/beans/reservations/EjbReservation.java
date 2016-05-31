package by.epamlab.beans.reservations;

import java.io.File;

public class EjbReservation extends Reservation{
	private File file;
	public EjbReservation() {
	}

	public EjbReservation(String code, String description, File file) {
		super(code, description, null);
		this.file=file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
