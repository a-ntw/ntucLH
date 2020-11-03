### Practices for Lesson 8: Creating and Using Methods

### Practice 8-3: Creating Overloaded Methods

console
``` console
run:
Goal scored after 2.0 mins by Robbie Burns of The Reds
Goal scored after 12.0 mins by Geoffrey Chaucer of The Greens
Goal scored after 31.0 mins by Geoffrey Chaucer of The Greens
Goal scored after 33.0 mins by Graham Greene of The Greens
Goal scored after 78.0 mins by Geoffrey Chaucer of The Greens
Goal scored after 88.0 mins by Robert Service of The Reds

BUILD SUCCESSFUL (total time: 0 seconds)
```

League.java
``` java

package soccer;

public class League {

    public static void main(String[] args) {
        
        League theLeague = new League();

        Team[] theTeams = createTeams();
        Game[] theGames = theLeague.createGames(theTeams);

        Game currGame = theGames[0];
        
        currGame.playGame();
        
        System.out.println(currGame.getDescription());

    }

    public static Team[] createTeams() {

        Player player1 = new Player();
        player1.playerName = "George Eliot";
        Player player2 = new Player();
        player2.playerName = "Graham Greene";
        Player player3 = new Player();
        player3.playerName = "Geoffrey Chaucer";
        Player[] thePlayers = {player1, player2, player3};

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

        Team[] theTeams = {team1, team2};
        return theTeams;
    }

    public Game[] createGames(Team[] theTeams) {
        Game theGame = new Game();
        theGame.homeTeam = theTeams[0];
        theGame.awayTeam = theTeams[1];
        Game[] theGames = {theGame};
        return theGames;
    }

}

```
Game.java
``` java
package soccer;

import utility.GameUtils;

public class Game {
    
    public Team homeTeam;
    public Team awayTeam;
    public Goal[] goals;
    
    public void playGame(int maxGoals) {
        /* Practice 8-3. Add code to initialize the array currGame.goals to a random size */
        //int numberOfGoals = (int)(Math.random() * 7);
        int numberOfGoals = (int)(Math.random() * (maxGoals + 1));
        Goal[] theGoals = new Goal[numberOfGoals];
        this.goals = theGoals;
        GameUtils.addGameGoals(this);        
    }
    
    /* Practice 8-3. Add no-parameter playGame() method here */
    public void playGame(){
        playGame(6);
    }
 
    
    public String getDescription() {
        StringBuilder returnString = new StringBuilder();
        for (Goal currGoal: this.goals) {
            returnString.append("Goal scored after "
            + currGoal.theTime + " mins by "
            + currGoal.thePlayer.playerName + " of "
            + currGoal.theTeam.teamName +
              "\n");
        }
        return returnString.toString();
    }
      
}

```
Player.java
``` java
package soccer;

public class Player {
    
    public String playerName;
    
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
