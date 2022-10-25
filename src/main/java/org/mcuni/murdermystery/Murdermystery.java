package org.mcuni.murdermystery;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Murdermystery extends JavaPlugin {

    public List<String> Players;

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Starting MurderMystery by MCUni.");
        loadCommands();
    }

    /**
     * Loads and registers the plugin's command handlers.
     */
    private void loadCommands() {
        try {
            this.getCommand("mm").setExecutor(new Commands(this));
        } catch (NullPointerException e) {
            Bukkit.getLogger().severe("ERROR: Couldn't enable commands.");
        }
        Bukkit.getLogger().info("Registered Command Executors.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
