package ua.lvivl.trainapplogos;

import java.util.ArrayList;
import java.util.Scanner;

public class Application2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String month_str;	
		
		while (true) {
			System.out.println("\n> Enter month: ");
			month_str = sc.next().toUpperCase();
					
			Months month;
			Seasons[] seasons = Seasons.values();
			
			month = monthExists(month_str);
			
			if (month != null) {
				//#1
				System.out.println("> #1: The month " + month_str + " is exists"); 
				
				//#2
				System.out.println("> #2: All months with the same season:");
				Months[] samemonths = returnMonths(2, month.getSeason().name(), 0);
				
				//#3
				System.out.println("> #3: All months with the same amount of days:");
				Months[] samedays = returnMonths(3, null, month.getDays());
				
				//#4
				System.out.println("> #4: All months with less amount of days:");
				Months[] lessdays =  returnMonths(4, null, month.getDays());
						
				//#5
				System.out.println("> #5: All months with more amount of days:");
				Months[] moredays = returnMonths(5, null, month.getDays());
						
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
				Months[] odddays = returnMonths(8, null, month.getDays());
						
				//#9
				System.out.println("> #9: All months with even amount of days:");
				Months[] evendays = returnMonths(9, null, month.getDays());
						
				//#10
				
				if (month.getDays() % 2 == 0) {
					System.out.println("> #10: The month " + month_str + " has odd amount of days");
				} else {
					System.out.println("> #10: The month " + month_str + " hasn't odd amount of days");
				}
				
				System.out.println("___________________________________________________________________\n");
			
			} else {
				System.out.println("> #1: Month doesn't exist");
			}
			
		}
	}
	
	//#1
	public static Months monthExists(String month_str) {
		Months[] months = Months.values();
		Months month = null;
		
		for (Months month_val : months) {
			if (month_val.name().equalsIgnoreCase(month_str)) {
				month = month_val;
				break;
			} 
		}
		return month;
	}
	
	public static Months[] returnMonths (int func, String season, int days) {
		Months[] months = Months.values();
		ArrayList <Months> months_res = new ArrayList<>();
		boolean flag = false;
		
		for (Months month : months) {
			//func is equal number of task
			switch  (func) {
			case 2:
				if (month.getSeason().name() == season) flag = true;
				break;
			case 3:
				if (month.getDays() == days) flag = true;
				break;
			case 4:
				if (month.getDays() < days) flag = true;
				break;
			case 5:
				if (month.getDays() > days) flag = true;
				break;
			case 8:
				if (month.getDays() % 2 == 0) flag = true;
				break;
			case 9:
				if (month.getDays() % 2 != 0) flag = true;
				break;
			}
			
			if (flag) {
				months_res.add(month);
				System.out.println("   -" + month.name());
			}
		}
		return months_res.toArray(new Months[0]);	
	}
	
}