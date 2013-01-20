package dao;

import model.Customer;

public interface CustomerDao {
	public boolean isExistedCustomer(String username);
	public boolean changePassword(Customer c, String oldPassword, String newPassword);
	public boolean createCustomer(Customer c);
}
