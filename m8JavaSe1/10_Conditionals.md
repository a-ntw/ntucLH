### Practices for Lesson 10: More on Conditionals
#### Practices for Lesson 10: Overview Practices Overview
In these practices, you will work with various combinations of if and else, 
and you will also use the ternary operator. You will also use the debugger to see 
what is happening in an if-else clause.

### Practice 10-1: Using Conditionals
In this practice, you enhance the getDescription method of the Game class in order to 
announce the name of the winning team. One way to do this is to iterate through the 
Goal array for the Game, incrementing int variables for either the home team or 
the away team.

### Practice 10-2: Debugging
In this practice, you will enhance the showBestTeam method to differentiate between 
teams that have the same number of points. Because this is some of the more complex 
code so far, it is a good time to look at some of the debugging features of NetBeans. 
In particular, you will step through the code line by line, seeing how each line 
modifies various attributes.

---
console
```
run:
The Greens vs. The Reds
Goal scored after 3.0 mins by Robbie Burns of The Reds
Goal scored after 20.0 mins by Graham Greene of The Greens
Goal scored after 45.0 mins by Rafael Sabatini of The Reds
Goal scored after 83.0 mins by Robbie Burns of The Reds
The Reds win (1 - 3) 

The Reds vs. The Greens
Goal scored after 44.0 mins by Robert Service of The Reds
Goal scored after 44.0 mins by Rafael Sabatini of The Reds
Goal scored after 52.0 mins by Robbie Burns of The Reds
Goal scored after 55.0 mins by Robbie Burns of The Reds
Goal scored after 88.0 mins by Robert Service of The Reds
The Reds win (5 - 0) 

The Greens vs. The Reds
Goal scored after 46.0 mins by Robert Service of The Reds
Goal scored after 68.0 mins by Geoffrey Chaucer of The Greens
Goal scored after 68.0 mins by George Eliot of The Greens
Goal scored after 70.0 mins by Graham Greene of The Greens
The Greens win (3 - 1) 

The Reds vs. The Greens
Goal scored after 41.0 mins by Geoffrey Chaucer of The Greens
Goal scored after 51.0 mins by Robert Service of The Reds
Goal scored after 56.0 mins by Robert Service of The Reds
The Reds win (2 - 1) 


Team Points
The Greens:2:5
The Reds:6:11
Winner of the League is The Reds
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
        
        theLeague.showBestTeam(theTeams);

    }

    public Team[] createTeams() {

        Player player1 = new Player("George Eliot");
        Player player2 = new Player("Graham Greene");
        Player player3 = new Player("Geoffrey Chaucer");
        Player[] thePlayers = {player1, player2, player3};

        Team team1 = new Team("The Greens", thePlayers);

        // Create team2
        Team team2 = new Team();
        team2.setTeamName("The Reds");
        team2.setPlayerArray(new Player[3]);
        team2.getPlayerArray()[0] = new Player("Robert Service");
        team2.getPlayerArray()[1] = new Player("Robbie Burns");
        team2.getPlayerArray()[2] = new Player("Rafael Sabatini");

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
    
    public void showBestTeam(Team[] theTeams) {
        Team currBestTeam = theTeams[0];  
        System.out.println("\nTeam Points");       
           
        for (Team currTeam: theTeams){
            /* Practice 10-2. Modify the line below to print out the goalsTotal for the current team also */
            System.out.println(currTeam.getTeamName() + ":" + 
                    currTeam.getPointsTotal() + ":" + currTeam.getGoalsTotal());
            /* Practice 10-2. Remove ternary statement above then add a replacement if statement here */
            if (currTeam.getPointsTotal() > 
                currBestTeam.getPointsTotal()){
                currBestTeam = currTeam;
            }
            else if (currTeam.getPointsTotal() == 
                currBestTeam.getPointsTotal()){
                currBestTeam = currTeam;
            }
                
        }
        
        System.out.println("Winner of the League is " + currBestTeam.getTeamName());
        
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
    
    public Game(Team homeTeam, Team awayTeam) {
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
                       
        int homeTeamGoals = 0;
        int awayTeamGoals = 0;
        StringBuilder returnString = new StringBuilder();
        
        returnString.append(homeTeam.getTeamName() + " vs. " +
        awayTeam.getTeamName() + "\n");
         
        for (Goal currGoal: this.getGoals()) {
            
            if (currGoal.getTheTeam()== homeTeam) {
                homeTeamGoals++;
                /* Practice 10-2. Add code to increment Team.goalsTotal here */
                homeTeam.incGoalsTotal(1);
                //theTeams[0].incGoalsTotal(1);
            } else {
                awayTeamGoals++;
                /* Practice 10-2. Add code to increment Team.goalsTotal here */
                awayTeam.incGoalsTotal(1);
            }
            
            returnString.append("Goal scored after "
            + currGoal.getTheTime() + " mins by "
            + currGoal.getThePlayer().getPlayerName() + " of "
            + currGoal.getTheTeam().getTeamName() +
              "\n");
        }
        
        if (homeTeamGoals == awayTeamGoals) {
            returnString.append("It's a draw!");
            homeTeam.incPointsTotal(1);
            awayTeam.incPointsTotal(1);
        } else if (homeTeamGoals > awayTeamGoals) {
            returnString.append(homeTeam.getTeamName() + " win");
            homeTeam.incPointsTotal(2);
        } else {
            returnString.append(awayTeam.getTeamName() + " win");
            awayTeam.incPointsTotal(2);
        }
        returnString.append(" (" + homeTeamGoals + " - " + awayTeamGoals + ") \n");
        
        return returnString.toString();
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Goal[] getGoals() {
        return goals;
    }

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
    private int pointsTotal;

    /* Practice 10-2. Add goalsTotal attribute here */
    private int goalsTotal;
    
    /* Practice 10-2. Add incGoalsTotal() method here */
    public void incGoalsTotal(int goals) {
        this.goalsTotal = this.goalsTotal + goals;
    }
    
    public void incPointsTotal(int points){
        this.pointsTotal += points;
    }
    
    public Team(String teamName) {
        this.teamName = teamName;
    }
    
    public Team(String teamName, Player[] players) {
        this(teamName);
        this.playerArray = players;
    }
    
    public Team() {}

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Player[] getPlayerArray() {
        return playerArray;
    }

    public void setPlayerArray(Player[] playerArray) {
        this.playerArray = playerArray;
    }

    public int getPointsTotal() {
        return pointsTotal;
    }

    public void setPointsTotal(int pointsTotal) {
        this.pointsTotal = pointsTotal;
    }

    public int getGoalsTotal() {
        return goalsTotal;
    }

    public void setGoalsTotal(int goalsTotal) {
        this.goalsTotal = goalsTotal;
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

    public Team getTheTeam() {
        return theTeam;
    }

    public void setTheTeam(Team theTeam) {
        this.theTeam = theTeam;
    }

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }


    public double getTheTime() {
        return theTime;
    }

    public void setTheTime(double theTime) {
        this.theTime = theTime;
    }
    
}

```
Player.java
``` java

package soccer;

public class Player {
    
    private String playerName;
    
    public Player(String playerName) {
        this.playerName = playerName;
    }
    
    public Player() {}

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
}

```
utility/GaneUtils.java
``` java

package utility;

import java.util.Arrays;
import soccer.*;

public class GameUtils {

    public static void addGameGoals(Game currGame) {
        
        //System.out.println(currGame.awayTeam + " : " + currGame.homeTeam);

        // Or possibly throw an Exception?
        if (currGame.getGoals() == null) {
            currGame.setGoals(new Goal[(int) (Math.random() * 10)]);   // If goals not initialized max will be 9
        }

        //System.out.println(currGame.goals.length);
        int i = 0;
        for (Goal currGoal : currGame.getGoals()) {
            currGoal = new Goal();
            currGoal.setTheTeam(Math.random() > 0.5 ? currGame.getHomeTeam() : currGame.getAwayTeam());
            currGoal.setThePlayer(currGoal.getTheTeam().getPlayerArray()[(int) (Math.random() * currGoal.getTheTeam().getPlayerArray().length)]);
            currGoal.setTheTime((int) (Math.random() * 90));
            currGame.getGoals()[i] = currGoal;
            i++;
        }
        Arrays.sort(currGame.getGoals(), (g1, g2) -> Double.valueOf(g1.getTheTime()).compareTo(Double.valueOf(g2.getTheTime())));

    }

}

```
