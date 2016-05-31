package by.epamlab.ejbs;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import by.epamlab.Constants;

public class UserSvBean implements SessionBean {

	private static final long serialVersionUID = 1L;

	public String getReservation(String login, String password) {
		String reservation = "";
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		InitialContext ic;
		try {
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:/SqlDS");
			con = ds.getConnection();
			pr = con.prepareStatement(Constants.SELECT_LOGIN);
			pr.setString(1, login);
			rs = pr.executeQuery();
			if (rs.next()) {
				String pass = rs.getString(Constants.COLOMN_PASSWORD);
				if (pass.equals(password)) {
					reservation = rs.getString(Constants.COLOMN_FILE);
				}
			}

		} catch (Exception e) {
			// ...delayed implementation
			System.out.println("\n>>>>>>Error>>>>>>UserSvBean:\n" + e.getMessage() + "\n");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pr != null) {
				try {
					pr.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
