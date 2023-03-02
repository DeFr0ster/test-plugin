package com.andrew.test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class HealCommand  implements CommandExecutor {

    private Cache<UUID, Long> cooldown = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.SECONDS).build();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (!cooldown.asMap().containsKey(p.getUniqueId())) {
                p.sendMessage(ChatColor.GREEN + "Your health & hunger has been restored!");
                p.setHealth(20);
                p.setFoodLevel(20);
                p.playSound(p.getLocation(), Sound.valueOf("ENTITY_GENERIC_EAT"),1, 1);
                cooldown.put(p.getUniqueId(), System.currentTimeMillis() + 5000);
            } else {
                long distance = cooldown.asMap().get(p.getUniqueId()) - System.currentTimeMillis();
                p.sendMessage(ChatColor.RED + "You must wait " + TimeUnit.MILLISECONDS.toSeconds(distance) + " to use this again.");
            }
        }
        return false;
    }
}
