package problem2;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class Problem2ApplicationTests {
	
	@Test
	public void prinInput() {
		prinInput(talks());

		var event = new Event(talks());
		
		System.out.println("\n*** Schedule Unsort ***");
		event.scheduleUnsortedOutput();

		System.out.println("\n*** Schedule Rotate Distributing ***");
		event = new Event(talks());
		event.scheduleRotateOutput();
		
		System.out.println("\n*** Schedule MustFinishedByNoon ***");
		event = new Event(talks());
		event.scheduleMustFinishedByNoon();	
		
		System.out.println("");
	}
	
	private static ArrayList<Talk> talks() {
		Talk[] talkArray = {
				new Talk( "Writing Fast Tests Against Enterprise Rails 60min", 60 ),
				new Talk( "Overdoing it in Python 45min",45 ),
				new Talk( "Lua for the Masses 30min",30 ),
				new Talk( "Ruby Errors from Mismatched Gem Versions 45min",45 ),
				new Talk( "Common Ruby Errors 45min",45 ),
				new Talk( "Rails for Python Developers lightning",5 ),
				new Talk( "Communicating Over Distance 60min",60 ),
				new Talk( "Accounting-Driven Development 45min",45 ),
				new Talk( "Woah 30min",30 ),
				new Talk( "Sit Down and Write 30min",30 ),
				new Talk( "Pair Programming vs Noise 45min",45 ),
				new Talk( "Rails Magic 60min",60 ),
				new Talk( "Ruby on Rails: Why We Should Move On 60min",60 ),
				new Talk( "Clojure Ate Scala (on my project) 45min",45 ),
				new Talk( "Programming in the Boondocks of Seattle 30min",30 ),
				new Talk( "Ruby vs. Clojure for Back-End Development 30min",30 ),
				new Talk( "Ruby on Rails Legacy App Maintenance 60min",60 ),	
				new Talk( "A World Without HackerNews 30min",30 ),
				new Talk( "User Interface CSS in Rails Apps 30min",30 ),
			};
		
		var talks = new ArrayList<Talk>();
		talks = new ArrayList<Talk>(Arrays.asList(talkArray));		
		return talks;
	}
	public static void prinInput(ArrayList<Talk> talks) {
		System.out.println("\nTest Input:");
		for (Talk s : talks) {
			System.out.println(s.getDesc());
		}
	}
}
/*
Test Input:
Writing Fast Tests Against Enterprise Rails 60min
Overdoing it in Python 45min
Lua for the Masses 30min
Ruby Errors from Mismatched Gem Versions 45min
Common Ruby Errors 45min
Rails for Python Developers lightning
Communicating Over Distance 60min
Accounting-Driven Development 45min
Woah 30min
Sit Down and Write 30min
Pair Programming vs Noise 45min
Rails Magic 60min
Ruby on Rails: Why We Should Move On 60min
Clojure Ate Scala (on my project) 45min
Programming in the Boondocks of Seattle 30min
Ruby vs. Clojure for Back-End Development 30min
Ruby on Rails Legacy App Maintenance 60min
A World Without HackerNews 30min
User Interface CSS in Rails Apps 30min

*** Schedule Unsort ***
Test Output:

Track 1:
09:00 am	Writing Fast Tests Against Enterprise Rails 60min
10:00 am	Overdoing it in Python 45min
10:45 am	Lua for the Masses 30min
11:15 am	Ruby Errors from Mismatched Gem Versions 45min
12:00 pm	Lunch
01:00 pm	Common Ruby Errors 45min
01:45 pm	Rails for Python Developers lightning
01:50 pm	Communicating Over Distance 60min
02:50 pm	Accounting-Driven Development 45min
03:35 pm	Woah 30min
04:05 pm	Sit Down and Write 30min
04:35 pm	Networking Event

Track 2:
09:00 am	Pair Programming vs Noise 45min
09:45 am	Rails Magic 60min
10:45 am	Ruby on Rails: Why We Should Move On 60min
11:45 am	Lunch
01:00 pm	Clojure Ate Scala (on my project) 45min
01:45 pm	Programming in the Boondocks of Seattle 30min
02:15 pm	Ruby vs. Clojure for Back-End Development 30min
02:45 pm	Ruby on Rails Legacy App Maintenance 60min
03:45 pm	A World Without HackerNews 30min
04:15 pm	User Interface CSS in Rails Apps 30min
04:45 pm	Networking Event

*** Schedule Rotate Distributing ***
Test Output:

Track 1:
09:00 am	Writing Fast Tests Against Enterprise Rails 60min
10:00 am	Ruby on Rails Legacy App Maintenance 60min
11:00 am	Accounting-Driven Development 45min
11:45 am	Lunch
01:00 pm	Communicating Over Distance 60min
02:00 pm	Overdoing it in Python 45min
02:45 pm	Pair Programming vs Noise 45min
03:30 pm	Woah 30min
04:00 pm	Ruby vs. Clojure for Back-End Development 30min
04:30 pm	User Interface CSS in Rails Apps 30min
05:00 pm	Networking Event

Track 2:
09:00 am	Rails Magic 60min
10:00 am	Ruby Errors from Mismatched Gem Versions 45min
10:45 am	Clojure Ate Scala (on my project) 45min
11:30 am	Sit Down and Write 30min
12:00 pm	Lunch
01:00 pm	Ruby on Rails: Why We Should Move On 60min
02:00 pm	Common Ruby Errors 45min
02:45 pm	Lua for the Masses 30min
03:15 pm	Programming in the Boondocks of Seattle 30min
03:45 pm	A World Without HackerNews 30min
04:15 pm	Rails for Python Developers lightning
04:20 pm	Networking Event

*** Schedule MustFinishedByNoon ***
Test Output:

Track 1:
09:00 am	Writing Fast Tests Against Enterprise Rails 60min
10:00 am	Overdoing it in Python 45min
10:45 am	Lua for the Masses 30min
11:15 am	Ruby Errors from Mismatched Gem Versions 45min
12:00 pm	Lunch
01:00 pm	Clojure Ate Scala (on my project) 45min
01:45 pm	Ruby vs. Clojure for Back-End Development 30min
02:15 pm	Ruby on Rails Legacy App Maintenance 60min
03:15 pm	A World Without HackerNews 30min
03:45 pm	User Interface CSS in Rails Apps 30min
04:15 pm	Networking Event

Track 2:
09:00 am	Accounting-Driven Development 45min
09:45 am	Woah 30min
10:15 am	Sit Down and Write 30min
10:45 am	Pair Programming vs Noise 45min
11:30 am	Programming in the Boondocks of Seattle 30min
12:00 pm	Lunch
01:00 pm	Common Ruby Errors 45min
01:45 pm	Rails for Python Developers lightning
01:50 pm	Communicating Over Distance 60min
02:50 pm	Rails Magic 60min
03:50 pm	Ruby on Rails: Why We Should Move On 60min
04:50 pm	Networking Event
*/