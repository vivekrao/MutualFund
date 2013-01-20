package dao;

import model.Employee;

public interface EmployeeDao {
	public boolean isExistedEmployee(String username);
	public boolean createEmployee(Employee e);
}
