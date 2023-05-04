package com.aula.warp.type;

import com.aula.warp.Warp;
import com.aula.warp.WarpType;
import org.bukkit.entity.Player;

public class FPS extends Warp {

    public FPS() {
        super("FPS", WarpType.FPS);
    }

    @Override
    public void onJoin(Player player) {
        player.sendMessage("§eVocê entrou no FPS!");
    }
}
