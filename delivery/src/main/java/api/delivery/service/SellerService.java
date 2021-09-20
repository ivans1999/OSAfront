package api.delivery.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.delivery.entity.Seller;
import api.delivery.repository.SellerRepository;

@Service
public class SellerService implements SellerServiceInterface{
	
	@Autowired
	SellerRepository sellerRepository;

	@Override
	public Seller findOne(Long sellerId) {
		return sellerRepository.getOne(sellerId);
	}

	@Override
	public Seller save(Seller seller) {
		return sellerRepository.save(seller);
	}

	@Override
	public void remove(Long sellerId) {
		sellerRepository.deleteById(sellerId);
	}

	@Override
	public List<Seller> findAll() {
		return sellerRepository.findAll();
	}
}
