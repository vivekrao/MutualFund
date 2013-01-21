package dao;

import java.util.List;

import model.Customer;
import model.Fund;
import model.Position;

public interface PositionDao {
	//Create new position.
	public boolean createPosition(Position p);
	//Get shares by customer's id.
	public int getSharesByCustomerAndFund(Customer c, Fund f);
	//Get all funds of customer through customer's id.
	public List<Fund> getAllFundByCustomer(Customer c);
}
