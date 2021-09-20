package api.delivery.service;

import java.util.List;
import api.delivery.entity.Sale;

public interface SaleServiceInterface {

	Sale findOne(Long saleId);
	
	Sale save(Sale sale);
	
	void remove(Long saleId);
	
	List<Sale> findAll();
}
