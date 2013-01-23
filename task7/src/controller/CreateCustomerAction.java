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

import model.Customer;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import dao.impl.CustomerDaoImpl;

import form.CreateCustomerForm;


public class CreateCustomerAction extends Action {
	private FormBeanFactory<CreateCustomerForm> formBeanFactory = FormBeanFactory.getInstance(CreateCustomerForm.class);

	private CustomerDaoImpl customerDaoImpl;
	
	public CreateCustomerAction(CustomerDaoImpl customerDaoImpl) {
		this.customerDaoImpl = customerDaoImpl;
	}

	public String getName() { return "createCustomer.do"; }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);

        try {
	        CreateCustomerForm form = formBeanFactory.create(request);
	        request.setAttribute("form",form);
	        //request.setAttribute("userList", userDAO.getUsers());
	
	        // If no params were passed, return with no errors so that the form will be
	        // presented (we assume for the first time).
	        if (!form.isPresent()) {
	            return "createCustomerAccount.jsp";
	        }
	
	        // Any validation errors?
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	            return "createCustomerAccount.jsp";
	        }
	        
	        if(customerDaoImpl.isExistedCustomer(form.getUsername())){
	        	errors.add("The user is existed");
	        	return "createCustomerAccount.jsp";
	        }
	
	        // Create the user bean
	        Customer customer = new Customer();
	        customer.setUsername(form.getUsername());
	        customer.setAddr_line1(form.getAddressLine1());
	        customer.setAddr_line2(form.getAddressLine2());
	        customer.setCity(form.getCity());
	        customer.setFirstname(form.getFirstName());
	        customer.setLastname(form.getLastName());
	        customer.setPassword(form.getPassword());
	        customer.setState(form.getState());
	        customer.setZip(form.getZip()==null?0:Integer.parseInt(form.getZip()));
        	customerDaoImpl.createCustomer(customer);
        
			// Attach (this copy of) the user bean to the session
	    /*    HttpSession session = request.getSession(false);
	       // session.setAttribute("user",user);
	
	        // After successful registration (and login) send to...
	        String redirectTo = (String) session.getAttribute("redirectTo");
	        if (redirectTo != null) return redirectTo;*/
	        
	        // If redirectTo is null, redirect to the "manage" action
			/*String webapp = request.getContextPath();
			return webapp + "/manage.do";*/
        	request.setAttribute("message","New Account for Customer "+customer.getFirstname()+customer.getLastname()+" has been created sucessfully.\n User Name is "+customer.getUsername());
			return "success.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "createCustomerAccount.jsp";
        }
    }
}
