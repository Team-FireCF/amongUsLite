package teamFire.JavaMongUs.models.location;

import teamFire.JavaMongUs.models.user.Player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

public class Location {

    public ArrayList<Location> adjacentLocations = new ArrayList<>();
    public ArrayList<Player> playersAtCurrentLocation = new ArrayList<>();
    public Boolean deadBody = false;


    public String locationName;

    public Location(String locationName) {
        this.locationName = locationName;
    }

    public String getName(){return locationName;}

    public Boolean getDeadBody() {
        return deadBody;
    }

    public void setDeadBody(Boolean deadBody) {
        this.deadBody = deadBody;
    }
}
