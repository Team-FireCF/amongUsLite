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
        char sym = location.charAt(0);
        String bol = String.format("%c", sym);
        switch (bol){
            case "!":
                return changeLocation(principal, location);

            case "#":
                return report(principal, location);

            case "&":
                return task(principal, location);

            case  "$":
                return meeting(principal, location);

            case "@":
                return kill(principal, location);

            default:
                return new RedirectView("/game");
        }
    }

    public RedirectView changeLocation (Principal principal, String location) throws InterruptedException {
        String str = location.substring(1);
        Player getPlayer = CreateGameController.startGame.playerList.get(principal.getName());
        getPlayer.getPlayerLocation().playersAtCurrentLocation.remove(getPlayer);
        Location getLocation = CreateGameController.startGame.currentLocation.get(str);
        getLocation.playersAtCurrentLocation.add(getPlayer);
        getPlayer.setPlayerLocation(getLocation);
        while(playerUpdateCounter < CreateGameController.startGame.playerList.values().size()) { Thread.sleep(50); }
        if(CreateGameController.startGame.discuss){
            return new RedirectView("/meeting");
        } else {
            return new RedirectView("/game");
        }
    }

    public RedirectView report (Principal principal, String location) throws InterruptedException {
        String str = location.substring(1);
        Location getLocation = CreateGameController.startGame.currentLocation.get(str);
        getLocation.deadBody = false;
        while(playerUpdateCounter < CreateGameController.startGame.playerList.values().size()) { Thread.sleep(50); }
        if(CreateGameController.startGame.discuss){
            return new RedirectView("/meeting");
        } else {
            return new RedirectView("/game");
        }
    }

    public RedirectView task (Principal principal, String location) throws InterruptedException {
        String str = location.substring(1);
        Player getPlayer = CreateGameController.startGame.playerList.get(principal.getName());
        for(int i =0; i < getPlayer.taskList.size(); i++){
            if (str.equals(getPlayer.taskList.get(i))) {
                getPlayer.taskList.remove(i);
            }
        }
        while(playerUpdateCounter < CreateGameController.startGame.playerList.values().size()) { Thread.sleep(50); }
        if(CreateGameController.startGame.discuss){
            return new RedirectView("/meeting");
        } else {
            return new RedirectView("/game");
        }
    }

    public RedirectView kill (Principal principal, String location){
        String str = location.substring(1);
        Location getLocation = CreateGameController.startGame.currentLocation.get(str);
        Player getPlayer = CreateGameController.startGame.playerList.get(getLocation.playersAtCurrentLocation.);

        if(CreateGameController.startGame.discuss){
            return new RedirectView("/meeting");
        } else {
            return new RedirectView("/game");
        }
    }

    public RedirectView meeting(Principal principal, String location) throws InterruptedException {
        String str = location.substring(1);
        CreateGameController.startGame.discuss = true;
        while(playerUpdateCounter < CreateGameController.startGame.playerList.values().size()) { Thread.sleep(50); }
        if(CreateGameController.startGame.discuss){
            return new RedirectView("/meeting");
        } else {
            return new RedirectView("/game");
        }
    }
}


