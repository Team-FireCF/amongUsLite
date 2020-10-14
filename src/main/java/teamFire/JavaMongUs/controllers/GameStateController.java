package teamFire.JavaMongUs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import teamFire.JavaMongUs.models.GameState;
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

//        System.out.println(CreateGameController.startGame.playerList.get(principal.getName()).getPlayerLocation().toString());
        CreateGameController.startGame.currentLocation.get(CreateGameController.startGame.playerList.get(principal.getName()).getPlayerLocation()).playersAtCurrentLocation.remove(CreateGameController.startGame.playerList.get(principal.getName()));
        CreateGameController.startGame.playerList.get(principal.getName()).playerLocation = CreateGameController.startGame.currentLocation.get(location);
        CreateGameController.startGame.currentLocation.get(location).playersAtCurrentLocation.add(CreateGameController.startGame.playerList.get(principal.getName()));

        System.out.println(CreateGameController.startGame.playerList.get(principal.getName()).playerLocation);
        System.out.println(CreateGameController.startGame.currentLocation.get("Conference Room").playersAtCurrentLocation.toString());
        System.out.println(CreateGameController.startGame.currentLocation.get(location).playersAtCurrentLocation.toString());
        while(playerUpdateCounter < CreateGameController.startGame.playerList.values().size()) { Thread.sleep(50); }

        return new RedirectView("/game");
    }


}
