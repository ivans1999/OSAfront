package api.delivery.service;

import java.util.List;
import api.delivery.entity.Order;

public interface OrderServiceInterface {

	Order findOne(Long orderId);
	
	Order save(Order order);
	
	void remove(Long orderId);
	
	List<Order> findAll();
}
