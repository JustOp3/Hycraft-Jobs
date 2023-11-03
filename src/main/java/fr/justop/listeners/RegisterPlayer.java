package fr.justop.listeners;

import fr.justop.Jobs;
import fr.justop.managers.ProfilesManager;
import fr.justop.mySQL.DbConnection;
import fr.justop.players.JobsProfile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class RegisterPlayer implements Listener {
	private Jobs plugin;

	public RegisterPlayer(Jobs plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onJoinPlayer(PlayerJoinEvent event) {
		final UUID uuid = event.getPlayer().getUniqueId();
		final DbConnection jobsLevelsConnection = plugin.getDbManager().getJobsLevelsConnection();

		try {
			final Connection connection = jobsLevelsConnection.getConnection();
			final PreparedStatement mineurStatement = connection.prepareStatement("SELECT * IN mineur_stats WHERE uuid = ?");
			final PreparedStatement farmeurStatement = connection.prepareStatement("SELECT * IN farmeur_stats WHERE uuid = ?");
			final PreparedStatement chasseurStatement = connection.prepareStatement("SELECT * IN chasseur_stats WHERE uuid = ?");
			final PreparedStatement mecaStatement = connection.prepareStatement("SELECT * IN meca_stats WHERE uuid = ?");
			final PreparedStatement pecheurStatement = connection.prepareStatement("SELECT * IN pecheur_stats WHERE uuid = ?");
			final PreparedStatement bucheronStatement = connection.prepareStatement("SELECT * IN bucheron_stats WHERE uuid = ?");
			final PreparedStatement exploStatement = connection.prepareStatement("SELECT * IN explo_stats WHERE uuid = ?");

			mineurStatement.setString(1, uuid.toString());
			farmeurStatement.setString(1, uuid.toString());
			chasseurStatement.setString(1, uuid.toString());
			mecaStatement.setString(1, uuid.toString());
			pecheurStatement.setString(1, uuid.toString());
			bucheronStatement.setString(1, uuid.toString());
			exploStatement.setString(1, uuid.toString());

			final ResultSet mineurResult = mineurStatement.executeQuery();
			final ResultSet farmeurResult = farmeurStatement.executeQuery();
			final ResultSet chasseurResult = chasseurStatement.executeQuery();
			final ResultSet mecaResult = mecaStatement.executeQuery();
			final ResultSet pecheurResult = pecheurStatement.executeQuery();
			final ResultSet bucheronResult = bucheronStatement.executeQuery();
			final ResultSet exploResult = exploStatement.executeQuery();

			if (mineurResult.next() && farmeurResult.next() && chasseurResult.next() && mecaResult.next() && pecheurResult.next() && bucheronResult.next()) {
				final int browse_schema = mineurResult.getInt("browse_schema");
				final int rewards_mineur = mineurResult.getInt("rewards_mineur");
				final int xp_mineur = mineurResult.getInt("xp_mineur");
				final int rewards_chasseur = chasseurResult.getInt("rewards_chasseur");
				final int xp_chasseur = chasseurResult.getInt("xp_chasseur");
				final int rewards_farmeur = farmeurResult.getInt("rewards_farmeur");
				final int xp_farmeur = farmeurResult.getInt("xp_farmeur");
				final int rewards_bucheron = bucheronResult.getInt("rewards_bucheron");
				final int xp_bucheron = bucheronResult.getInt("xp_bucheron");
				final int rewards_pecheur = pecheurResult.getInt("rewards_pecheur");
				final int xp_pecheur = pecheurResult.getInt("xp_pecheur");
				final int rewards_meca = mecaResult.getInt("rewards_meca");
				final int xp_meca = mecaResult.getInt("xp_meca");
				final int rewards_explo = exploResult.getInt("rewards_explo");
				final int xp_explo = exploResult.getInt("xp_explo");

				final JobsProfile profile = new JobsProfile(xp_mineur
						, xp_farmeur, xp_chasseur, xp_meca, xp_pecheur, xp_bucheron, xp_explo, browse_schema
						, new int[]{rewards_mineur, rewards_farmeur, rewards_chasseur, rewards_meca, rewards_pecheur, rewards_bucheron
						, rewards_explo});

				ProfilesManager.addToMap(uuid, profile);


			} else {
				setDefaultAdvancement(uuid);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void setDefaultAdvancement(UUID uuid) {
		final JobsProfile profile = new JobsProfile(0, 0, 0, 0, 0, 0, 0, 0000000,
				new int[]{0, 0, 0, 0, 0, 0, 0});

		ProfilesManager.addToMap(uuid, profile);
	}
}
