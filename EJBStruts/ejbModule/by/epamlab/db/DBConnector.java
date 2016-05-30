package by.epamlab.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.epamlab.ConstantsSQL;

public class DBConnector {
	private Connection connection;

	static {
		try {
			Class.forName(ConstantsSQL.DB_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new NullPointerException();
		}
	}

	public DBConnector() throws SQLException {
		connection = DriverManager.getConnection(ConstantsSQL.DB_URL, ConstantsSQL.DB_LOGIN, ConstantsSQL.DB_PASSWORD);
	}

	public Connection getConnection() {
		return connection;
	}

	private void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println(ConstantsSQL.ERROR_CLOSING + e);
			}
		}
	}

	private void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.err.println(ConstantsSQL.ERROR_CLOSING + e);
			}
		}
	}

	private void closeStatements(Statement... statements) {
		for (Statement statement : statements) {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.err.println(ConstantsSQL.ERROR_CLOSING + e);
				}
			}
		}
	}

	public void closeDB(DBConnector connector, ResultSet rs, PreparedStatement... preparedStatement) {
		if (connector != null) {
			connector.closeResultSet(rs);
			connector.closeStatements(preparedStatement);
			connector.closeConnection();
		}
	}

	public void closeDB(DBConnector connector, PreparedStatement... preparedStatement) {
		if (connector != null) {
			connector.closeStatements(preparedStatement);
			connector.closeConnection();
		}
	}
}
