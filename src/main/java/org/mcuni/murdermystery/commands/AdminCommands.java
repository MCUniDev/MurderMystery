package org.mcuni.murdermystery.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mcuni.murdermystery.EndGame;
import org.mcuni.murdermystery.Murdermystery;
import org.mcuni.murdermystery.SelectPlayers;
import org.mcuni.murdermystery.StartGame;

public class AdminCommands implements CommandExecutor {

    public Murdermystery plugin;
    public AdminCommands(Murdermystery plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        if (player.hasPermission("mm.admin")) {
            if (command.getName().equalsIgnoreCase("mma")) {
                if (args.length > 0) {
                    if ("list".equals(args[0])) {
                        StringBuilder playerList = new StringBuilder();
                        int playerCount = 0;
                        for (Player p : plugin.Players) {
                            playerList.append(p.getName()).append(" ");
                            playerCount++;
                        }
                        if (playerCount != 0) {
                            player.sendMessage(ChatColor.DARK_RED + "[MMA]" + ChatColor.WHITE + " Players in game: " + playerList + "(" + playerCount + ")");
                        } else {
                            player.sendMessage(ChatColor.DARK_RED + "[MMA]" + ChatColor.RED + " There are no players in game.");
                        }
                    } else if ("start".equals(args[0])) {
                        if (true) {
                            SelectPlayers sp = new SelectPlayers(plugin);
                            StartGame sg = new StartGame(plugin);
                            boolean found = false;
                            Player detective = null;
                            while (!found) {
                                if (detective == null) {
                                    detective = sp.SelectDetective();
                                    plugin.Detective = detective;
                                    plugin.getLogger().info("[MurderMystery] DetectiveSearch: " + detective.getName());
                                } else {
                                    found = true;
                                }
                            }
                            found = false;
                            Player murderer = null;
                            while (!found) {
                                if (murderer == null) {
                                    murderer = sp.SelectMurderer();
                                    plugin.Murderer = murderer;
                                    plugin.getLogger().info("[MurderMystery] DetectiveSearch: " + murderer.getName());
                                } else {
                                    found = true;
                                }
                            }
                            player.sendMessage(ChatColor.DARK_RED + "[MMA]" + ChatColor.WHITE + " Starting game.");
                            player.sendMessage(ChatColor.DARK_RED + "[MMA]" + ChatColor.WHITE + " Detective: " + plugin.Detective.getName());
                            player.sendMessage(ChatColor.DARK_RED + "[MMA]" + ChatColor.WHITE + " Murderer: " + plugin.Murderer.getName());
                            plugin.GameRunning = true;
                            sg.Run();
                        } else {
                            player.sendMessage(ChatColor.DARK_RED + "[MMA]" + ChatColor.RED + " There are not enough players to start a game.");
                        }
                    } else if ("end".equals(args[0])) {
                        EndGame eg = new EndGame(plugin);
                        eg.Stop();
                    } else {
                        player.sendMessage(ChatColor.DARK_RED + "[MMA]" + ChatColor.RED + " Command not found.");
                    }
                } else {
                    player.sendMessage(ChatColor.DARK_RED + "[MMA]" + ChatColor.WHITE + " Running MurderMystery version " + plugin.getDescription().getVersion() + " by MCUni.");
                }
                return true;
            }
        } else {
            player.sendMessage(ChatColor.DARK_RED + "[MMA]"+ChatColor.RED+" You don't have permission to access this command.");
        }
        return true;
    }
}
