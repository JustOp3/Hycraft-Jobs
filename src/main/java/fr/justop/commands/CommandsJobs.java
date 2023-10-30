package fr.justop.commands;

import fr.justop.Jobs;
import fr.justop.guis.MainGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandsJobs implements CommandExecutor {
	private Jobs plugin;

	public CommandsJobs(Jobs plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player && label.equalsIgnoreCase("jobs")) {
			Player player = (Player) sender;

			if (args.length == 0) {
				MainGUI.openInventory(player);
			}

			if (args.length > 0) {
				if (args[0].equalsIgnoreCase("help")) {
					player.sendMessage("§7+++++++++++++++++++++++++++++++++++++++");
					player.sendMessage("§7+-------------------------------------+");
					player.sendMessage("§7+                                     +");
					player.sendMessage("§7+     §6§lHycraft-Jobs  §4[1.0]       +");
					player.sendMessage("§7+                                     +");
					player.sendMessage("§7+   §eTous les éléments de ce plugin  +");
					player.sendMessage("§7+ §esont accessible depuis l'interface+");
					player.sendMessage("§7+              §e/jobs                +");
					player.sendMessage("§7+                                     +");
					player.sendMessage("§7+  §aMerci de contacter le staff en   +");
					player.sendMessage("§7+          §acas de problème!         +");
					player.sendMessage("§7+                                     +");
					player.sendMessage("§7+-------------------------------------+");
					player.sendMessage("§7+++++++++++++++++++++++++++++++++++++++");

				} else {
					player.sendMessage(Jobs.PREFIX + "§cMerci d'entrer /jobs help pour plus d'information sur cette commande!");
				}

			}

			return true;
		}

		return false;
	}
}
