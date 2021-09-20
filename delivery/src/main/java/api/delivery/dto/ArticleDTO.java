package api.delivery.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ArticleDTO implements Serializable{

	private Long id;
	
	private String articleName;
	
	private String articleDescription;
	
	private Double articleMark;
	
	private String path;
	
	private Boolean deleted;
	
	private UsersDTO usersDTO;
		
	public ArticleDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public String getArticleDescription() {
		return articleDescription;
	}

	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}

	public Double getArticleMark() {
		return articleMark;
	}

	public void setArticleMark(Double articleMark) {
		this.articleMark = articleMark;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public UsersDTO getUsersDTO() {
		return usersDTO;
	}

	public void setUsersDTO(UsersDTO usersDTO) {
		this.usersDTO = usersDTO;
	}
}