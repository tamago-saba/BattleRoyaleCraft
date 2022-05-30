package com.github.tsuoihito.battleroyalecraft.model;

import java.util.UUID;

public class PlayerData {

    private String name;
    private final UUID uuid;
    private boolean dead;
    private Integer killCount;

    public PlayerData(UUID uuid) {

        this.uuid = uuid;
        dead = false;
        killCount = 0;

    }

    public void increaseKillCount() {
        killCount ++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public Integer getKillCount() {
        return killCount;
    }

}
