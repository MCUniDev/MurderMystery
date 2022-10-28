package org.mcuni.murdermystery;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class StartGame {

    public Murdermystery plugin;

    public StartGame(Murdermystery plugin) {
        this.plugin = plugin;
    }

    public void Run() {
        RestoreHealth();

        Bukkit.broadcastMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.WHITE + " Don't die - and find the murderer!");
        Bukkit.broadcastMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.WHITE + " Let the game begin.");

        plugin.Murderer.sendMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.WHITE + " You are the " + ChatColor.BOLD + "Murderer" + ChatColor.RESET + ChatColor.RED + ", you must kill all the innocents and the detective to win.");
        plugin.Detective.sendMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.WHITE + " You are the " + ChatColor.BOLD + "Detective" + ChatColor.RESET + ChatColor.RED + ", you must kill the murderer and protect the innocents to win.");

        ClearInventory(plugin.Murderer);
        ClearInventory(plugin.Detective);

        ItemStack itemStackM = new ItemStack(Material.IRON_SWORD);
        plugin.Murderer.getInventory().addItem(itemStackM);

        ItemStack itemStackD1 = new ItemStack(Material.IRON_SWORD);
        plugin.Detective.getInventory().addItem(itemStackD1);

        ItemStack itemStackD2 = new ItemStack(Material.BOW);
        plugin.Detective.getInventory().addItem(itemStackD2);

        ItemStack itemStackD3 = new ItemStack(Material.SPECTRAL_ARROW);
        plugin.Detective.getInventory().addItem(itemStackD3);
    }

    private void RestoreHealth() {
        for (Player player : plugin.Players) {
            player.setHealth(20);
            player.setFoodLevel(20);

            ItemStack itemStack = new ItemStack(Material.BREAD, 6);
            player.getInventory().addItem(itemStack);
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

    public void NewDetective() {
        SelectPlayers sp = new SelectPlayers(plugin);
        boolean found = false;
        Player detective = null;
        if (plugin.Players.size() > 2) {
            while (!found) {
                if (detective == null) {
                    detective = sp.SelectDetective();
                    plugin.Detective = detective;
                    plugin.getLogger().info("[MurderMystery] DetectiveSearch: " + detective.getName());
                } else if (detective != plugin.Murderer) {
                    found = false;
                    detective = null;
                } else {
                    found = true;
                }
            }

            ClearInventory(plugin.Detective);
            ItemStack itemStackD1 = new ItemStack(Material.IRON_SWORD);
            plugin.Detective.getInventory().addItem(itemStackD1);
            ItemStack itemStackD2 = new ItemStack(Material.BOW);
            plugin.Detective.getInventory().addItem(itemStackD2);
            ItemStack itemStackD3 = new ItemStack(Material.SPECTRAL_ARROW);
            plugin.Detective.getInventory().addItem(itemStackD3);

            Bukkit.broadcastMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.RED + " The detective has died. Someone else has been given the sword.");
        } else {
            Bukkit.broadcastMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.RED + " The detective has died. The Murderer wins!");
            EndGame eg = new EndGame(plugin);
            eg.Stop();
        }
        plugin.Detective.sendMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.WHITE + " You are the new " + ChatColor.BOLD + "Detective" + ChatColor.RESET + ChatColor.RED + ", you must kill the murderer and protect the innocents to win.");
    }
}
