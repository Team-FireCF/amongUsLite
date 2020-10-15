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
    public long startTimer = 0;
    public boolean game = false;

    @Override
    public String toString() {
        return "GameState{" +
                "startTimer=" + startTimer +
                '}';
    }
}
