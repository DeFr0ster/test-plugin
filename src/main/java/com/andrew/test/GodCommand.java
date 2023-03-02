package com.andrew.test;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0 || args.length > 2) {
                // Needs to be cooler
                p.sendMessage(ChatColor.GRAY + "+------------------------------------+");
                p.sendMessage(" ");
                p.sendMessage(ChatColor.AQUA + "             /god on");
                p.sendMessage(ChatColor.AQUA + "             /god off");
                p.sendMessage(" ");
                p.sendMessage(ChatColor.GRAY + "+------------------------------------+");
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("on")) {
                    p.setInvulnerable(true);
                    p.sendMessage(ChatColor.AQUA + "You have enabled god mode.");
                } else if (args[0].equalsIgnoreCase("off")) {
                    p.setInvulnerable(false);
                    p.sendMessage(ChatColor.AQUA + "You have disable godmode.");
                }
            }
        }
        return false;
    }
}
