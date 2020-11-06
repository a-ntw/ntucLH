### Practices for Lesson 14: Handling Exceptions
In these practices, you will modify your code to catch an exception.

### Practice 14-1: Overview – Adding Exception Handling
In this practice, you will investigate how the code of the soccer application can break under 
certain circumstances, and modify your code to handle this gracefully.

console
```
run:
utility.PlayerDatabaseException: Not enough players in the database for the teams requested.
	at utility.PlayerDatabase.getTeam(PlayerDatabase.java:44)
	at soccer.League.createTeams(League.java:69)
	at soccer.League.main(League.java:36)
BUILD SUCCESSFUL (total time: 0 seconds)
```

League.java
``` java

package soccer;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import utility.PlayerDatabase;
import utility.PlayerDatabaseException;

public class League {

    public static void main(String[] args) {
        
        League theLeague = new League();
        
        /* Practice 14-1, Step 3a. Start a try block here */
        try {

            /* Practice 14-1, Step 2a. Modify the line below to add more teams and players */
            //Team[] theTeams = theLeague.createTeams("The Robins,The Crows,The Swallows", 5);
            Team[] theTeams = theLeague.createTeams
                ("The Robins, The Crows, The Swallows, The Owls", 11);
            Game[] theGames = theLeague.createGames(theTeams);

            System.out.println(theLeague.getLeagueAnnouncement(theGames));
            for (Game currGame: theGames){
                currGame.playGame();
                //break;
                System.out.println(currGame.getDescription());
            }

            theLeague.showBestTeam(theTeams);
            theLeague.showBestPlayers(theTeams);

            /* Practice 14-1, Step 3b. Close the try block here */
        }
        
        /* Practice 14-1, Step 3d. Add a catch block here */
        catch (Exception e) {
            e.printStackTrace(System.err);
        }
        

    }

    /* Practice 14-1, Step 6e. Modify the signature to throw PlayerDatabaseException */
    public Team[] createTeams(String teamNames, int teamSize) throws 
            PlayerDatabaseException {

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
        
        Arrays.sort(theTeams);
        Team currBestTeam = theTeams[0];  
        System.out.println("\nTeam Points");       
           
        for (Team currTeam: theTeams){
            System.out.println(currTeam.getTeamName() + " : " + currTeam.getPointsTotal() + " : "
                     + currTeam.getGoalsTotal());

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
    
    public void showBestPlayers(Team[] theTeams){
        ArrayList <Player> thePlayers = new ArrayList();
        for (Team currTeam: theTeams){
            thePlayers.addAll(Arrays.asList(currTeam.getPlayerArray()));
        }
        
        Collections.sort(thePlayers, (p1, p2) -> Double.valueOf(p2.getGoalsScored()).compareTo(Double.valueOf(p1.getGoalsScored())));
        
        System.out.println("\n\nBest Players");
        for (Player currPlayer: thePlayers){
            System.out.println(currPlayer.getPlayerName() + " : " + currPlayer.getGoalsScored());
        }
    }

}

```
utility/PlayerDatabase
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
    /* Practice 14-1, Step 6d. Modify the signature to throw PlayerDatabaseException */
    public Player[] getTeam(int numberOfPlayers) throws 
            PlayerDatabaseException {
        Player[] teamPlayers = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++){
            int playerIndex = (int) (Math.random() * players.size());
            
            /* Practice 14-1, Step 6b. Start a try block here */
            try {
                teamPlayers[i] = players.get(playerIndex);
                players.remove(playerIndex);
            /* Practice 14-1, Step 6b. End the try block here */
            }
            /* Practice 14-1, Step 6c. Add catch block here */
            catch (IndexOutOfBoundsException ie) {
                throw new PlayerDatabaseException("Not enough players in the "
                        + "database for the teams requested.");
            }
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
