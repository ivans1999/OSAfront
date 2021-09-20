package api.delivery.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderId", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "hour", unique = false, nullable = false)
	private Date hour;
	
	@Column(name = "delivered", unique = false, nullable = false)
	private Boolean delivered;
	
	@Column(name = "orderMark", unique = false, nullable = false)
	private Integer orderMark;
	
	@Column(name = "comment", unique = false, nullable = false)
	private String comment;
	
	@Column(name = "anonymousComment" , unique = false, nullable = false)
	private Boolean anonymousComment;
	
	@Column(name = "arhivedComment",unique = false, nullable = false)
	private Boolean arhivedComment;
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "order")
	private Set<Item> items = new HashSet<Item>();
	
	@ManyToOne
	@JoinColumn(name="userId", referencedColumnName="userId", nullable=false)
	private Customer customer;
	
	public Order() {
		
	}

	public Order(Long id, Date hour, Boolean delivered, Integer orderMark, String comment, Boolean anonymousComment,
			Boolean arhivedComment, Set<Item> items) {
		super();
		this.id = id;
		this.hour = hour;
		this.delivered = delivered;
		this.orderMark = orderMark;
		this.comment = comment;
		this.anonymousComment = anonymousComment;
		this.arhivedComment = arhivedComment;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getHour() {
		return hour;
	}

	public void setHour(Date hour) {
		this.hour = hour;
	}

	public Boolean getDelivered() {
		return delivered;
	}

	public void setDelivered(Boolean delivered) {
		this.delivered = delivered;
	}

	public Integer getOrderMark() {
		return orderMark;
	}

	public void setOrderMark(Integer orderMark) {
		this.orderMark = orderMark;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getAnonymousComment() {
		return anonymousComment;
	}

	public void setAnonymousComment(Boolean anonymousComment) {
		this.anonymousComment = anonymousComment;
	}

	public Boolean getArhivedComment() {
		return arhivedComment;
	}

	public void setArhivedComment(Boolean arhivedComment) {
		this.arhivedComment = arhivedComment;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}	
}