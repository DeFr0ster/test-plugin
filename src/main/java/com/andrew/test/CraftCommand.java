package com.andrew.test;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CraftCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
             p.openWorkbench(null, true);
             p.playSound(p.getLocation(), Sound.valueOf("BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON"), 0.5f, 1);
        }
        return false;
    }
}
