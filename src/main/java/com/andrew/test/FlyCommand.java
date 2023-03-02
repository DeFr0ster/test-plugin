package com.andrew.test;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                p.setAllowFlight(!p.getAllowFlight());
                p.sendMessage("Flight has been " + String.valueOf(p.getAllowFlight()).toUpperCase(Locale.ROOT));
            }
        }
        return false;
    }
}
