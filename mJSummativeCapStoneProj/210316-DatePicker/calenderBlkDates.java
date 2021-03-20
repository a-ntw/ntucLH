package com.ntuc;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

public class calenderBlkDates {
	
	@Autowired Blockdate d;
	@Autowired bdatesRepository repo;
	
	/** Return String[] of d/M/yyyy dates,  from List<Blockdates> 
	 * with LocalDate startDate and Integer period
     *
     * @param 
     * @return String[] **/
	public static String[] fdates(List<Blockdate> listBddates) {

		//listBddates.forEach(b -> System.out.println("Dates blocked: " + b.getBdate() 
		//								+ " to " + b.getEdate() ));
		
		//listBddates	.forEach(b -> Stream.of(listDates(b.getBdate(),b.getEdate()))
		//			.forEach(s -> System.out.println("Stream :: " + s)));

		LocalDate dummyDate = LocalDate.parse("2021-04-01");
		LocalDate[] mergedates;
		mergedates = dateRange(dummyDate, 0);
		
		for (Blockdate bd: listBddates){

			LocalDate[] ld = listDates(bd.getBdate(), bd.getEdate().plusDays(1));
			mergedates = mergeDates(mergedates, ld );

			}

		//Stream.of(mergedates).forEach(s -> System.out.println("mergedates :: " + s));
		return  finalDates(mergedates);
		
	}

	/** Return LocaDate[] of merge LocalDate[] A and LocalDate[] B
	 * @param
	 * @return LocalDate[] **/
	public static LocalDate[] mergeDates(LocalDate[] listA, LocalDate[] listB) {
		int length = listA.length + listB.length;
		LocalDate[] mergedates = new LocalDate[length];
		int pos =0;
		for (LocalDate element : listA)
		{ mergedates[pos] = element; pos ++;}
		for (LocalDate element : listB)
		{ mergedates[pos] = element; pos ++;}
		//Stream.of(mergedates).forEach(s -> System.out.println("Stream :: " + s));
		
		return mergedates;
	}
	
	/** return LocalDate[] array all dates from LocalDate start and end (exclude)
	 * @param
	 * @return LocalDate[] **/
	public static LocalDate[] listDates(LocalDate start, LocalDate end) {
		Integer getDays = getDays(start, end);
		LocalDate[] listDate = dateRange(start, getDays);
		return listDate;
	}
	
	/** return Integer of days between LocalDate start date and end date 
	 * @param
	 * @return Integer	 **/
	public static Integer getDays(LocalDate start, LocalDate end) {
		Period period = Period.between(start, end);
		Integer getDays = period.getDays();
		return getDays;
	}
	
	/* not use */
	public static <T> Object[] mergeArray(T[] arr1, T[] arr2)   
	{   
		return Stream.of(arr1, arr2).flatMap(Stream::of).toArray();   
	}   

	/** return LocalDate[] with range of LocalDate start till end 
	 * @param
	 * @return LocalDate[]	 **/
	public static LocalDate[] dateRange(LocalDate start, Integer daysNo) {
		LocalDate[] dateRange = new LocalDate[daysNo];
		for(int i=0;i<daysNo;i++) {
			dateRange[i] = start.plusDays(i);
		}
		
		return dateRange;
	}
	
	/** return date format d/M/yyyy from LocalDate[] 
	 * @param
	 * @return String[]	 **/
	public static String[] finalDates(LocalDate[] listdates) {
		
		String[] finalDates= new String[listdates.length]; // size up first
	
		DateTimeFormatter dTF; 
		dTF = DateTimeFormatter.ofPattern("d/M/yyyy");

		for(int i=0;i<listdates.length;i++) {
			finalDates[i]=dTF.format(listdates[i]);
			//System.out.println("=====> finalDates: " + finalDates[i]);
		}

		return finalDates;
		
	}

    /** not use
     *  Stream of dates with 1 day difference */
    public static List<LocalDate> getDaysInJava8(LocalDate start, int days) 
    {
        return Stream.iterate(start, date -> date.plusDays(1))
                .limit(days)
                .collect(Collectors.toList());
    }
    
}
