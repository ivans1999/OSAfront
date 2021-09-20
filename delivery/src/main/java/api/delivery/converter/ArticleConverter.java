package api.delivery.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import api.delivery.dto.ArticleDTO;
import api.delivery.entity.Article;
import api.delivery.service.SellerServiceInterface;
import api.delivery.service.UserServiceInterface;

@Component
public class ArticleConverter {
	
	@Autowired
	public UsersConverter usersConverter;
	
	@Autowired
	UserServiceInterface userServiceInterface;
	
	@Autowired
	SellerServiceInterface sellerServiceInterface;
			
	public ArticleDTO toDTO(Article article) {
		ArticleDTO dto = new ArticleDTO();
		dto.setId(article.getId());
		dto.setArticleName(article.getArticleName());
		dto.setArticleDescription(article.getArticleDescription());
		dto.setArticleMark(article.getArticleMark());
		dto.setPath(article.getPath());
		dto.setDeleted(article.getDeleted());
		dto.setUsersDTO(usersConverter.toDTOSeller(article.getSeller()));
		return dto;
	}
	
	public Article toArticle(ArticleDTO articleDTO) {
		Article a = new Article();
		a.setId(articleDTO.getId());
		a.setArticleName(articleDTO.getArticleName());
		a.setArticleDescription(articleDTO.getArticleDescription());
		a.setArticleMark(articleDTO.getArticleMark());
		a.setPath(articleDTO.getPath());
		a.setDeleted(articleDTO.getDeleted());
		a.setSeller(sellerServiceInterface.findOne(articleDTO.getUsersDTO().getId()));
		return a;
	}

}