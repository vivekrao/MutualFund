package form;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class BuyFundForm extends FormBean{
	private String buyAmount;
	private String fundName;
	
	public String getBuyAmount() {
		return buyAmount;
	}

	public void setBuyAmount(String buyAmount) {
		this.buyAmount = buyAmount;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		
		try { 
			double amt = Double.parseDouble(buyAmount);
			if(amt<=0) {
				errors.add("Please enter an amount that is greater than 0");
			}
			buyAmount = amt*100+"";
		} catch(NumberFormatException nfe) {
			errors.add("Please enter amount in digits. Do not use letters");
			return errors;
		}
		System.out.println("The errors are: "+errors);
        if (errors.size() > 0) return errors;
		
        return errors;
    }
}
