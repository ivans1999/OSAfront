package api.delivery.service;

import java.util.List;
import api.delivery.entity.Customer;

public interface CustomerServiceInterface {

	Customer findOne(Long customerId);
	
	Customer save(Customer customer);
	
	void remove(Long customerId);
	
	List<Customer> findAll();
}