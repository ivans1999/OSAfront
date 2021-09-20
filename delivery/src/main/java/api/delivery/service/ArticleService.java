package api.delivery.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.delivery.entity.Article;
import api.delivery.repository.ArticleRepository;

@Service
public class ArticleService implements ArticleServiceInterface{

	@Autowired
	ArticleRepository articleRepository;

	@Override
	public Article findOne(Long articleId) {
		return articleRepository.getOne(articleId);
	}

	@Override
	public Article save(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public void remove(Long articleId) {
		articleRepository.deleteById(articleId);
	}

	@Override
	public List<Article> findAll() {
		return articleRepository.findAll();
	}

	@Override
	public List<Article> findAllByDeleted(Boolean deleted) {
		return articleRepository.findAllByDeleted(deleted);
	}
}