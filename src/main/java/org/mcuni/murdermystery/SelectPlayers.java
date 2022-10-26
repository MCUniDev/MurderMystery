package org.mcuni.murdermystery;

import org.bukkit.entity.Player;

import java.util.Random;

public class SelectPlayers {

    public Murdermystery plugin;

    public SelectPlayers(Murdermystery plugin) {
        this.plugin = plugin;
    }

    public Player SelectDetective() {
        Random rand = new Random();
        Player selected = plugin.Players.get(rand.nextInt(this.plugin.Players.size()));
        plugin.getLogger().info("[MurderMystery] Detective: "+selected.getName());
        return selected;
    }

    public Player SelectMurderer() {
        Random rand = new Random();
        Player selected = plugin.Players.get(rand.nextInt(this.plugin.Players.size()));
        plugin.getLogger().info("[MurderMystery] Murderer: "+selected.getName());
        return selected;
    }
}
