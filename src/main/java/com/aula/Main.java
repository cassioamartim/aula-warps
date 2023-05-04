package com.aula;

import com.aula.command.SetWarpCommand;
import com.aula.command.WarpCommand;
import com.aula.listener.UserListener;
import com.aula.user.UserStorage;
import com.aula.warp.Warp;
import com.aula.warp.WarpStorage;
import com.aula.warp.type.FPS;
import com.aula.warp.type.Spawn;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private final static UserStorage userStorage = new UserStorage();

    private final static WarpStorage warpStorage = new WarpStorage();

    public static WarpStorage getWarpStorage() {
        return warpStorage;
    }

    public static UserStorage getUserStorage() {
        return userStorage;
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();

        warpStorage.create(new Spawn());

        warpStorage.create(new FPS());

        getServer().getCommandMap().register("warp", new WarpCommand());
        getServer().getCommandMap().register("setwarp", new SetWarpCommand());

        getServer().getPluginManager().registerEvents(new UserListener(), this);
    }

    @Override
    public void onDisable() {

    }

}
