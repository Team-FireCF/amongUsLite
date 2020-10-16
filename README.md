# amongUsLite

Group Midterm project for Code Fellows Advanced Java

## Live deployment
Check out our app out in the wild [here](https://javamongus.herokuapp.com/)! 

<hr>


## Table of Contents
- [JavaMongUs](#amongUsLite)
  - [Live deployment](#live-deployment)
  - [Table of Contents](#table-of-contents)
  - [Overview](#overview)
    - [Pain Points](#pain-points)
  - [Technologies used in this project](#technologies-used-in-this-project)
    - [USER STORIES](#user-stories)
  - [Domain Modeling:](#domain-modeling)
    - [Compenent Model](#compenent-model)
  - [Authors](#authors)
  - [Acknowledgements](#acknowledgements)

<hr>

## Overview
JavaMongUs is a multiplayer game, where players have to accomplish “tasks” while randomly-assigned impostors among them are trying to kill them. If an imposter kills a player, they leave a dead body in a room. When a body is discovered, players can make a report and have a meeting to discuss who the imposter might be and vote who they think is an impostor out.  

The goal of regular players is for all regular players to achieve all the goals or vote off both of the imposters  and the goal of the impostors is to kill everyone or be down to the last two players. 

### Pain Points
Over the past several months, entertainment has grown from a large part of the lives of many, to an essential aspect of life as we currently know it. Streaming platforms and game developers are in overdrive to meet our needs to remain occupied as quarantine restrictions are in place. 
To tackle the issue of constantly seeking out new content, our team wanted to contribute, with a new game: JavaMongUs, an app based off of the popular game AmongUs.



[Return to the top](#Table-of-Contents)

<hr>


## Technologies used in this project

- [HTML](https://html.spec.whatwg.org/multipage/) - A standard markup language used for web site structure.
- [CSS](https://www.w3.org/Style/CSS/Overview.en.html) - A simple language used to add styling to web documents.
- [JavaScript](http://es6-features.org/#Constants) - A dynamically typed programming language used heavily in front-end development.
- [BCrypt](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/crypto/bcrypt/BCrypt.html) - A library to help you hash passwords. 
- [Spring](https://spring.io/guides/gs/spring-boot/) - an source Java-based framework used to create a Micro Service.
- [Java](https://docs.oracle.com/en/java/) - a class-based, object-oriented programming language.
 

### USER STORIES

- As a user, I would like to sign up using a username and password so that my data can persist if I choose to come back to the game in the future.
- As a user, I would like the ability to start a new game, as well as reset mid-game so that in the case of an error I can start the game again. 
- As a user, I would like to message over a TCP connection, so that the other players and I can communicate in near-real time, during the meeting phase of the game.
- As a user, I would like to see players that have died and players that are still living throughout the course of the game and I want that list to be updated when a meeting is called.
- As a user, I would like to see a timer that signifies how long I have to make the decision of where I want to go next during my turn. 
- As a user, I would like to see where I have chosen to go next, and be able to update that location if I change my mind. 
- As a user, I would like to have a list of available locations to go to from my current location. 
- As a user, I would like to see a visual representation (map) of the game board so that I can better communicate with my team.
- As a user, I would like to be able to log out of the game
- As a user, I would like to be able to report/kill if I am an imposter.
- As a user, I would like to be able to report if I am a crewmate.
- As a user, I would like to be able to complete a task when I get to a room.
- As a user, I would like to be able to see how many tasks are remaining in each room.



[Return to the top](#Table-of-Contents)


<hr>

## Domain Modeling: 
![img](./src/main/resources/DOM1.png)
![img](./src/main/resources/DOM2.png)
![img](./src/main/resources/DOM3.png)


### Component Model

SQL: id, username, password(encoded)


[Return to the top](#Table-of-Contents)

<hr>

## Authors

* Garhett Morgan - Full-stack Javascript Developer [GitHub](https://github.com/GarhettM)
* Krystian Francuz-Harris - Full-stack Javascript Developer [GitHub](https://github.com/KrystianFH)
* Claudio Bailon-Schubert - Full-stack Javascript Developer [GitHub](https://github.com/claudiobailon)

[Return to the top](#Table-of-Contents)

<hr>

## Acknowledgements

This section goes out to our instructional team: Nicholas, Bade, Ashlyn and the troops.

[Return to the top](#Table-of-Contents)

<hr>
