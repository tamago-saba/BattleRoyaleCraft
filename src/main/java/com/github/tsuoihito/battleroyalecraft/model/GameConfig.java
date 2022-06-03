package com.github.tsuoihito.battleroyalecraft.model;

import org.bukkit.Location;

public class GameConfig {

    private Location lobby;
    private Location start;

    public GameConfig() {}

    public Location getLobby() {
        return lobby;
    }

    public void setLobby(Location lobby) {
        this.lobby = lobby;
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

}
