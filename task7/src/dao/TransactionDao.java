package dao;

import java.util.List;

import model.Customer;
import model.Transaction;

public interface TransactionDao {
	//Get the amount of the pending transaction of check request and buy funds.
	public List<Long> getAmountForCheckAndBuyByCustomer(Customer c);
	//Get all transaction history of customer
	public List<Transaction> getTransactionHistory(Customer c);
}
