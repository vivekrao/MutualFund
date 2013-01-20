package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.IdClass;

@Entity  
@Table(name="position")  
@IdClass(PKPosition.class)
public class Position {
	private Customer customer;
	private Fund fund;
	private String shares;
	
	@Id
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Id
	public Fund getFund() {
		return fund;
	}
	
	public void setFund(Fund fund) {
		this.fund = fund;
	}
	
	@Column(name = "shares")
	public String getShares() {
		return shares;
	}
	
	public void setShares(String shares) {
		this.shares = shares;
	}
}
