package net.myblog.service;

import java.util.List;

import net.myblog.entity.Article;
import net.myblog.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
	
	@Autowired ArticleRepository articleRepository;

	/**
	 * 构建PageRequest对象
	 * @param num
	 * @param size
	 * @param asc
	 * @param string
	 * @return
	 */
	private PageRequest buildPageRequest(int num, int size, Direction asc,
			String string) {
		return new PageRequest(num-1, size,null,string);
	}
	
	/**
	 * 获取所有的博客信息并分页显示
	 * @param pageNo
	 * 			当前页面数
	 * @param pageSize
	 * 			每一页面的页数
	 * @return
	 */
	public Page<Article> findAll(int pageNo, int pageSize,Direction dir, String str){
		PageRequest request = buildPageRequest(pageNo, pageSize, dir, str);
		Page<Article> articles = articleRepository.findAll(request);
		return articles;
	}
	
	
	/**
	 * 按点击量对文章进行排序
	 * @return
	 */
	public List<Article> finyOrderByArticleClick(int num,int size,Direction dir,String str){
		PageRequest request = buildPageRequest(num, size, dir, str);
		List<Article> articles = articleRepository.findAll(request).getContent();
		return articles;
	}
	
	/**
	 * 按发布时间对文章进行排序
	 * @param num
	 * @param size
	 * @param dir
	 * @param str
	 * @return
	 */
	public List<Article> findOrderByArticleTime(int num,int size,Direction dir,String str){
		PageRequest request = buildPageRequest(num, size, dir, str);
		List<Article> articles = articleRepository.findAll(request).getContent();
		return articles;
	}
	
	/**
	 * 获取站长推荐的文章
	 * @return
	 */
	/**
	 * @param num
	 * @param size
	 * @param dir
	 * @param str
	 * @return
	 */
	public List<Article> findSupportArticle(){
		//PageRequest request = buildPageRequest(num, size, dir, str);
		List<Article> articles = articleRepository.findSupportArticle();
		return articles;
	}
	
}