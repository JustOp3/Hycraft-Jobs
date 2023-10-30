package fr.justop.managers;

import fr.justop.Jobs;
import fr.justop.configs.*;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigurationsManager {
	private YamlConfiguration mineurConfig;
	private YamlConfiguration chasseurConfig;
	private YamlConfiguration pêcheurConfig;
	private YamlConfiguration farmeurConfig;
	private YamlConfiguration electricienConfig;
	private YamlConfiguration bucheronConfig;

	private MineurConfig mineurClass;
	private ChasseurConfig chasseurClass;
	private PecheurConfig pecheurClass;
	private FarmeurConfig farmeurClass;
	private MecanicienConfig elecClass;
	private BucheronConfig bucheronClass;

	private Jobs plugin;

	public ConfigurationsManager(Jobs plugin) {
		this.plugin = plugin;

		this.mineurClass = new MineurConfig(plugin);
		this.chasseurClass = new ChasseurConfig(plugin);
		this.pecheurClass = new PecheurConfig(plugin);
		this.farmeurClass = new FarmeurConfig(plugin);
		this.elecClass = new MecanicienConfig(plugin);
		this.bucheronClass = new BucheronConfig(plugin);

		loadAll();

		this.setMineurConfig(mineurClass.getConfig());
		this.setChasseurConfig(chasseurClass.getConfig());
		this.setPêcheurConfig(pecheurClass.getConfig());
		this.setBucheronConfig(bucheronClass.getConfig());
		this.setElectricienConfig(elecClass.getConfig());
		this.setFarmeurConfig(farmeurClass.getConfig());
	}

	public void loadAll() {
		mineurClass.loadConfig();
		chasseurClass.loadConfig();
		pecheurClass.loadConfig();
		farmeurClass.loadConfig();
		elecClass.loadConfig();
		bucheronClass.loadConfig();
	}

	public YamlConfiguration getMineurConfig() {
		return mineurConfig;
	}

	public void setMineurConfig(YamlConfiguration mineurConfig) {
		this.mineurConfig = mineurConfig;
	}

	public YamlConfiguration getChasseurConfig() {
		return chasseurConfig;
	}

	public void setChasseurConfig(YamlConfiguration chasseurConfig) {
		this.chasseurConfig = chasseurConfig;
	}

	public YamlConfiguration getPêcheurConfig() {
		return pêcheurConfig;
	}

	public void setPêcheurConfig(YamlConfiguration pêcheurConfig) {
		this.pêcheurConfig = pêcheurConfig;
	}

	public YamlConfiguration getFarmeurConfig() {
		return farmeurConfig;
	}

	public void setFarmeurConfig(YamlConfiguration farmeurConfig) {
		this.farmeurConfig = farmeurConfig;
	}

	public YamlConfiguration getElectricienConfig() {
		return electricienConfig;
	}

	public void setElectricienConfig(YamlConfiguration electricienConfig) {
		this.electricienConfig = electricienConfig;
	}

	public YamlConfiguration getBucheronConfig() {
		return bucheronConfig;
	}

	public void setBucheronConfig(YamlConfiguration bucheronConfig) {
		this.bucheronConfig = bucheronConfig;
	}
}
