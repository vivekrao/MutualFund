package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	private int transaction_id;
	private Customer customer;
	private Fund fund;
	private String execute_date;
	private String shares;
	private String transaction_type;
	private int amount;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transaction_id")
	public int getTransaction_id() {
		return transaction_id;
	}
	
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	
	@Column(name = "execute_date")
	public String getExecute_date() {
		return execute_date;
	}
	
	public void setExecute_date(String execute_date) {
		this.execute_date = execute_date;
	}
	
	@Column(name = "shares")
	public String getShares() {
		return shares;
	}
	
	public void setShares(String shares) {
		this.shares = shares;
	}
	
	@Column(name = "transaction_type")
	public String getTransaction_type() {
		return transaction_type;
	}
	
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	
	@Column(name = "amount")
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
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
}
