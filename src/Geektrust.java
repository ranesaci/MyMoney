import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import mymoney.IMyMoney;
import mymoney.MyMoney;
import mymoney.util.MyMoneyUtils;

public class Geektrust {

	public static void main(String[] args) throws IOException {
		
		String filePath = args[0];
		//Parse the file and call your code
		List<String> list = Files.readAllLines(Paths.get(filePath));
		
		//Print the output
		

		IMyMoney myMoney = new MyMoney();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).startsWith("ALLOCATE")) {
				int[] allocates = MyMoneyUtils.getAllocates(list.get(i));
				myMoney.allocate(allocates[1], allocates[2], allocates[3]);
			}
			if (list.get(i).startsWith("SIP")) {
				int[] sips = MyMoneyUtils.getSIPs(list.get(i));
				myMoney.sip(sips[1], sips[2], sips[3]);
			}
			if (list.get(i).startsWith("CHANGE")) {

				myMoney.change(list.get(i));
			}
			if (list.get(i).startsWith("BALANCE")) {
				String month = MyMoneyUtils.getMonth(list.get(i));
				myMoney.balance(month);
			}
			if (list.get(i).startsWith("REBALANCE")) {

				myMoney.reBalance();
			}

		}

	}

}
