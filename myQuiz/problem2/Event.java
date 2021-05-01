package problem2;

import java.util.ArrayList;
import java.util.Collections;

public class Event {
	private static ArrayList<Talk> talks;
	
	public Event(ArrayList<Talk> talks) {
		super();
		Event.talks = talks;
	}

	/* Schedule Unsorted */
	public void scheduleUnsortedOutput() {

		System.out.println("Test Output:");
		int trackNo = 1;
		do {
			System.out.println("\nTrack " + trackNo + ":");
			Track tk = new Track(talks);
			tk.genTracks();
			tk.getAm().printSess();
			tk.getPm().printSess();	
			talks =  tk.getBalanceTalks();
			trackNo ++;
		}
		while ( talks.size() > 0  ) ;
	}
	
	/* ScheduleRptateDistribute output */
	public void scheduleRotateOutput() {

		ArrayList<Talk> ts = talksSorted();
		Track track = new Track(talks);
		ArrayList<Track> allTracks = track.iniTrack();

		genSessions(allTracks, ts);
		
		System.out.println("Test Output:");
		for (var t: allTracks) {
			System.out.println("\nTrack " + t.getTrackNo() + ":");
			t.getAm().printSess();
			t.getPm().printSess();
		}
	}
	// sorted from longest timing to dummy array
	public ArrayList<Talk> talksSorted(){
		ArrayList<Talk> talksSorted = talks;
		// https://stackoverflow.com/questions/5805602/how-to-sort-list-of-objects-by-some-property
		Collections.sort(talksSorted, (Talk t1, Talk t2) -> t2.getMins()-t1.getMins());
		return talksSorted;
	}
	// ScheduleRotate-distribution, add Session
	public void genSessions(ArrayList<Track> allTracks, ArrayList<Talk> talksSorted ) {
		ArrayList<Talk> tks = talksSorted;
		
		do {
			for (var track: allTracks) {
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
		
		addLunchNetwork(allTracks);
	}

	
	
	/* MustFinishedByNoon output */
	public void scheduleMustFinishedByNoon() {

		Track trackList = new Track(talks);
		ArrayList<Track> allTracks = trackList.iniTrack();
		
		var sessSorting = new Session(talks);
		
		// sort on morning session, must before noon
		for (var tk: allTracks) {
			Session sessAm = tk.getAm();
			sessAm = sessSorting.selectionSort(sessSorting.getTalks(), sessAm);
			tk.setAm(sessAm);
		}
		
		// sort on afternoon session
		for (var tk: allTracks) {
			Session sessPm = tk.getPm();
			sessPm = sessSorting.selectionSort(sessSorting.getTalks(), sessPm);
			tk.setPm(sessPm);
		}	
		
		addLunchNetwork(allTracks);
		printout(allTracks);
	}

	/* added in lunch and networking */
	public static void addLunchNetwork(ArrayList<Track> allTracks) {
		var lunch = new Talk("Lunch",60); 
		var networking = new Talk("Networking Event",30);
		for (var t: allTracks) {
			t.getAm().getTalks().add(lunch);
			t.getPm().getTalks().add(networking);
		}
	}
	
	public static void printout(ArrayList<Track> allTracks) {

		System.out.println("Test Output:");
		
		for (var t: allTracks) {
			System.out.println("\nTrack " + t.getTrackNo() + ":");
			t.getAm().printSess();
			t.getPm().printSess();
		}
	}
}