package teamFire.JavaMongUs.models.user;

import teamFire.JavaMongUs.models.location.Location;

public class Player {

    public String username;
    public boolean dead = false;
    public boolean impostor = false;
    public Location playerLocation;
    //ToDo: Add tasks


    public Player(String username, Location playerLocation) {
        this.username = username;
        this.playerLocation = playerLocation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isImpostor() {
        return impostor;
    }

    public void setImpostor(boolean impostor) {
        this.impostor = impostor;
    }

    public Location getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(Location playerLocation) {
        this.playerLocation = playerLocation;
    }
}
