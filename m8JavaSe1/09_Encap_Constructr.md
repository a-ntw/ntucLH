### Practices for Lesson 9: 
Overview Practices Overview

In these practices, you will modify all classes to encapsulate all the attributes and add constructors.

### Practice 9-1: Encapsulating Attributes

- Right-click Player and select Refactor > Encapsulate Fields.
- In the Encapsulate Fields dialog box, select playerName as the field to encapsulate (it will be selected by default), 
and check the boxes to create the getPlayerName method and the setPlayerName method. The options should be as follows 
(these are the defaults).

### Practice 9-2: Adding Constructors
console
``` console
run:
Goal scored after 30.0 mins by George Eliot of The Greens
Goal scored after 60.0 mins by Robbie Burns of The Reds

Goal scored after 14.0 mins by Robert Service of The Reds
Goal scored after 33.0 mins by Graham Greene of The Greens
Goal scored after 42.0 mins by Graham Greene of The Greens
Goal scored after 50.0 mins by Geoffrey Chaucer of The Greens
Goal scored after 73.0 mins by Rafael Sabatini of The Reds

Goal scored after 6.0 mins by Robbie Burns of The Reds
Goal scored after 21.0 mins by Robert Service of The Reds
Goal scored after 48.0 mins by Rafael Sabatini of The Reds
Goal scored after 71.0 mins by Geoffrey Chaucer of The Greens
Goal scored after 85.0 mins by Geoffrey Chaucer of The Greens

Goal scored after 22.0 mins by Rafael Sabatini of The Reds

BUILD SUCCESSFUL (total time: 0 seconds)
```

League.java
``` java

package soccer;

public class League {

    public static void main(String[] args) {
        
        League theLeague = new League();

        Team[] theTeams = theLeague.createTeams();
        Game[] theGames = theLeague.createGames(theTeams);

        for (Game currGame: theGames){
            currGame.playGame();
            System.out.println(currGame.getDescription());
        }

    }

    public Team[] createTeams() {

        Player player1 = new Player("George Eliot");
        Player player2 = new Player("Graham Greene");
        Player player3 = new Player("Geoffrey Chaucer");
        Player[] thePlayers = {player1, player2, player3};

        Team team1 = new Team("The Greens", thePlayers);
        /* Practice 9-2. The following two lines can be removed after the line above has been
           modified to pass parameters to the constructor of Team */

        // Create team2
        Team team2 = new Team();
        team2.setTeamName("The Reds");
        team2.setPlayerArray(new Player[3]);
        team2.getPlayerArray()[0] = new Player();
        team2.getPlayerArray()[0].setPlayerName("Robert Service");
        team2.getPlayerArray()[1] = new Player();
        team2.getPlayerArray()[1].setPlayerName("Robbie Burns");
        team2.getPlayerArray()[2] = new Player();
        team2.getPlayerArray()[2].setPlayerName("Rafael Sabatini");

        Team[] theTeams = {team1, team2};
        return theTeams;
    }

    public Game[] createGames(Team[] theTeams) {
        Game theGame = new Game(theTeams[0], theTeams[1]);
        Game theGame2 = new Game(theTeams[1], theTeams[0]);
        Game theGame3 = new Game(theTeams[0], theTeams[1]);
        Game theGame4 = new Game(theTeams[1], theTeams[0]);
        
        Game[] theGames = {theGame, theGame2, theGame3, theGame4};
        return theGames;
    }

}

```

Player.java
``` java

package soccer;

public class Player {
    
    private String playerName;
    
    /* Practice 9-2. Add the constructor here */
    public Player(String playerName){
        this.playerName = playerName;
    }
    public Player() {}

    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
}

```
Game.java
``` java

package soccer;

import utility.GameUtils;

public class Game {
    
    private Team homeTeam;
    private Team awayTeam;
    private Goal[] goals;
    
    /* Practice 9-2. Add constructor here */
    public Game (Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }
    
    public void playGame(int maxGoals) {
        int numberOfGoals = (int)(Math.random() * maxGoals + 1);
        Goal[] theGoals = new Goal[numberOfGoals];
        this.setGoals(theGoals);
        GameUtils.addGameGoals(this);        
    }
    
    public void playGame() {
        playGame(6);
    }
    
    public String getDescription() {
        StringBuilder returnString = new StringBuilder();
        for (Goal currGoal: this.getGoals()) {
            returnString.append("Goal scored after "
            + currGoal.getTheTime() + " mins by "
            + currGoal.getThePlayer().getPlayerName() + " of "
            + currGoal.getTheTeam().getTeamName() +
              "\n");
        }
        return returnString.toString();
    }

    /**
     * @return the homeTeam
     */
    public Team getHomeTeam() {
        return homeTeam;
    }

    /**
     * @param homeTeam the homeTeam to set
     */
    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    /**
     * @return the awayTeam
     */
    public Team getAwayTeam() {
        return awayTeam;
    }

    /**
     * @param awayTeam the awayTeam to set
     */
    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    /**
     * @return the goals
     */
    public Goal[] getGoals() {
        return goals;
    }

    /**
     * @param goals the goals to set
     */
    public void setGoals(Goal[] goals) {
        this.goals = goals;
    }
      
}

```

Team.java
``` java

package soccer;

public class Team {
    
    private String teamName;
    private Player[] playerArray;
    
    /* Practice 9-2. Add the two constructors here */
    public Team(String teamName) {
        this.teamName = teamName;
    }
    
    public Team(String teamName, Player[] players){
        this(teamName);
        this.playerArray = players;
    }
    public Team() {
        
    }

    /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * @return the playerArray
     */
    public Player[] getPlayerArray() {
        return playerArray;
    }

    /**
     * @param playerArray the playerArray to set
     */
    public void setPlayerArray(Player[] playerArray) {
        this.playerArray = playerArray;
    }
    
}

```
Goal.java
``` java

package soccer;

public class Goal {
    
    private Team theTeam;
    private Player thePlayer;
    private double theTime;

    /**
     * @return the theTeam
     */
    public Team getTheTeam() {
        return theTeam;
    }

    /**
     * @param theTeam the theTeam to set
     */
    public void setTheTeam(Team theTeam) {
        this.theTeam = theTeam;
    }

    /**
     * @return the thePlayer
     */
    public Player getThePlayer() {
        return thePlayer;
    }

    /**
     * @param thePlayer the thePlayer to set
     */
    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    /**
     * @return the theTime
     */
    public double getTheTime() {
        return theTime;
    }

    /**
     * @param theTime the theTime to set
     */
    public void setTheTime(double theTime) {
        this.theTime = theTime;
    }
    
}

```
