package com.github.tsuoihito.battleroyalecraft.model;

import org.bukkit.Location;

public class GameData {

    private Location base;
    private Location lobby;
    private Location start;

    public GameData(){}

    public Location getBase() {
        return base;
    }

    public void setBase(Location base) {
        this.base = base;
    }

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
