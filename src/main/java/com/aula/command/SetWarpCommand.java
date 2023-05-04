package com.aula.command;

import com.aula.Main;
import com.aula.util.Util;
import com.aula.warp.Warp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetWarpCommand extends Command {

    public SetWarpCommand() {
        super("setwarp");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§cSomente jogadores podem usar este comando!");
            return false;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("§cModo de uso: /setwarp <nome-da-warp>");
            return false;
        }

        Warp warp = Main.getWarpStorage().get(args[0]);

        if (warp == null) {
            player.sendMessage("§cEssa warp não existe meu amigo!");
            return false;
        }

        warp.setLocation(player.getLocation());

        Main.getWarpStorage().create(warp);

        Util.registerLocation(player.getLocation(), "warp." + warp.getName());

        player.sendMessage("§aVocê setou a localização da warp com sucesso!");

        return true;
    }
}
