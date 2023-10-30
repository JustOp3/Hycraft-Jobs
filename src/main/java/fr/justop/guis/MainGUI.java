package fr.justop.guis;

import fr.justop.Jobs;
import fr.justop.items.ItemBuilder;
import fr.justop.items.ItemSkull;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MainGUI implements Listener {

	private Jobs plugin;

	private static Inventory inv = Bukkit.createInventory(null, 9 * 4, "§4§lJobs §r§8- §cMenu principal");

	private int[] nonVitres = {10, 12, 14, 16, 35};
	private static int[] fillerBas = {27, 28, 29, 30, 31, 32, 33, 34};

	public MainGUI(Jobs plugin) {
		this.plugin = plugin;
	}

	public static void openInventory(Player player) {
		String SKULL_Arbre = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzVjOWNjY2Y2MWE2ZTYyODRmZTliYmU2NDkxNTViZTRkOWNhOTZmNzhmZmNiMjc5Yjg0ZTE2MTc4ZGFjYjUyMiJ9fX0=";
		String SKULL_Browse = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2U4N2IxZGY2YmYyMzg3ZTEwZTg3NTVkZTM3ZDdiY2I5NGNmNjFhNWZhMThlMjA0YjM4ZDZjMWZmOTIyMzE3YyJ9fX0=";
		String SKULL_Top = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2ZlOTcyNWM5NTA0NzJlNDY5YjlmY2NhZTMyZjYxYmNlZmViZGI1ZWE5Y2U5YzkyZDU4MTcxZmZiN2EzMzZmZSJ9fX0=";
		String SKULL_How = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzY5MTk2YjMzMGM2Yjg5NjJmMjNhZDU2MjdmYjZlY2NlNDcyZWFmNWM5ZDQ0Zjc5MWY2NzA5YzdkMGY0ZGVjZSJ9fX0=";

		String[] arbreLore = {"§2§nCliquez ici", "§aPour acceder à l'avancement", "§ade vos récompenses à travers", "§ales âges!"};
		String[] browseLore = {"§3§nCliquez ici", "§bPour pouvoir rejoindre les", "§bdifférents métiers disponibles", "§bsur le server!"};
		String[] topLore = {"§6§nCliquez ici", "§ePour acceder aux classements", "§edes joueurs sur les différents", "§amétiers!", "", "§8§oTechnoblade never dies!"};
		String[] howLore = {"§5§nCliquez ici", "§dPour savoir comment avancer dans", "§dnos différents métiers!"};

		ItemBuilder closeItem = new ItemBuilder();
		closeItem.setType(Material.BARRIER);
		closeItem.setLores("§cCliquez §4§nici", "§cPour quittez le menu");
		closeItem.setName("§c§lFermer");
		closeItem.build();

		ItemBuilder fillerItem = new ItemBuilder();
		closeItem.setType(Material.GREEN_STAINED_GLASS_PANE);
		closeItem.setName("");
		closeItem.build();

		ItemBuilder fillerItemSecond = new ItemBuilder();
		closeItem.setType(Material.YELLOW_STAINED_GLASS_PANE);
		closeItem.setName("");
		closeItem.build();

		for (int i = 0; i < inv.getSize(); i++) {
			inv.setItem(i, fillerItem);
		}

		for (int i : fillerBas) {
			inv.setItem(i, fillerItemSecond);
		}

		inv.setItem(35, closeItem);
		inv.setItem(10, ItemSkull.createSkull(player, SKULL_Arbre, "§a§lArbre des récompenses", arbreLore));
		inv.setItem(12, ItemSkull.createSkull(player, SKULL_Browse, "§b§lRejoindre les métiers", browseLore));
		inv.setItem(14, ItemSkull.createSkull(player, SKULL_Top, "§e§lClassement joueurs", topLore));
		inv.setItem(16, ItemSkull.createSkull(player, SKULL_How, "§d§lComment xp?", howLore));


	}

	@EventHandler
	public void onClickInventory(InventoryClickEvent event) {
		ItemStack clickedItem = event.getCurrentItem();

		if (event.getView().getTitle().equals("§4§lJobs §r§8- §cMenu principal")) {
			Player player = (Player) event.getWhoClicked();

			event.setCancelled(true);

			if (event.isLeftClick()) {
				if (clickedItem == null || event.getClickedInventory() == null) return;

				for (int i : nonVitres) if (!(event.getSlot() == i)) return;

				switch (event.getSlot()) {
					case 10:
						player.sendMessage(Jobs.PREFIX + "Suite pas encore créée");
						break;

					case 12:
						player.sendMessage(Jobs.PREFIX + "Suite pas encore créée");
						break;

					case 14:
						player.sendMessage(Jobs.PREFIX + "Suite pas encore créée");
						break;

					case 16:
						player.sendMessage(Jobs.PREFIX + "Suite pas encore créée");
						break;

					case 35:
						player.getOpenInventory().close();
						break;

				}


			}
		}
	}

}