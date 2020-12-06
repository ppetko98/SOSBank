package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "op")
public class Operation {

	private int opId;
	private boolean	transfer;
	private float amount;
	private int accountOg, accountDt;
	private java.sql.Timestamp date;
	
	public Operation() {
		
	}

	public Operation(boolean transfer, float amount) {
		this.transfer = transfer;
		this.amount = amount;
	}
	
	public Operation(boolean transfer, float amount, int accountDt) {
		super();
		this.transfer = transfer;
		this.amount = amount;
		this.accountDt = accountDt;
	}

	public int getOpId() {
		return opId;
	}

	public void setOpId(int opId) {
		this.opId = opId;
	}

	public boolean isTransfer() {
		return transfer;
	}

	public void setTransfer(boolean transfer) {
		this.transfer = transfer;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getAccountOg() {
		return accountOg;
	}

	public void setAccountOg(int accountOg) {
		this.accountOg = accountOg;
	}

	public int getAccountDt() {
		return accountDt;
	}

	public void setAccountDt(int accountDt) {
		this.accountDt = accountDt;
	}

	public java.sql.Timestamp getDate() {
		return date;
	}

	public void setDate(java.sql.Timestamp date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Operation [opId=" + opId + ", transfer=" + transfer + ", amount=" + amount + ", accountOg=" + accountOg
				+ ", accountDt=" + accountDt + ", date=" + date + "]";
	}
	
}
