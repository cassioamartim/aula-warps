package com.aula.warp;

import com.aula.util.Util;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public abstract class Warp {

    private final String name;

    private final WarpType type;

    private Location location;

    private final Set<Player> players = new HashSet<>();

    public Warp(String name, WarpType type) {
        this.name = name;

        this.type = type;

        location = Util.getLocation("warp." + name);
    }

    public abstract void onJoin(Player player);

    public WarpType getType() {
        return type;
    }

    public void joinPlayer(Player player) {
        players.add(player);
    }

    public void leavePlayer(Player player) {
        players.remove(player);
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
