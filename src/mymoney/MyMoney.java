package mymoney;

import java.util.Map;
import java.util.TreeMap;

import mymoney.helper.MyMoneyHelper;
import mymoney.model.MonthlyMap;
import mymoney.model.PortFolio;
import mymoney.model.SIP;
import mymoney.util.MyMoneyUtils;

public class MyMoney implements IMyMoney{
	
	private Map<String, PortFolio> map;
	private SIP sip;
	private static final String INITIAL_ENTRY = "INITIAL";
	
	
	public MyMoney() {
		this.map = new TreeMap<>();
	}

	@Override
	public void allocate(int equity, int debit, int gold) {
		PortFolio portFolio = new PortFolio(equity, debit, gold);
		
		map.put(INITIAL_ENTRY, portFolio);
		
	}

	@Override
	public void sip(int equity, int debit, int gold) {
		sip = new SIP.SIPBuilder()
				.setEquity(equity)
				.setDebit(debit)
				.setGold(gold)
				.build();
		
	}

	@Override
	public void change(String changeStr) {
		//get changes and month
		MyMoneyHelper myMoneyHelper = new MyMoneyHelper(changeStr);
		String month = myMoneyHelper.getMonth();
		
		PortFolio newMonthlyPortfolio = null;
		int index = MonthlyMap.getMonthIndex(month);
		
		if (index== 0) {
			newMonthlyPortfolio = MyMoneyUtils.getnewMonthlyPortFolio(map.get(INITIAL_ENTRY));
			/*
			 * System.out.println("Initial entries:"+
			 * newMonthlyPortfolio.getEquity().getAmount()+ "::" +
			 * newMonthlyPortfolio.getDebit().getAmount()+ "::" +
			 * newMonthlyPortfolio.getGold().getAmount()+ "::" );
			 */
			
			//apply change
			newMonthlyPortfolio.change(myMoneyHelper);
			
			/*
			 * System.out.println("Balance 0f "+ month);
			 * System.out.println(newMonthlyPortfolio.getEquity().getAmountAfterMarketChange
			 * () + " "+ newMonthlyPortfolio.getDebit().getAmountAfterMarketChange()+" "+
			 * newMonthlyPortfolio.getGold().getAmountAfterMarketChange());
			 */
		}
		
		if (index != 0) {
			//sip
			//apply change
			//rebalance
			newMonthlyPortfolio = MyMoneyUtils.getnewMonthlyPortFolio(map.get(MonthlyMap.getMonthByIndex(index-1)));
			
			/*
			 * System.out.println("Initial 0f "+ month);
			 * System.out.println(newMonthlyPortfolio.getEquity().getAmount() + " "+
			 * newMonthlyPortfolio.getDebit().getAmount()+" "+
			 * newMonthlyPortfolio.getGold().getAmount());
			 */
			
			newMonthlyPortfolio.sip(sip);
			
			/*
			 * System.out.println("After SIP 0f "+ month);
			 * System.out.println(newMonthlyPortfolio.getEquity().getAmountAfterSip() + " "+
			 * newMonthlyPortfolio.getDebit().getAmountAfterSip()+" "+
			 * newMonthlyPortfolio.getGold().getAmountAfterSip());
			 */
			
			newMonthlyPortfolio.change(myMoneyHelper);
			/*
			 * System.out.println("after market change 0f "+ month);
			 * System.out.println(newMonthlyPortfolio.getEquity().getAmountAfterMarketChange
			 * () + " "+ newMonthlyPortfolio.getDebit().getAmountAfterMarketChange()+" "+
			 * newMonthlyPortfolio.getGold().getAmountAfterMarketChange());
			 */
			
			if (month.equals("JUNE") || month.equals("DECEMBER")) {
				newMonthlyPortfolio.rebalance();
			}
			
			
		}
		
		map.put(month, newMonthlyPortfolio);
		
	}


	@Override
	public void balance(String month) {
		
			PortFolio folio = map.get(month);
			System.out.println(folio.getEquity().getAmountAfterMarketChange() + " "+ 
			folio.getDebit().getAmountAfterMarketChange()+" "+ 
			folio.getGold().getAmountAfterMarketChange());
	}

	@Override
	public void reBalance() {
		PortFolio folio = null;
		if (map.size()>= 7 && map.size() < 12) {
			 folio = map.get("JUNE");
		} else if (map.size() >= 12) {
			folio = map.get("DECEMBER");
		} else {
			System.out.println("CANNOT_REBALANCE");
		}
		
		if (null != folio) {
			System.out.println(folio.getEquity().getAmountAfterRebalance() + " "+ 
					folio.getDebit().getAmountAfterRebalance()+" "+ 
					folio.getGold().getAmountAfterRebalance());
		}
		
	}
	
	

}
