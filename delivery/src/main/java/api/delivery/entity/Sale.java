package api.delivery.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sales")
public class Sale implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="saleId", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "percentage", unique = false, nullable = false)
	private String percentage;
	
	@Column(name = "dateFrom", unique = false, nullable = false)
	private Date dateFrom;
	
	@Column(name = "dateTo", unique = false, nullable = false)
	private Date dateTo;
	
	@Column(name = "text", unique = false, nullable = false)
	private String text;

	@ManyToMany(mappedBy="sales")
	private Set<Article> articles = new HashSet<Article>();
	
	@ManyToOne
	@JoinColumn(name="userId", referencedColumnName="userId", nullable=false)
	private Seller seller;
	
	public Sale() {
		
	}

	public Sale(Long id, String percentage, Date dateFrom, Date dateTo, String text,Set<Article> articles) {
		super();
		this.id = id;
		this.percentage = percentage;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.text = text;
		this.articles = articles;
	}
	
	

	public Sale(Long id, String percentage, Date dateFrom, Date dateTo, String text, Set<Article> articles,
			Seller seller) {
		super();
		this.id = id;
		this.percentage = percentage;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.text = text;
		this.articles = articles;
		this.seller = seller;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(User user) {
		this.seller = (Seller) user;
	}
		
	


	

}
