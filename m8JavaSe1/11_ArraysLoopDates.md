### Practices for Lesson 11: Working with Arrays, Loops, and Dates
#### Practices Overview
In these practices, you will use an ArrayList to iterate through data.

### Practice 11-1: Iterating Through Data
In this practice, you will write code to allow teams of any size to be created 
from a comma- separated list of names stored in a String. You will find a new PlayerDatabase class 
in the utility package. At the moment, it contains only a String with a comma-separated list of names.

### Practice 11-2: Working with LocalDateTime
In this practice, you work with the LocalDateTime object so that games have a LocalDateTime attribute.

---
console
```
run:
The League is scheduled to run for 1 month(s), and 12 day(s)

The Robins vs. The Crows
Date 2020-11-18
Goal scored after 59.0 mins by Baroness Orczy of The Robins
The Robins win (1 - 0) 

The Robins vs. The Swallows
Date 2020-11-25
Goal scored after 15.0 mins by Dorothy Parker of The Robins
Goal scored after 44.0 mins by Anthony Trollope of The Swallows
Goal scored after 49.0 mins by Anthony Trollope of The Swallows
Goal scored after 55.0 mins by Henry James of The Swallows
Goal scored after 61.0 mins by Henry James of The Swallows
Goal scored after 86.0 mins by William Shakespeare of The Swallows
The Swallows win (1 - 5) 

The Crows vs. The Robins
Date 2020-12-02
Goal scored after 20.0 mins by Sean O'Casey of The Crows
Goal scored after 37.0 mins by Agatha Christie of The Robins
Goal scored after 42.0 mins by Baroness Orczy of The Robins
Goal scored after 62.0 mins by Sean O'Casey of The Crows
Goal scored after 74.0 mins by William Makepeace Thackeray of The Robins
Goal scored after 76.0 mins by Arthur Conan Doyle of The Crows
It's a draw! (3 - 3) 

The Crows vs. The Swallows
Date 2020-12-16
Goal scored after 6.0 mins by Sean O'Casey of The Crows
Goal scored after 42.0 mins by Alan Patton of The Crows
Goal scored after 48.0 mins by William Shakespeare of The Swallows
Goal scored after 50.0 mins by Oscar Wilde of The Crows
Goal scored after 73.0 mins by William Shakespeare of The Swallows
The Crows win (3 - 2) 

The Swallows vs. The Robins
Date 2020-12-23
Goal scored after 6.0 mins by William Shakespeare of The Swallows
Goal scored after 41.0 mins by James Joyce of The Swallows
Goal scored after 65.0 mins by William Makepeace Thackeray of The Robins
The Swallows win (2 - 1) 

The Swallows vs. The Crows
Date 2020-12-30
Goal scored after 15.0 mins by James Joyce of The Swallows
Goal scored after 15.0 mins by Henry James of The Swallows
Goal scored after 27.0 mins by Henry James of The Swallows
Goal scored after 55.0 mins by Henry James of The Swallows
Goal scored after 73.0 mins by Anthony Trollope of The Swallows
Goal scored after 85.0 mins by Arthur Conan Doyle of The Crows
The Swallows win (5 - 1) 


Team Points
The Robins : 2 : 6
The Crows : 2 : 7
The Swallows : 3 : 14
Winner of the League is The Swallows
BUILD SUCCESSFUL (total time: 0 seconds)

```

League.java
``` java

package soccer;

import java.time.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import utility.PlayerDatabase;

public class League {

    public static void main(String[] args) {
        
        League theLeague = new League();

        Team[] theTeams = theLeague.createTeams("The Robins,The Crows,The Swallows", 5);
        Game[] theGames = theLeague.createGames(theTeams);

        /* Practice 11-2. Print the League announcement here */
        System.out.println(theLeague.getLeagueAnnouncement(theGames));
        
        for (Game currGame: theGames){
            currGame.playGame();
            System.out.println(currGame.getDescription());
        }
        
        theLeague.showBestTeam(theTeams);

    }

    public Team[] createTeams(String teamNames, int teamSize) {

        PlayerDatabase playerDB = new PlayerDatabase();
        
        StringTokenizer teamNameTokens = new StringTokenizer(teamNames, ",");
        Team[] theTeams = new Team[teamNameTokens.countTokens()];
        for (int i =0; i < theTeams.length; i++){
             theTeams[i] = new Team(teamNameTokens.nextToken(), playerDB.getTeam(teamSize));
        }
       

        return theTeams;
    }

    public Game[] createGames(Team[] theTeams) {
        /* Practice 11-2. Add a line to declare and initialize daysBetweenGames variable */
        int daysBetweenGames = 0;
        ArrayList theGames = new ArrayList();
        
        for (Team homeTeam: theTeams){
            for (Team awayTeam: theTeams){
                /* Practice 11-2. Increment daysBetweenGames here */
                daysBetweenGames += 7;
                if (homeTeam != awayTeam) {
                   /* Practice 11-2. Modify the statement below to add pass LocalDateTime into constructor */
                    theGames.add(new Game(homeTeam, awayTeam, 
                    LocalDateTime.now().plusDays(daysBetweenGames) ));
               } 
            }
        }
        
        return (Game[]) theGames.toArray(new Game[1]);
    }
    
    public void showBestTeam(Team[] theTeams) {
        Team currBestTeam = theTeams[0];  
        System.out.println("\nTeam Points");       
           
        for (Team currTeam: theTeams){
            System.out.println(currTeam.getTeamName() + " : " + currTeam.getPointsTotal() + " : "
                     + currTeam.getGoalsTotal());
            currBestTeam = currTeam.getPointsTotal() > currBestTeam.getPointsTotal()?currTeam:currBestTeam;
            if (currTeam.getPointsTotal() > currBestTeam.getPointsTotal()){
                currBestTeam = currTeam;
            } else if (currTeam.getPointsTotal() == currBestTeam.getPointsTotal()){
                if (currTeam.getGoalsTotal() > currBestTeam.getGoalsTotal()){
                currBestTeam = currTeam;
                }
            }
        }
        
        System.out.println("Winner of the League is " + currBestTeam.getTeamName());
        
    }
    
    /* Practice 11-2. Add the getLeagueAnnouncement() method here */
    public String getLeagueAnnouncement (Game[] theGames){
        Period thePeriod = 
        Period.between(theGames[0].getTheDateTime().toLocalDate(), 
        theGames[theGames.length - 1].getTheDateTime().toLocalDate());
        
        return "The League is scheduled to run for " +
                thePeriod.getMonths() + " month(s), and " +
                thePeriod.getDays() + " day(s)\n";

    }

}

```

Game.java
``` java

package soccer;

import java.time.*;
import java.time.format.DateTimeFormatter;
import utility.GameUtils;

public class Game {
    
    private Team homeTeam;
    private Team awayTeam;
    private Goal[] goals;
    
    /* Practice 11-2. Add LocalDateTime attribute here */
    private LocalDateTime theDateTime;
    
    /* Practice 11-2. Modify the constructor to include the date and time of the game */
    public Game(Team homeTeam, Team awayTeam, LocalDateTime theDateTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.theDateTime = theDateTime;
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
        
        /* Practice 11-2. Modify the next line to include the date and time of the game */
        returnString.append(this.getHomeTeam().getTeamName() + " vs. " +
            this.getAwayTeam().getTeamName() + "\n" +
            "Date " +
            this.theDateTime.format
            (DateTimeFormatter.ISO_LOCAL_DATE) + "\n" );
         
        for (Goal currGoal: this.getGoals()) {
            
            if (currGoal.getTheTeam()== homeTeam) {
                homeTeamGoals++;
                homeTeam.incGoalsTotal(1);
            } else {
                awayTeamGoals++;
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
            this.homeTeam.incPointsTotal(1);
            this.awayTeam.incPointsTotal(1);
        } else if (homeTeamGoals > awayTeamGoals) {
            returnString.append(homeTeam.getTeamName() + " win");
            this.homeTeam.incPointsTotal(1);
        } else {
            returnString.append(awayTeam.getTeamName() + " win");
            this.awayTeam.incPointsTotal(1);
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

    public LocalDateTime getTheDateTime() {
        return theDateTime;
    }

    public void setTheDateTime(LocalDateTime theDateTime) {
        this.theDateTime = theDateTime;
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
    private int goalsTotal;
    
    public void incGoalsTotal(int goals){
        this.setGoalsTotal(this.getGoalsTotal() + goals);
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

    /**
     * @return the teamName
     */
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

utility/GameUtilis.java
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

utility/PlayerDatabase.java
``` java

package utility;

import java.util.*;
import soccer.Player;

public class PlayerDatabase {
    
    private ArrayList <Player> players;
    
    public PlayerDatabase(){
        StringTokenizer authorTokens = new StringTokenizer(authorList, ",");
        players = new ArrayList();
        while (authorTokens.hasMoreTokens()){
            players.add(new Player(authorTokens.nextToken()));
        }
    }
    
    public Player[] getTeam(int numberOfPlayers){
        Player[] teamPlayers = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++){
            int playerIndex = (int) (Math.random() * players.size());
            teamPlayers[i] = players.get(playerIndex);
            players.remove(playerIndex);
        }
        return teamPlayers;
        
    }
    
    
        
String authorList = 
"Agatha Christie," + 
"Alan Patton," +
"Alexander Solzhenitsyn," +
"Arthur Conan Doyle," +
"Anthony Trollope," +
"Baroness Orczy," +          
"Brendan Behan," +      
"Brian Moore," +
"Boris Pasternik," +
"Charles Dickens," +    
"Charlotte Bronte," +
"Dorothy Parker," +
"Emile Zola," +
"Frank O'Connor," +        
"Geoffrey Chaucer," +
"George Eliot," +
"G. K. Chesterton," +
"Graham Green," +
"Henry James," +
"James Joyce," +        
"J. M. Synge," + 
"J. R. Tolkien," +
"Jane Austin," +
"Leo Tolstoy," +
"Liam O'Flaherty," +
"Marcel Proust," +
"Mark Twain," +
"Oscar Wilde," +
"O. Henry," +
"Samuel Beckett," +
"Sean O'Casey," +
"William Shakespeare," +        
"William Makepeace Thackeray," +
"W. B. Yeats," +
"Wilkie Collins";
    
}

```



