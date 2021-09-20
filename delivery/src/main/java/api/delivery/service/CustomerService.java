package api.delivery.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.delivery.entity.Customer;
import api.delivery.repository.CustomerRepository;

@Service
public class CustomerService implements CustomerServiceInterface{

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer findOne(Long customerId) {
		return customerRepository.getOne(customerId);
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void remove(Long customerId) {
		customerRepository.deleteById(customerId);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
