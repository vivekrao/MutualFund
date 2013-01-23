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

public class CreateCustomerForm extends FormBean{
	private String username;
	private String firstName;
	private String lastName;
	private String password;
    private String confirmedPassword;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;
    
    public String getUsername()   { return username;}
    public String getFirstName()  { return firstName; }
    public String getLastName()  { return lastName; }
    public String getPassword()  { return password;}
    public String getConfirmedPassword()    { return confirmedPassword;   }
    public String getAddressLine1() {return addressLine1;}
    public String getAddressLine2() {return addressLine2;}
    public String getCity(){return city;}
    public String getState(){return state;}
    public String getZip(){return zip;}
    
    public void setUsername(String s) { username = trimAndConvert(s,"<>\"");  }
    public void setFirstName(String s) { firstName = trimAndConvert(s,"<>\"");  }
	public void setLastName(String s)  { lastName  = trimAndConvert(s,"<>\"");  }
	public void setPassword(String s)  { password  = s.trim();                  }
	public void setConfirmedPassword(String s)   { confirmedPassword = s.trim();        }
	public void setAddressLine1(String s){addressLine1=trimAndConvert(s,"<>\"");}
	public void setAddressLine2(String s){addressLine2=trimAndConvert(s,"<>\"");}
	public void setCity(String s){city=trimAndConvert(s,"<>\"");}
	public void setState(String s){state=trimAndConvert(s,"<>\"");}
	public void setZip(String s){trimAndConvert(s,"<>\"");}
    
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();
        
        if (username == null || username.length() == 0) errors.add("username is required");
        if (password == null || password.length() == 0) errors.add("Password is required");
        if (confirmedPassword == null||confirmedPassword.length() == 0) errors.add("ConfirmedPassword is required");
        
        if (errors.size() > 0) return errors;
        
        if (!password.equals(confirmedPassword)) errors.add("The confirmed Password is different from the password");
		
        return errors;
    }

}
