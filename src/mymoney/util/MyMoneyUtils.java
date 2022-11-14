package mymoney.util;

import mymoney.model.Fund;
import mymoney.model.PortFolio;

public class MyMoneyUtils {
	
	public static double removePercentFromString(String str) {
		return Double.valueOf(str.replace("%", ""));
	}
	
	public static PortFolio getnewMonthlyPortFolio(PortFolio inputPortFolio) {
		PortFolio  portFolio;
		if (inputPortFolio.getEquity().getAmountAfterRebalance() > 0) {
			portFolio = new PortFolio(inputPortFolio.getEquity().getAmountAfterRebalance(), 
					inputPortFolio.getDebit().getAmountAfterRebalance(), 
					inputPortFolio.getGold().getAmountAfterRebalance());
		} else if (inputPortFolio.getEquity().getAmountAfterMarketChange() > 0) {
			portFolio = new PortFolio(inputPortFolio.getEquity().getAmountAfterMarketChange(), 
					inputPortFolio.getDebit().getAmountAfterMarketChange(), 
					inputPortFolio.getGold().getAmountAfterMarketChange());
		} else {
			portFolio = new PortFolio(inputPortFolio.getEquity().getAmount(), 
					inputPortFolio.getDebit().getAmount(), 
					inputPortFolio.getGold().getAmount());
		}
	    
		
		return portFolio;
	}

	public static void change(Fund fund, double percent) {
		
		if (fund.getAmountAfterRebalance() > 0) {
			fund.setAmountAfterMarketChange(getPercentValue(fund.getAmountAfterRebalance(), percent));
		} else if (fund.getAmountAfterSip() > 0) {
			fund.setAmountAfterMarketChange(getPercentValue(fund.getAmountAfterSip(), percent));
		} else {
			fund.setAmountAfterMarketChange(getPercentValue(fund.getAmount(), percent));
		}
		
		
	}
	
	public static int getPercentValue(int number, double percent) {
		return (int) (number + (number * percent/100));
	}
	
	public static void main(String[] args) {
		int value = getPercentValue(200, 40);
		System.out.println(value);
	}

	public static void rebalance(PortFolio portFolio) {
		int total = portFolio.getEquity().getAmountAfterMarketChange()
				+ portFolio.getDebit().getAmountAfterMarketChange()
				+ portFolio.getGold().getAmountAfterMarketChange();
		
		portFolio.getEquity().setAmountAfterRebalance(MyMoneyUtils.getRebalance(total, 60));
		portFolio.getDebit().setAmountAfterRebalance(MyMoneyUtils.getRebalance(total, 30));
		portFolio.getGold().setAmountAfterRebalance(MyMoneyUtils.getRebalance(total, 10));
		
	}

	private static int getRebalance(int total, int percent) {
		
		return total * percent/100;
	}

	public static int[] getAllocates(String data) {
		
		String[] arr = data.split(" ");
		int[] retArr = new int[arr.length];
		retArr[1] = Integer.valueOf(arr[1]);
		retArr[2] = Integer.valueOf(arr[2]);
		retArr[3] = Integer.valueOf(arr[3]);
		return retArr;
	}

	public static int[] getSIPs(String data) {
		String[] arr = data.split(" ");
		int[] retArr = new int[arr.length];
		retArr[1] = Integer.valueOf(arr[1]);
		retArr[2] = Integer.valueOf(arr[2]);
		retArr[3] = Integer.valueOf(arr[3]);
		return retArr;
	}

	public static int[] getChange(String data) {
		String[] arr = data.split(" ");
		int[] retArr = new int[arr.length];
		retArr[1] = Integer.valueOf(arr[1]);
		retArr[2] = Integer.valueOf(arr[2]);
		retArr[3] = Integer.valueOf(arr[3]);
		retArr[4] = Integer.valueOf(arr[4]);
		return retArr;
	}

	public static String getMonth(String data) {
		String[] strArr = data.split(" ");
		return strArr[1];
	}

}
