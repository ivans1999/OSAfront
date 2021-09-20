package api.delivery.converter;

import org.springframework.stereotype.Component;

import api.delivery.dto.UsersDTO;
import api.delivery.entity.Customer;
import api.delivery.entity.Seller;
import api.delivery.entity.User_Type;

@Component
public class UsersConverter {
	
	public UsersDTO toDTOCustomer(Customer customer) {
		UsersDTO dto = new UsersDTO();
		dto.setId(customer.getId());
		dto.setFirstname(customer.getLastname());
		dto.setLastname(customer.getLastname());
		dto.setUsername(customer.getUsername());
		dto.setPassword(customer.getPassword());
		dto.setUserType(customer.getUserType());
		dto.setBlocked(customer.getBlocked());
		dto.setAddress(customer.getAddress());
		return dto;
	}
	
	public UsersDTO toDTOSeller(Seller seller) {
		UsersDTO dto = new UsersDTO();
		dto.setId(seller.getId());
		dto.setFirstname(seller.getLastname());
		dto.setLastname(seller.getLastname());
		dto.setUsername(seller.getUsername());
		dto.setPassword(seller.getPassword());
		dto.setUserType(seller.getUserType());
		dto.setBlocked(seller.getBlocked());
		dto.setAddress(seller.getAddress());
		dto.setDateFrom(seller.getDateFrom());
		dto.setEmail(seller.getEmail());
		dto.setName(seller.getName());
		return dto;
	}
	
	public Customer toCustomer(UsersDTO usersDTO) {
		Customer c = new Customer();
		c.setId(usersDTO.getId());
		c.setFirstname(usersDTO.getFirstname());
		c.setLastname(usersDTO.getLastname());
		c.setUsername(usersDTO.getUsername());
		c.setPassword(usersDTO.getPassword());
		c.setUserType(User_Type.CUSTOMER);
		c.setBlocked(usersDTO.getBlocked());
		c.setAddress(usersDTO.getAddress());
		return c;
	}
	
	public Seller toSeller(UsersDTO usersDTO) {
		Seller s = new Seller();
		s.setId(usersDTO.getId());
		s.setFirstname(usersDTO.getFirstname());
		s.setLastname(usersDTO.getLastname());
		s.setUsername(usersDTO.getUsername());
		s.setPassword(usersDTO.getPassword());
		s.setUserType(User_Type.SELLER);
		s.setBlocked(usersDTO.getBlocked());
		s.setAddress(usersDTO.getAddress());
		s.setDateFrom(usersDTO.getDateFrom());
		s.setEmail(usersDTO.getEmail());
		s.setName(usersDTO.getName());
		return s;
	}
}
