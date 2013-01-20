package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PKFundPriceHistory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Fund fund;
	private String price_date;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fund_id")
	public Fund getFund() {
		return fund;
	}
	
	public void setFund(Fund fund) {
		this.fund = fund;
	}
	
	@Column(name = "price_date")
	public String getPrice_date() {
		return price_date;
	}
	
	public void setPrice_date(String price_date) {
		this.price_date = price_date;
	}
	
	@Override  
	public boolean equals(Object o) {  
		if (this == o)  
			return true;  
		if (o == null)  
			return false;  
		if (!(o instanceof PKFundPriceHistory))  
			return false;  
		PKFundPriceHistory pk = (PKFundPriceHistory) o;  
		if (this.fund.getFund_id() == pk.getFund().getFund_id() &&
				this.price_date.equals(pk.getPrice_date())) {  
			return true;  
	    }  
		return true;  
	}  
	  
	@Override  
	public int hashCode() {  
		return 31 * this.fund.hashCode() + this.price_date.hashCode();  
	} 
}
