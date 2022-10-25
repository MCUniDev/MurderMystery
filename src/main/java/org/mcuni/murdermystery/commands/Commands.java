package org.mcuni.murdermystery.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mcuni.murdermystery.Murdermystery;

public class Commands implements CommandExecutor {

    public Murdermystery plugin;
    public Commands(Murdermystery plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        if (command.getName().equalsIgnoreCase("mm")) {
            if (args.length > 0) {
                if ("join".equals(args[0])) {
                    plugin.Players.add(player.getName());
                    player.sendMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.RED + " Joined MurderMystery game.");
                } else if ("leave".equals(args[0])) {
                    plugin.Players.remove(player.getName());
                    player.sendMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.RED + " Left MurderMystery game.");
                }
            } else {
                player.sendMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.RED + " Running MurderMystery version "+plugin.getDescription().getVersion()+" by MCUni.");
            }
            return true;
        }
        return true;
    }
}
