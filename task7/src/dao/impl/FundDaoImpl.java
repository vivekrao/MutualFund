package dao.impl;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Fund;
import model.Position;
import model.Transaction;
import dao.FundDao;

public class FundDaoImpl extends HibernateBaseDaoImpl implements FundDao {

	@Override
	public synchronized boolean isExistedFund(String name) {
		List<Object> list = this.findByHQL("from Fund f where f.name = '" + name + "'");
		if(list.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public synchronized boolean createFund(Fund f) {
		return this.save(f);
	}

	@Override
	public synchronized long checkAvailablityOfFund(String name) {
		List<Object> list = this.findByHQL("from Fund f where f.name = '" + name + "'");
		if(list.size() > 0) {
			return ((Fund) list.get(0)).getLatestPrice();
		}
		return -1;
	}

	@Override
	public synchronized long checkAvailablityOfFund(String name, Customer c) {
		Fund f = this.findFundByName(name);
		List<Object> list = this.findByHQL("from Position p where p.fund_id = " + f.getFund_id());
		for(Object o : list) {
			Position p = (Position) o;
			if(p.getCustomer().equals(c)) {
				return f.getLatestPrice() * p.getShares();
			}
		}
		return -1;
	}

	@Override
	public synchronized Fund findFundByName(String name) {
		List<Object> list = this.findByHQL("from Fund f where f.name = '" + name + "'");
		return (Fund) list.get(0);
	}

	@Override
	public synchronized List<Fund> getFundHistory() {
		List<Object> list = this.findByHQL("from Fund f");
		if(list.size() == 0) {
			return null;
		}
		List<Fund> fundList = new ArrayList<Fund>();
		for(Object o : list) {
			fundList.add((Fund) o);
		}
		return fundList;
	}
	
	@Override
	public boolean isBalanceAvailable(Customer customer, long amount) {
		return true;
	}
	
	@Override
	public void buyFundTransaction(Transaction transaction) {
		this.save(transaction);
	}
	
	@Override
	public synchronized List<Fund> getCustomerFunds(Customer customer) {
		
		List<Object> list = this.findByHQL("from Position p where p.customer_id = " + customer.getCustomer_id());
		
		if(list!=null && list.size() > 0) {
			return (List<Fund>) ((Fund) list);
		}
		return null;
	}

}
