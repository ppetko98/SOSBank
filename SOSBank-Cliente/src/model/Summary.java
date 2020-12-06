package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "summary")
public class Summary {

	private Client cliente;
	private Accounts cuentas;
	private Operations operaciones;
	private Link clientLink;
	
	public Summary() {
	}

	public Summary(Client cliente) {
		this.cliente = cliente;
	}

	public Summary(Client cliente, Accounts cuentas, Operations operaciones) {
		this.cliente = cliente;
		this.cuentas = cuentas;
		this.operaciones = operaciones;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public Accounts getCuentas() {
		return cuentas;
	}

	public void setCuentas(Accounts cuentas) {
		this.cuentas = cuentas;
	}

	public Operations getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(Operations operaciones) {
		this.operaciones = operaciones;
	}

	public Link getClientLink() {
		return clientLink;
	}

	public void setClientLink(Link clientLink) {
		this.clientLink = clientLink;
	}

	@Override
	public String toString() {
		return "Summary [cliente=" + cliente + ", cuentas=" + cuentas.toString() + ", operaciones=" + operaciones.toString() + ", clientLink="
				+ clientLink.toString() + "]";
	}
	
}
