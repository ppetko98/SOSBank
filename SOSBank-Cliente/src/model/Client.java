package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "client")
public class Client {

		private int clientId;
		private String name, surname, familyName, identificationN;
		private float balance;
		
		public Client() {
			
		}
		
		public Client(String name, String surname, float balance) {
			super();
			this.name = name;
			this.surname = surname;
			this.balance = balance;
		}
		
		public int getClientId() {
			return clientId;
		}
		public void setClientId(int clientId) {
			this.clientId = clientId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public String getFamilyName() {
			return familyName;
		}
		public void setFamilyName(String familyName) {
			this.familyName = familyName;
		}
		public String getIdentificationN() {
			return identificationN;
		}
		public void setIdentificationN(String identificationN) {
			this.identificationN = identificationN;
		}
		public float getBalance() {
			return balance;
		}
		public void setBalance(float balance) {
			this.balance = balance;
		}

		@Override
		public String toString() {
			return "Client [clientId=" + clientId + ", name=" + name + ", surname=" + surname + ", familyName="
					+ familyName + ", identificationN=" + identificationN + ", balance=" + balance + "]";
		}
		
}