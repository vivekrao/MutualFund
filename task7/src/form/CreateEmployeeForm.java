/**
 * andrew ID: chenc2
 * name:Chen Chen
 * date:5th Dec
 */
package form;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class CreateEmployeeForm extends FormBean{
	private String username;
	private String firstName;
	private String lastName;
	private String password;
    private String confirmedPassword;
    
    public String getUsername()   { return username;}
    public String getFirstName()  { return firstName; }
    public String getLastName()  { return lastName; }
    public String getPassword()  { return password;}
    public String getConfirmedPassword()    { return confirmedPassword;   }
    
    public void setUsername(String s) { username = trimAndConvert(s,"<>\"");  }
    public void setFirstName(String s) { firstName = trimAndConvert(s,"<>\"");  }
	public void setLastName(String s)  { lastName  = trimAndConvert(s,"<>\"");  }
	public void setPassword(String s)  { password  = s.trim();                  }
	public void setConfirmedPassword(String s)   { confirmedPassword = s.trim();        }
    
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
