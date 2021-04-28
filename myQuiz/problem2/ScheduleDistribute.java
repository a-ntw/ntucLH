package problem2;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScheduleDistribute {
	@Test
	void contextLoads() {

		var talks = new ArrayList<Talk>();
		talks.add(new Talk("Writing Fast Tests Against Enterprise Rails 60min", 60));
		talks.add(new Talk("Overdoing it in Python 45min",45));
		talks.add(new Talk("Lua for the Masses 30min",30));
		talks.add(new Talk("Ruby Errors from Mismatched Gem Versions 45min",45));
		talks.add(new Talk("Common Ruby Errors 45min",45));
		talks.add(new Talk("Rails for Python Developers lightning",5));
		talks.add(new Talk("Communicating Over Distance 60min",60));
		talks.add(new Talk("Accounting-Driven Development 45min",45));
		talks.add(new Talk("Woah 30min",30));
		talks.add(new Talk("Sit Down and Write 30min",30));
		talks.add(new Talk("Pair Programming vs Noise 45min",45));
		talks.add(new Talk("Rails Magic 60min",60));
		talks.add(new Talk("Ruby on Rails: Why We Should Move On 60min",60));
		talks.add(new Talk("Clojure Ate Scala (on my project) 45min",45));
		talks.add(new Talk("Programming in the Boondocks of Seattle 30min",30));
		talks.add(new Talk("Ruby vs. Clojure for Back-End Development 30min",30));
		talks.add(new Talk("Ruby on Rails Legacy App Maintenance 60min",60));		
		talks.add(new Talk("A World Without HackerNews 30min",30));
		talks.add(new Talk("User Interface CSS in Rails Apps 30min",30));
		
		
		var event = new Event(talks);
		event.output();

	}
}
/*
...
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
 * */
 