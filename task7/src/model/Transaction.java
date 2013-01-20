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
	
	public final static int SELL = 1;
	public final static int BUY = 2;
	public final static int DEPOSIT = 3;
	public final static int CHECK = 4;
	
	private int transaction_id;
	private Customer customer;
	private Fund fund;
	private String execute_date;
	private int shares;
	private int transaction_type;
	private double amount;
	
	public Transaction() {
		
	}
	
	public Transaction(Customer c, Fund f, String execute_date, 
			int shares, int transaction_type, double amount) {
		this.customer = c;
		this.fund = f;
		this.execute_date = execute_date;
		this.shares = shares;
		this.transaction_type = transaction_type;
		this.amount = amount;
	}
	
	public Transaction(Customer c, int transaction_type, double amount) {
		this.customer = c;
		this.transaction_type = transaction_type;
		this.amount = amount;
	}
	
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
	public int getShares() {
		return shares;
	}
	
	public void setShares(int shares) {
		this.shares = shares;
	}
	
	@Column(name = "transaction_type")
	public int getTransaction_type() {
		return transaction_type;
	}
	
	public void setTransaction_type(int transaction_type) {
		this.transaction_type = transaction_type;
	}
	
	@Column(name = "amount")
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
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
