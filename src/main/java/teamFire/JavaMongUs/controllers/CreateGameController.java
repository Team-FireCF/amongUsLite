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
import java.util.Map;

@Controller
public class CreateGameController {
    public static GameState startGame = new GameState();

    @GetMapping("/create")
    public RedirectView createGame(Principal principal){
        Location conferenceRoom = new Location("Conference Room");
        startGame.currentLocation.put("conferenceRoom", conferenceRoom);
        Location lounge = new Location("Lounge");
        startGame.currentLocation.put("lounge",lounge);
        Location oxygen = new Location("Oxygen Room");
        startGame.currentLocation.put("oxygen",oxygen);
        Location electrical = new Location("Electrical Room");
        startGame.currentLocation.put("electrical",electrical);
        Location zoom = new Location("Zoom Room");
        startGame.currentLocation.put("zoom",zoom);
        Location remo = new Location("Remo Room");
        startGame.currentLocation.put("remo",remo);
        Location computer = new Location("Computer Room");
        startGame.currentLocation.put("computer",computer);
        Location codeFellows = new Location("CodeFellows Room");
        startGame.currentLocation.put("codeFellows",codeFellows);
        Location study = new Location("Study");
        startGame.currentLocation.put("study",study);
        Location hall1 = new Location("Hall 1");
        startGame.currentLocation.put("hall1",hall1);
        Location hall2 = new Location("Hall 2");
        startGame.currentLocation.put("hall2",hall2);
        Location hall3 = new Location("Hall 3");
        startGame.currentLocation.put("hall3",hall3);
        Location hall4 = new Location("Hall 4");
        startGame.currentLocation.put("hall4",hall4);
        Location hall5 = new Location("Hall 5");
        startGame.currentLocation.put("hall5",hall5);
        Location hall6 = new Location("Hall 6");
        startGame.currentLocation.put("hall6",hall6);
        Location hall7 = new Location("Hall 7");
        startGame.currentLocation.put("hall7",hall7);
        Location hall8 = new Location("Hall 8");
        startGame.currentLocation.put("hall8",hall8);
        Location hall9 = new Location("Hall 9");
        startGame.currentLocation.put("hall9",hall9);
        Location hall10 = new Location("Hall 10");
        startGame.currentLocation.put("hall10",hall10);
        Location hall11 = new Location("Hall 11");
        startGame.currentLocation.put("hall11",hall11);
        Location hall12 = new Location("Hall 12");
        startGame.currentLocation.put("hall12",hall12);
        Location hall13 = new Location("Hall 13");
        startGame.currentLocation.put("hall13",hall13);
        Location hall14 = new Location("Hall 14");
        startGame.currentLocation.put("hall14",hall14);
        Location hall15 = new Location("Hall 15");
        startGame.currentLocation.put("hall15",hall15);
        Location hall16 = new Location("Hall 16");
        startGame.currentLocation.put("hall16",hall16);
        Location hall17 = new Location("Hall 17");
        startGame.currentLocation.put("hall17",hall17);
        Location hall18 = new Location("Hall 18");
        startGame.currentLocation.put("hall18", hall18);
        Location hall19 = new Location("Hall 19");
        startGame.currentLocation.put("hall19",hall19);
        Location hall20 = new Location("Hall 20");
        startGame.currentLocation.put("hall20", hall20);
        Location hall21 = new Location("Hall 21");
        startGame.currentLocation.put("hall21", hall21);
        Location hall22 = new Location("Hall 22");
        startGame.currentLocation.put("hall22", hall22);
        Location hall23 = new Location("Hall 23");
        startGame.currentLocation.put("hall23", hall23);
        Location hall24 = new Location("Hall 24");
        startGame.currentLocation.put("hall24", hall24);
        Location hall25 = new Location("Hall 25");
        startGame.currentLocation.put("hall25", hall25);

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
        System.out.println(startGame.toString());

        return new RedirectView("/");
    }

    @GetMapping("/playerJoin")
    public RedirectView playerJoinGame(Principal principal){
        Player newPlayer = new Player(principal.getName(), startGame.currentLocation.get("conferenceRoom"));
        startGame.currentLocation.get("conferenceRoom").playersAtCurrentLocation.add(newPlayer);
        startGame.playerList.put(principal.getName(), newPlayer);
        System.out.println(startGame.playerList.get(principal.getName()).getPlayerLocation().adjacentLocations);


        return new RedirectView("/game");
    }



}

