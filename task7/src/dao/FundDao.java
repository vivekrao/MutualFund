package dao;

import model.Fund;

public interface FundDao {
	//Check whether fund is existed through fund name.
	public boolean isExistedFund(String name);
	//Create new fund in database.
	public boolean createFund(Fund f);
}
