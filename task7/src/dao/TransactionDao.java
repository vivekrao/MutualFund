package dao;

import java.util.List;

public interface TransactionDao {
	public List<Double> getAmountForCheckAndBuy(int customer_id);
	
}
