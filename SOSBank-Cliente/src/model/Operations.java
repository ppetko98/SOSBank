package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "op")
public class Operations {
	private ArrayList<Link> operations;
	private ArrayList<Operation> ops;
	
	public Operations() {
		this.operations = new ArrayList<Link>();
		this.ops = new ArrayList<Operation>();
	}

	@XmlElement(name="op")
	public ArrayList<Link> getOperations() {
		return operations;
	}

	public void setOperations(ArrayList<Link> operations) {
		this.operations = operations;
	}
	
	@XmlElement(name="op")
	public ArrayList<Operation> getOps() {
		return ops;
	}

	public void setOps(ArrayList<Operation> ops) {
		this.ops = ops;
	}
	
}
