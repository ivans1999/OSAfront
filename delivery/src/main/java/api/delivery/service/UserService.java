package api.delivery.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.delivery.entity.User;
import api.delivery.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User findOne(Long userId) {
		return userRepository.getOne(userId);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public void remove(Long userId) {
		userRepository.deleteById(userId);
		
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}	
}
