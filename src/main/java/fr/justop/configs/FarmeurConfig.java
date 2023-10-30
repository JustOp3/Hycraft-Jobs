package fr.justop.configs;

import fr.justop.Jobs;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FarmeurConfig {
	private YamlConfiguration config;
	private Jobs plugin;

	public FarmeurConfig(Jobs plugin) {
		this.plugin = plugin;
	}

	public void loadConfig() {

		if (!plugin.getDataFolder().exists()) {

			plugin.getDataFolder().mkdir();
		}

		File file = new File(plugin.getDataFolder() + File.separator + "farmeur.yml");

		if (!file.exists()) {

			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		config = YamlConfiguration.loadConfiguration(file);

	}

	public YamlConfiguration getConfig() {
		return config;
	}
}
