package api.delivery.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ItemDTO implements Serializable{
	
	private Long id;
	
	private Integer quantity;
	
	private OrderDTO orderDTO;
	
	private ArticleDTO articleDTO;
	
	public ItemDTO() {
		super();
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

	public OrderDTO getOrderDTO() {
		return orderDTO;
	}

	public void setOrderDTO(OrderDTO orderDTO) {
		this.orderDTO = orderDTO;
	}

	public ArticleDTO getArticleDTO() {
		return articleDTO;
	}

	public void setArticleDTO(ArticleDTO articleDTO) {
		this.articleDTO = articleDTO;
	}
}