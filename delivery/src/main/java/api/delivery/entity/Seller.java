package api.delivery.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Seller extends User{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "dateFrom", unique = false, nullable = true)
	private Date dateFrom;
	
	@Column(name = "email", unique = false, nullable = true)
	private String email;
	
	@Column(name = "address", unique = false, nullable = false)
	private String address;
	
	@Column(name = "name", unique = false, nullable = true)
	private String name;
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "seller")
	private Set<Article> articles = new HashSet<Article>();
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "seller")
	private Set<Sale> sales = new HashSet<Sale>();
	
	public Seller() {
		super();

	}

	public Seller(Long id, String firstname, String lastname, String username, String password,User_Type userType, Date dateFrom, String email, String address, String name) {
		super(id, firstname, lastname, username, password, userType);
		this.dateFrom = dateFrom;
		this.email = email;
		this.address = address;
		this.name = name;
	}
	
	

	public Seller(Date dateFrom, String email, String address, String name, Set<Article> articles) {
		super();
		this.dateFrom = dateFrom;
		this.email = email;
		this.address = address;
		this.name = name;
		this.articles = articles;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
}