package com.github.tsuoihito.battleroyalecraft.utils;

import com.github.tsuoihito.battleroyalecraft.BattleRoyaleCraft;
import com.github.tsuoihito.battleroyalecraft.model.GameState;
import org.bukkit.GameMode;

public class GameManager {

    private final BattleRoyaleCraft plugin;

    public GameManager(BattleRoyaleCraft plugin) {
        this.plugin = plugin;
    }

    public void startGame() {

        if (plugin.getGameConfig().getStart() == null) {
            // Not set start point
            return;
        }

        initWorldBorder();
        initPlayers();

        plugin.setInGame(true);
        plugin.setGameState(new GameState());

    }

    public void finishGame() {

        teleportAllLobby();
        plugin.setInGame(false);

    }

    public void teleportAllLobby() {
        plugin.getServer().getOnlinePlayers().forEach(player -> {
            player.teleport(plugin.getGameConfig().getLobby());
            player.setGameMode(GameMode.ADVENTURE);
        });
    }

    private void initWorldBorder() {

        if (plugin.getGameConfig().getStart().getWorld() == null) {
            return;
        }

        if (plugin.getWorldBorder() == null) {
            plugin.setWorldBorder(plugin.getGameConfig().getStart().getWorld().getWorldBorder());
        }

        plugin.getWorldBorder().reset();
        plugin.getWorldBorder().setCenter(plugin.getGameConfig().getStart());

    }

    private void initPlayers() {

        plugin.getServer().getOnlinePlayers().forEach(player -> {

            player.setHealth(20);
            player.setSaturation(20);
            player.teleport(plugin.getGameConfig().getStart());

            plugin.getGameState().addPlayerData(player.getUniqueId());

        });

    }

}
