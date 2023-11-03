package fr.justop;

import fr.justop.commands.CommandsJobs;
import fr.justop.guis.MainGUI;
import fr.justop.listeners.RegisterPlayer;
import fr.justop.listeners.SavePlayer;
import fr.justop.managers.ConfigurationsManager;
import fr.justop.managers.DbManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class Jobs extends JavaPlugin {

	public static String PREFIX = "§8[§4Hycraft-Jobs§8]§r ";
	private DbManager dbManager;
	private ConfigurationsManager configsManager;

	@Override
	public void onEnable() {
		Bukkit.getServer().getConsoleSender().sendMessage(PREFIX + "§aSuccefully enabled!");
		this.dbManager = new DbManager();
		try {
			this.dbManager.setupDatabase();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		this.configsManager = new ConfigurationsManager(this);

		onCommand();
		onListener();

	}

	@Override
	public void onDisable() {
		Bukkit.getServer().getConsoleSender().sendMessage(PREFIX + "§cSuccefully disabled!");
		this.dbManager.close();
	}

	private void onCommand() {
		this.getCommand("jobs").setExecutor(new CommandsJobs(this));
	}


	private void onListener() {
		Bukkit.getPluginManager().registerEvents(new RegisterPlayer(this), this);
		Bukkit.getPluginManager().registerEvents(new MainGUI(this), this);
		Bukkit.getPluginManager().registerEvents(new SavePlayer(this), this);
	}

	public DbManager getDbManager() {
		return this.dbManager;
	}

	public ConfigurationsManager getConfigurationsManager() {
		return configsManager;
	}

	public Jobs getInstance() {
		return getPlugin(Jobs.class);
	}
}
