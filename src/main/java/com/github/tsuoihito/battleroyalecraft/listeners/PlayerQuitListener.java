package com.github.tsuoihito.battleroyalecraft.listeners;

import com.github.tsuoihito.battleroyalecraft.BattleRoyaleCraft;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    private final BattleRoyaleCraft plugin;

    public PlayerQuitListener(BattleRoyaleCraft plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerQuit(PlayerQuitEvent e) {

        if (!plugin.isInGame()) {
            return;
        }

        plugin.getGameState().removePlayerData(e.getPlayer().getUniqueId());

    }
}
