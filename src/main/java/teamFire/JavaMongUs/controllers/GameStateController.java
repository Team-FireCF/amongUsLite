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
import java.util.concurrent.TimeUnit;

@Controller
public class GameStateController {

    @GetMapping("/game")
    public String showTheGame(Principal principal, Model m){
        m.addAttribute("playerOne", CreateGameController.startGame.playerList.get(principal.getName()) );
        m.addAttribute("allPlayers", CreateGameController.startGame.playerList.values());
        m.addAttribute("locationDeets", CreateGameController.startGame.currentLocation);
        m.addAttribute("taskNum",CreateGameController.startGame);

        return "game";
    }

    @GetMapping("/startGame")
    public String startGame(Principal principal, Model m) throws InterruptedException {
        if(principal.getName().equals(CreateGameController.startGame.gameStartedBy)) {
            CreateGameController.startGame.playerList.get(principal.getName()).setImpostor(true);
            new Thread(() -> {
                try {
                    startTimer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            m.addAttribute("playerOne", CreateGameController.startGame.playerList.get(principal.getName()) );
            m.addAttribute("allPlayers", CreateGameController.startGame.playerList.values() );
            m.addAttribute("startTimer", CreateGameController.startGame.startTimer);
            return "start";
        }
        m.addAttribute("playerOne", CreateGameController.startGame.playerList.get(principal.getName()) );
        m.addAttribute("allPlayers", CreateGameController.startGame.playerList.values() );
        m.addAttribute("startTimer", CreateGameController.startGame.startTimer);
        m.addAttribute("taskNum", CreateGameController.startGame.playerList.size());
        return "start";
    }

    @GetMapping("/meeting")
    public String showMeeting(Principal principal, Model m) {
        m.addAttribute("playerOne", CreateGameController.startGame.playerList.get(principal.getName()) );
        m.addAttribute("allPlayers", CreateGameController.startGame.playerList.values() );

        return "meeting";
    }

    @GetMapping("/reset")
    public String resetServer(Principal principal) {
        CreateGameController.startGame.setDiscuss(false);
        CreateGameController.startGame.setStartTimer(0);
        CreateGameController.startGame.setJoinGame(false);
        CreateGameController.startGame.setGameInProgress(false);
        CreateGameController.startGame.setGameStartedBy("");
        CreateGameController.startGame.currentLocation.clear();
        CreateGameController.startGame.playerList.clear();

        return "home";
    }

    @PostMapping("/killUpdate")
    public RedirectView killMFers(Principal principal, String kill, Model m) throws InterruptedException {
        CreateGameController.startGame.setPlayerUpdateCounter(CreateGameController.startGame.getPlayerUpdateCounter()+1);
        return kill(principal, kill);
    }

    @PostMapping("/gameUpdate")
    public RedirectView updateGameState(Principal principal, String location) throws InterruptedException {
        CreateGameController.startGame.setPlayerUpdateCounter(CreateGameController.startGame.getPlayerUpdateCounter()+1);

        if(location == null){
            changeLocation(principal, "stayHere");
        }

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
//
    @GetMapping("/game/vote")
    public RedirectView countVotes(Principal principal, String location, Model m){
        System.out.println(location);
        CreateGameController.startGame.setDiscuss(false);
        m.addAttribute("playerOne", CreateGameController.startGame.playerList.get(principal.getName()) );
        m.addAttribute("allPlayers", CreateGameController.startGame.playerList.values());
        m.addAttribute("locationDeets", CreateGameController.startGame.currentLocation);
//        add iff statement to check if all tasks are done.  hardcode to 20
        return new RedirectView("/game");
    }

    public RedirectView changeLocation (Principal principal, String location) throws InterruptedException {
        String str = location.substring(1);
        System.out.println();
        if(!str.equals("stayHere")){

            Player getPlayer = CreateGameController.startGame.playerList.get(principal.getName());
            getPlayer.getPlayerLocation().playersAtCurrentLocation.remove(getPlayer);
            Location getLocation = CreateGameController.startGame.currentLocation.get(str);
            getLocation.playersAtCurrentLocation.add(getPlayer);
            getPlayer.setPlayerLocation(getLocation);
        }

        while(CreateGameController.startGame.getPlayerUpdateCounter() < CreateGameController.startGame.playerList.values().size()) { Thread.sleep(20); }
//        add iff statement to check if all tasks are done.  hardcode to 20 and if playerlist.size =2
//        or if numTasks = 20

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
        CreateGameController.startGame.setDiscuss(true);
        while(CreateGameController.startGame.getPlayerUpdateCounter() < CreateGameController.startGame.playerList.values().size()) { Thread.sleep(20); }

//        add iff statement to check if all tasks are done.  hardcode to 20


        if(CreateGameController.startGame.discuss){
            return new RedirectView("/meeting");
        } else {
            return new RedirectView("/game");
        }
    }

    public RedirectView task (Principal principal, String location) throws InterruptedException {
        String str = location.substring(1);
        Player getPlayer = CreateGameController.startGame.playerList.get(principal.getName());
        getPlayer.setNumTask(getPlayer.getNumTask()-1);
        CreateGameController.startGame.setTaskNum(CreateGameController.startGame.getTaskNum() +1);
        for(int i =0; i < getPlayer.taskList.size(); i++){
            if (str.equals(getPlayer.taskList.get(i))) {
                getPlayer.taskList.remove(i);
            }
        }

//        add iff statement to check if all tasks are done.  hardcode to 20

        while(CreateGameController.startGame.getPlayerUpdateCounter() < CreateGameController.startGame.playerList.values().size()) { Thread.sleep(20); }


        if(CreateGameController.startGame.discuss){
            return new RedirectView("/meeting");
        } else {
            return new RedirectView("/game");
        }
    }

    public RedirectView kill (Principal principal, String kill) throws InterruptedException {

        Player getVictim = CreateGameController.startGame.playerList.get(kill);
        Location getLocation = CreateGameController.startGame.currentLocation.get(getVictim.playerLocation.locationName);

        getVictim.setDead(true);
        while(CreateGameController.startGame.getPlayerUpdateCounter() < CreateGameController.startGame.playerList.values().size()) { Thread.sleep(20); }

        if(CreateGameController.startGame.discuss){
            return new RedirectView("/meeting");
        } else {
            return new RedirectView("/game");
        }
    }

    public RedirectView meeting(Principal principal, String location) throws InterruptedException {
        String str = location.substring(1);
        CreateGameController.startGame.discuss = true;

//        add iff statement to check if all tasks are done.  hardcode to 20

        while(CreateGameController.startGame.getPlayerUpdateCounter() < CreateGameController.startGame.playerList.values().size()) { Thread.sleep(20); }



        if(CreateGameController.startGame.discuss){
            return new RedirectView("/meeting");
        } else {
            return new RedirectView("/game");
        }
    }


    public void startTimer() throws InterruptedException {

        boolean x=true;
        long startTime=System.currentTimeMillis();
        while(x) {
            TimeUnit.SECONDS.sleep(1);
            long timepassed=System.currentTimeMillis()-startTime;
            long secondspassed=timepassed/1000;
            if(secondspassed==8) {
                CreateGameController.startGame.startTimer = -1;
                x = false;
                CreateGameController.startGame.joinGame = false;

            }
            if(secondspassed < 8)   {
                CreateGameController.startGame.startTimer++;
            }


            System.out.println(CreateGameController.startGame.startTimer);
        }

    }

}


