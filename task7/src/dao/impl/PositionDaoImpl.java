package dao.impl;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Fund;
import model.PKPosition;
import model.Position;
import dao.PositionDao;

public class PositionDaoImpl extends HibernateBaseDaoImpl implements PositionDao {

	@Override
	public boolean createPosition(Position p) {
		return this.save(p);
	}

	@Override
	public int getSharesByCustomerAndFund(Customer c, Fund f) {
		Position p = (Position) this.get(Position.class, new PKPosition(c, f));
		if(p == null) {
			return -1;
		}
		return p.getShares();
	}

	@Override
	public List<Fund> getAllFundByCustomer(Customer c) {
		List<Object> list = this.findByHQL("from Position p where p.customer = " + c);
		if(list.size() == 0) {
			return null;
		}
		List<Fund> fundList = new ArrayList<Fund>();
		for(Object o : list) {
			fundList.add(((Position) o).getFund());
		}
		return fundList;
	}

}
