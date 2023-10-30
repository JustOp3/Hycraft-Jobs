package fr.justop.listeners;

import fr.justop.Jobs;
import fr.justop.mySQL.DbConnection;
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
			final PreparedStatement preparedStatement = connection.prepareStatement("SELECT uuid, isRegistred, "
					+ "browse_mineur, level_mineur, rewards_mineur, xp_mineur, browse_chasseur, "
					+ "level_chasseur, rewards_chasseur, xp_chasseur, browse_farmeur, level_farmeur, "
					+ "rewards_farmeur, xp_farmeur, browse_enchanteur, level_enchanteur, rewards_enchanteur, "
					+ "xp_enchanteur, browse_bucheron, level_bucheron, rewards_bucheron, xp_bucheron, "
					+ "browse_pecheur, level_pecheur, rewards_pecheur, xp_pecheur, browse_builder, "
					+ "level_builder, rewards_builder, xp_builder, browse_elec, level_elec, "
					+ "rewards_elec, xp_elec, browse_explo, level_explo, rewards_explo, "
					+ "xp_explo, browse_vete, level_vete, rewards_vete, xp_vete"
					+ " FROM JobsLevels_players WHERE uuid = ?");

			preparedStatement.setString(1, uuid.toString());

			final ResultSet result = preparedStatement.executeQuery();

			if (result.next()) {
				final boolean browse_mineur = result.getBoolean("browse_mineur");
				final int level_mineur = result.getInt("level_mineur");
				final int rewards_mineur = result.getInt("rewards_mineur");
				final double xp_mineur = result.getDouble("xp_mineur");
				final boolean browse_chasseur = result.getBoolean("browse_chasseur");
				final int level_chasseur = result.getInt("level_chasseur");
				final int rewards_chasseur = result.getInt("rewards_chasseur");
				final double xp_chasseur = result.getDouble("xp_chasseur");
				final boolean browse_farmeur = result.getBoolean("browse_farmeur");
				final int level_farmeur = result.getInt("level_farmeur");
				final int rewards_farmeur = result.getInt("rewards_farmeur");
				final double xp_farmeur = result.getDouble("xp_farmeur");
				final boolean browse_enchanteur = result.getBoolean("browse_enchanteur");
				final int level_enchanteur = result.getInt("level_enchanteur");
				final int rewards_enchanteur = result.getInt("rewards_enchanteur");
				final double xp_enchanteur = result.getDouble("xp_enchanteur");
				final boolean browse_bucheron = result.getBoolean("browse_bucheron");
				final int level_bucheron = result.getInt("level_bucheron");
				final int rewards_bucheron = result.getInt("rewards_bucheron");
				final double xp_bucheron = result.getDouble("xp_bucheron");
				final boolean browse_pecheur = result.getBoolean("browse_pecheur");
				final int level_pecheur = result.getInt("level_pecheur");
				final int rewards_pecheur = result.getInt("rewards_pecheur");
				final double xp_pecheur = result.getDouble("xp_pecheur");
				final boolean browse_builder = result.getBoolean("browse_builder");
				final int level_builder = result.getInt("level_builder");
				final int rewards_builder = result.getInt("rewards_builder");
				final double xp_builder = result.getDouble("xp_builder");
				final boolean browse_elec = result.getBoolean("browse_elec");
				final int level_elec = result.getInt("level_elec");
				final int rewards_elec = result.getInt("rewards_elec");
				final double xp_elec = result.getDouble("xp_elec");
				final boolean browse_explo = result.getBoolean("browse_explo");
				final int level_explo = result.getInt("level_explo");
				final int rewards_explo = result.getInt("rewards_explo");
				final double xp_explo = result.getDouble("xp_explo");
				final boolean browse_vete = result.getBoolean("browse_vete");
				final int level_vete = result.getInt("level_vete");
				final int rewards_vete = result.getInt("rewards_vete");
				final double xp_vete = result.getDouble("xp_vete");

				final JobsAdvancements jobsAdvancements = plugin.getJobsAdvancements();

				jobsAdvancements.putBrowseMineurAchievments(uuid, browse_mineur);
				jobsAdvancements.putLevelMineurAchievments(uuid, level_mineur);
				jobsAdvancements.putRewardsMinerAchievments(uuid, rewards_mineur);
				jobsAdvancements.putXpMineurAchievments(uuid, xp_mineur);
				jobsAdvancements.putBrowseChasseurAchievments(uuid, browse_chasseur);
				jobsAdvancements.putLevelChasseurAchievments(uuid, level_chasseur);
				jobsAdvancements.putRewardsChasseurAchievments(uuid, rewards_chasseur);
				jobsAdvancements.putXpChasseurAchievments(uuid, xp_chasseur);
				jobsAdvancements.putBrowseFarmeurAchievments(uuid, browse_farmeur);
				jobsAdvancements.putLevelFarmeurAchievments(uuid, level_farmeur);
				jobsAdvancements.putRewardsFarmeurAchievments(uuid, rewards_farmeur);
				jobsAdvancements.putXpFarmeurAchievments(uuid, xp_farmeur);
				jobsAdvancements.putBrowseEnchanteurAchievments(uuid, browse_enchanteur);
				jobsAdvancements.putLevelEnchanteurAchievments(uuid, level_enchanteur);
				jobsAdvancements.putRewardsEnchanteurAchievments(uuid, rewards_enchanteur);
				jobsAdvancements.putXpEnchanteurAchievments(uuid, xp_enchanteur);
				jobsAdvancements.putBrowseBucheronAchievments(uuid, browse_bucheron);
				jobsAdvancements.putLevelBucheronAchievments(uuid, level_bucheron);
				jobsAdvancements.putRewardsBucheronAchievments(uuid, rewards_bucheron);
				jobsAdvancements.putXpBucheronAchievments(uuid, xp_bucheron);
				jobsAdvancements.putBrowsePecheurAchievments(uuid, browse_pecheur);
				jobsAdvancements.putLevelPecheurAchievments(uuid, level_pecheur);
				jobsAdvancements.putRewardsPecheurAchievments(uuid, rewards_pecheur);
				jobsAdvancements.putXpPecheurAchievments(uuid, xp_pecheur);
				jobsAdvancements.putBrowseBuilderAchievments(uuid, browse_builder);
				jobsAdvancements.putLevelBuilderAchievments(uuid, level_builder);
				jobsAdvancements.putRewardsBuilderAchievments(uuid, rewards_builder);
				jobsAdvancements.putXpBuilderAchievments(uuid, xp_builder);
				jobsAdvancements.putBrowseElecAchievments(uuid, browse_elec);
				jobsAdvancements.putLevelElecAchievments(uuid, level_elec);
				jobsAdvancements.putRewardsElecAchievments(uuid, rewards_elec);
				jobsAdvancements.putXpElecAchievments(uuid, xp_elec);
				jobsAdvancements.putBrowseExploAchievments(uuid, browse_explo);
				jobsAdvancements.putLevelExploAchievments(uuid, level_explo);
				jobsAdvancements.putRewardsExploAchievments(uuid, rewards_explo);
				jobsAdvancements.putXpExploAchievments(uuid, xp_explo);
				jobsAdvancements.putBrowseVeteAchievments(uuid, browse_vete);
				jobsAdvancements.putLevelVeteAchievments(uuid, level_vete);
				jobsAdvancements.putRewardsVeteAchievments(uuid, rewards_vete);
				jobsAdvancements.putXpVeteAchievments(uuid, xp_vete);

			} else {
				setDefaultAdvancement(connection, uuid);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void setDefaultAdvancement(Connection connection, UUID uuid) {
		try {
			final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO JobsLevels_players VALUES ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");

			preparedStatement.setString(1, uuid.toString());
			preparedStatement.setBoolean(2, false);
			preparedStatement.setInt(3, 0);
			preparedStatement.setInt(4, 0);
			preparedStatement.setDouble(5, 0.0);
			preparedStatement.setBoolean(6, false);
			preparedStatement.setInt(7, 0);
			preparedStatement.setInt(8, 0);
			preparedStatement.setDouble(9, 0.0);
			preparedStatement.setBoolean(10, false);
			preparedStatement.setInt(11, 0);
			preparedStatement.setInt(12, 0);
			preparedStatement.setDouble(13, 0.0);
			preparedStatement.setBoolean(14, false);
			preparedStatement.setInt(15, 0);
			preparedStatement.setInt(16, 0);
			preparedStatement.setDouble(17, 0.0);
			preparedStatement.setBoolean(18, false);
			preparedStatement.setInt(19, 0);
			preparedStatement.setInt(20, 0);
			preparedStatement.setDouble(21, 0.0);
			preparedStatement.setBoolean(22, false);
			preparedStatement.setInt(23, 0);
			preparedStatement.setInt(24, 0);
			preparedStatement.setDouble(25, 0.0);
			preparedStatement.setBoolean(26, false);
			preparedStatement.setInt(27, 0);
			preparedStatement.setInt(28, 0);
			preparedStatement.setDouble(29, 0.0);
			preparedStatement.setBoolean(30, false);
			preparedStatement.setInt(31, 0);
			preparedStatement.setInt(32, 0);
			preparedStatement.setDouble(33, 0.0);
			preparedStatement.setBoolean(34, false);
			preparedStatement.setInt(35, 0);
			preparedStatement.setInt(36, 0);
			preparedStatement.setDouble(37, 0.0);
			preparedStatement.setBoolean(38, false);
			preparedStatement.setInt(39, 0);
			preparedStatement.setInt(40, 0);
			preparedStatement.setDouble(41, 0.0);
			preparedStatement.setBoolean(42, true);

			preparedStatement.executeQuery();

			final JobsAdvancements jobsAdvancements = plugin.getJobsAdvancements();

			jobsAdvancements.putBrowseMineurAchievments(uuid, false);
			jobsAdvancements.putLevelMineurAchievments(uuid, 0);
			jobsAdvancements.putRewardsMinerAchievments(uuid, 0);
			jobsAdvancements.putXpMineurAchievments(uuid, 0.0);
			jobsAdvancements.putBrowseChasseurAchievments(uuid, false);
			jobsAdvancements.putLevelChasseurAchievments(uuid, 0);
			jobsAdvancements.putRewardsChasseurAchievments(uuid, 0);
			jobsAdvancements.putXpChasseurAchievments(uuid, 0.0);
			jobsAdvancements.putBrowseFarmeurAchievments(uuid, false);
			jobsAdvancements.putLevelFarmeurAchievments(uuid, 0);
			jobsAdvancements.putRewardsFarmeurAchievments(uuid, 0);
			jobsAdvancements.putXpFarmeurAchievments(uuid, 0.0);
			jobsAdvancements.putBrowseEnchanteurAchievments(uuid, false);
			jobsAdvancements.putLevelEnchanteurAchievments(uuid, 0);
			jobsAdvancements.putRewardsEnchanteurAchievments(uuid, 0);
			jobsAdvancements.putXpEnchanteurAchievments(uuid, 0.0);
			jobsAdvancements.putBrowseBucheronAchievments(uuid, false);
			jobsAdvancements.putLevelBucheronAchievments(uuid, 0);
			jobsAdvancements.putRewardsBucheronAchievments(uuid, 0);
			jobsAdvancements.putXpBucheronAchievments(uuid, 0.0);
			jobsAdvancements.putBrowsePecheurAchievments(uuid, false);
			jobsAdvancements.putLevelPecheurAchievments(uuid, 0);
			jobsAdvancements.putRewardsPecheurAchievments(uuid, 0);
			jobsAdvancements.putXpPecheurAchievments(uuid, 0.0);
			jobsAdvancements.putBrowseBuilderAchievments(uuid, false);
			jobsAdvancements.putLevelBuilderAchievments(uuid, 0);
			jobsAdvancements.putRewardsBuilderAchievments(uuid, 0);
			jobsAdvancements.putXpBuilderAchievments(uuid, 0.0);
			jobsAdvancements.putBrowseElecAchievments(uuid, false);
			jobsAdvancements.putLevelElecAchievments(uuid, 0);
			jobsAdvancements.putRewardsElecAchievments(uuid, 0);
			jobsAdvancements.putXpElecAchievments(uuid, 0.0);
			jobsAdvancements.putBrowseExploAchievments(uuid, false);
			jobsAdvancements.putLevelExploAchievments(uuid, 0);
			jobsAdvancements.putRewardsExploAchievments(uuid, 0);
			jobsAdvancements.putXpExploAchievments(uuid, 0.0);
			jobsAdvancements.putBrowseVeteAchievments(uuid, false);
			jobsAdvancements.putLevelVeteAchievments(uuid, 0);
			jobsAdvancements.putRewardsVeteAchievments(uuid, 0);
			jobsAdvancements.putXpVeteAchievments(uuid, 0.0);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
