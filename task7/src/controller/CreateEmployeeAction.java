/**
 * andrew ID: chenc2
 * name:Chen Chen
 * date:5th Dec
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Employee;

import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;
import dao.EmployeeDao;
import dao.impl.EmployeeDaoImpl;
import form.CreateEmployeeForm;


public class CreateEmployeeAction extends Action {
	private FormBeanFactory<CreateEmployeeForm> formBeanFactory = FormBeanFactory.getInstance(CreateEmployeeForm.class);

	private EmployeeDaoImpl employeeDaoImpl;
	
	public CreateEmployeeAction(EmployeeDaoImpl employeeDaoImpl) {
		this.employeeDaoImpl = employeeDaoImpl;
	}

	public String getName() { return "createEmployee.do"; }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);

        try {
	        CreateEmployeeForm form = formBeanFactory.create(request);
	        request.setAttribute("form",form);
	        //request.setAttribute("userList", userDAO.getUsers());
	
	        // If no params were passed, return with no errors so that the form will be
	        // presented (we assume for the first time).
	        if (!form.isPresent()) {
	            return "createEmployeeAccount.jsp";
	        }
	
	        // Any validation errors?
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	            return "createEmployeeAccount.jsp";
	        }
	        
	        if(employeeDaoImpl.isExistedEmployee(form.getUsername())){
	        	errors.add("The user is existed");
	        	return "createEmployeeAccount.jsp";
	        }
	
	        // Create the user bean
	        Employee employee = new Employee();
	        employee.setUsername(form.getUsername());
	        employee.setFirstname(form.getFirstName());
	        employee.setLastname(form.getLastName());
	        employee.setPassword(form.getPassword());
	        employeeDaoImpl.createEmployee(employee);
        
			// Attach (this copy of) the user bean to the session
	        //HttpSession session = request.getSession(false);
	       // session.setAttribute("employee",employee);
	
	        // After successful registration (and login) send to...
	        /*String redirectTo = (String) session.getAttribute("redirectTo");
	        if (redirectTo != null) return redirectTo;*/
	        
	        // If redirectTo is null, redirect to the "manage" action
	        request.setAttribute("message","New Account for Employee "+employee.getFirstname()+employee.getLastname()+" has been created sucessfully.\n User Name is "+employee.getUsername());
			return "success.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "createEmployeeAccount.jsp";
        }
    }
}
