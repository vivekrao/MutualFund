package dao.impl;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import dao.CustomerDao;

public class CustomerDaoImpl extends HibernateBaseDaoImpl implements CustomerDao {

	@Override
	public boolean isExistedCustomer(String username) {
		List<Object> list = this.findByHQL("from Customer c where c.username = '" + username + "'");
		if(list.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean changePassword(Customer c, String newPassword) {
		c.setPassword(newPassword);
		return this.update(c);
	}

	@Override
	public boolean createCustomer(Customer c) {
		return this.save(c);
	}

	@Override
	public double getCashByCustomerId(int customer_id) {
		Customer c = this.getCustomerById(customer_id);
		if(c == null) {
			return -1;
		}
		return c.getCash();
	}
	
	@Override
	public Customer getCustomerById(int id) {
		return (Customer) this.get(Customer.class, new Integer(id));
	}

	@Override
	public String getNameById(int customer_id) {
		Customer c = this.getCustomerById(customer_id);
		if(c == null) {
			return null;
		}
		return c.getUsername();
	}
	
	@Override
	public String getAddrById(int customer_id) {
		Customer c = this.getCustomerById(customer_id);
		if(c == null) {
			return null;
		}
		return c.getAddr_line1() + " " + c.getAddr_line2();
	}
	
	@Override
	public Customer getCustomerByName(String username) {
		List<Object> list = this.findByHQL("from Customer c where c.username = '" + username + "'");
		if(list.size() > 0) {
			return (Customer) list.get(0);
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Object> list = this.findByHQL("from Customer c");
		if(list.size() == 0) {
			return null;
		}
		List<Customer> customerList = new ArrayList<Customer>();
		for(Object o : list) {
			customerList.add((Customer) o);
		}
		return customerList;
	}

}
