package fr.justop.listeners;

import fr.justop.Jobs;
import fr.justop.mySQL.DbConnection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class SavePlayer implements Listener {
	private Jobs plugin;

	public SavePlayer(Jobs plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onQuitPlayer(PlayerQuitEvent event) {
		final UUID uuid = event.getPlayer().getUniqueId();
		final DbConnection jobsLevelConnection = plugin.getDbManager().getJobsLevelsConnection();

		try {
			final Connection connection = jobsLevelConnection.getConnection();
			final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO JobsLevels_players VALUES ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");

			final boolean browse_mineur = plugin.getJobsAdvancements().getBrowseMineurAchievments().get(uuid);
			final int level_mineur = plugin.getJobsAdvancements().getLevelMineurAchievments().get(uuid);
			final int rewards_mineur = plugin.getJobsAdvancements().getRewardsMinerAchievments().get(uuid);
			final double xp_mineur = plugin.getJobsAdvancements().getXpMineurAchievments().get(uuid);
			final boolean browse_chasseur = plugin.getJobsAdvancements().getBrowseChasseurAchievments().get(uuid);
			final int level_chasseur = plugin.getJobsAdvancements().getLevelChasseurAchievements().get(uuid);
			final int rewards_chasseur = plugin.getJobsAdvancements().getRewardsChasseurAchievments().get(uuid);
			final double xp_chasseur = plugin.getJobsAdvancements().getXpChasseurAchievments().get(uuid);
			final boolean browse_farmeur = plugin.getJobsAdvancements().getBrowseFarmeurAchievments().get(uuid);
			final int level_farmeur = plugin.getJobsAdvancements().getLevelFarmeurAchievments().get(uuid);
			final int rewards_farmeur = plugin.getJobsAdvancements().getRewardsFarmeurAchievments().get(uuid);
			final double xp_farmeur = plugin.getJobsAdvancements().getXpFarmeurAchievments().get(uuid);
			final boolean browse_enchanteur = plugin.getJobsAdvancements().getBrowseEnchanteurAchievments().get(uuid);
			final int level_enchanteur = plugin.getJobsAdvancements().getLevelEnchanteurAchievments().get(uuid);
			final int rewards_enchanteur = plugin.getJobsAdvancements().getRewardsEnchanteurAchievments().get(uuid);
			final double xp_enchanteur = plugin.getJobsAdvancements().getXpEnchanteurAchievments().get(uuid);
			final boolean browse_bucheron = plugin.getJobsAdvancements().getBrowseBucheronAchievments().get(uuid);
			final int level_bucheron = plugin.getJobsAdvancements().getLevelBucheronAchievments().get(uuid);
			final int rewards_bucheron = plugin.getJobsAdvancements().getRewardsBucheronAchievments().get(uuid);
			final double xp_bucheron = plugin.getJobsAdvancements().getXpBucheronAchievments().get(uuid);
			final boolean browse_pecheur = plugin.getJobsAdvancements().getBrowsePecheurAchievments().get(uuid);
			final int level_pecheur = plugin.getJobsAdvancements().getLevelPecheurAchievments().get(uuid);
			final int rewards_pecheur = plugin.getJobsAdvancements().getRewardsPecheurAchievments().get(uuid);
			final double xp_pecheur = plugin.getJobsAdvancements().getXpPecheurAchievments().get(uuid);
			final boolean browse_builder = plugin.getJobsAdvancements().getBrowseBuilderAchievments().get(uuid);
			final int level_builder = plugin.getJobsAdvancements().getLevelBuilderAchievments().get(uuid);
			final int rewards_builder = plugin.getJobsAdvancements().getRewardsBuilderAchievments().get(uuid);
			final double xp_builder = plugin.getJobsAdvancements().getXpBuilderAchievments().get(uuid);
			final boolean browse_elec = plugin.getJobsAdvancements().getBrowseElecAchievments().get(uuid);
			final int level_elec = plugin.getJobsAdvancements().getLevelElecAchievments().get(uuid);
			final int rewards_elec = plugin.getJobsAdvancements().getRewardsElecAchievments().get(uuid);
			final double xp_elec = plugin.getJobsAdvancements().getXpElecAchievments().get(uuid);
			final boolean browse_explo = plugin.getJobsAdvancements().getBrowseExploAchievments().get(uuid);
			final int level_explo = plugin.getJobsAdvancements().getLevelExploAchievments().get(uuid);
			final int rewards_explo = plugin.getJobsAdvancements().getRewardsExploAchievments().get(uuid);
			final double xp_explo = plugin.getJobsAdvancements().getXpExploAchievments().get(uuid);
			final boolean browse_vete = plugin.getJobsAdvancements().getBrowseVeteAchievments().get(uuid);
			final int level_vete = plugin.getJobsAdvancements().getLevelVeteAchievments().get(uuid);
			final int rewards_vete = plugin.getJobsAdvancements().getRewardsVeteAchievments().get(uuid);
			final double xp_vete = plugin.getJobsAdvancements().getXpVeteAchievments().get(uuid);

			plugin.getJobsAdvancements().getBrowseMineurAchievments().remove(uuid);
			plugin.getJobsAdvancements().getLevelMineurAchievments().remove(uuid);
			plugin.getJobsAdvancements().getRewardsMinerAchievments().remove(uuid);
			plugin.getJobsAdvancements().getXpMineurAchievments().remove(uuid);
			plugin.getJobsAdvancements().getBrowseChasseurAchievments().remove(uuid);
			plugin.getJobsAdvancements().getLevelChasseurAchievements().remove(uuid);
			plugin.getJobsAdvancements().getRewardsChasseurAchievments().remove(uuid);
			plugin.getJobsAdvancements().getXpChasseurAchievments().remove(uuid);
			plugin.getJobsAdvancements().getBrowseFarmeurAchievments().remove(uuid);
			plugin.getJobsAdvancements().getLevelFarmeurAchievments().remove(uuid);
			plugin.getJobsAdvancements().getRewardsFarmeurAchievments().remove(uuid);
			plugin.getJobsAdvancements().getXpFarmeurAchievments().remove(uuid);
			plugin.getJobsAdvancements().getBrowseEnchanteurAchievments().remove(uuid);
			plugin.getJobsAdvancements().getLevelEnchanteurAchievments().remove(uuid);
			plugin.getJobsAdvancements().getRewardsEnchanteurAchievments().remove(uuid);
			plugin.getJobsAdvancements().getXpEnchanteurAchievments().remove(uuid);
			plugin.getJobsAdvancements().getBrowseBucheronAchievments().remove(uuid);
			plugin.getJobsAdvancements().getLevelBucheronAchievments().remove(uuid);
			plugin.getJobsAdvancements().getRewardsBucheronAchievments().remove(uuid);
			plugin.getJobsAdvancements().getXpBucheronAchievments().remove(uuid);
			plugin.getJobsAdvancements().getBrowsePecheurAchievments().remove(uuid);
			plugin.getJobsAdvancements().getLevelPecheurAchievments().remove(uuid);
			plugin.getJobsAdvancements().getRewardsPecheurAchievments().remove(uuid);
			plugin.getJobsAdvancements().getXpPecheurAchievments().remove(uuid);
			plugin.getJobsAdvancements().getBrowseBuilderAchievments().remove(uuid);
			plugin.getJobsAdvancements().getLevelBuilderAchievments().remove(uuid);
			plugin.getJobsAdvancements().getRewardsBuilderAchievments().remove(uuid);
			plugin.getJobsAdvancements().getXpBuilderAchievments().remove(uuid);
			plugin.getJobsAdvancements().getBrowseElecAchievments().remove(uuid);
			plugin.getJobsAdvancements().getLevelElecAchievments().remove(uuid);
			plugin.getJobsAdvancements().getRewardsElecAchievments().remove(uuid);
			plugin.getJobsAdvancements().getXpElecAchievments().remove(uuid);
			plugin.getJobsAdvancements().getBrowseExploAchievments().remove(uuid);
			plugin.getJobsAdvancements().getLevelExploAchievments().remove(uuid);
			plugin.getJobsAdvancements().getRewardsExploAchievments().remove(uuid);
			plugin.getJobsAdvancements().getXpExploAchievments().remove(uuid);
			plugin.getJobsAdvancements().getBrowseVeteAchievments().remove(uuid);
			plugin.getJobsAdvancements().getLevelVeteAchievments().remove(uuid);
			plugin.getJobsAdvancements().getRewardsVeteAchievments().remove(uuid);
			plugin.getJobsAdvancements().getXpVeteAchievments().remove(uuid);

			preparedStatement.setString(1, uuid.toString());
			preparedStatement.setBoolean(2, browse_mineur);
			preparedStatement.setInt(3, level_mineur);
			preparedStatement.setInt(4, rewards_mineur);
			preparedStatement.setDouble(5, xp_mineur);
			preparedStatement.setBoolean(6, browse_chasseur);
			preparedStatement.setInt(7, level_chasseur);
			preparedStatement.setInt(8, rewards_chasseur);
			preparedStatement.setDouble(9, xp_chasseur);
			preparedStatement.setBoolean(10, browse_farmeur);
			preparedStatement.setInt(11, level_farmeur);
			preparedStatement.setInt(12, rewards_farmeur);
			preparedStatement.setDouble(13, xp_farmeur);
			preparedStatement.setBoolean(14, browse_enchanteur);
			preparedStatement.setInt(15, level_enchanteur);
			preparedStatement.setInt(16, rewards_enchanteur);
			preparedStatement.setDouble(17, xp_enchanteur);
			preparedStatement.setBoolean(18, browse_bucheron);
			preparedStatement.setInt(19, level_bucheron);
			preparedStatement.setInt(20, rewards_bucheron);
			preparedStatement.setDouble(21, xp_bucheron);
			preparedStatement.setBoolean(22, browse_pecheur);
			preparedStatement.setInt(23, level_pecheur);
			preparedStatement.setInt(24, rewards_pecheur);
			preparedStatement.setDouble(25, xp_pecheur);
			preparedStatement.setBoolean(26, browse_builder);
			preparedStatement.setInt(27, level_builder);
			preparedStatement.setInt(28, rewards_builder);
			preparedStatement.setDouble(29, xp_builder);
			preparedStatement.setBoolean(30, browse_elec);
			preparedStatement.setInt(31, level_elec);
			preparedStatement.setInt(32, rewards_elec);
			preparedStatement.setDouble(33, xp_elec);
			preparedStatement.setBoolean(34, browse_explo);
			preparedStatement.setInt(35, level_explo);
			preparedStatement.setInt(36, rewards_explo);
			preparedStatement.setDouble(37, xp_explo);
			preparedStatement.setBoolean(38, browse_vete);
			preparedStatement.setInt(39, level_vete);
			preparedStatement.setInt(40, rewards_vete);
			preparedStatement.setDouble(41, xp_vete);
			preparedStatement.setBoolean(42, true);

			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
