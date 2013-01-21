package dao.impl;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Transaction;

import dao.TransactionDao;

public class TransactionDaoImpl extends HibernateBaseDaoImpl implements TransactionDao {

	@Override
	public List<Double> getAmountForCheckAndBuyByCustomer(Customer c) {
		List<Object> list1 = this.findByHQL("from Transaction t where t.customer = '" + c
				+ "' and t.execute_date = '" + null
				+ "' and t.transaction_type = '" + Transaction.CHECK + "'");
		List<Object> list2 = this.findByHQL("from Transaction t where t.customer = '" + c
				+ "' and t.execute_date = '" + null
				+ "' and t.transaction_type = '" + Transaction.BUY + "'");
		list1.addAll(list2);
		if(list1.size() == 0) {
			return null;
		}
		List<Double> amountList = new ArrayList<Double>();
		for(Object o : list1) {
			amountList.add(((Transaction) o).getAmount());
		}
		return amountList;
	}

}
