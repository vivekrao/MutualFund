package form;

import java.util.ArrayList;
import java.util.List;

import model.Fund;

import org.mybeans.form.FormBean;

public class ResearchFundForm extends FormBean{
	
	private String fundName;

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();
        
        //if(fundName.isEmpty()) errors.add("No funds are created");
        
        if (errors.size() > 0) return errors;
        
        return errors;
    }

}
