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
