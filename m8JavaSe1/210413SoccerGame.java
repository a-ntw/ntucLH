import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class soccerGame {
	
	private static class Player {
		public String playerName;
	}

	private static class Team {
		public String teamName;
		public Player[] playerArray;
	}	

	//@Disabled
	@Test
	public void soccer() {

		class Goal {
			public Team theTeam;
			public Player thePlayer;
			public double theTime;
		}

		class Game {
			private Team homeTeam;
			private Team awayTeam;
			private Goal[] goals;
		}
			
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
        
        //for (Player thePlayer: team1.playerArray) {
        //    System.out.println(thePlayer.playerName);
        //}
        //        for (Player thePlayer: team2.playerArray) {
        //    System.out.println(thePlayer.playerName);
        //}
  
        /* Practice 6-2b. Create a Game here */
        Game currGame = new Game();
        currGame.homeTeam = team1;
        currGame.awayTeam = team2;
        
        /* Practice 6-2c. Create a Goal object here */
        Goal goal1 = new Goal();
        goal1.thePlayer = currGame.homeTeam.playerArray[2];
        goal1.theTeam = currGame.homeTeam;
        goal1.theTime = 55;
        
        /* Practice 6-2d. Put  Goal object in a Goal array and assign Goal array to goals attribute of Game object */
        Goal[] theGoals = {goal1};
        currGame.goals = theGoals;
        
        /* Practice 6-2e. Print out the score of the Game */
        System.out.println("Goal scored after " + 
        currGame.goals[0].theTime + " mins by " + 
        currGame.goals[0].thePlayer.playerName + " of " +
        currGame.goals[0].theTeam.teamName);  
	}
}
