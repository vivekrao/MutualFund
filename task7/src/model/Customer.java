package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int customer_id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String addr_line1;
	private String addr_line2;
	private String city;
	private String state;
	private int zip;
	private double cash;
	
	public Customer() {
		
	}
	
	public Customer(String username, String password, String firstname,
			String lastname, String addr_line1, String addr_line2, 
			String city, String state, int zip, double cash) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.addr_line1 = addr_line1;
		this.addr_line2 = addr_line2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.cash = cash;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	public int getCustomer_id() {
		return customer_id;
	}
	
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	@Column(name = "username")
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Column(name = "addr_line1")
	public String getAddr_line1() {
		return addr_line1;
	}
	
	public void setAddr_line1(String addr_line1) {
		this.addr_line1 = addr_line1;
	}
	
	@Column(name = "addt_line2")
	public String getAddr_line2() {
		return addr_line2;
	}
	
	public void setAddr_line2(String addr_line2) {
		this.addr_line2 = addr_line2;
	}
	
	@Column(name = "city")
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "state")
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name = "zip")
	public int getZip() {
		return zip;
	}
	
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	@Column(name = "cash")
	public double getCash() {
		return cash;
	}
	
	public void setCash(double cash) {
		this.cash = cash;
	}
}
