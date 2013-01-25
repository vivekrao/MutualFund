package dao;

import java.util.List;

import model.Customer;
import model.Fund;
import model.Transaction;

public interface FundDao {
	//Check whether fund is existed through fund name.
	public boolean isExistedFund(String name);
	//Create new fund in database.
	public boolean createFund(Fund f);
	//Check the availability of the fund for Buy Fund.
	public long checkAvailablityOfFund(String name);
	//Check the availability of the fund for Sell Fund.
	public long checkAvailablityOfFund(String name, Customer c);
	//Find fund by name.
	public Fund findFundByName(String name);
	//Find info of all funds.
	public List<Fund> getFundHistory();
	//Check the balance of customer
	public boolean isBalanceAvailable(Customer customer, long amount);
	//Send buy fund transaction to Transaction table as pending
	public void buyFundTransaction(Transaction transaction);
	//get fund list of customer
	public List<Fund> getCustomerFunds(Customer customer);
}
