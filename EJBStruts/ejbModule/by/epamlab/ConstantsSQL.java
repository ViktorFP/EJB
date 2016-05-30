package by.epamlab;

public class ConstantsSQL {
	// data SQL
	public final static String DB_URL = "jdbc:mysql://localhost/users";
	public final static String DB_LOGIN = "ee";
	public final static String DB_PASSWORD = "ee";
	public final static String DB_DRIVER = "org.gjt.mm.mysql.Driver";
	// SQL tables
	private final static String TABLE_USER = "customers";
	private final static String COLOMN_LOGIN = "login";
	public final static String COLOMN_PASSWORD = "password";
	public final static String COLOMN_FILE = "dataFile";
	// -users
	public final static String SELECT_LOGIN = "SELECT " + COLOMN_FILE + ", " + COLOMN_PASSWORD + " FROM " + TABLE_USER
			+ " WHERE " + COLOMN_LOGIN + " = ?";
	// errors SQL
	public final static String ERROR_CLOSING = "Resource closing problem: ";
}
