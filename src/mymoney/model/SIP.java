package mymoney.model;

public class SIP {
	private int equity;
	private int debit;
	private int gold;
	
	private SIP(SIPBuilder sipBuilder) {
		this.equity = sipBuilder.equity;
		this.debit = sipBuilder.debit;
		this.gold = sipBuilder.gold;
	}

	public int getEquity() {
		return equity;
	}

	public int getDebit() {
		return debit;
	}

	public int getGold() {
		return gold;
	}
	
	public static class SIPBuilder {
		private int equity;
		private int debit;
		private int gold;
		public SIPBuilder setEquity(int equity) {
			this.equity = equity;
			return this;
		}
		public SIPBuilder setDebit(int debit) {
			this.debit = debit;
			return this;
			
		}
		public SIPBuilder setGold(int gold) {
			this.gold = gold;
			return this;
		}
		
		public SIP build() {
			return new SIP(this);
		}
		
		
	}
	
	

}
