package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "accounts")
public class Account {
	
	private int accountId, accountOwner;
	private float balance;
	private String name;
	
	public Account() {
	
	}

	public Account(int accountOwner, float balance) {
		super();
		this.accountOwner = accountOwner;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(int accountOwner) {
		this.accountOwner = accountOwner;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
