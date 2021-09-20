package api.delivery.entity;

import javax.persistence.Entity;

@Entity
public class Admin extends User{

	private static final long serialVersionUID = 1L;
	
	public Admin() {
		
	}

	public Admin(Long id, String firstname, String lastname, String username, String password, User_Type userType) {
		super(id, firstname, lastname, username, password, userType);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}