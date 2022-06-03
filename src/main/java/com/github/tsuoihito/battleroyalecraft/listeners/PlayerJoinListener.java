package com.github.tsuoihito.battleroyalecraft.listeners;

import com.github.tsuoihito.battleroyalecraft.BattleRoyaleCraft;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final BattleRoyaleCraft plugin;

    public PlayerJoinListener(BattleRoyaleCraft plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerJoin(PlayerJoinEvent e) {

        if (!plugin.isInGame()) {
            plugin.getGameManager().teleportAllLobby();
            return;
        }

        // Teleport somewhere
        e.getPlayer().setGameMode(GameMode.SPECTATOR);
    }
}
