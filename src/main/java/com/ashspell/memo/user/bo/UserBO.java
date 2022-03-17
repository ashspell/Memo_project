package com.ashspell.memo.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashspell.memo.common.EncryptUtils;
import com.ashspell.memo.user.dao.UserDAO;
import com.ashspell.memo.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	
	public int addUser(
			String loginId,
			String password,
			String name,
			String email) {
		
		String encryptPassword =  EncryptUtils.md5(password);
		
		
		return userDAO.insertUser(loginId, password, name, email);
	}
	
	
	public User getUser(String loginID, String password) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		return userDAO.selectUser(loginID, encryptPassword);
	}
}
