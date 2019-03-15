package co.simplon.entities;

public class Customer {
	private int IdCust;
	private String Name;
	private String firstName;
	public Customer(int IdCust, String name, String firstname) {
		this.IdCust = IdCust;
		this.Name = name;
		this.firstName = firstname;
	}

	@Override
	public String toString() {
		return "Customer [IdCust=" + IdCust + ", nom=" + Name + ", prenom=" + firstName + "]";
	}

	public int getIdCust() {
		return IdCust;
	}

	public void setIdCust(int IdCust) {
		this.IdCust = IdCust;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String FirstName) {
		this.firstName = FirstName;
} 
}
