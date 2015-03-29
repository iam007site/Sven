package com.hsq.sven.service.blog.Impl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsq.sven.dao.blog.BlogDao;
import com.hsq.sven.dao.blog.BlogTagDao;
import com.hsq.sven.dao.blog.CategoryDao;
import com.hsq.sven.domain.blog.Blog;
import com.hsq.sven.domain.blog.BlogCategoryStatistic;
import com.hsq.sven.domain.blog.BlogTag;
import com.hsq.sven.domain.blog.Category;
import com.hsq.sven.domain.blog.item.BlogItem;
import com.hsq.sven.form.NewBlogForm;
import com.hsq.sven.security.UserUtils;
import com.hsq.sven.service.blog.BlogService;

/*author:huangshanqi
 *time  :2015年3月28日 上午9:38:33
 *email :hsqmobile@gmail.com
 */
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private BlogTagDao blogTagDao;
	
	
	
	
	

	@Override
	public Blog getBlogById(long blogId) {
		// TODO Auto-generated method stub
		return blogDao.findById(blogId);
	}

	@Transactional
	@Override
	public boolean newBlog(NewBlogForm blogForm) {
		// TODO Auto-generated method stub
		long uid = UserUtils.getLoginUser().getUserId();
		String username = UserUtils.getLoginUser().getUsername();
		Blog blog = new Blog();
		
		boolean success = true;
		Category category = categoryDao.getByUserIdName(uid,blogForm.getCategory());
		if(category==null){
			category = new Category();
			category.setCreateTime(new Date());
			category.setUpdateTime(category.getCreateTime());
			category.setUserId(uid);
			category.setName(blogForm.getCategory());
			success = success && categoryDao.create(category)>0 ;
		}
		blog.setCategoryName(category.getName());
		blog.setCategoryId(category.getId());
		blog.setUserId(uid);
		blog.setCreateTime(new Date());
		blog.setUpdateTime(blog.getCreateTime());
		blog.setAuthor(username);
		blog.setTitle(blogForm.getTitle());
		blog.setSummary(blogForm.getSummary());
		blog.setContent(blogForm.getContent());
		blog.setBlogType(blogForm.getBlogType());
		
		success = success &&  blogDao.create(blog)>0;
		
		String[] tags = blogForm.getTags().split(",");
		for(String str:tags){
			BlogTag blogTag = new BlogTag();
			blogTag.setBlogId(blog.getId());
			blogTag.setCreateTime(new Date());
			blogTag.setUpdateTime(blogTag.getCreateTime());
			blogTag.setUserId(uid);
			blogTag.setTagName(str);
			success = success &&  blogTagDao.create(blogTag)>0;
		}
		
		return success;
	}

	@Transactional
	@Override
	public int getUserTotalBlogNum(long userId) {
		// TODO Auto-generated method stub
		return blogDao.getUserTotalBlogNum(userId);
	}

	@Transactional
	@Override
	public ArrayList<BlogItem> getUserBlogByOffset(long userId, int offset, int pageSize) {
		// TODO Auto-generated method stub
		ArrayList<BlogItem> blogs = blogDao.getUserBlogByOffset(userId, offset, pageSize);
		if(blogs!=null){
			for(BlogItem blog:blogs){
				ArrayList<String> tags = new ArrayList<String>();
				for(BlogTag blogTag:blogTagDao.getBlogTag(blog.getId())){
					tags.add(blogTag.getTagName());
				}
				blog.setTags(tags);
			}
		}
		return blogs;
	}

	@Override
	public ArrayList<BlogCategoryStatistic> getUserBlogCategoryStatistic(long userId) {
		// TODO Auto-generated method stub
		return blogDao.getUsrBlogCategoryStatistic(userId);
	}

	@Transactional
	@Override
	public ArrayList<BlogItem> getUserBlogByCategoryByOffset(long userId, long categoryId, int offset, int pageSize) {
		// TODO Auto-generated method stub
		ArrayList<BlogItem> blogs = blogDao.getUserBlogByCategoryByOffset(userId,categoryId,offset,pageSize);
		if(blogs!=null){
			for(BlogItem blog:blogs){
				ArrayList<String> tags = new ArrayList<String>();
				for(BlogTag blogTag:blogTagDao.getBlogTag(blog.getId())){
					tags.add(blogTag.getTagName());
				}
				blog.setTags(tags);
			}
		}
		return blogs;
	}

	@Transactional
	@Override
	public ArrayList<BlogItem> getUserBlogByTagByOffset(long userId, String tag, int offset, int pageSize) {
		// TODO Auto-generated method stub
		ArrayList<BlogItem> blogs = blogDao.getUserBlogByTagByOffset(userId,tag,offset,pageSize);
		if(blogs!=null){
			for(BlogItem blog:blogs){
				ArrayList<String> tags = new ArrayList<String>();
				for(BlogTag blogTag:blogTagDao.getBlogTag(blog.getId())){
					tags.add(blogTag.getTagName());
				}
				blog.setTags(tags);
			}
		}
		return blogs;
	}

	@Transactional
	@Override
	public ArrayList<String> getUserAllTag(long userId) {
		// TODO Auto-generated method stub
		ArrayList<BlogTag> blogTags = blogTagDao.getUserAllTag(userId);
		if(blogTags != null){
			ArrayList<String> tags = new ArrayList<String>();
			for(BlogTag blogTag:blogTags){
			    tags.add(blogTag.getTagName());
			}
			return tags;
		}
		return null;
	}

	
	
	
	
	
	
	
}
