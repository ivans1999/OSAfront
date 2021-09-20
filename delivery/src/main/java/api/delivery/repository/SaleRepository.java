package api.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.delivery.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

}
