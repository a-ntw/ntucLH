package carDate;

import java.sql.Time;
import java.time.LocalDate;

public class BusinessConfig {

	private LocalDate dateEff; 
	private int gracePeriod; 
	private Time openTime; 
	private Time returnTime;
	private Time hireTime;
	private Time closeTime;
	private int hourlyRate;
	private int extraTimeSurcharge;
	private int weekendSurcharge;
	
	public LocalDate getDateEff() {
		// Date this config becomes effective.  There can be multple config records in the database.
		return dateEff;
	}

	public int getGracePeriod() {
		// Actual start and end time of a hire can be overrided to no more than 30 minutes before and after the clock.
		return 30;
	}
	public Time getOpenTime() {
		// Office opens at, 09:00
		return Time.valueOf("09:00:00");
	}
	public Time getReturnTime() {
		// Hired cars should return by 12:00
		return Time.valueOf("12:00:00");
	}
	public Time getHireTime() {
		// Hired cars can be collected starting 14:00
		return Time.valueOf("14:00:00");
	}
	public Time getCloseTime() {
		// office closes at 21:00
		return Time.valueOf("21:00:00");
	}
	public int getHourlyRate() {
		// Extra time charged hourly at 5% of daily rate 
		return 5;
	}
	public int getExtraTimeSurcharge() {
		// For return of vehicle beyond dtsEnd, 10% levy 
		return 10;
	}
	public int getWeekendSurcharge() {
		// Weekend hires attracts 10% levy  --- not yet implemented..
		return 10;
	}
	
	public void setDateEff(LocalDate dateEff) {
		this.dateEff = dateEff;
	}
	
	
}
