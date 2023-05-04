package com.aula.command;

import com.aula.Main;
import com.aula.user.User;
import com.aula.warp.Warp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand extends Command {

    public WarpCommand() {
        super("warp");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§cSomente jogadores podem usar este comando!");
            return false;
        }

        Player player = (Player) sender;

        User user = Main.getUserStorage().get(player.getUniqueId());

        if (args.length == 0) {
            player.sendMessage("§cModo de uso: /warp <nome-da-warp>");
            return false;
        }

        Warp warp = Main.getWarpStorage().get(args[0]);

        if (warp == null || user.getType().equals(warp.getType())) {
            player.sendMessage("§cA warp solicitada não existe ou você já está nela!");
            return false;
        }

        Warp old = user.getWarp();

        old.leavePlayer(player);

        Main.getWarpStorage().create(old);

        user.setType(warp.getType());

        Main.getUserStorage().create(user);

        warp.joinPlayer(player);

        warp.onJoin(player);

        Main.getWarpStorage().create(warp);

        player.teleport(warp.getLocation());

        return true;
    }
}
