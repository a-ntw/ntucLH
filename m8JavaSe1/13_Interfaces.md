### Practices for Lesson 13: Using Interfaces
In these practices, you will work with class hierarchies and interfaces. Interfaces do not allow code reuse 
of methods as do superclasses, but they do allow you to use a common reference for a group of related 
classes, thus allowing polymorphic code. Interfaces also are not part of the class hierarchy; therefore, 
classes in different hierarchies can implement the same interface.

### Practice 13-1: Overriding the toString Method
In the practice for the previous lesson, you created a new class hierarchy with a GameEvent superclass and 
two subclasses Possession and Goal. One of the advantages of this approach is that common code can be put 
in the superclass and code specific to either Possession or Goal can be put in the class itself. Then, by 
using GameEvent as the reference to objects of either subclass, polymorphism ensures that the method will 
be called on the actual object.

### Practice 13-2: Implementing an Interface
In this practice, you implement the Comparable interface so that you can order the elements in an array.

### Practice 13-3: Using a Lambda Expression for Sorting (Optional Practice)
In this practice, you order the players based on their goal scoring. However, instead of having Player 
implement compareTo, you will use a lambda expression.


--- 
### softcode for Practice 13-2: Implementing an Interface

console
``` java
run:
The league is scheduled to run for 1 month(s), and 5 day(s)

The Robins vs. The Crows
Date: 2020-11-12
Goal scored after 3.0 mins by J. M. Synge of The Robins
Possession after 13.0 mins by Arthur Conan Doyle of The Crows
Possession after 20.0 mins by Frank O'Connor of The Crows
Goal scored after 21.0 mins by Anthony Trollope of The Robins
Goal scored after 43.0 mins by Sean O'Casey of The Crows
Possession after 44.0 mins by Sean O'Casey of The Crows
Goal scored after 51.0 mins by Arthur Conan Doyle of The Crows
Goal scored after 56.0 mins by J. M. Synge of The Robins
Possession after 57.0 mins by Boris Pasternik of The Crows
Possession after 59.0 mins by Arthur Conan Doyle of The Crows
Possession after 60.0 mins by Boris Pasternik of The Crows
Goal scored after 79.0 mins by Geoffrey Chaucer of The Robins
Goal scored after 87.0 mins by Boris Pasternik of The Crows
The Robins win (4 - 3) 

The Robins vs. The Swallows
Date: 2020-11-19
Possession after 3.0 mins by Geoffrey Chaucer of The Robins
Possession after 10.0 mins by Dorothy Parker of The Swallows
Possession after 13.0 mins by Geoffrey Chaucer of The Robins
Possession after 16.0 mins by J. M. Synge of The Robins
Goal scored after 18.0 mins by William Shakespeare of The Robins
Possession after 24.0 mins by William Makepeace Thackeray of The Swallows
Possession after 25.0 mins by William Makepeace Thackeray of The Swallows
Possession after 26.0 mins by Jane Austin of The Swallows
Possession after 40.0 mins by Agatha Christie of The Swallows
Goal scored after 49.0 mins by William Shakespeare of The Robins
Goal scored after 52.0 mins by J. M. Synge of The Robins
Possession after 56.0 mins by William Shakespeare of The Robins
Possession after 66.0 mins by William Shakespeare of The Robins
Goal scored after 68.0 mins by Agatha Christie of The Swallows
Possession after 76.0 mins by J. R. Tolkien of The Swallows
Possession after 87.0 mins by Anthony Trollope of The Robins
The Robins win (3 - 1) 

The Crows vs. The Robins
Date: 2020-11-26
Possession after 2.0 mins by J. M. Synge of The Robins
Goal scored after 11.0 mins by Anthony Trollope of The Robins
Goal scored after 15.0 mins by Boris Pasternik of The Crows
Possession after 24.0 mins by J. M. Synge of The Robins
Possession after 26.0 mins by J. M. Synge of The Robins
Possession after 33.0 mins by Frank O'Connor of The Crows
Possession after 37.0 mins by Anthony Trollope of The Robins
Goal scored after 44.0 mins by Geoffrey Chaucer of The Robins
Possession after 47.0 mins by Alexander Solzhenitsyn of The Robins
Goal scored after 69.0 mins by Anthony Trollope of The Robins
Possession after 73.0 mins by J. M. Synge of The Robins
Goal scored after 74.0 mins by J. M. Synge of The Robins
Possession after 76.0 mins by Anthony Trollope of The Robins
Possession after 77.0 mins by William Shakespeare of The Robins
Goal scored after 81.0 mins by William Shakespeare of The Robins
Possession after 85.0 mins by Arthur Conan Doyle of The Crows
Possession after 89.0 mins by J. M. Synge of The Robins
The Robins win (1 - 5) 

The Crows vs. The Swallows
Date: 2020-12-03
Goal scored after 1.0 mins by Frank O'Connor of The Crows
Possession after 4.0 mins by William Makepeace Thackeray of The Swallows
Possession after 6.0 mins by Dorothy Parker of The Swallows
Possession after 7.0 mins by Sean O'Casey of The Crows
Goal scored after 9.0 mins by Agatha Christie of The Swallows
Possession after 23.0 mins by Arthur Conan Doyle of The Crows
Possession after 24.0 mins by George Eliot of The Crows
Goal scored after 25.0 mins by Boris Pasternik of The Crows
Possession after 28.0 mins by George Eliot of The Crows
Goal scored after 29.0 mins by William Makepeace Thackeray of The Swallows
Goal scored after 33.0 mins by Sean O'Casey of The Crows
Possession after 36.0 mins by Boris Pasternik of The Crows
Possession after 45.0 mins by Dorothy Parker of The Swallows
Possession after 51.0 mins by William Makepeace Thackeray of The Swallows
Possession after 55.0 mins by George Eliot of The Crows
Goal scored after 56.0 mins by Frank O'Connor of The Crows
Possession after 69.0 mins by Arthur Conan Doyle of The Crows
Possession after 71.0 mins by Dorothy Parker of The Swallows
Possession after 75.0 mins by George Eliot of The Crows
Possession after 76.0 mins by Dorothy Parker of The Swallows
Goal scored after 78.0 mins by Agatha Christie of The Swallows
Possession after 79.0 mins by Sean O'Casey of The Crows
Possession after 80.0 mins by J. R. Tolkien of The Swallows
Possession after 90.0 mins by Jane Austin of The Swallows
The Crows win (4 - 3) 

The Swallows vs. The Robins
Date: 2020-12-10
Goal scored after 12.0 mins by William Shakespeare of The Robins
Goal scored after 13.0 mins by William Shakespeare of The Robins
Possession after 14.0 mins by William Shakespeare of The Robins
Possession after 20.0 mins by William Shakespeare of The Robins
Goal scored after 26.0 mins by Jane Austin of The Swallows
Goal scored after 27.0 mins by Jane Austin of The Swallows
Possession after 33.0 mins by William Shakespeare of The Robins
Possession after 36.0 mins by Alexander Solzhenitsyn of The Robins
Possession after 39.0 mins by Anthony Trollope of The Robins
Possession after 42.0 mins by Jane Austin of The Swallows
Possession after 45.0 mins by William Shakespeare of The Robins
Goal scored after 48.0 mins by William Shakespeare of The Robins
Possession after 49.0 mins by Agatha Christie of The Swallows
Goal scored after 53.0 mins by J. M. Synge of The Robins
Possession after 56.0 mins by Alexander Solzhenitsyn of The Robins
Goal scored after 57.0 mins by Anthony Trollope of The Robins
Possession after 59.0 mins by Jane Austin of The Swallows
Possession after 60.0 mins by Jane Austin of The Swallows
Possession after 65.0 mins by William Shakespeare of The Robins
Possession after 70.0 mins by Dorothy Parker of The Swallows
Possession after 81.0 mins by Jane Austin of The Swallows
Possession after 85.0 mins by Agatha Christie of The Swallows
The Robins win (2 - 5) 

The Swallows vs. The Crows
Date: 2020-12-17
Possession after 12.0 mins by Boris Pasternik of The Crows
Possession after 16.0 mins by Dorothy Parker of The Swallows
Goal scored after 28.0 mins by Frank O'Connor of The Crows
Possession after 30.0 mins by William Makepeace Thackeray of The Swallows
Possession after 41.0 mins by Agatha Christie of The Swallows
Possession after 50.0 mins by Jane Austin of The Swallows
Possession after 53.0 mins by Frank O'Connor of The Crows
Possession after 65.0 mins by Boris Pasternik of The Crows
Possession after 71.0 mins by Sean O'Casey of The Crows
Possession after 78.0 mins by Arthur Conan Doyle of The Crows
The Crows win (0 - 1) 


Team Points
The Robins : 4 : 17
The Crows : 2 : 9
The Swallows : 0 : 6
Winner of the League is The Robins


Best Players
William Shakespeare : 6
J. M. Synge : 5
Anthony Trollope : 4
Frank O'Connor : 3
Boris Pasternik : 3
Agatha Christie : 3
Geoffrey Chaucer : 2
Sean O'Casey : 2
Jane Austin : 2
Arthur Conan Doyle : 1
William Makepeace Thackeray : 1
Alexander Solzhenitsyn : 0
George Eliot : 0
J. R. Tolkien : 0
Dorothy Parker : 0
BUILD SUCCESSFUL (total time: 0 seconds)

```
League.java
``` java

package soccer;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
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
        
        /* Practice 13-2. Add statement to sort theTeams here */
        Arrays.sort(theTeams);
        
        Team currBestTeam = theTeams[0];  
        System.out.println("\nTeam Points");       
           
        for (Team currTeam: theTeams){
            System.out.println(currTeam.getTeamName() + " : " + currTeam.getPointsTotal() + " : "
                     + currTeam.getGoalsTotal());
            
        /* Practice 13-2. Remove all conditional code starting here */    

        /* Practice 13-2. Remove all conditional code between this point and above comment */
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
Team.java
``` java

package soccer;

/* Practice 13-2. Change class declaration so that it implements Comparable */
public class Team implements Comparable {
    
    private String teamName;
    private Player[] playerArray;
    private int pointsTotal;
    private int goalsTotal;
    
    /* Practice 13-2. Add the compareTo() method here */
    public int compareTo(Object theTeam) {
        int returnValue = -1;
        if (this.getPointsTotal() < ((Team)theTeam).getPointsTotal()) {
            returnValue = 1;
        } else if (this.getPointsTotal() == ((Team)theTeam).getPointsTotal() ) {
            if (this.getGoalsTotal() < ((Team)theTeam).getGoalsTotal() ){
                returnValue = 1;
            }
            
        }
        return returnValue;
    }
    
    
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
            
            if (Math.random() > 0.8){
              
                currEvent = Math.random() > 0.8?new Goal():new Possession();
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
            
            if (currEvent instanceof Goal) {
                if (currEvent.getTheTeam()== homeTeam) {
                    homeTeamGoals++;
                    homeTeam.incGoalsTotal(1);
                } else {
                    awayTeamGoals++;
                    awayTeam.incGoalsTotal(1);
                }
            }
            
            returnString.append(currEvent +" after "
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
    
    public String toString(){
        return "Possession";
    }
    
}

```
Goal.java
``` java

package soccer;

public class Goal extends GameEvent {

    public String toString() {
        return "Goal scored";
    }
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
