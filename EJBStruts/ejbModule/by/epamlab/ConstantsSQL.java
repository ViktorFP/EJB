package by.epamlab;

public class ConstantsSQL {
	// SQL tables
	private final static String TABLE_USER = "customers";
	private final static String COLOMN_LOGIN = "login";
	public final static String COLOMN_PASSWORD = "password";
	public final static String COLOMN_FILE = "dataFile";
	// -users
	public final static String SELECT_LOGIN = "SELECT " + COLOMN_PASSWORD + ", " + COLOMN_FILE + " FROM " + TABLE_USER
			+ " WHERE " + COLOMN_LOGIN + " = ?";
}
