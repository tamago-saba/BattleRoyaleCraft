package com.github.tsuoihito.battleroyalecraft.utils;

import com.github.tsuoihito.battleroyalecraft.BattleRoyaleCraft;
import org.bukkit.GameMode;

public class GameManager {

    private final BattleRoyaleCraft plugin;

    public GameManager(BattleRoyaleCraft plugin) {
        this.plugin = plugin;
    }

    public void startGame() {

        plugin.getPluginState().setInGame(true);
        plugin.getPluginState().initGame();

        plugin.getServer().getOnlinePlayers().forEach(player -> {

            player.setHealth(20);
            player.setSaturation(20);
            player.teleport(plugin.getGameData().getStart());

            plugin.getPluginState().getGameState().addPlayerData(player.getUniqueId());

        });

    }

    public void finishGame() {

        plugin.getPluginState().setInGame(false);
        teleportAllLobby();

    }

    public void teleportAllLobby() {
        plugin.getServer().getOnlinePlayers().forEach(player -> {
            player.teleport(plugin.getGameData().getLobby());
            player.setGameMode(GameMode.ADVENTURE);
        });
    }
}
