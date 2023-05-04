package com.aula.util;

import com.aula.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.FileConfiguration;

public class Util {

    public static void registerLocation(Location location, String configName) {
        configName = configName.toLowerCase();

        FileConfiguration config = Main.getPlugin(Main.class).getConfig();

        config.set(configName + ".world", location.getWorld().getName());

        config.set(configName + ".x", location.getX());
        config.set(configName + ".y", location.getY());
        config.set(configName + ".z", location.getZ());

        config.set(configName + ".pitch", location.getPitch());
        config.set(configName + ".yaw", location.getYaw());

        Main.getPlugin(Main.class).saveConfig();
    }

    public static Location getLocation(String configName) {
        configName = configName.toLowerCase();

        FileConfiguration config = Main.getPlugin(Main.class).getConfig();

        if (!config.contains(configName + ".x")) {
            return Bukkit.getWorlds().get(0).getSpawnLocation();
        }

        World world = Bukkit.getWorld(config.getString(configName + ".world"));

        if (world == null) {
            world = Main.getPlugin(Main.class).getServer().createWorld(new WorldCreator(config.getString(configName + ".world")));
        }

        Location location = new Location(world, config.getDouble(configName + ".x"), config.getDouble(configName + ".y"),
                config.getDouble(configName + ".z"));

        location.setPitch(config.getLong(configName + ".pitch"));
        location.setYaw(config.getLong(configName + ".yaw"));

        return location;
    }
}
