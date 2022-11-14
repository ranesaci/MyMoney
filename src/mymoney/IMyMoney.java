package mymoney;

public interface IMyMoney {
	
	public void allocate(int equity, int debit, int gold);
	public void sip(int equity, int debit, int gold);
	public void change(String change);
	public void balance(String month);
	public void reBalance();
	

}
