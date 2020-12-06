package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "client")
public class Clients {
	private ArrayList<Link> clients;
	private ArrayList<Client> cs;
	
	public Clients() {
		this.cs = new ArrayList<Client>();
		this.clients = new ArrayList<Link>();
	}

	@XmlElement(name="client")
	public ArrayList<Link> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Link> clients) {
		this.clients = clients;
	}

	@XmlElement(name="client")
	public ArrayList<Client> getCs() {
		return cs;
	}

	public void setCs(ArrayList<Client> cs) {
		this.cs = cs;
	}

}
