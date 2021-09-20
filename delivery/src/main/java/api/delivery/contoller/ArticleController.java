package api.delivery.contoller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.delivery.converter.ArticleConverter;
import api.delivery.dto.ArticleDTO;
import api.delivery.entity.Article;
import api.delivery.service.ArticleServiceInterface;

@RestController
@RequestMapping(value="delivery/articles")
public class ArticleController {

	@Autowired
	private ArticleServiceInterface articleServiceInterface;
	
	@Autowired
	ArticleConverter articleConverter;
	
	@GetMapping(value="/all")
	public ResponseEntity<List<ArticleDTO>> getArticles(){
		List<Article> articles = articleServiceInterface.findAllByDeleted(false);
		List<ArticleDTO> articlesDTO = new ArrayList<ArticleDTO>();
		for (Article a : articles) {
			articlesDTO.add(articleConverter.toDTO(a));
		}
		return new ResponseEntity<List<ArticleDTO>>(articlesDTO,HttpStatus.OK);
	}
	
	@GetMapping(value="/{article_id}")
	public ResponseEntity<ArticleDTO> getArticle(@PathVariable("article_id") Long article_id){
		Article article = articleServiceInterface.findOne(article_id);
		if(article == null) {
			return new ResponseEntity<ArticleDTO>(HttpStatus.NOT_FOUND);
		}
		ArticleDTO articleDTO = articleConverter.toDTO(article);
		return new ResponseEntity<ArticleDTO>(articleDTO, HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json", value="/add")
	public ResponseEntity<ArticleDTO> saveArticle(@RequestBody ArticleDTO aDTO){
		Article a = articleConverter.toArticle(aDTO);
		a.setDeleted(false);
		Article ar = articleServiceInterface.save(a);
		ArticleDTO articleDTO = articleConverter.toDTO(ar);
		return new ResponseEntity<ArticleDTO>(articleDTO, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{article_id}", consumes = "application/json")
	public ResponseEntity<ArticleDTO> updateArticle(@RequestBody ArticleDTO aDTO,@PathVariable("article_id") Long article_id){
		Article article = articleServiceInterface.findOne(article_id);
		if (article == null) {
			return new ResponseEntity<ArticleDTO>(HttpStatus.NOT_FOUND);
		}
		Article a = articleConverter.toArticle(aDTO);
		a.setDeleted(false);
		Article ar = articleServiceInterface.save(a);
		ArticleDTO articleDTO = articleConverter.toDTO(ar);
		return new ResponseEntity<ArticleDTO>(articleDTO, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{article_id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("article_id") Long article_id){
		Article article = articleServiceInterface.findOne(article_id);
		if (article!=null) {
			article.setDeleted(true);
			articleServiceInterface.save(article);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
}
