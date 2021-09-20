package api.delivery.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.delivery.dto.ItemDTO;
import api.delivery.entity.Item;
import api.delivery.service.ArticleServiceInterface;
import api.delivery.service.OrderServiceInterface;

@Component
public class ItemConverter {
	
	@Autowired
	private ArticleConverter articleConverter;
	
	@Autowired
	private ArticleServiceInterface articleServiceInterface;
	
	@Autowired
	private OrderConverter orderConverter;
	
	@Autowired
	private OrderServiceInterface orderServiceInterface;
	
	public ItemDTO toDTO(Item item) {
		ItemDTO dto = new ItemDTO();
		dto.setId(item.getId());
		dto.setQuantity(item.getQuantity());
		dto.setOrderDTO(orderConverter.toDTO(item.getOrder()));
		dto.setArticleDTO(articleConverter.toDTO(item.getArticle()));
		return dto;
	}
	
	public Item toItem(ItemDTO itemDTO) {
		Item i = new Item();
		i.setId(itemDTO.getId());
		i.setQuantity(itemDTO.getQuantity());
		i.setOrder(orderServiceInterface.findOne(itemDTO.getOrderDTO().getId()));
		i.setArticle(articleServiceInterface.findOne(itemDTO.getArticleDTO().getId()));
		return i;
	}

}
