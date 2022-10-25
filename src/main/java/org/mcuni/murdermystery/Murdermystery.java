package org.mcuni.murdermystery;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcuni.murdermystery.commands.AdminCommands;
import org.mcuni.murdermystery.commands.Commands;
import org.mcuni.murdermystery.events.PlayerQuit;

import java.util.ArrayList;
import java.util.List;

public final class Murdermystery extends JavaPlugin {

    public List<String> Players = new ArrayList<>();
    public String Murderer;
    public String Detective;

    public PlayerQuit PlayerQuitClass = new PlayerQuit(this);

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("[MurderMystery] Starting MurderMystery by MCUni.");
        loadEventHandlers();
        loadCommands();
    }

    /**
     * Loads and registers the plugin's event handlers.
     */
    private void loadEventHandlers() {
        Bukkit.getServer().getPluginManager().registerEvents(PlayerQuitClass, this);
        Bukkit.getLogger().info("[MurderMystery] Registered Event Handlers.");
    }

    /**
     * Loads and registers the plugin's command handlers.
     */
    private void loadCommands() {
        try {
            this.getCommand("mm").setExecutor(new Commands(this));
            this.getCommand("mma").setExecutor(new AdminCommands(this));
        } catch (NullPointerException e) {
            Bukkit.getLogger().severe("[MurderMystery] ERROR: Couldn't enable commands.");
            Bukkit.getLogger().severe(String.valueOf(e));
        }
        Bukkit.getLogger().info("[MurderMystery] Registered Command Executors.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
