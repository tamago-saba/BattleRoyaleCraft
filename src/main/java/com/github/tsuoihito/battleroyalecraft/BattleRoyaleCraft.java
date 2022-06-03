package com.github.tsuoihito.battleroyalecraft;

import com.github.tsuoihito.battleroyalecraft.model.GameConfig;
import com.github.tsuoihito.battleroyalecraft.model.GameState;
import com.github.tsuoihito.battleroyalecraft.utils.GameManager;
import org.bukkit.WorldBorder;
import org.bukkit.plugin.java.JavaPlugin;

public final class BattleRoyaleCraft extends JavaPlugin {

    private boolean inGame;
    private GameState gameState;

    private WorldBorder worldBorder;

    private final GameConfig gameConfig = new GameConfig();
    private final GameManager gameManager = new GameManager(this);

    @Override
    public void onEnable() {
        setInGame(false);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public WorldBorder getWorldBorder() {
        return worldBorder;
    }

    public void setWorldBorder(WorldBorder worldBorder) {
        this.worldBorder = worldBorder;
    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }

    public GameManager getGameManager() {
        return gameManager;
    }

}
