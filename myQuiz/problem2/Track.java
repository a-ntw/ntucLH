package problem2;

import java.util.ArrayList;

public class Track {
	private int TrackNo;
	private Session am;
	private Session pm;
	private ArrayList<Talk> talks;
	public Track() {
		super();
	}
	public Track(ArrayList<Talk> talks) {
		super();
		this.talks = talks;
	}

	public void setTrack() {
		var talks1Am = new ArrayList<Talk>();
		var sessAm = new Session();
		sessAm.setDuration(180);
		sessAm.setTalks(talks1Am);
		sessAm.setStartTime("26/4/2021 09:00");
		this.am = sessAm;
		
		var talks1Pm = new ArrayList<Talk>();
		var sessPm = new Session();
		sessPm.setDuration(240);
		sessPm.setTalks(talks1Pm);
		sessPm.setStartTime("26/4/2021 13:00");	
		this.pm = sessPm;
	}
	
	// for ScheduleUnsort
	public void genTracks() {
		var lunch = new Talk("Lunch",60); 
		var networking = new Talk("Networking Event",30);
		
		var talks1Am = new ArrayList<Talk>();
		var sessAm = new Session();
		sessAm.setDuration(180);
		sessAm.setTalks(talks1Am);
		sessAm.setStartTime("26/4/2021 09:00");

		var balTalks = new ArrayList<Talk>();
		for (var s : talks) {
			if ((sessAm.getTotalTime() + s.getMins() ) <= sessAm.getDuration()) {
				talks1Am.add(s);}
			else balTalks.add(s);
		}
		talks1Am.add(lunch);

		var talks1Pm = new ArrayList<Talk>();
		var sessPm = new Session();
		sessPm.setDuration(240);
		sessPm.setTalks(talks1Pm);
		sessPm.setStartTime("26/4/2021 13:00");	
		
		var temp2Talks = new ArrayList<Talk>();
		for (var s : balTalks) {
			if ((sessPm.getTotalTime() + s.getMins()) <= sessPm.getDuration()) {
				talks1Pm.add(s);}
			else temp2Talks.add(s);
		}
		talks1Pm.add(networking);	
		
		setAm(sessAm);
		setPm(sessPm);
		setBalanceTalks(temp2Talks);
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
		for (var i = 1 ; i <= noOfTrack() ; i++) {
			var t = new Track();
			t.setTrack();
			t.setTrackNo(i);
			allTracks.add(t);
		}
		return allTracks;
	}
	
	public int getTrackNo() {
		return TrackNo;
	}
	public void setTrackNo(int trackNo) {
		TrackNo = trackNo;
	}
	public Session getAm() {
		return am;
	}
	public void setAm(Session am) {
		this.am = am;
	}
	public Session getPm() {
		return pm;
	}
	public void setPm(Session pm) {
		this.pm = pm;
	}
	public ArrayList<Talk> getBalanceTalks() {
		return talks;
	}
	public void setBalanceTalks(ArrayList<Talk> balanceTalks) {
		this.talks = balanceTalks;
	}
}
