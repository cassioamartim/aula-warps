package com.aula.user;

import com.aula.Main;
import com.aula.warp.Warp;
import com.aula.warp.WarpType;
import org.bukkit.entity.Player;

public class User {

    private final Player player;

    private WarpType type;

    public User(Player player, WarpType type) {
        this.player = player;

        this.type = type;
    }

    public Warp getWarp() {
        return Main.getWarpStorage().get(type.name());
    }

    public Player getPlayer() {
        return player;
    }

    public WarpType getType() {
        return type;
    }

    public void setType(WarpType type) {
        this.type = type;
    }
}
