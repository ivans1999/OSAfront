package api.delivery.service;

import java.util.List;
import api.delivery.entity.Article;

public interface ArticleServiceInterface {
	
	Article findOne(Long articleId);
	
	Article save(Article article);
	
	void remove(Long articleId);
	
	List<Article> findAll();
	
	List<Article> findAllByDeleted(Boolean deleted);
}