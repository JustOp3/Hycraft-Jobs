package fr.justop.managers;

import fr.justop.mySQL.DbConnection;
import fr.justop.mySQL.DbCredentials;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {
	private DbConnection jobsLevelsConnection;

	public DbManager() {
		this.jobsLevelsConnection = new DbConnection(new DbCredentials("localhost", "u4_c5qWr8MtUl", "M8ydVtx+e6@3aolco@CF3pLC", "s4_hycraftjobs", 3306));
	}

	public DbConnection getJobsLevelsConnection() {
		return this.jobsLevelsConnection;
	}

	public void setupDatabase() throws SQLException {
		Connection connection = getJobsLevelsConnection().getConnection();

		Statement statement = connection.createStatement();
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS mineur_stats(uuid varchar(36), xp_mineur INT, rewards_mineur TINYINT, browse_schema BIGINT)");
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS farmeur_stats(uuid varchar(36), xp_farmeur INT, rewards_farmeur TINYINT)");
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS chasseur_stats(uuid varchar(36), xp_chasseur INT, rewards_chasseur TINYINT)");
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS meca_stats(uuid varchar(36), xp_meca INT, rewards_meca TINYINT)");
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS pecheur_stats(uuid varchar(36), xp_pecheur INT, rewards_pecheur TINYINT)");
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS bucheron_stats(uuid varchar(36), xp_bucheron INT, rewards_bucheron TINYINT)");
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS explo_stats(uuid varchar(36), xp_explo INT, rewards_explo TINYINT)");
	}

	public void close() {
		try {
			this.jobsLevelsConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
