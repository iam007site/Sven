package com.caipiao.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caipiao.dao.UserDao;
import com.caipiao.domain.User;
import com.caipiao.security.Digests;
import com.caipiao.security.Encodes;
import com.caipiao.service.UserService;



/*author:huangshanqi
 *time  :2015年1月31日 下午9:05:13
 *email :hsqmobile@gmail.com
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	@Override
	public int createUser(User user) {
		// TODO Auto-generated method stub
		User temp = userDao.findUserByEmail(user.getEmail());
		if(temp != null)
			return -1;
		user.setCreateTime(new Date());
		user.setEmailAuth(0);
		
		
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
		return userDao.create(user);
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findUserByEmail(email);
	}

	@Override
	public User findUserByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.findUserByUserName(username);
	}

	@Override
	public User findUserByid(int userId) {
		// TODO Auto-generated method stub
		return userDao.findById(userId);
	}

	@Transactional
	@Override
	public boolean updateUsername(int userId, String username) {
		// TODO Auto-generated method stub
		User temp = userDao.findById(userId);
		if(temp == null){
			return false;
		}
		temp.setCreateTime(new Date());
		temp.setUsername(username);
		return userDao.updateUsername(temp)>0;
	}

	@Transactional
	@Override
	public boolean updatePassword(int userId, String password) {
		// TODO Auto-generated method stub
		User temp = userDao.findById(userId);
		if(temp == null){
			return false;
		}
		temp.setCreateTime(new Date());
		temp.setPassword(password);
		return userDao.updatePassword(temp)>0;
	}

	@Transactional
	@Override
	public boolean checkPassword(int userId, String password) {
		// TODO Auto-generated method stub
		User temp = userDao.findById(userId);
		if(temp == null){
			return false;
		}
		return temp.getPassword().equals(password);
	}

	@Transactional
	@Override
	public boolean updateEmailAuth(int userId, int emailAuthStatus) {
		// TODO Auto-generated method stub
		User temp = userDao.findById(userId);
		if(temp == null){
			return false;
		}
		temp.setCreateTime(new Date());
		temp.setEmailAuth(emailAuthStatus);
		return userDao.updateEmailAuth(temp)>0;
	}

	@Override
	public boolean checkEmailAuth(int userId) {
		// TODO Auto-generated method stub
		User temp = userDao.findById(userId);
		if(temp == null){
			return false;
		}
		return 1 == temp.getEmailAuth();
	}
	
	
	
	
	

}
