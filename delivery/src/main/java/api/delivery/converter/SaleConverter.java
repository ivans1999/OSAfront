package api.delivery.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import api.delivery.dto.SaleDTO;
import api.delivery.entity.Sale;
import api.delivery.service.UserServiceInterface;


@Component
public class SaleConverter {
	
	@Autowired
	public UsersConverter usersConverter;
	
	@Autowired
	UserServiceInterface userServiceInterface;
	
	public SaleDTO toDTO(Sale sale) {
		SaleDTO dto = new SaleDTO();
		dto.setId(sale.getId());
		dto.setPercentage(sale.getPercentage());
		dto.setDateFrom(sale.getDateFrom());
		dto.setDateTo(sale.getDateTo());
		dto.setText(sale.getText());
		dto.setUsersDTO(usersConverter.toDTOSeller(sale.getSeller()));
		return dto;
	}
	
	public Sale toSale(SaleDTO saleDTO) {
		Sale s = new Sale();
		s.setId(saleDTO.getId());
		s.setPercentage(saleDTO.getPercentage());
		s.setDateFrom(saleDTO.getDateFrom());
		s.setDateTo(saleDTO.getDateTo());
		s.setText(saleDTO.getText());
		s.setSeller(userServiceInterface.findOne(saleDTO.getUsersDTO().getId()));
		return s;
	}

}
