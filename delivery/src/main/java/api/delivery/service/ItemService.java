package api.delivery.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.delivery.entity.Item;
import api.delivery.repository.ItemRepository;

@Service
public class ItemService implements ItemServiceInterface{
	
	@Autowired
	ItemRepository itemRepository;

	@Override
	public Item findOne(Long itemId) {
		return itemRepository.getOne(itemId);
	}

	@Override
	public Item save(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public void remove(Long itemId) {
		itemRepository.deleteById(itemId);
	}

	@Override
	public List<Item> findAll() {
		return itemRepository.findAll();
	}
}