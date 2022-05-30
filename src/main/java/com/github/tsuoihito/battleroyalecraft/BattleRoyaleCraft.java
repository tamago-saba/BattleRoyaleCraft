package com.github.tsuoihito.battleroyalecraft;

import com.github.tsuoihito.battleroyalecraft.model.GameData;
import com.github.tsuoihito.battleroyalecraft.model.PluginState;
import com.github.tsuoihito.battleroyalecraft.utils.GameManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class BattleRoyaleCraft extends JavaPlugin {

    private final PluginState pluginState = new PluginState();
    private final GameData gameData = new GameData();
    private final GameManager gameManager = new GameManager(this);

    @Override
    public void onEnable() {
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public PluginState getPluginState() {
        return pluginState;
    }

    public GameData getGameData() {
        return gameData;
    }

    public GameManager getGameManager() {
        return gameManager;
    }

}
