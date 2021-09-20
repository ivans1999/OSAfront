package api.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.delivery.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsernameAndPassword(String username, String password);
	
}
