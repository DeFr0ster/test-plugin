package com.andrew.test;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DayCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

       if (sender instanceof Player) {
           Player p = (Player) sender;
           p.getWorld().setTime(6000);
           p.sendMessage(ChatColor.GREEN + "You have just set the time to day.");
       }
        return false;
    }
}
