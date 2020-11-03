### Practices for Lesson 7: Manipulating and Formatting the Data in Your Program
Practices Overview
In these practices, you will use Javadocs to find useful methods for String manipulation and then work with these methods.

console
``` console
run:
Goal scored after 55.0 mins by Geoffrey Chaucer of The Greens
Found Rafael Sabatini
Last name is Sabatini
Eliot, George
Greene, Graham
Chaucer, Geoffrey
BUILD SUCCESSFUL (total time: 0 seconds)
```

League.java
``` java
package soccer;

public class League {

    public static void main(String[] args) {
        
        // Create team1      
        Player player1 = new Player();
        player1.playerName = "George Eliot";
        Player player2 = new Player();
        player2.playerName = "Graham Greene";
        Player player3 = new Player();
        player3.playerName = "Geoffrey Chaucer";
        Player[] thePlayers = {player1, player2, player3 };
        
        Team team1 = new Team();
        team1.teamName = "The Greens";
        team1.playerArray = thePlayers;
        
        // Create team2
        Team team2 = new Team();
        team2.teamName = "The Reds";
        team2.playerArray = new Player[3];
        team2.playerArray[0] = new Player();
        team2.playerArray[0].playerName = "Robert Service";
        team2.playerArray[1] = new Player();
        team2.playerArray[1].playerName = "Robbie Burns";
        team2.playerArray[2] = new Player();
        team2.playerArray[2].playerName = "Rafael Sabatini";
        
        Game currGame = new Game();
        currGame.homeTeam = team1;
        currGame.awayTeam = team2;
        Goal goal1 = new Goal();
        goal1.thePlayer = currGame.homeTeam.playerArray[2];
        goal1.theTeam = currGame.homeTeam;
        goal1.theTime = 55;
        Goal[] theGoals = {goal1};
        currGame.goals = theGoals;
        
        System.out.println("Goal scored after " + 
                currGame.goals[0].theTime + " mins by " +
                currGame.goals[0].thePlayer.playerName + " of " +
                currGame.goals[0].theTeam.teamName);
        
        /* Practice 7-1. Add code for finding a player within team2 here */
        //for (Player thePlayer: team2.playerArray) {
        //    System.out.println( thePlayer.playerName);
        //}
        
        for (Player thePlayer: team2.playerArray) {
            if(thePlayer.playerName.matches(".*Sab.*")){
                System.out.println("Found " +  thePlayer.playerName);
                System.out.println("Last name is " +
                thePlayer.playerName.split(" ")[1]);
            }
        }
        StringBuilder familyNameFirst = new StringBuilder();
        
        for (Player thePlayer: team1.playerArray) {
            String name[] = thePlayer.playerName.split(" ");
            familyNameFirst.append(name[1]);
            familyNameFirst.append(", ");
            familyNameFirst.append(name[0]);
            
            System.out.println(familyNameFirst);
            familyNameFirst.delete(0, familyNameFirst.length());
        }
   
    }   
}

```
Game.java
``` java
package soccer;

public class Game {
    
    public Team homeTeam;
    public Team awayTeam;
    public Goal[] goals;
    
}
```
Team.java
``` java
package soccer;

public class Team {
    
    public String teamName;
    public Player[] playerArray;
    
}
```
Goal.java
``` java
package soccer;

public class Goal {
    
    public Team theTeam;
    public Player thePlayer;
    public double theTime;
    
}
```
Player.java
``` java
package soccer;

public class Player {
    
    public String playerName;
    
}
```
