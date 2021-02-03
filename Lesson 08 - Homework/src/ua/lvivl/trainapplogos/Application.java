package ua.lvivl.trainapplogos;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String month_str;	
		
		while (true) {
			System.out.println("\n> Enter month: ");
				
			month_str = sc.next().toUpperCase();
					
			Months[] months = Months.values();
			Months month;
			Seasons[] seasons = Seasons.values();
			
			month = monthExists(months, month_str);
			
			
			if (month != null) {
				//#1
				System.out.println("> #1: The month " + month_str + " is exists"); 
				
				//#2
				System.out.println("> #2: All months with the same season:");
				Months[] samemonths = getMonthsBySeason(months, month.getSeason().name()); 
				
				//#3
				System.out.println("> #3: All months with the same amount of days:");
				Months[] samedays = getMonthsByDays(months, month.getDays());
				
				//#4
				System.out.println("> #4: All months with less amount of days:");
				Months[] lessdays = getMonthsWithLessDays(months, month.getDays());
				
				//#5
				System.out.println("> #5: All months with more amount of days:");
				Months[] moredays = getMonthsWithMoreDays(months, month.getDays());
				
				//#6
				int nextSeasonInd = month.getSeason().ordinal() + 1;
				if (nextSeasonInd == 4)	nextSeasonInd = 0;
					
				System.out.println("> #6: The next season is " + seasons[nextSeasonInd].name());
				
				//#7
				int previousSeasonInd = month.getSeason().ordinal() - 1;
				if (previousSeasonInd == -1) previousSeasonInd = 3;
					
				System.out.println("> #7: The previous season is " + seasons[previousSeasonInd].name());
				
				//#8
				System.out.println("> #8: All months with odd amount of days:");
				Months[] odddays = getMonthsWithOddDays(months);
				
				//#9
				System.out.println("> #9: All months with even amount of days:");
				Months[] evendays = getMonthsWithEvenDays(months);
				
				//#10
				
				if (month.getDays() % 2 == 0) {
					System.out.println("> #10: The month " + month_str + " has odd amount of days");
				} else {
					System.out.println("> #10: The month " + month_str + " hasn't odd amount of days");
				}
				
				System.out.println("______________________________________________________________\n");
			
			} else {
				System.out.println("> #1: Month doesn't exist");
			}
			
		}
	}
	
	//#1
	public static Months monthExists(Months [] months, String month_str) {
		Months month = null;
		
		for (Months month_val : months) {
			if (month_val.name().equalsIgnoreCase(month_str)) {
				month = month_val;
				break;
			} 
		}
		return month;
	}
	
	//#2
	public static Months[] getMonthsBySeason(Months[] months, String season) {
		ArrayList <Months> months_res = new ArrayList<>();
		
		for (Months month : months) {
			if (month.getSeason().name() == season) {
				months_res.add(month);
				System.out.println("   -" + month.name());
			}
		}
		return months_res.toArray(new Months[0]);
	}
	
	//#3
	public static Months[] getMonthsByDays(Months[] months, int days) {
		ArrayList <Months> months_res = new ArrayList<>();
		
		for (Months month : months) {
			if (month.getDays() == days) {
				months_res.add(month);
				System.out.println("   -" + month.name());
			}
		}
		return months_res.toArray(new Months[0]);
	}
	
	//#4
	public static Months[] getMonthsWithLessDays(Months[] months, int days) {
		ArrayList <Months> months_res = new ArrayList<>();
		
		for (Months month : months) {
			if (month.getDays() < days) {
				months_res.add(month);
				System.out.println("   -" + month.name());
			}
		}
		return months_res.toArray(new Months[0]);
	}
	
	//#5
	public static Months[] getMonthsWithMoreDays(Months[] months, int days) {
		ArrayList <Months> months_res = new ArrayList<>();
		
		for (Months month : months) {
			if (month.getDays() > days) {
				months_res.add(month);
				System.out.println("   -" + month.name());
			}
		}
		return months_res.toArray(new Months[0]);
	}
	
	//#6
	public static Months[] getMonthsWithOddDays(Months[] months) {
		ArrayList <Months> months_res = new ArrayList<>();
		
		for (Months month : months) {
			if (month.getDays() % 2 == 0) {
				months_res.add(month);
				System.out.println("   -" + month.name());
			}
		}
		return months_res.toArray(new Months[0]);
	}
	
	//#7
	public static Months[] getMonthsWithEvenDays(Months[] months) {
		ArrayList <Months> months_res = new ArrayList<>();
		
		for (Months month : months) {
			if (month.getDays() % 2 != 0) {
				months_res.add(month);
				System.out.println("   -" + month.name());
			}
		}
		return months_res.toArray(new Months[0]);
	}
	
}
