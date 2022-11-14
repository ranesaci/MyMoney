package mymoney.model;

public class Fund {
	private int amount;
	private int amountAfterSip;
	private int amountAfterMarketChange;
	private int amountAfterRebalance;
	
	public Fund(int amount) {
		this.amount = amount;
	}
	
	public void sip(int sipAmount) {
		if (amountAfterRebalance > 0) {
			this.amountAfterSip = amountAfterRebalance + sipAmount;
		} else if (amountAfterMarketChange > 0) {
			this.amountAfterSip = amountAfterMarketChange + sipAmount;
		} else {
			this.amountAfterSip = this.amount + sipAmount;
		}
		
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAmountAfterSip() {
		return amountAfterSip;
	}

	public void setAmountAfterSip(int amountAfterSip) {
		this.amountAfterSip = amountAfterSip;
	}

	public int getAmountAfterMarketChange() {
		return amountAfterMarketChange;
	}

	public void setAmountAfterMarketChange(int amountAfterMarketChange) {
		this.amountAfterMarketChange = amountAfterMarketChange;
	}

	public int getAmountAfterRebalance() {
		return amountAfterRebalance;
	}

	public void setAmountAfterRebalance(int amountAfterRebalance) {
		this.amountAfterRebalance = amountAfterRebalance;
	}

	

}
