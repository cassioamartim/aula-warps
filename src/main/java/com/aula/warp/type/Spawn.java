package com.aula.warp.type;

import com.aula.warp.Warp;
import com.aula.warp.WarpType;
import org.bukkit.entity.Player;

public class Spawn extends Warp {

    public Spawn() {
        super("Spawn", WarpType.SPAWN);
    }

    @Override
    public void onJoin(Player player) {
        player.sendMessage("§cVocê entrou no Spawn!");
    }
}
