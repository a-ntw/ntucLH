package problem2;

import java.util.ArrayList;
import java.util.Collections;

public class Event {
	public ArrayList<Talk> talks;
	
	public Event(ArrayList<Talk> talks) {
		super();
		this.talks = talks;
		
	}

	/* sorted from longest timing to dummy array*/
	public ArrayList<Talk> talksSorted(){
		ArrayList<Talk> talksSorted = talks;
		// https://stackoverflow.com/questions/5805602/how-to-sort-list-of-objects-by-some-property
		Collections.sort(talksSorted, (Talk t1, Talk t2) -> t2.getMins()-t1.getMins());
		return talksSorted;
	}

	/* determines total no of tracks via totalTime*/
	public int noOfTrack() {
		var totalTalks = new Session();
		totalTalks.setTalks(talks);
		totalTalks.setStartTime("26/4/2021 00:00");

		int timePerTrack = 3*60 + 4*60; 
		int noOfTrack = totalTalks.getTotalTime() / timePerTrack + 1;
		
		return noOfTrack;
	}
	
	/* Instantiate Track and Sessions */
	public ArrayList<Track> iniTrack() {
		var allTracks = new ArrayList<Track>();
		for (int i = 1 ; i <= noOfTrack() ; i++) {
			var t = new Track();
			t.setTrack();
			t.setTrackNo(i);
			allTracks.add(t);
		}
		return allTracks;
	}
	
	/* rotate-distribution, added Session*/
	public void genSessions(ArrayList<Track> allTracks, ArrayList<Talk> talksSorted ) {
		ArrayList<Talk> tks = talksSorted;
		
		do {
			for (Track track: allTracks) {
				Session am = track.getAm();
				if (am.getTotalTime() + tks.get(0).getMins() <=am.getDuration()) {
					am.getTalks().add(tks.get(0));
						tks.remove(0);
				}
				if (tks.size()>0 ) {
				track.getPm().getTalks().add(tks.get(0));
				tks.remove(0);
				}
			}
		} while (tks.size() > 0);
		
		/* added in lunch and networking */
		var lunch = new Talk("Lunch",60); 
		var networking = new Talk("Networking Event",30);
		for (Track t: allTracks) {
			t.getAm().getTalks().add(lunch);
			t.getPm().getTalks().add(networking);
		}
	}
	
	/* output */
	public void output() {
		System.out.println("\nTest Input:");
		for (Talk s : talks) {
			System.out.println(s.getDesc());
		}
		System.out.println("\nTest Output:");
		
		ArrayList<Talk> ts = talksSorted();
		ArrayList<Track> allTracks = iniTrack();

		genSessions(allTracks, ts);
		
		for (Track t: allTracks) {
			System.out.println("\nTrack " + t.getTrackNo() + ":");
			t.getAm().printSess();
			t.getPm().printSess();
		}
		
	}
}
