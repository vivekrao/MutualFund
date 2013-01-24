package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Customer;
import model.Fund;

import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import dao.impl.FundDaoImpl;
import form.CreateCustomerForm;
import form.ResearchFundForm;

public class ResearchFundAction extends Action {
	private FormBeanFactory<ResearchFundForm> formBeanFactory = FormBeanFactory
			.getInstance(ResearchFundForm.class);

	private FundDaoImpl fundDaoImpl;

	public ResearchFundAction(FundDaoImpl fundDaoImpl) {
		this.fundDaoImpl = fundDaoImpl;
		
	}

	@Override
	public String getName() {
		return "researchFund.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			ResearchFundForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);
			System.out.println("in here! "+fundDaoImpl.getFundHistory().get(0).getSymbol());
			request.setAttribute("fundList", fundDaoImpl.getFundHistory());
			if (!form.isPresent()) {
				return "researchFund.jsp";
			}
			long fundPrice = fundDaoImpl.checkAvailablityOfFund(form.getFundName());
			if(fundPrice == -1) {
				errors.add("No such fund exists");
			}
			// Any validation errors?
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "researchFund.jsp";
			}
			request.setAttribute("fundPrice", fundPrice);
			request.setAttribute("fundName", form.getFundName());
			return "researchFundDetail.jsp";
		} catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "researchFund.jsp";
        }

	}
}
