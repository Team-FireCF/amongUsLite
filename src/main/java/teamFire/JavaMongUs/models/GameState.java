package teamFire.JavaMongUs.models;


import teamFire.JavaMongUs.models.location.Location;
import teamFire.JavaMongUs.models.user.ApplicationUser;
import teamFire.JavaMongUs.models.user.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GameState {
    public HashMap<String, Player> playerList = new HashMap<>();
    public HashMap<String, Location> currentLocation = new HashMap<>();
    public Boolean discuss = false;
    public int startTimer = 0;
    public boolean joinGame = false;
    public boolean gameInProgress = false;
    public String gameStartedBy;
    int playerUpdateCounter = 0;

    public HashMap<String, Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(HashMap<String, Player> playerList) {
        this.playerList = playerList;
    }

    public HashMap<String, Location> getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(HashMap<String, Location> currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Boolean getDiscuss() {
        return discuss;
    }

    public void setDiscuss(Boolean discuss) {
        this.discuss = discuss;
    }

    public long getStartTimer() {
        return startTimer;
    }

    public void setStartTimer(int startTimer) {
        this.startTimer = startTimer;
    }

    public boolean isJoinGame() {
        return joinGame;
    }

    public void setJoinGame(boolean joinGame) {
        this.joinGame = joinGame;
    }

    public boolean isGameInProgress() {
        return gameInProgress;
    }

    public void setGameInProgress(boolean gameInProgress) {
        this.gameInProgress = gameInProgress;
    }

    public String getGameStartedBy() {
        return gameStartedBy;
    }

    public void setGameStartedBy(String gameStartedBy) {
        this.gameStartedBy = gameStartedBy;
    }

    public void setPlayerUpdateCounter(int playerUpdateCounter) {
        this.playerUpdateCounter = playerUpdateCounter;
    }

    public int getPlayerUpdateCounter() {
        return playerUpdateCounter;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "playerList=" + playerList +
                ", currentLocation=" + currentLocation +
                ", discuss=" + discuss +
                ", startTimer=" + startTimer +
                ", joinGame=" + joinGame +
                ", gameInProgress=" + gameInProgress +
                ", gameStartedBy='" + gameStartedBy + '\'' +
                '}';
    }
}
