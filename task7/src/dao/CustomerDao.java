package dao;

import model.Customer;

public interface CustomerDao {
	//Check whether the customer is existed through username.
	public boolean isExistedCustomer(String username); 
	//Update the customer with the new password.
	public boolean changePassword(Customer c, String newPassword);
	//Get customer through customer id.
	public Customer getCustomerById(int id);
	//Create new customer in database.
	public boolean createCustomer(Customer c);
	//Get customer's cash through customer id.
	public double getCashByCustomerId(int customer_id);
	//Get customer's name by id.
	public String getNameById(int customer_id);
	//Get customer's address by id.
	public String getAddrById(int customer_id);
	//Get customer through username
	public Customer getCustomerByName(String username);
}
