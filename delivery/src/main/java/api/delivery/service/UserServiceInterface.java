package api.delivery.service;

import java.util.List;
import api.delivery.entity.User;

public interface UserServiceInterface {

	User findOne(Long userId);
	
	User save(User user);
	
	void remove(Long userId);
	
	List<User> findAll();
	
	User findByUsernameAndPassword(String username, String password);
}
