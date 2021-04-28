package problem2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Session {
	public String listName;
	public ArrayList<Talk> talks;
	public LocalDateTime startTime;
	public int duration;

	public LocalDateTime getStartTime() {
		return startTime;
	}
	
	public int getTotalTime() {
		int ttime = 0;
		for (Talk s : talks) {
			ttime += s.getMins();
		}
		return ttime;
	}
	
	public void setStartTime(String text) {
	    DateTimeFormatter dTF;  //Declare dateTime formatter
	    dTF = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
	    LocalDateTime parsedDate = LocalDateTime.parse(text, dTF);
		this.startTime = parsedDate;
	}

	public void printSess() {
	    DateTimeFormatter tF = DateTimeFormatter.ofPattern("hh:mm a");	// Declare Time format	
		LocalDateTime ldt = getStartTime();
		for (Talk s : talks) {
			System.out.println(ldt.format(tF) + "\t" +s.getDesc());
			ldt = ldt.plusMinutes(s.getMins());
		}
	}
}
