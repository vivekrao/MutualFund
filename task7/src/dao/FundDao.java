package dao;

import model.Fund;

public interface FundDao {
	public boolean isExistedFund(String name);
	public boolean createFund(Fund f);
}
