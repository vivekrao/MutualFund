/**
 * andrew ID: chenc2
 * name:Chen Chen
 * date:5th Dec
 */
package form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybeans.form.FormBean;

public class CreateFundForm extends FormBean{
	private String name;
	private String ticker;
    
    public String getName()   { return name;}
    public String getTicker()  { return ticker; }
    
    public void setName(String s) { name = trimAndConvert(s,"<>\"");  }
    public void setTicker(String s) { ticker = trimAndConvert(s,"<>\"");  }
    
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();
        
        if (name == null || name.length() == 0) errors.add("Name is required");
        if (ticker == null || ticker.length() == 0) errors.add("ticker is required");
        
        if (errors.size() > 0) return errors;
		
        return errors;
    }

}
