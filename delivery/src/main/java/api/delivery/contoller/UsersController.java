package api.delivery.contoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import api.delivery.converter.UsersConverter;
import api.delivery.dto.UsersDTO;
import api.delivery.entity.Customer;
import api.delivery.entity.Seller;
import api.delivery.entity.User_Type;
import api.delivery.service.CustomerServiceInterface;
import api.delivery.service.SellerServiceInterface;

@RestController
@RequestMapping(value="delivery/users")
public class UsersController {
	
	@Autowired
	private CustomerServiceInterface customerServiceInterface;
	
	@Autowired
	private SellerServiceInterface sellerServiceInterface;
	
	@Autowired
	UsersConverter usersConverter;
	
	@GetMapping(value="/all")
	public ResponseEntity<List<UsersDTO>> getUsers(){
		List<Seller> sellers = sellerServiceInterface.findAll();
		List<UsersDTO> sellersDTO = new ArrayList<UsersDTO>();
		for (Seller s : sellers) {
			sellersDTO.add(usersConverter.toDTOSeller(s));
		}
		return new ResponseEntity<List<UsersDTO>>(sellersDTO, HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json", value = "/add")
	public ResponseEntity<UsersDTO> register(@RequestBody UsersDTO uDTO){
		System.out.println(uDTO.getUserType());
		if(uDTO.getUserType() == User_Type.SELLER) {
			Seller s = usersConverter.toSeller(uDTO);
			s.setBlocked(false);
			Seller us = sellerServiceInterface.save(s);
			UsersDTO sellerDTO = usersConverter.toDTOSeller(us);
			return new ResponseEntity<UsersDTO>(sellerDTO, HttpStatus.CREATED);
		}
		else {
			Customer c = usersConverter.toCustomer(uDTO);
			c.setBlocked(false);
			Customer uc = customerServiceInterface.save(c);
			UsersDTO customerDTO = usersConverter.toDTOCustomer(uc);
			return new ResponseEntity<UsersDTO>(customerDTO, HttpStatus.CREATED);
		}
	}	
}