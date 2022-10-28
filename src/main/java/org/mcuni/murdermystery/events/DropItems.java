package org.mcuni.murdermystery.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.mcuni.murdermystery.Murdermystery;

import java.util.Objects;

public class DropItems implements Listener {
    public Murdermystery plugin;
    public DropItems(Murdermystery plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event){
        if (plugin.GameRunning) {
            event.setCancelled(true);
        }
    }
}
