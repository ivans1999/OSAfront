package api.delivery.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class OrderDTO implements Serializable{
	
	private Long id;
	
	private Date hour;
	
	private Boolean delivered;
	
	private String comment;
	
	private Boolean anonymousComment;
	
	private Boolean arhivedComment;
	
	public OrderDTO() {
		super();
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
}
