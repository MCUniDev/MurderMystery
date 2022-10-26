package org.mcuni.murdermystery.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.mcuni.murdermystery.EndGame;
import org.mcuni.murdermystery.Murdermystery;
import org.mcuni.murdermystery.SelectPlayers;
import org.mcuni.murdermystery.StartGame;

import java.util.Objects;

public class PlayerDeath implements Listener {
    public Murdermystery plugin;
    public PlayerDeath(Murdermystery plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent player) {
        try {
            for (Player s : plugin.Players) {
                if (Objects.equals(s, player.getPlayer().getName())) {
                    plugin.Players.remove(player);
                    ClearInventory(s);
                    player.getPlayer().sendMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.RED + " You died.");
                    if (s == plugin.Murderer) {
                        EndGame eg = new EndGame(plugin);
                        eg.Stop();
                    }
                    if (s == plugin.Detective) {
                        StartGame sg = new StartGame(plugin);
                        sg.NewDetective();
                    }
                }
            }
        }
        catch (Exception e) {
            Bukkit.getLogger().severe("[MurderMystery] ERROR: There was a problem handling player disconnection.");
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
