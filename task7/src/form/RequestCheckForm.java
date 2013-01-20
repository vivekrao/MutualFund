package form;
import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class RequestCheckForm extends FormBean {
	private String amount;
	
	public String getAmount() { return amount;}
	
	public void setAmount(String s) { amount = s.trim(); }
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		double x=0;
		
		if (amount == null || amount.length() == 0) {
			errors.add("Amount is required");
			return errors;
		}
		
		try {
			 x = Double.parseDouble(amount);
		} catch ( NumberFormatException e1) {
			errors.add("You should enter a number");
		}
		
		if(x<0) {
			errors.add("The amount should be positive");
		}
			
		return errors;
		
		}

}
