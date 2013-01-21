package dao.impl;

import java.util.List;

import dao.TransactionDao;

public class TransactionDaoImpl extends HibernateBaseDaoImpl implements TransactionDao {

	@Override
	public List<Double> getAmountForCheckAndBuy(int customer_id) {
		List<Object> list = this.findByHQL("from Customer c where c.username = '" + username + "'");
		if(list.size() > 0) {
			return true;
		}
		return false;
	}

}
