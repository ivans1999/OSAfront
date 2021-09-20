package api.delivery.service;

import java.util.List;
import api.delivery.entity.Seller;

public interface SellerServiceInterface {

	Seller findOne(Long sellerId);
	
	Seller save(Seller seller);
	
	void remove(Long sellerId);
	
	List<Seller> findAll();
}
