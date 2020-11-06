### Practices for Lesson 12: Using Inheritance
In these practices, you will work with class hierarchies. Remember that class hierarchies give 
you a way of not only sharing like behaviors in different classes, but they also allow you to 
use a common reference type for a set of objects of related but different types. 
In the next lesson, you will see how powerful this can be.

### Practice 12-1: Creating a Class Hierarchy
In this practice, you will rewrite the playGame method. Now that you have learned how to use the 
for loop with an increment, you can iterate through a game from the beginning until the end 
90 minutes later. This way, you can add various events at the point in the game when they take 
place. The code you write here will replace utility.GameUtils.

### Practice 12-2: Add a GameEvent Hierarchy
In this practice, you will make the application more flexible by adding other event types 
(currently there is only the Goal class). You already have Goal as one type of event, and you 
will create Possession as another type of event. Possession will be used to represent the time 
that one or other of the teams has possession of the ball and as such would need to store Team 
and Player just like Goal does. Both Goal and Possession will extend a new abstract GameEvent 
class that you will also create.

---
console
``` java
run:
The league is scheduled to run for 1 month(s), and 5 day(s)

The Robins vs. The Crows
Date: 2020-11-12
GameEvent scored after 10.0 mins by James Joyce of The Crows
GameEvent scored after 16.0 mins by Wilkie Collins of The Crows
GameEvent scored after 28.0 mins by Wilkie Collins of The Crows
GameEvent scored after 37.0 mins by William Makepeace Thackeray of The Robins
GameEvent scored after 48.0 mins by J. R. Tolkien of The Crows
GameEvent scored after 54.0 mins by Charles Dickens of The Crows
GameEvent scored after 61.0 mins by Liam O'Flaherty of The Crows
GameEvent scored after 70.0 mins by O. Henry of The Robins
The Crows win (2 - 6) 

The Robins vs. The Swallows
Date: 2020-11-19
GameEvent scored after 24.0 mins by Boris Pasternik of The Swallows
GameEvent scored after 67.0 mins by Brendan Behan of The Robins
GameEvent scored after 83.0 mins by Alexander Solzhenitsyn of The Swallows
The Swallows win (1 - 2) 

The Crows vs. The Robins
Date: 2020-11-26
GameEvent scored after 6.0 mins by O. Henry of The Robins
GameEvent scored after 31.0 mins by W. B. Yeats of The Robins
The Robins win (0 - 2) 

The Crows vs. The Swallows
Date: 2020-12-03
GameEvent scored after 49.0 mins by Liam O'Flaherty of The Crows
GameEvent scored after 55.0 mins by Wilkie Collins of The Crows
The Crows win (2 - 0) 

The Swallows vs. The Robins
Date: 2020-12-10
GameEvent scored after 32.0 mins by Brian Moore of The Swallows
GameEvent scored after 77.0 mins by W. B. Yeats of The Robins
It's a draw! (1 - 1) 

The Swallows vs. The Crows
Date: 2020-12-17
GameEvent scored after 28.0 mins by J. R. Tolkien of The Crows
GameEvent scored after 37.0 mins by Alexander Solzhenitsyn of The Swallows
It's a draw! (1 - 1) 


Team Points
The Robins : 2 : 6
The Crows : 3 : 9
The Swallows : 3 : 4
Winner of the League is The Crows
BUILD SUCCESSFUL (total time: 0 seconds)

```
League.java
``` java

package soccer;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.StringTokenizer;
import utility.PlayerDatabase;

public class League {

    public static void main(String[] args) {
        
        League theLeague = new League();

        Team[] theTeams = theLeague.createTeams("The Robins,The Crows,The Swallows", 5);
        Game[] theGames = theLeague.createGames(theTeams);

        System.out.println(theLeague.getLeagueAnnouncement(theGames));
        for (Game currGame: theGames){
            currGame.playGame();
            //break;
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
        int daysBetweenGames = 0;
        
        ArrayList theGames = new ArrayList();
        
        for (Team homeTeam: theTeams){
            for (Team awayTeam: theTeams){
               if (homeTeam != awayTeam) {
                   daysBetweenGames += 7;
                   theGames.add(new Game(homeTeam, awayTeam, LocalDateTime.now().plusDays(daysBetweenGames)));
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
    
    public String getLeagueAnnouncement(Game[] theGames){
        
        Period thePeriod = Period.between(theGames[0].getTheDateTime().toLocalDate(), 
        theGames[theGames.length - 1].getTheDateTime().toLocalDate());
        
        return "The league is scheduled to run for " +
        thePeriod.getMonths() + " month(s), and " +
        thePeriod.getDays() + " day(s)\n";
    }

}

```
Game.java
``` java

package soccer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Game {
    
    private Team homeTeam;
    private Team awayTeam;
    private GameEvent[] goals;
    private LocalDateTime theDateTime;
    
    public Game(Team homeTeam, Team awayTeam, LocalDateTime theDateTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.theDateTime = theDateTime;
    }
    
    public void playGame() {
        ArrayList <GameEvent> eventList = new ArrayList();
        GameEvent currEvent;
        for (int i = 1; i <=90; i++){
            
            if (Math.random() > 0.95){
                //currEvent = new Goal();
                currEvent = Math.random() > 0.6?new Goal():new Possession();
                currEvent.setTheTeam(Math.random() > 0.5?homeTeam: awayTeam);
                currEvent.setThePlayer(currEvent.getTheTeam().
                getPlayerArray()[(int)(Math.random() * currEvent.getTheTeam().getPlayerArray().length)]);
                currEvent.setTheTime(i);
                eventList.add(currEvent);
                //System.out.println(i);
            }
            this.goals = new GameEvent[eventList.size()];
            eventList.toArray(goals);
 
        }
    }
    
    public String getDescription() {
                       
        int homeTeamGoals = 0;
        int awayTeamGoals = 0;
        StringBuilder returnString = new StringBuilder();
        
        returnString.append(this.getHomeTeam().getTeamName() + " vs. " +
        this.getAwayTeam().getTeamName() + "\n" + 
               "Date: " + this.getTheDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE) + "\n");
         
        for (GameEvent currEvent: this.getEvents()) {
            
            if (currEvent.getTheTeam()== homeTeam) {
                homeTeamGoals++;
                homeTeam.incGoalsTotal(1);
            } else {
                awayTeamGoals++;
                awayTeam.incGoalsTotal(1);
            }
            
            /* Practice 12-2. Modify the text printed */
            returnString.append("GameEvent scored after "
            + currEvent.getTheTime() + " mins by "
            + currEvent.getThePlayer().getPlayerName() + " of "
            + currEvent.getTheTeam().getTeamName() +
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

    public GameEvent[] getEvents() {
        return goals;
    }

    public void setEvents(GameEvent[] goals) {
        this.goals = goals;
    }

    public LocalDateTime getLocalDateTime() {
        return getTheDateTime();
    }

    public void setLocalDateTime(LocalDateTime theDateTime) {
        this.setTheDateTime(theDateTime);
    }

    public LocalDateTime getTheDateTime() {
        return theDateTime;
    }

    public void setTheDateTime(LocalDateTime theDateTime) {
        this.theDateTime = theDateTime;
    }
      
}
```
Possession.java
``` java

package soccer;

public class Possession extends GameEvent {
    
}

```
Goal.java
``` java

package soccer;

/* Practice 12-2. Make this class extend GameEvent */
public class Goal extends GameEvent {
    
    /* Practice 12-2. Start selection here for code in Goal to cut and paste to GameEvent  */
    
    /* Practice 12-2. End selection here for code in Goal to cut and paste to GameEvent  */
    
}

```
GameEvent.java
``` java

package soccer;

public abstract class GameEvent {
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
