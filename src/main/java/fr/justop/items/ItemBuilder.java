package fr.justop.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ItemBuilder extends ItemStack {
	private ItemStack item;
	private ItemMeta itemMeta;

	public ItemBuilder() {
		this.item = this;
		this.itemMeta = this.item.getItemMeta();
	}

	@Override
	public ItemMeta getItemMeta() {
		return this.itemMeta;
	}

	public ItemBuilder setMaterial(Material material) {
		this.item.setType(material);
		return this;
	}

	public Material getMaterial() {
		return this.item.getType();
	}

	public ItemBuilder setName(String name) {
		this.itemMeta.setDisplayName(name);
		return this;
	}

	public String getName() {
		return this.itemMeta.getDisplayName();
	}

	public ItemBuilder setLores(String... lores) {
		this.itemMeta.setLore(Arrays.asList(lores));
		return this;
	}

	public List<String> getLores() {
		return this.itemMeta.getLore();
	}

	public ItemBuilder setEnchant(Enchantment enchantment, int level, boolean actived, boolean hide) {
		this.itemMeta.addEnchant(enchantment, level, actived);
		if (hide == true) this.itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		return this;
	}

	public Map<Enchantment, Integer> getEnchant() {
		return this.itemMeta.getEnchants();
	}

	public ItemBuilder setUnbreakable(boolean unbreakable, boolean hide) {
		this.itemMeta.setUnbreakable(unbreakable);
		if (hide == true) this.itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		return this;
	}

	public boolean isUnbreakable() {
		if (this.itemMeta.isUnbreakable() == true) return true;
		return false;
	}

	public ItemBuilder build() {
		this.item.setItemMeta(this.itemMeta);
		return this;
	}
}
