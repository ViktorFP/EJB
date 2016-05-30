package by.epamlab.ejbs;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import by.epamlab.ConstantsSQL;
import by.epamlab.db.DBConnector;

public class UserSvBean implements SessionBean {

	private static final long serialVersionUID = 1L;

	public String getReservation(String login, String password) throws SQLException {
		String reservation = null;
		/*DBConnector connector = null;
		PreparedStatement psSelectUser = null;
		ResultSet rs = null;
		try {
			connector = new DBConnector();
			Connection connection = connector.getConnection();

			int colIdx = 1;
			psSelectUser = connection.prepareStatement(ConstantsSQL.SELECT_LOGIN);
			psSelectUser.setString(colIdx, login);
			rs = psSelectUser.executeQuery();
			if (rs.next()) {
				String pass = rs.getString(ConstantsSQL.COLOMN_PASSWORD);
				if (pass.equals(password)) {
					reservation = rs.getString(ConstantsSQL.COLOMN_FILE);
				}
			}
		} finally {
			connector.closeDB(connector, rs, psSelectUser);
		}*/

		if (login.equals("user")) {
			reservation = "0004257753";
		} else {
			reservation = "2224257753";
		}
		return reservation;
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
