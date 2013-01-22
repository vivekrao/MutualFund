package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "fund_price_history")
@IdClass(PKFundPriceHistory.class)
public class FundPriceHistory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Fund fund;
	private String price_date;
	private long price;
	
	public FundPriceHistory() {
		
	}	
	
	public FundPriceHistory(Fund fund, String price_date, long price) {
		this.fund = fund;
		this.price_date = price_date;
		this.price = price;
	}
	
	@Id
	public Fund getFund() {
		return fund;
	}
	
	public void setFund(Fund fund) {
		this.fund = fund;
	}
	
	@Id
	public String getPrice_date() {
		return price_date;
	}
	
	public void setPrice_date(String price_date) {
		this.price_date = price_date;
	}
	
	@Column(name = "price")
	public long getPrice() {
		return price;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}
}
