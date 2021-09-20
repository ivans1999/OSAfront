package api.delivery.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.delivery.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

	List<Article> findAllByDeleted(Boolean deleted);
}
