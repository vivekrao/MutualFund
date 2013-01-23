package dao.impl;

import java.util.List;

import model.Employee;
import dao.EmployeeDao;

public class EmployeeDaoImpl extends HibernateBaseDaoImpl implements EmployeeDao {

	@Override
	public boolean isExistedEmployee(String username) {
		List<Object> list = this.findByHQL("from Employee e where e.username = '" + username + "'");
		if(list.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean createEmployee(Employee e) {
		return this.save(e);
	}
	
	@Override
	public Employee getEmployeeByName(String username) {
		List<Object> list = this.findByHQL("from Employee c where c.username = '" + username + "'");
		if(list.size() > 0) {
			return (Employee) list.get(0);
		}
		return null;
	}

}
