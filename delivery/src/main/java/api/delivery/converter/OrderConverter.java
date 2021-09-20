package api.delivery.converter;


import org.springframework.stereotype.Component;

import api.delivery.dto.OrderDTO;
import api.delivery.entity.Order;

@Component
public class OrderConverter {
	
	public OrderDTO toDTO(Order order) {
		OrderDTO dto = new OrderDTO();
		dto.setId(order.getId());
		dto.setHour(order.getHour());
		dto.setDelivered(order.getDelivered());
		dto.setComment(order.getComment());
		dto.setAnonymousComment(order.getAnonymousComment());
		dto.setArhivedComment(order.getArhivedComment());
		return dto;
	}
	
	public Order toOrder(OrderDTO orderDTO) {
		Order o = new Order();
		o.setId(orderDTO.getId());
		o.setHour(orderDTO.getHour());
		o.setDelivered(orderDTO.getDelivered());
		o.setComment(orderDTO.getComment());
		o.setAnonymousComment(orderDTO.getAnonymousComment());
		o.setArhivedComment(orderDTO.getArhivedComment());
		return o;
	}

}
