package problem2;

import java.util.ArrayList;

public class Track {
	private int TrackNo;
	private Session am;
	private Session pm;
	private ArrayList<Talk> balanceTalks;

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
	public void genTracks(ArrayList<Talk> talks) {
		var lunch = new Talk("Lunch",60); 
		var networking = new Talk("Networking Event",30);
		
		var talks1Am = new ArrayList<Talk>();
		var sessAm = new Session();
		sessAm.setDuration(180);
		sessAm.setTalks(talks1Am);
		sessAm.setStartTime("26/4/2021 09:00");

		var balTalks = new ArrayList<Talk>();
		for (Talk s : talks) {
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
		for (Talk s : balTalks) {
			if ((sessPm.getTotalTime() + s.getMins()) <= sessPm.getDuration()) {
				talks1Pm.add(s);}
			else temp2Talks.add(s);
		}
		talks1Pm.add(networking);	
		
		setAm(sessAm);
		setPm(sessPm);
		setBalanceTalks(temp2Talks);
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
		return balanceTalks;
	}
	public void setBalanceTalks(ArrayList<Talk> balanceTalks) {
		this.balanceTalks = balanceTalks;
	}
}
