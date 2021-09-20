package api.delivery.service;

import java.util.List;
import api.delivery.entity.Admin;

public interface AdminServiceInterface {
	
	Admin findOne(Long userId);
	
	Admin save(Admin admin);
	
	void remove(Long userId);
	
	List<Admin> findAll();

}
