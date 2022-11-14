package mymoney.helper;

import mymoney.util.MyMoneyUtils;

public class MyMoneyHelper {
	private String[] strDataArr;
	private int equityPercent;
	private int debitPercent;
	private int goldPercent;
	private String month;
	
	
	public MyMoneyHelper(String str) {
		this.strDataArr = str.split(" ");
		
	}




	public String getMonth() {
		return strDataArr[4];
	}




	public double getEquityPercent() {
		return MyMoneyUtils.removePercentFromString(strDataArr[1]);
	}


	public double getDebitPercent() {
		return MyMoneyUtils.removePercentFromString(strDataArr[2]);
	}


	public double getGoldPercent() {
		return MyMoneyUtils.removePercentFromString(strDataArr[3]);
	}




	

}
