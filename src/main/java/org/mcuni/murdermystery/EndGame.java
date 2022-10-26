package org.mcuni.murdermystery;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class EndGame {

    public Murdermystery plugin;

    public EndGame(Murdermystery plugin) {
        this.plugin = plugin;
    }

    public void Stop() {
        for (Player player : plugin.Players) {
            ClearInventory(player);
        }
        RestoreHealth();
    }

    private void RestoreHealth() {
        for (Player player : plugin.Players) {
            player.setHealth(20);
            player.setFoodLevel(20);

            ItemStack itemStack = new ItemStack(Material.BREAD, 6);
            player.getInventory().addItem(itemStack);
        }
    }

    public void ClearInventory(Player player) {
        PlayerInventory pli = player.getInventory();
        pli.clear();

        pli.setHelmet(new ItemStack(Material.AIR));
        pli.setChestplate(new ItemStack(Material.AIR));
        pli.setLeggings(new ItemStack(Material.AIR));
        pli.setBoots(new ItemStack(Material.AIR));
    }
}
