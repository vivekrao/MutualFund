package dao;

import model.Employee;

public interface EmployeeDao {
	//Check whether employee is existed through username.
	public boolean isExistedEmployee(String username);
	//Create new employee in database.
	public boolean createEmployee(Employee e);
}
