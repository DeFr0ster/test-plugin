package com.andrew.test;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvseeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0 || args.length > 2) {
                p.sendMessage(ChatColor.RED + "WRONG");
            }
            if (args.length == 1) {
                for (Player online : Bukkit.getOnlinePlayers()) {
                    if (args[0].equalsIgnoreCase(online.getName())) {
                        p.openInventory(online.getInventory());
                        p.sendMessage("&bOpening &c" + online.getName() + " &bInventory...");
                    } else {
                        p.sendMessage("&bNo player by the name of &c" + args[0] + " &bwas found");
                    }
                    return false;
                }
            }
        }
        return false;
    }
}



