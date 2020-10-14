package teamFire.JavaMongUs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import teamFire.JavaMongUs.models.GameState;
import teamFire.JavaMongUs.models.location.Location;
import teamFire.JavaMongUs.models.user.Player;

import java.security.Principal;

@Controller
public class GameStateController {
    int playerUpdateCounter = 0;
    @GetMapping("/game")
    public String showTheGame(Principal principal, Model m){
        m.addAttribute("playerOne", CreateGameController.startGame.playerList.get(principal.getName()) );
        m.addAttribute("allPlayers", CreateGameController.startGame.playerList.values());
        return "game";
    }

    @GetMapping("/startGame")
    public String startGame(Principal principal, Model m) {
        m.addAttribute("playerOne", CreateGameController.startGame.playerList.get(principal.getName()) );
        m.addAttribute("allPlayers", CreateGameController.startGame.playerList.values() );
        return "game";
    }

    @GetMapping("/meeting")
    public String showMeeting(Principal principal, Model m) {
        m.addAttribute("playerOne", CreateGameController.startGame.playerList.get(principal.getName()) );
        m.addAttribute("allPlayers", CreateGameController.startGame.playerList.values() );
        return "meeting";
    }

    @PostMapping("/gameUpdate")
    public RedirectView updateGameState(Principal principal, String location) throws InterruptedException {
        playerUpdateCounter++;
        // Steps
        // Remove principal player from the current location arraylist
        // add principal player to new current location array list
        // update principal player "player" location.
        Player getPlayer = CreateGameController.startGame.playerList.get(principal.getName());
        getPlayer.getPlayerLocation().playersAtCurrentLocation.remove(getPlayer);

        Location getLocation = CreateGameController.startGame.currentLocation.get(location);
        getLocation.playersAtCurrentLocation.add(getPlayer);

        getPlayer.setPlayerLocation(getLocation);


        while(playerUpdateCounter < CreateGameController.startGame.playerList.values().size()) { Thread.sleep(50); }

        return new RedirectView("/game");
    }


}
