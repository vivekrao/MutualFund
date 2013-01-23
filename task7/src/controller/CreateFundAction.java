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

import model.Fund;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import dao.impl.FundDaoImpl;
import form.CreateFundForm;


public class CreateFundAction extends Action {
	private FormBeanFactory<CreateFundForm> formBeanFactory = FormBeanFactory.getInstance(CreateFundForm.class);

	private FundDaoImpl fundDaoImpl;
	
	public CreateFundAction(FundDaoImpl fundDaoImpl) {
		this.fundDaoImpl = fundDaoImpl;
	}

	public String getName() { return "createFund.do"; }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);

        try {
	        CreateFundForm form = formBeanFactory.create(request);
	        //request.setAttribute("form",form);
	
	        // If no params were passed, return with no errors so that the form will be
	        // presented (we assume for the first time).
	        if (!form.isPresent()) {
	            return "createFund.jsp";
	        }
	
	        // Any validation errors?
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	            return "createFund.jsp";
	        }
	
	        // Create the user bean
	        Fund fund = new Fund();
	        fund.setName(form.getName());
	        fund.setSymbol(form.getTicker());
        	fundDaoImpl.createFund(fund);
        
			// Attach (this copy of) the user bean to the session
	      
	
	        // After successful registration (and login) send to...
	        /*String redirectTo = (String) session.getAttribute("redirectTo");
	        if (redirectTo != null) return redirectTo;
	        
	        // If redirectTo is null, redirect to the "manage" action
			String webapp = request.getContextPath();
			return webapp + "/manage.do";*/
        	request.setAttribute("message","New fund "+fund.getName()+" has been created sucessfully.");
			return "success.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "createFund.jsp";
        }
    }
}
