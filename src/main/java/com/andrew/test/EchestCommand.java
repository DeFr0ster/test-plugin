package com.andrew.test;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class EchestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.openInventory(p.getEnderChest());
            p.playSound(p.getLocation(), Sound.valueOf("BLOCK_ENDER_CHEST_OPEN"), 0.5f, 1);
            p.playSound(p.getLocation(), Sound.valueOf("ENTITY_EGG_THROW"), 2.0f, 1.0f);
            p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 10);
            p.sendMessage(ChatColor.LIGHT_PURPLE + "Opening ender chest....");
        }
        return false;
    }
}
