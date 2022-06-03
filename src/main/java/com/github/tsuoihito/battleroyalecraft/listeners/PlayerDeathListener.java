package com.github.tsuoihito.battleroyalecraft.listeners;

import com.github.tsuoihito.battleroyalecraft.BattleRoyaleCraft;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    private final BattleRoyaleCraft plugin;

    public PlayerDeathListener(BattleRoyaleCraft plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerDeath(PlayerDeathEvent e) {

        if (!plugin.isInGame()) {
            return;
        }

        if (!plugin.getGameState().getPlayerDataOptional(e.getEntity().getUniqueId()).isPresent()) {
            return;
        }

        plugin.getGameState().getPlayerDataOptional(e.getEntity().getUniqueId()).get().setDead(true);
        e.getEntity().setGameMode(GameMode.SPECTATOR);

        if (plugin.getGameState().getLivingPlayerDataList().size() == 1) {
            plugin.getGameManager().finishGame();
        }

        if (e.getEntity().getKiller() == null) {
            return;
        }

        if (!plugin.getGameState().getPlayerDataOptional(e.getEntity().getKiller().getUniqueId()).isPresent()) {
            return;
        }

        plugin.getGameState().getPlayerDataOptional(e.getEntity().getKiller().getUniqueId()).get().increaseKillCount();

    }
}
