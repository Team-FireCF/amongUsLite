package teamFire.JavaMongUs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import teamFire.JavaMongUs.models.GameState;
import teamFire.JavaMongUs.models.user.Player;

import java.security.Principal;

@Controller
public class GameStateController {

    @GetMapping("/game")
    public String showTheGame(Principal principal, Model m){
        m.addAttribute(CreateGameController.startGame.playerList.get(principal.getName()) );
        return "game";
    }
}