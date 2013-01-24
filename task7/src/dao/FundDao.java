package dao;

import java.util.List;

import model.Customer;
import model.Fund;

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
}
