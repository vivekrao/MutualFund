package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import model.Employee;

import dao.EmployeeDao;
import dao.impl.EmployeeDaoImpl;


import form.LoginForm;

public class EmployeeLoginAction extends Action{
	private FormBeanFactory<LoginForm> formBeanFactory = FormBeanFactory.getInstance(LoginForm.class);
		
	private EmployeeDaoImpl employeeDaoImpl;
		
	public EmployeeLoginAction(EmployeeDaoImpl employeeDaoImpl) {
		this.employeeDaoImpl = employeeDaoImpl;
	}
	
	public String getName() { return "employeeLogin.do";}
		
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors",errors);
			
		try {
			LoginForm form = formBeanFactory.create(request);
			request.setAttribute("form",form);
			
			if(!form.isPresent()) {
				return "index.jsp";
			}
			
			errors.addAll(form.getValidationErrors());
			if(errors.size() != 0) {
				return"index.jsp";
			}
				
			Employee employee = employeeDaoImpl.getEmployeeByName(form.getUserName());
				
			if(!employeeDaoImpl.isExistedEmployee(form.getUserName())) {
				errors.add("User Name not found");
				return "index.jsp";
			}
				
			if(!employee.getPassword().equals(form.getPassword())) {
				errors.add("Incorrect password");
				return "index.jsp";
			}
			
			// Attach (this copy of) the user bean to the session
	        HttpSession session = request.getSession();
	        session.setAttribute("employee",employee);
	
			
			// After successful login send to...
	        /*String redirectTo = (String) session.getAttribute("redirectTo");
	        if (redirectTo != null) return redirectTo;
	        
	        
	        // If redirectTo is null, redirect to the "manage" action
			String webapp = request.getContextPath();
			return webapp + "/manage.do";	*/
	        request.setAttribute("message","Employee "+employee.getFirstname()+employee.getLastname()+" logged in sucessfully.");
			return "success.jsp";
        } catch (RuntimeException e) {
        	errors.add(e.getMessage());
        	return "index.jsp";
	    } catch (FormBeanException e) {
	       	errors.add(e.getMessage());
        	return "index.jsp";
	       }
		
	}
}
