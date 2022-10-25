package org.mcuni.murdermystery;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AdminCommands implements CommandExecutor {

    public Murdermystery plugin;
    public AdminCommands(Murdermystery murdermystery) {
        this.plugin = murdermystery;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("mma")) {
            if (args.length > 0) {
                if ("list".equals(args[0])) {
                    for (String player : this.plugin.Players) {
                        commandSender.sendMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.RED + " "+player);
                    }
                }
            } else {
                commandSender.sendMessage(ChatColor.DARK_RED + "[MM]" + ChatColor.RED + " Running MurderMystery version "+this.plugin.getDescription().getVersion()+" by MCUni.");
            }
            return true;
        }
        return true;
    }
}
