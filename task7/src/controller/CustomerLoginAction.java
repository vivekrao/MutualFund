package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import form.LoginForm;
import model.Customer;

public class CustomerLoginAction extends Action {
	private FormBeanFactory<LoginForm> formBeanFactory = FormBeanFactory.getInstance(LoginForm.class);
	
	private CustomerDaoImpl customerDaoImpl;
	
	public CustomerLoginAction(CustomerDaoImpl customerDaoImpl) {
		this.customerDaoImpl = customerDaoImpl;
	}

	public String getName() { return "login1.do";}
	
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
			
			Customer customer = customerDaoImpl.getCustomerByName(form.getUserName());
			
			if(!customerDaoImpl.isExistedCustomer(form.getUserName())) {
				errors.add("User Name not found");
				return "index.jsp";
			}
			
			if(!customer.getPassword().equals(form.getPassword())) {
				errors.add("Incorrect password");
				return "index.jsp";
			}
			
			/*HttpSession session = request.getSession();
	        session.setAttribute("customer",customer);
			
			String webapp = request.getContextPath();
			return webapp + "/manage.do";//???*/
			request.setAttribute("message","Customer "+customer.getFirstname()+customer.getLastname()+" logged in sucessfully.");
			return "success.jsp";
        } catch (RuntimeException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
    }
}
