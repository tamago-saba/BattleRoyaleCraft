package com.github.tsuoihito.battleroyalecraft.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class GameState {

    private Integer elapsedTime;
    private final List<PlayerData> playerDataList;

    public GameState(){

        elapsedTime = 0;
        playerDataList = new ArrayList<>();

    }

    public void increaseElapsedTime() {
        elapsedTime ++;
    }

    public Optional<PlayerData> getPlayerDataOptional(UUID uuid) {
        return playerDataList.stream().filter(playerData -> playerData.getUuid().equals(uuid)).findAny();
    }

    public List<PlayerData> getLivingPlayerDataList() {
        return playerDataList.stream().filter(playerData -> !playerData.isDead()).collect(Collectors.toList());
    }

    public boolean addPlayerData(UUID uuid) {
        return !getPlayerDataOptional(uuid).isPresent() && playerDataList.add(new PlayerData(uuid));
    }

    public boolean removePlayerData(UUID uuid) {
        return playerDataList.removeIf(playerData -> playerData.getUuid().equals(uuid));
    }

    public Integer getElapsedTime() {
        return elapsedTime;
    }

    public List<PlayerData> getPlayerDataList() {
        return playerDataList;
    }

}
