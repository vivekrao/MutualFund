package dao.impl;

import java.util.List;

import model.Fund;
import dao.FundDao;

public class FundDaoImpl extends HibernateBaseDaoImpl implements FundDao {

	@Override
	public boolean isExistedFund(String name) {
		List<Object> list = this.findByHQL("from Fund f where f.name = '" + name + "'");
		if(list.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean createFund(Fund f) {
		return this.save(f);
	}

}
