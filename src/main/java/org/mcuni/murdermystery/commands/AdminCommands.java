package org.mcuni.murdermystery.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mcuni.murdermystery.Murdermystery;

public class AdminCommands implements CommandExecutor {

    public Murdermystery plugin;
    public AdminCommands(Murdermystery plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        if (player.hasPermission("kit.events")) {
            if (command.getName().equalsIgnoreCase("mma")) {
                if (args.length > 0) {
                    if ("list".equals(args[0])) {
                        String playerList = "";
                        int playerCount = 0;
                        for (String p : plugin.Players) {
                            playerList += p + " ";
                            playerCount++;
                        }
                        if (playerCount != 0) {
                            player.sendMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.WHITE + " Players in game: " + playerList + "(" + playerCount + ")");
                        } else {
                            player.sendMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.RED + " There are no players in game.");
                        }
                    }
                } else {
                    player.sendMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.WHITE + " Running MurderMystery version " + plugin.getDescription().getVersion() + " by MCUni.");
                }
                return true;
            }
        } else {
            player.sendMessage(ChatColor.DARK_RED + "[MM]"+ChatColor.RED+" You don't have permission to access this command.");
        }
        return true;
    }
}
