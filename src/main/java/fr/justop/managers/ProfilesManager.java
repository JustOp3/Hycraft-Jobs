package fr.justop.managers;

import fr.justop.players.JobsProfile;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProfilesManager {
	private static Map<UUID, JobsProfile> profiles = new HashMap<>();

	public static JobsProfile getProfile(Player player) {
		return profiles.get(player.getUniqueId());
	}

	public static void addToMap(UUID uuid, JobsProfile profile) {
		profiles.put(uuid, profile);
	}

	public static boolean isBrowsed(JobsProfile profile, String job) {
		String number = String.valueOf(profile.getBrowseSchema());
		String[] digits = number.split("(?<=.)");

		switch (job) {
			case "mineur":
				return Integer.parseInt(digits[0]) == 1;

			case "farmeur":
				return Integer.parseInt(digits[1]) == 1;

			case "chasseur":
				return Integer.parseInt(digits[2]) == 1;

			case "meca":
				return Integer.parseInt(digits[3]) == 1;

			case "pecheur":
				return Integer.parseInt(digits[4]) == 1;

			case "bucheron":
				return Integer.parseInt(digits[5]) == 1;

			case "explo":
				return Integer.parseInt(digits[6]) == 1;

			default:
				return false;

		}
	}
}
