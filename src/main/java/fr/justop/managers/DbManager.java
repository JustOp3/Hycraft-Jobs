package fr.justop.managers;

import fr.justop.mySQL.DbConnection;
import fr.justop.mySQL.DbCredentials;

import java.sql.SQLException;

public class DbManager {
	private DbConnection jobsLevelsConnection;

	public DbManager() {
		this.jobsLevelsConnection = new DbConnection(new DbCredentials("localhost", "u4_c5qWr8MtUl", "M8ydVtx+e6@3aolco@CF3pLC", "s4_hycraftjobs", 3306));
	}

	public DbConnection getJobsLevelsConnection() {
		return this.jobsLevelsConnection;
	}

	public void close() {
		try {
			this.jobsLevelsConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
