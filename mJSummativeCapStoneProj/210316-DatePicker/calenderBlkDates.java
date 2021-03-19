package com.ntuc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class calenderBlkDates {

	// Array of Blockdates with Localdate startDate and Integer period
	public static String[] fdates(List<Blockdate> listBddates) {
		
		LocalDate abcDate2 = LocalDate.parse("2021-04-20");
		LocalDate[] listdates1;
		listdates1 = dateRange(abcDate2, 3);
		LocalDate abcDate3 = LocalDate.parse("2021-03-22");
		LocalDate[] listdates3;
		listdates3 = dateRange(abcDate3, 3);

		LocalDate[] mergedates = mergeDates(listdates1, listdates3 );

		return  finalDates(mergedates);
	}
	
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

	
	public static <T> Object[] mergeArray(T[] arr1, T[] arr2)   
	{   
		return Stream.of(arr1, arr2).flatMap(Stream::of).toArray();   
	}   

	public static LocalDate[] dateRange(LocalDate start, Integer daysNo) {
		LocalDate[] dateRange = new LocalDate[daysNo];
		for(int i=0;i<daysNo;i++) {
			dateRange[i] = start.plusDays(i);
			//System.out.println("=====> dateRange: " + dateRange[i] );
		}
		
		return dateRange;
	}
	
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
	

    //Stream of dates with 1 day difference
    public static List<LocalDate> getDaysInJava8(LocalDate start, int days) 
    {
        return Stream.iterate(start, date -> date.plusDays(1))
                .limit(days)
                .collect(Collectors.toList());
    }
    
}
