package api.delivery.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="articles")
public class Article implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = true)
	private Long id;
	
	@Column(name="articleName", unique = false, nullable = true)
	private String articleName;
	
	@Column(name="articleDescription", unique = false, nullable = true)
	private String articleDescription;
	
	@Column(name="articleMark", unique = false, nullable = true)
	private Double articleMark;
	
	@Column(name="path", unique = false, nullable = true)
	private String path;

	@OneToMany(cascade= {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "article")
	private Set<Item> items = new HashSet<Item>();
		
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="articles_sales",
				joinColumns = {@JoinColumn(name = "id")},
				inverseJoinColumns = {@JoinColumn(name="saleId")}
			)
	private Set<Sale> sales = new HashSet<Sale>();
	
	@Column(name="deleted", unique = false, nullable = false)
	private Boolean deleted;
	
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="userId", nullable=false)
	private Seller seller;
	
	public Article() {
		
	}

	public Article(Long id, String articleName, String articleDescription, Double articleMark, String path,
			Set<Item> items, Set<Sale> sales) {
		super();
		this.id = id;
		this.articleName = articleName;
		this.articleDescription = articleDescription;
		this.articleMark = articleMark;
		this.path = path;
		this.items = items;
		this.sales = sales;
	}
	
	public Article(Long id, String articleName, String articleDescription, Double articleMark, String path) {
		super();
		this.id = id;
		this.articleName = articleName;
		this.articleDescription = articleDescription;
		this.articleMark = articleMark;
		this.path = path;
	}
	
	public Article(Long id, String articleName, String articleDescription, Double articleMark, String path,
			Set<Item> items, Set<Sale> sales, Boolean deleted, Seller seller) {
		super();
		this.id = id;
		this.articleName = articleName;
		this.articleDescription = articleDescription;
		this.articleMark = articleMark;
		this.path = path;
		this.items = items;
		this.sales = sales;
		this.deleted = deleted;
		this.seller = seller;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public String getArticleDescription() {
		return articleDescription;
	}

	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}

	public Double getArticleMark() {
		return articleMark;
	}

	public void setArticleMark(Double articleMark) {
		this.articleMark = articleMark;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Set<Sale> getSales() {
		return sales;
	}

	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(User user) {
		this.seller = (Seller) user;
	}
}