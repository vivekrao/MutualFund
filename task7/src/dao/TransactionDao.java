package dao;

import java.util.List;

import model.Customer;

public interface TransactionDao {
	//Get the amount of the pending transaction of check request and buy funds.
	public List<Long> getAmountForCheckAndBuyByCustomer(Customer c);
	
}
