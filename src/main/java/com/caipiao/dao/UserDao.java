package com.caipiao.dao;

import com.caipiao.dao.base.BaseDao;
import com.caipiao.domain.User;

/*author:huangshanqi
 *time  :2015年1月31日 下午8:46:50
 *email :hsqmobile@gmail.com
 */
public interface UserDao extends BaseDao<User>{
	
	public User findUserByEmail(String email);
	public User findUserByUserName(String username);
	
	public int updateUsername(User user);
	public int updatePassword(User user);
	public int updateEmailAuth(User user);

}
