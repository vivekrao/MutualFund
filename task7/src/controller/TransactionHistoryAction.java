package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Customer;
import model.Transaction;

import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import dao.impl.TransactionDaoImpl;

public class TransactionHistoryAction extends Action {

	private TransactionDaoImpl transactionDaoImpl;

	public TransactionHistoryAction(TransactionDaoImpl transactionDaoImpl) {
		this.transactionDaoImpl = transactionDaoImpl;
		
	}

	@Override
	public String getName() {
		return "transactionHistory.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			Customer customer= (Customer)request.getSession(false).getAttribute("customer");
			List<Transaction> list = transactionDaoImpl.getTransactionHistory(customer);
			
			if(list == null || list.isEmpty()) {
				errors.add("There is no transactions in your records.");
			}
			
			// Any validation errors?
			if (errors.size() != 0) {
				return "transactionHistory.jsp";
			}
			
			request.setAttribute("transactionHistory", list);
			
			return "transactionHistory.jsp";
		} catch (Exception e) {
        	errors.add(e.getMessage());
        	return "transactionHistory.jsp";
        }

	}

}
