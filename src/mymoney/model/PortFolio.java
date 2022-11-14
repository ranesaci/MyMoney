package mymoney.model;

import mymoney.helper.MyMoneyHelper;
import mymoney.util.MyMoneyUtils;

public class PortFolio {
	private Fund equity;
	private Fund debit;
	private Fund gold;
	
	public PortFolio(int equity, int debit, int gold ) {
		this.equity = new Fund(equity);
		this.debit = new Fund(debit);
		this.gold = new Fund(gold);
	}
	
	public void sip(SIP sip) {
		this.equity.sip(sip.getEquity());
		this.debit.sip(sip.getDebit());
		this.gold.sip(sip.getGold());
	}
	
	public void change(MyMoneyHelper myMoneyHelper) {
		MyMoneyUtils.change(this.equity,myMoneyHelper.getEquityPercent());
		MyMoneyUtils.change(this.debit,myMoneyHelper.getDebitPercent());
		MyMoneyUtils.change(this.gold,myMoneyHelper.getGoldPercent());
		
		
	}
	public void rebalance() {
		MyMoneyUtils.rebalance(this);
	}

	public Fund getEquity() {
		return equity;
	}

	public void setEquity(Fund equity) {
		this.equity = equity;
	}

	public Fund getDebit() {
		return debit;
	}

	public void setDebit(Fund debit) {
		this.debit = debit;
	}

	public Fund getGold() {
		return gold;
	}

	public void setGold(Fund gold) {
		this.gold = gold;
	}
	
	

}
