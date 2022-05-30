package com.github.tsuoihito.battleroyalecraft.model;

public class PluginState {

    private boolean inGame;
    private GameState gameState;

    public PluginState() {
        inGame = false;
    }

    public void initGame() {
        gameState = new GameState();
    }

    public GameState getGameState() {
        return gameState;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

}
