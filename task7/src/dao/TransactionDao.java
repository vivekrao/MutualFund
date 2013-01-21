package dao;

import java.util.List;

public interface TransactionDao {
	//Get the amount of the pending transaction of check request and buy funds.
	public List<Double> getAmountForCheckAndBuy(int customer_id);
	
}
