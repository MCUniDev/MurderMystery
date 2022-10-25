package org.mcuni.murdermystery;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Murdermystery extends JavaPlugin {

    public List<String> Players;
    public String Murderer;
    public String Detective;

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("[MurderMystery] Starting MurderMystery by MCUni.");
        loadCommands();
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
