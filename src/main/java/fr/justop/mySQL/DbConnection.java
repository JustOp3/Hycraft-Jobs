package fr.justop.mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DbConnection {
	private DbCredentials dbCredentials;
	private Connection connection;


	public DbConnection(DbCredentials dbCredentials) {
		this.dbCredentials = dbCredentials;
		this.connect();
	}

	public void connect() {
		try {
			Class.forName("com.mysql.jbdc.Driver");
			this.connection = DriverManager.getConnection(this.dbCredentials.toURI(), this.dbCredentials.getUser(), this.dbCredentials.getPass());

			Logger.getLogger("Minecraft").info("§aConnection à la DB réussie!");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void close() throws SQLException {
		if (this.connection != null) {
			if (!this.connection.isClosed()) {
				this.connection.close();
			}
		}

	}

	public Connection getConnection() throws SQLException {
		if (this.connection != null) {
			if (!this.connection.isClosed()) {
				return this.connection;
			}
		}

		connect();
		return this.connection;
	}
}
