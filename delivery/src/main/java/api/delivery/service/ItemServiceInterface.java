package api.delivery.service;

import java.util.List;
import api.delivery.entity.Item;

public interface ItemServiceInterface {

	Item findOne(Long itemId);
	
	Item save(Item item);
	
	void remove(Long itemId);
	
	List<Item> findAll();
}
