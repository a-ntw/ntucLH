package problem2;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScheduleUnsort {
	@Test
	void contextLoads() {
		ArrayList<Talk> talks = new ArrayList<>();
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
		
		System.out.println("\nTest Input:");
		for (Talk s : talks) {
			System.out.println(s.getDesc());
		}
		
		System.out.println("\nTest Output:");
		int trackNo = 1;
		do {
			System.out.println("\nTrack " + trackNo + ":");
			Track tk = new Track();
			tk.genTracks(talks);
			tk.getAm().printSess();
			tk.getPm().printSess();	
			talks =  tk.getBalanceTalks();
			trackNo ++;
		}
		while ( talks.size() > 0  ) ;
		
	}
}
/*
...
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

*/