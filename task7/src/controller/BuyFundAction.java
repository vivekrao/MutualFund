package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Customer;
import model.Fund;
import model.Transaction;

import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import dao.impl.CustomerDaoImpl;
import dao.impl.FundDaoImpl;
import dao.impl.PositionDaoImpl;
import dao.impl.TransactionDaoImpl;
import form.BuyFundForm;

public class BuyFundAction extends Action {
	private FormBeanFactory<BuyFundForm> formBeanFactory = FormBeanFactory
			.getInstance(BuyFundForm.class);

	private FundDaoImpl fundDaoImpl;
	private TransactionDaoImpl transactionDaoImpl;
	private PositionDaoImpl positionDaoImpl;
	private CustomerDaoImpl customerDaoImpl;

	public BuyFundAction(FundDaoImpl fundDaoImpl) {
		this.fundDaoImpl = fundDaoImpl;

	}

	@Override
	public String getName() {
		return "buyFund.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		transactionDaoImpl = new TransactionDaoImpl();
		positionDaoImpl = new PositionDaoImpl();
		customerDaoImpl = new CustomerDaoImpl();

		try {
			BuyFundForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);
			request.setAttribute("fundList", fundDaoImpl.getFundHistory());
			Customer customer = (Customer) request.getSession(false)
					.getAttribute("customer");
			request.setAttribute("custFundList",
					positionDaoImpl.getAllFundByCustomer(customer));
			System.out.println("third!");
			if (!form.isPresent()) {
				return "buyFund.jsp";
			}
			System.out.println("second!");
			if (!fundDaoImpl.isExistedFund(form.getFundName())) {
				System.out.println(form.getFundName());
				errors.add("This fund does not exist");
			}
			double amount = Double.parseDouble(form.getBuyAmount());
			System.out.println("third");
			Fund fund = fundDaoImpl.findFundByName(form.getFundName());
			List<Long> amountList = transactionDaoImpl
					.getAmountForCheckAndBuyByCustomer(customer);
			double cashBalance = customerDaoImpl.getCashByCustomerId(customer.getCustomer_id()) / 100;
			System.out.println(cashBalance);
			if (amountList == null || amountList.size() <= 0) {

			} else {
				for (int i = 0; i < amountList.size(); i++) {
					cashBalance = cashBalance - (amountList.get(i) / 100);
					System.out.println("amount list : "+amountList.get(i));
				}
			}
			System.out.println(cashBalance-amount);
			if ((cashBalance - amount) < 0.0) {
				errors.add("You do not have enough cash balance in your account");
			}
			// Any validation errors?
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				System.out.println(errors);
				return "buyFund.jsp";
			}

			Transaction transaction = new Transaction();
			transaction.setAmount((long) (amount * 100));
			transaction.setCustomer(customer);
			transaction.setExecute_date(null);
			transaction.setFund(fund);
			transaction.setTransaction_type(2);
			System.out.println("transaction entered");
			if(transactionDaoImpl.createTransaction(transaction)) {
				System.out.println("done!");
			} else {
				System.out.println("not done! ");
			}

			return "success.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "buyFund.jsp";
		}

	}
}
