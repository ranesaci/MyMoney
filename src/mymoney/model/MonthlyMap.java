package mymoney.model;

import java.util.Arrays;
import java.util.List;

public class MonthlyMap {
	private static List<String> list = Arrays.asList("JANUARY", "FEBRUARY", "MARCH","APRIL", "MAY",
			"JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER");
	
	public static int getMonthIndex(String month) {
		return list.indexOf(month);
	}
	
	public static String getMonthByIndex(int index) {
		return list.get(index);
	}
	

}
