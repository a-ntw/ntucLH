package problem2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Session {

	private LocalDateTime startTime;
	private int duration;
	private ArrayList<Talk> talks;
	
	public ArrayList<Talk> getTalks() {
		return talks;
	}
	public void setTalks(ArrayList<Talk> talks) {
		this.talks = talks;
	}

	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(String text) {
	    DateTimeFormatter dTF;  //Declare dateTime formatter
	    dTF = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
	    LocalDateTime parsedDate = LocalDateTime.parse(text, dTF);
		this.startTime = parsedDate;
	}
	
	public int getTotalTime() {
		int ttime = 0;
		for (var s : talks) {
			ttime += s.getMins();
		}
		return ttime;
	}
	
	public void printSess() {
	    DateTimeFormatter tF = DateTimeFormatter.ofPattern("hh:mm a");	// Declare Time format	
		LocalDateTime ldt = getStartTime();
		for (var s : talks) {
			System.out.println(ldt.format(tF) + "\t" +s.getDesc());
			ldt = ldt.plusMinutes(s.getMins());
		}
	}
}
