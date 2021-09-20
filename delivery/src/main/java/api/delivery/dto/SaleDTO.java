package api.delivery.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class SaleDTO implements Serializable{

	private Long id;
	
	private String percentage;
	
	private Date dateFrom;
	
	private Date dateTo;
	
	private String text;
	
	private UsersDTO usersDTO;
		
	public SaleDTO() {
		super();
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

	public UsersDTO getUsersDTO() {
		return usersDTO;
	}

	public void setUsersDTO(UsersDTO usersDTO) {
		this.usersDTO = usersDTO;
	}
	
	
}
