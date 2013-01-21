package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.IdClass;

@Entity  
@Table(name="position")  
@IdClass(PKPosition.class)
public class Position implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Customer customer;
	private Fund fund;
	private int shares;
	
	public Position() {
		
	}
	
	public Position(Customer c, Fund f, String shares) {
		this.customer = c;
		this.fund = f;
		this.shares = shares;
	}
	
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
	public int getShares() {
		return shares;
	}
	
	public void setShares(int shares) {
		this.shares = shares;
	}
}
