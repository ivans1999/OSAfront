package api.delivery.dto;

import java.io.Serializable;
import java.util.Date;

import api.delivery.entity.User_Type;

@SuppressWarnings("serial")
public class UsersDTO implements Serializable{
	
	private Long id;
	
	private String firstname;

	private String lastname;
	
	private String username;
	
	private String password;
	
	private User_Type userType;
	
	private Boolean blocked;
	
	private String address;
	
	private Date dateFrom;
	
	private String email;
	
	private String name;
	
	public UsersDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User_Type getUserType() {
		return userType;
	}

	public void setUserType(User_Type userType) {
		this.userType = userType;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}
}
