package teamFire.JavaMongUs.models;


import teamFire.JavaMongUs.models.location.Location;
import teamFire.JavaMongUs.models.user.ApplicationUser;
import teamFire.JavaMongUs.models.user.Player;

import java.util.ArrayList;

public class GameState {
    ArrayList<Player> playerList = new ArrayList<>();
    ArrayList<Location> currentLocation = new ArrayList<>();
    Boolean discuss= false;


}
