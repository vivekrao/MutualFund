package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PKPosition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Customer customer;
	private Fund fund;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="customer_id")
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fund_id")
	public Fund getFund() {
		return fund;
	}
	
	public void setFund(Fund fund) {
		this.fund = fund;
	}
	
	@Override  
	public boolean equals(Object o) {  
		if (this == o)  
			return true;  
		if (o == null)  
			return false;  
		if (!(o instanceof PKPosition))  
			return false;  
		PKPosition pk = (PKPosition) o;  
		if (this.customer.getCustomer_id() == pk.getCustomer().getCustomer_id() &&
				this.fund.getFund_id() == pk.getFund().getFund_id()) {  
			return true;  
	    }  
		return true;  
	}  
	  
	@Override  
	public int hashCode() {  
		return 31 * this.customer.hashCode() + this.fund.hashCode();  
	} 
}
