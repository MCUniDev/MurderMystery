package org.mcuni.murdermystery;

import java.util.Random;

public class SelectPlayers {

    public Murdermystery plugin;

    public SelectPlayers(Murdermystery murdermystery) {
        this.plugin = murdermystery;
    }

    public String SelectDetective() {
        Random rand = new Random();
        return this.plugin.Players.get(rand.nextInt(this.plugin.Players.size()));
    }

    public String SelectMurderer() {
        Random rand = new Random();
        return this.plugin.Players.get(rand.nextInt(this.plugin.Players.size()));
    }
}
