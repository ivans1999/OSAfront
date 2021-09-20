package api.delivery.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.delivery.entity.Sale;
import api.delivery.repository.SaleRepository;

@Service
public class SaleService implements SaleServiceInterface{

	@Autowired
	SaleRepository saleRepository;

	@Override
	public Sale findOne(Long saleId) {
		return saleRepository.getOne(saleId);
	}

	@Override
	public Sale save(Sale sale) {
		return saleRepository.save(sale);
	}

	@Override
	public void remove(Long saleId) {
		saleRepository.deleteById(saleId);
	}

	@Override
	public List<Sale> findAll() {
		return saleRepository.findAll();
	}	
}