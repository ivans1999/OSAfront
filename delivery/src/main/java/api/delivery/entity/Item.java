package api.delivery.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="item_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "quantity", unique = false, nullable = false)
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name="orderId", referencedColumnName="orderId", nullable=false)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="articleId", referencedColumnName="id", nullable=false)
	private Article article;
	
	public Item() {
		
	}

	public Item(Long id, Integer quantity, Order order, Article article) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.order = order;
		this.article = article;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
}