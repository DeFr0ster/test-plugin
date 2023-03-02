package com.andrew.test;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("kill").setExecutor(new KillCommand());
        getCommand("craft").setExecutor(new CraftCommand());
        getCommand("echest").setExecutor(new EchestCommand());
        getCommand("day").setExecutor(new DayCommand());
        getCommand("night").setExecutor(new NightCommand());
        getCommand("invsee").setExecutor(new InvseeCommand());
    }
}

