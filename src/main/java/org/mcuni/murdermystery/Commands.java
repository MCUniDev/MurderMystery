package org.mcuni.murdermystery;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Commands implements CommandExecutor {

    public Murdermystery plugin;
    public Commands(Murdermystery murdermystery) {
        this.plugin = murdermystery;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("mm")) {
            if (args.length > 0) {
                if ("join".equals(args[0])) {
                    this.plugin.Players.add(commandSender.getName());
                    commandSender.sendMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.RED + " Joined MurderMystery game.");
                } else if ("leave".equals(args[0])) {
                    this.plugin.Players.remove(commandSender.getName());
                    commandSender.sendMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.RED + " Left MurderMystery game.");
                }
            } else {
                commandSender.sendMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.RED + " Running MurderMystery version "+this.plugin.getDescription().getVersion()+" by MCUni.");
            }
            return true;
        }
        return true;
    }
}
