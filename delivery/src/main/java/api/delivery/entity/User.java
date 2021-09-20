package api.delivery.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table(name="users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userId", unique = true, nullable = false)
	private Long id;

	@Column(name = "firstname", unique = false, nullable = false)
	private String firstname;
	
	@Column(name = "lastname", unique = false, nullable = false)
	private String lastname;
	
	@Column(name = "username", unique = false, nullable = false)
	private String username;
	
	@Column(name = "password", unique = false, nullable = false)
	private String password;
	
	@Column(name="User_Type", unique = false, nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private User_Type userType;
	
	@Column(name="blocked", unique = false, nullable = false)
	private Boolean blocked;
	
	public User() {
		
	}

	public User(Long id, String firstname, String lastname, String username, String password, User_Type userType) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}
	
	

	public User(Long id, String firstname, String lastname, String username, String password, User_Type userType,
			Boolean blocked) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.blocked = blocked;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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