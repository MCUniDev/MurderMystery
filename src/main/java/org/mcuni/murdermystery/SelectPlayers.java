package org.mcuni.murdermystery;

import java.util.Random;

public class SelectPlayers {

    public Murdermystery plugin;

    public SelectPlayers(Murdermystery plugin) {
        this.plugin = plugin;
    }

    public String SelectDetective() {
        Random rand = new Random();
        return plugin.Players.get(rand.nextInt(this.plugin.Players.size()));
    }

    public String SelectMurderer() {
        Random rand = new Random();
        return plugin.Players.get(rand.nextInt(this.plugin.Players.size()));
    }
}
