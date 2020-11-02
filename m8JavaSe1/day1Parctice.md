### Practices for Lesson 6: Overview 
#### Practices Overview
In these practices, you will create the classes needed to represent the data for the soccer application and write code to instantiate these classes.

### Practice 6-1: Creating Classes for the Soccer League
#### Overview
In this practice, you create the five classes required for the soccer application (`Goal`, `Game`, `Player`, `Team`, and `League`).

#### Tasks
1. Open the project for this practice in NetBeans.
- Start NetBeans by double-clicking the NetBeans icon on the desktop.
- Open the project **06-ObjectsClasses_Practice1** by clicking the Open Project icon, and then navigate to
```
~/labs/06-ObjectsClasses/Practices/Practice1/06- 
ObjectsClasses_Practice1
```
and click Open Project.

2. Create a package named soccer in the **06-ObjectsClasses_Practice1** project.
- In NetBeans, right-click the project named **06-ObjectsClasses_Practice1**, and select New > Java Package.
- In the New Java Package dialog box, enter `soccer` as the Package Name, and click Finish.

3. The initial version of the soccer application comprises five main data classes:
`Player`, `Team`, `Game`, `Goal`, and League. Create the `Player` class.
- Right-click the soccer package and select New > Java Class.
- In the New Java Class dialog box, enter `Player` as the Class Name and click Finish.
- In the most basic version of the soccer application, the `Player` class has only one attribute, 
a String called `playerName`. Add this attribute now.
- The code of the `Player` class should now look like this:
``` java
   package soccer;
   public class Player {
        public String playerName;
   }
```   
4. Create the Team class.
- Right-click the soccer package and select New > Java Class.
- In the New Java Class dialog box, enter Team as the Class Name and click Finish.
- In the most basic version of the soccer application, the Team class has two attributes: a String named teamName and a Player array named playerArray. Add these attributes now.
- The code of the Team class should now look like this:
``` java
package soccer;
public class Team {
    public String teamName;
    public Player[] playerArray;
}
```
5. Create the `Goal` class with the following attributes.

Type | Name
--- | ---
Team | theTeam
Player | thePlayer
double | theTime

The code of the `Goal` class should look like this.
``` java
       package soccer;
       public class Goal {
           public Team theTeam;
           public Player thePlayer;
           public double theTime;
}
```
6. Create the Game class with the following attributes:

Type | Name
--- | ---
Team | homeTeam
Team | awayTeam
Goal[] | goals

The code of the `Game` class should look like this.
``` java
       package soccer;
       public class Game {
           public Team homeTeam;
           public Team awayTeam;
           public Goal[] goals;
}
```
7. Now that you have created the required classes, you create one more class called `League`, 
which will use these classes to run a set of games. 
This class needs to have a method main so that it can be run as a console application.
- Right-click the soccer package and select New > Other.
- In the New File dialog box, select Categories > Java, then select File Types: > Java Main Class, a
nd click Next.
- In the New Java Class dialog box, enter League as the Class Name and click Finish. Your new class should look like this (there will be other comments in your code that are not shown here).
``` java
package soccer;
   public class League {
        public static void main(String[] args) {
        // TODO code application logic here
        }
}
```
8. Using the classes that you have created means populating them with data. So you need to:
- Instantiate a number of `Player` objects for each `Team`.
- Instantiate some `Team` objects to play games.
- Instantiate some `Game` objects to represent those games.
- For each goal in a game, instantiate a `Goal` object and add it to the `Goal` array in the 
appropriate `Game` object.

In the `main` method of `League`, you now create two teams, each with two players. 
To help remember which player plays for which team, player names and their team names start with 
the same letter. For example George Eliot plays for The Greens; Robert Service plays for the Reds.
- At the top of the `main` method (below where it says TODO code application logic here), 
declare and instantiate a `Player` object.
`Player player1 = new Player();`
- Set the `playerName` attribute of the `Player` object to "George Eliot".
`player1.playerName = "George Eliot";`
- Declare and instantiate a new `Player` object and set its `playerName` attribute to "Graham Greene".
``` java
Player player2 = new Player(); 
player2.playerName = "Graham Greene";
```
- Declare and instantiate a third `Player` object and set its `playerName` attribute to "Geoffrey Chaucer".
``` java
Player player3 = new Player(); 
player3.playerName = "Geoffrey Chaucer";
```
- Create a `Player` array called `thePlayers` that comprises the three `Player` objects that you just instantiated.
`Player[] thePlayers = { player1, player2, player3 };`
- Declare and instantiate a `Team` object.
`Team team1 = new Team();`
- Set the `teamName` attribute of the `Team` object to "The Greens". 
`team1.teamName = "The Greens";`
- Set the `playerArray` attribute of the `Team` object to the `Player` array `thePlayers`. 
`team1.playerArray = thePlayers;`
9. Print out the players in the team "The Greens".
- Create a for loop that iterates through the array in `team1`.
``` java
for (Player thePlayer: team1.playerArray) { 
    System.out.println(thePlayer.playerName);
}
```
- Run the project by clicking the green arrow.
- The output should look like the following. Notice that the output begins with a line that indicates that 
the project was run (as opposed to debugged, which you will learn about later). 
Then comes the three lines output by `System.out.println`. Finally, there is a line 
indicating that the project built successfully.

From now on, in these instructions, the output will show just the lines output by the code that you write. 
Here is what that would look like for the project that you just ran:
```
        George Eliot
        Graham Greene
        Geoffrey Chaucer
```
`0. Just above the for loop, add a statement to set `player1.playerName` to "Robert Service".
`player1.playerName = "Robert Service";`
- Now run the class again. What do you expect the output to be?
```
   Robert Service
   Graham Greene
   Geoffrey Chaucer
```   
- Remove or comment out the line that changes the name to Robert Service.
##### Technical Note:
Think about what has happened in this step. In your code, there are two references to "Robert Service" 
(the `String` that used to be "Graham Greene"). One of the references is `player1.playerName`; 
the other is `Team.playerArray[0].playerName`. Because both point to the same `String` in memory, 
if you use either reference to replace the old `String` with a new `String`, 
both references will now point to this new `String`.

11. Now create a second team with the reference `team2`. However, this time don't use the temporary 
references `player1`, `player2`, `player3`. Instead, create the team, create a new `Player` array and 
assign it to the team, and then add players to the team and set their names.
- Just above the for loop block, create a Team called `team2` and name it "The Reds". 
`Team team2 = new Team();`
`team2.teamName = "The Reds";`
- Create a three-element `Player` array and assign it to the `playerArray` reference of the Team object that you just created.
`team2.playerArray = new Player[3];`
- Add a player named "Robert Service" to the first element of `playerArray`. 
`team2.playerArray[0] = new Player();` 
`team2.playerArray[0].playerName = "Robert Service";`
- Add two new Player objects with `playerName` attributes set to "Robbie Burns" and "Rafael Sabatini" 
(or use names of your own choosing). Add these players to the second and third elements of the 
`playerArray` array. Copy and paste may save some time here.
``` java
team2.playerArray[1] = new Player(); 
team2.playerArray[1].playerName = "Robbie Burns"; 
team2.playerArray[2] = new Player(); 
team2.playerArray[2].playerName = "Rafael Sabatini";
```
-C opy and paste the for loop so that the second loop now prints out the names of the players on team2 
(for the second loop change the reference to the `Team` object to team2). Run the application. 
Your output should look like this.
```
        George Eliot
        Graham Greene
        Geoffrey Chaucer
        Robert Service
        Robbie Burns
        Rafael Sabatini
```

This is the end of this practice. Shut down any NetBeans tabs that contain Java code.

### Practice 6-2: Creating a Soccer Game
#### Overview
In this practice, you use the classes that you have created and populated to create a new `Game` object and add some goals.
#### Tasks
1. Open the project **06-ObjectsClasses_Practice2**.
2. Create a game and add some goals.
- a. In the `League` class, delete the two for loops that print out the names of the players on `team1` and `team2`.
- b. At the bottom of the method, create a `Game` and populate the `homeTeam` and `awayTeam` attributes.
```
Game currGame = new Game(); 
currGame.homeTeam = team1; 
currGame.awayTeam = team2;
```
- c. Create a `Goal` object to give the home team a 1–0 lead.
```
Goal goal1 = new Goal();
goal1.thePlayer = currGame.homeTeam.playerArray[2]; 
goal1.theTeam = currGame.homeTeam;
goal1.theTime = 55;
```
- d. Put this `Goal` object in a Goal array, and then assign this `Goal` array to the `goals` attribute of the 
`Game` object.
```
Goal[] theGoals = {goal1}; 
currGame.goals = theGoals;
```
- e. Print out the score of the game (if there was more than one goal, you would need to use a loop)
```
System.out.println("Goal scored after " + 
currGame.goals[0].theTime + " mins by " + 
currGame.goals[0].thePlayer.playerName + " of " + 
currGame.goals[0].theTeam.teamName);
```
- f. When you run the code you should see this output.
```
Goal scored after 55.0 mins by Geoffrey Chaucer of the Greens
```

This is the end of this practice. Shut down any NetBeans tabs that contain Java code.


---
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

Game.java
``` java
package soccer;
public class Game {
    
    public Team homeTeam;
    public Team awayTeam;
    public Goal[] goals;
    
}
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
/*run:
Goal scored after 55.0 mins by Geoffrey Chaucer of The Greens
BUILD SUCCESSFUL (total time: 0 seconds)
*/
```
