package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "accounts")
public class Accounts {
	private ArrayList<Link> accounts;
	private ArrayList<Account> acs;
	
	public Accounts() {
		this.accounts = new ArrayList<Link>();
		this.acs = new ArrayList<Account>();
	}

	@XmlElement(name="accounts")
	public ArrayList<Link> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Link> accounts) {
		this.accounts = accounts;
	}

	@XmlElement(name="accounts")
	public ArrayList<Account> getAcs() {
		return acs;
	}

	public void setAcs(ArrayList<Account> acs) {
		this.acs = acs;
	}
	
}
