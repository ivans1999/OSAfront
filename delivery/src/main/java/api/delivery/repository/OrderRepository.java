package api.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.delivery.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
