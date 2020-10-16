package teamFire.JavaMongUs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.view.RedirectView;
import teamFire.JavaMongUs.models.GameState;
import teamFire.JavaMongUs.models.location.Location;
import teamFire.JavaMongUs.models.user.Player;
import java.util.ArrayList;


import java.security.Principal;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Controller
public class CreateGameController {
    public static GameState startGame = new GameState();

    @GetMapping("/create")
    public RedirectView createGame(Principal principal) throws InterruptedException {
        startGame.setJoinGame(true);
        startGame.setGameStartedBy(principal.getName());
        startGame.setGameInProgress(true);
        Location conferenceRoom = new Location("Conference Room");
        startGame.currentLocation.put("Conference Room", conferenceRoom);
        Location lounge = new Location("Lounge");
        startGame.currentLocation.put("Lounge",lounge);
        Location oxygen = new Location("Oxygen Room");
        startGame.currentLocation.put("Oxygen Room",oxygen);
        Location electrical = new Location("Electrical Room");
        startGame.currentLocation.put("Electrical Room",electrical);
        Location zoom = new Location("Zoom Room");
        startGame.currentLocation.put("Zoom Room",zoom);
        Location remo = new Location("Remo Room");
        startGame.currentLocation.put("Remo Room",remo);
        Location computer = new Location("Computer Room");
        startGame.currentLocation.put("Computer Room",computer);
        Location codeFellows = new Location("CodeFellows Room");
        startGame.currentLocation.put("CodeFellows Room",codeFellows);
        Location study = new Location("Study");
        startGame.currentLocation.put("Study",study);
        Location hall1 = new Location("Hall 1");
        startGame.currentLocation.put("Hall 1",hall1);
        Location hall2 = new Location("Hall 2");
        startGame.currentLocation.put("Hall 2",hall2);
        Location hall3 = new Location("Hall 3");
        startGame.currentLocation.put("Hall 3",hall3);
        Location hall4 = new Location("Hall 4");
        startGame.currentLocation.put("Hall 4",hall4);
        Location hall5 = new Location("Hall 5");
        startGame.currentLocation.put("Hall 5",hall5);
        Location hall6 = new Location("Hall 6");
        startGame.currentLocation.put("Hall 6",hall6);
        Location hall7 = new Location("Hall 7");
        startGame.currentLocation.put("Hall 7",hall7);
        Location hall8 = new Location("Hall 8");
        startGame.currentLocation.put("Hall 8",hall8);
        Location hall9 = new Location("Hall 9");
        startGame.currentLocation.put("Hall 9",hall9);
        Location hall10 = new Location("Hall 10");
        startGame.currentLocation.put("Hall 10",hall10);
        Location hall11 = new Location("Hall 11");
        startGame.currentLocation.put("Hall 11",hall11);
        Location hall12 = new Location("Hall 12");
        startGame.currentLocation.put("Hall 12",hall12);
        Location hall13 = new Location("Hall 13");
        startGame.currentLocation.put("Hall 13",hall13);
        Location hall14 = new Location("Hall 14");
        startGame.currentLocation.put("Hall 14",hall14);
        Location hall15 = new Location("Hall 15");
        startGame.currentLocation.put("Hall 15",hall15);
        Location hall16 = new Location("Hall 16");
        startGame.currentLocation.put("Hall 16",hall16);
        Location hall17 = new Location("Hall 17");
        startGame.currentLocation.put("Hall 17",hall17);
        Location hall18 = new Location("Hall 18");
        startGame.currentLocation.put("Hall 18", hall18);
        Location hall19 = new Location("Hall 19");
        startGame.currentLocation.put("Hall 19",hall19);
        Location hall20 = new Location("Hall 20");
        startGame.currentLocation.put("Hall 20", hall20);
        Location hall21 = new Location("Hall 21");
        startGame.currentLocation.put("Hall 21", hall21);
        Location hall22 = new Location("Hall 22");
        startGame.currentLocation.put("Hall 22", hall22);
        Location hall23 = new Location("Hall 23");
        startGame.currentLocation.put("Hall 23", hall23);
        Location hall24 = new Location("Hall 24");
        startGame.currentLocation.put("Hall 24", hall24);
        Location hall25 = new Location("Hall 25");
        startGame.currentLocation.put("Hall 25", hall25);

//       Todo: refactor hardcoding
//        for(int i = 1; i < 26 ; i++){
//            String hall = String.format("hall%d", i);
//            Location hall = new Location("Hal");
//
//        }
        conferenceRoom.adjacentLocations.add(hall1);
        conferenceRoom.adjacentLocations.add(hall19);
        conferenceRoom.adjacentLocations.add(hall20);
        oxygen.adjacentLocations.add(hall2);
        oxygen.adjacentLocations.add(hall5);
        oxygen.adjacentLocations.add(hall9);
        electrical.adjacentLocations.add(hall6);
        electrical.adjacentLocations.add(hall7);
        computer.adjacentLocations.add(hall7);
        computer.adjacentLocations.add(hall8);
        computer.adjacentLocations.add(hall10);
        codeFellows.adjacentLocations.add(hall10);
        codeFellows.adjacentLocations.add(hall11);
        codeFellows.adjacentLocations.add(hall13);
        lounge.adjacentLocations.add(hall19);
        lounge.adjacentLocations.add(hall12);
        lounge.adjacentLocations.add(hall14);
        lounge.adjacentLocations.add(hall18);
        remo.adjacentLocations.add(hall17);
        remo.adjacentLocations.add(hall16);
        remo.adjacentLocations.add(hall22);
        zoom.adjacentLocations.add(hall23);
        zoom.adjacentLocations.add(hall24);
        study.adjacentLocations.add(hall24);
        study.adjacentLocations.add(hall25);
        hall1.adjacentLocations.add(conferenceRoom);
        hall1.adjacentLocations.add(hall2);
        hall1.adjacentLocations.add(hall3);
        hall2.adjacentLocations.add(oxygen);
        hall2.adjacentLocations.add(hall1);
        hall2.adjacentLocations.add(hall3);
        hall3.adjacentLocations.add(hall1);
        hall3.adjacentLocations.add(hall2);
        hall3.adjacentLocations.add(hall4);
        hall3.adjacentLocations.add(hall25);
        hall4.adjacentLocations.add(hall25);
        hall4.adjacentLocations.add(hall3);
        hall4.adjacentLocations.add(hall5);
        hall4.adjacentLocations.add(hall6);
        hall5.adjacentLocations.add(oxygen);
        hall5.adjacentLocations.add(hall4);
        hall5.adjacentLocations.add(hall6);
        hall6.adjacentLocations.add(hall4);
        hall6.adjacentLocations.add(hall5);
        hall6.adjacentLocations.add(electrical);
        hall7.adjacentLocations.add(electrical);
        hall7.adjacentLocations.add(computer);
        hall8.adjacentLocations.add(computer);
        hall8.adjacentLocations.add(hall9);
        hall9.adjacentLocations.add(hall8);
        hall9.adjacentLocations.add(oxygen);
        hall10.adjacentLocations.add(computer);
        hall10.adjacentLocations.add(codeFellows);
        hall11.adjacentLocations.add(codeFellows);
        hall11.adjacentLocations.add(hall2);
        hall12.adjacentLocations.add(hall11);
        hall12.adjacentLocations.add(lounge);
        hall13.adjacentLocations.add(codeFellows);
        hall13.adjacentLocations.add(hall15);
        hall13.adjacentLocations.add(hall14);
        hall14.adjacentLocations.add(lounge);
        hall14.adjacentLocations.add(hall13);
        hall14.adjacentLocations.add(hall15);
        hall15.adjacentLocations.add(hall13);
        hall15.adjacentLocations.add(hall14);
        hall15.adjacentLocations.add(hall16);
        hall16.adjacentLocations.add(hall15);
        hall16.adjacentLocations.add(remo);
        hall17.adjacentLocations.add(remo);
        hall17.adjacentLocations.add(hall18);
        hall18.adjacentLocations.add(hall17);
        hall18.adjacentLocations.add(lounge);
        hall19.adjacentLocations.add(lounge);
        hall19.adjacentLocations.add(conferenceRoom);
        hall20.adjacentLocations.add(conferenceRoom);
        hall20.adjacentLocations.add(hall21);
        hall21.adjacentLocations.add(hall20);
        hall21.adjacentLocations.add(hall22);
        hall21.adjacentLocations.add(hall23);
        hall22.adjacentLocations.add(remo);
        hall22.adjacentLocations.add(hall21);
        hall22.adjacentLocations.add(hall23);
        hall23.adjacentLocations.add(zoom);
        hall23.adjacentLocations.add(hall21);
        hall23.adjacentLocations.add(hall22);
        hall24.adjacentLocations.add(zoom);
        hall24.adjacentLocations.add(study);
        hall25.adjacentLocations.add(study);
        hall25.adjacentLocations.add(hall3);
        hall25.adjacentLocations.add(hall4);
        startGame.currentLocation.get("Computer Room").setDeadBody(true);
        return new RedirectView("/playerJoin");
    }

    @GetMapping("/playerJoin")
    public RedirectView playerJoinGame(Principal principal){

        Player newPlayer = new Player(principal.getName(), startGame.currentLocation.get("Conference Room"));
        startGame.currentLocation.get("Conference Room").playersAtCurrentLocation.add(newPlayer);

        startGame.playerList.put(principal.getName(), newPlayer);
        startGame.playerList.get(principal.getName()).taskList.add("Conference Room");
        startGame.playerList.get(principal.getName()).taskList.add("Lounge");
        startGame.playerList.get(principal.getName()).taskList.add("Zoom Room");
        startGame.playerList.get(principal.getName()).taskList.add("CodeFellows Room");
        startGame.playerList.get(principal.getName()).taskList.add("Oxygen Room");
        startGame.playerList.get(principal.getName()).taskList.add("Electrical Room");
        startGame.playerList.get(principal.getName()).taskList.add("Study");
        startGame.playerList.get(principal.getName()).taskList.add("Remo Room");
        startGame.playerList.get(principal.getName()).taskList.add("Computer Room");

        ArrayList taskArr = startGame.playerList.get(principal.getName()).taskList;
        Random random = new Random();
        taskArr.remove(getRandomNumberUsingInts(0, (taskArr.size()-1)));
        taskArr.remove(getRandomNumberUsingInts(0, (taskArr.size()-1)));

        maxTasks();


        Player newPlayer2 = new Player("Tom", startGame.currentLocation.get("Conference Room"));
        Player newPlayer3 = new Player("Dick", startGame.currentLocation.get("Oxygen Room"));
        Player newPlayer4 = new Player("Harry", startGame.currentLocation.get("Computer Room"));

        startGame.playerList.put("Tom", newPlayer2);
        startGame.playerList.put("Dick", newPlayer3);
        startGame.playerList.put("Harry", newPlayer4);
        startGame.playerList.get("Tom").setDead(true);
        startGame.playerList.get("Harry").setDead(true);
        startGame.setPlayerUpdateCounter(3);
        startGame.currentLocation.get("Oxygen Room").playersAtCurrentLocation.add(newPlayer3);
        startGame.currentLocation.get("Conference Room").playersAtCurrentLocation.add(newPlayer2);
        startGame.currentLocation.get("Computer Room").playersAtCurrentLocation.add(newPlayer4);


        return new RedirectView("/startGame");
    }

    @GetMapping("/game/startup")
    public RedirectView startUp(Principal principal) {
//        int imp;
//        int nums = 0;
//        if(startGame.playerList.values().size() < 7) {
//            imp = 1;
//        } else {
//            imp = 2;
//        }
//
//        Iterator <Player> playerIterator = startGame.playerList.values().iterator();
//
//        while(nums < imp) {
//            playerIterator.next().impostor = true;
//        }

        return new RedirectView("/game");
    }

    private int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }

    private void maxTasks() {
        int val = startGame.playerList.size() * 7;
        startGame.setMaxTask(val);
    }


}

