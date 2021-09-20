package api.delivery.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.delivery.entity.Admin;
import api.delivery.repository.AdminRepository;

@Service
public class AdminService implements AdminServiceInterface{
	
	@Autowired
	AdminRepository adminRepository;

	@Override
	public Admin findOne(Long userId) {
		return adminRepository.getOne(userId);
	}

	@Override
	public Admin save(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public void remove(Long userId) {
		adminRepository.deleteById(userId);
	}

	@Override
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}
}