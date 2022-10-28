package org.mcuni.murdermystery.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.mcuni.murdermystery.Murdermystery;

import java.util.Objects;

public class PlayerQuit implements Listener {
    public Murdermystery plugin;
    public PlayerQuit(Murdermystery plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent player) {
        if (plugin.GameRunning) {
            try {
                for (Player s : plugin.Players) {
                    if (Objects.equals(s, player.getPlayer().getName())) {
                        plugin.Players.remove(player.getPlayer().getName());
                        ClearInventory(s);
                    }
                }
            } catch (Exception e) {
                Bukkit.getLogger().severe("[MurderMystery] ERROR: There was a problem handling player disconnection.");
            }
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
