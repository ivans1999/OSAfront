package api.delivery.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "address", unique = false, nullable = false)
	private String address;
		
	@OneToMany(cascade= {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "customer")
	private Set<Order> orders = new HashSet<Order>();
	
	public String getAddress() {
		return address;
	}

	public Customer() {
		super();
	}

	public Customer(Long id, String firstname, String lastname, String username, String password, User_Type userType) {
		super(id, firstname, lastname, username, password, userType);
	}
	
	public Customer(Long id, String firstname, String lastname, String username, String password, String address, User_Type userType) {
		super(id, firstname, lastname, username, password, userType);
		this.address = address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}