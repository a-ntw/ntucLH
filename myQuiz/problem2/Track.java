package problem2;

import java.util.ArrayList;

public class Track {
	private int TrackNo;
	private Session am;
	private Session pm;
	private ArrayList<Talk> balanceTalks;

	public void setTrack() {
		ArrayList<Talk> talks1Am = new ArrayList<>();
		Session sessAm = new Session();
		sessAm.duration = 180;
		sessAm.listName = "morning";
		sessAm.talks = (ArrayList<Talk>) talks1Am;
		sessAm.setStartTime("26/4/2021 09:00");
		this.am = sessAm;
		
		ArrayList<Talk> talks1Pm = new ArrayList<>();
		Session sessPm = new Session();
		sessPm.duration = 240;
		sessPm.listName = "afternoon";
		sessPm.talks = (ArrayList<Talk>) talks1Pm;
		sessPm.setStartTime("26/4/2021 13:00");	
		this.pm = sessPm;
	}
	
	public void genTracks(ArrayList<Talk> talks) {
		Talk lunch = new Talk("Lunch",60); 
		Talk networking = new Talk("Networking Event",30);
		
		ArrayList<Talk> talks1Am = new ArrayList<>();
		Session sessAm = new Session();
		sessAm.duration = 180;
		sessAm.listName = "morning";
		sessAm.talks = (ArrayList<Talk>) talks1Am;
		sessAm.setStartTime("26/4/2021 09:00");

		ArrayList<Talk> balTalks = new ArrayList<>();
		for (Talk s : talks) {
			if ((sessAm.getTotalTime() + s.getMins() ) <= sessAm.duration) {
				talks1Am.add(s);}
			else balTalks.add(s);
		}
		talks1Am.add(lunch);

		ArrayList<Talk> talks1Pm = new ArrayList<>();
		Session sessPm = new Session();
		sessPm.duration = 240;
		sessPm.listName = "afternoon";
		sessPm.talks = (ArrayList<Talk>) talks1Pm;
		sessPm.setStartTime("26/4/2021 13:00");	
		
		ArrayList<Talk> temp2Talks = new ArrayList<>();
		for (Talk s : balTalks) {
			if ((sessPm.getTotalTime() + s.getMins()) <= sessPm.duration) {
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
