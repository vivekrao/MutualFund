package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "fund_price_history")
@IdClass(PKFundPriceHistory.class)
public class FundPriceHistory {
	private Fund fund;
	private String price_date;
	private double price;
	
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
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}
