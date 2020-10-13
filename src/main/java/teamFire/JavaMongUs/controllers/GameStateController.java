package teamFire.JavaMongUs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import teamFire.JavaMongUs.models.user.Player;

import java.security.Principal;

@Controller
public class GameStateController {

    @GetMapping("/game")
    public String showGame(Principal principal){
        return "game";
    }
}
