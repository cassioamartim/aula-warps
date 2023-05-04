package com.aula.listener;

import com.aula.Main;
import com.aula.user.User;
import com.aula.warp.Warp;
import com.aula.warp.WarpType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class UserListener implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        User user = new User(player, WarpType.SPAWN);

        Main.getUserStorage().create(user);

        Warp warp = user.getWarp();

        warp.onJoin(player);

        warp.joinPlayer(player);

        Main.getWarpStorage().create(warp);
    }

    @EventHandler
    public void leave(PlayerQuitEvent event) {
        User user = Main.getUserStorage().get(event.getPlayer().getUniqueId());

        user.getWarp().leavePlayer(event.getPlayer());

        Main.getWarpStorage().create(user.getWarp());

        Main.getUserStorage().remove(event.getPlayer().getUniqueId());
    }
}
