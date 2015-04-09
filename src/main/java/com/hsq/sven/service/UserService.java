package com.hsq.sven.service;

import com.hsq.sven.domain.User;


/*author:huangshanqi
 *time  :2015年1月31日 下午9:04:30
 *email :hsqmobile@gmail.com
 */
public interface UserService {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	

	
	public User createUser(User user);
	
	public User findUserByEmail(String email);
	public User findUserByUserName(String username);
	public User findUserByid(long userId);
	
	public boolean updateUsername(long userId,String username);
	public boolean updatePassword(long userId,String password);
	
	public boolean checkPassword(long userId,String password);
	public boolean updateEmailAuth(long userId,int emailAuthStatus);
	public boolean checkEmailAuth(long userId);

}
