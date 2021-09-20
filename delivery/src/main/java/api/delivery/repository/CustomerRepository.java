package api.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.delivery.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
