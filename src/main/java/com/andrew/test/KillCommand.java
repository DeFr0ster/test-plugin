package com.andrew.test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class KillCommand implements CommandExecutor {

    private Cache<UUID, Long> cooldown = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.SECONDS).build();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (!cooldown.asMap().containsKey(p.getUniqueId())) {
                if (args.length == 0) {
                    p.setHealth(0);
                    p.sendMessage("You have just killed yourself!");
                    cooldown.put(p.getUniqueId(), System.currentTimeMillis() + 5000);
                }
            } else {
                long distance = cooldown.asMap().get(p.getUniqueId()) - System.currentTimeMillis();
                p.sendMessage(ChatColor.RED + "You must wait " + TimeUnit.MILLISECONDS.toSeconds(distance) + " to use this again.");
                }
            }  return false;
        }
    }


