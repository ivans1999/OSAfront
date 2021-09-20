package api.delivery.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.delivery.entity.Order;
import api.delivery.repository.OrderRepository;

@Service
public class OrderService implements OrderServiceInterface {

	@Autowired
	OrderRepository orderRepository;

	@Override
	public Order findOne(Long orderId) {
		return orderRepository.getOne(orderId);
	}

	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public void remove(Long orderId) {
		orderRepository.deleteById(orderId);
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}	
}