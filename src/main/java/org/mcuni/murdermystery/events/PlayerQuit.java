package org.mcuni.murdermystery.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mcuni.murdermystery.Murdermystery;

import java.util.Objects;

public class PlayerQuit implements Listener {
    public Murdermystery plugin;
    public PlayerQuit(Murdermystery plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent player) {
        try {
            for (String s : plugin.Players) {
                if (Objects.equals(s, player.getPlayer().getName())) {
                    plugin.Players.remove(player.getPlayer().getName());
                }
            }
        }
        catch (Exception e) {
            Bukkit.getLogger().severe("[MurderMystery] ERROR: There was a problem handling player disconnection.");
        }
    }
}
