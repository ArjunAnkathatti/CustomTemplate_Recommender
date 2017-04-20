package com.geni.services;

import com.geni.dao.User_Information_Dao;

public class User_Information_Service {
	User_Information_Dao userDao = new User_Information_Dao();
	
	public boolean loginAccount(String emailID, String password){
		String pass = userDao.getUserPasswordWithID(emailID);
		if(pass.equals(password) && pass != null){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean addAccount(String emailID, String passowrd){
		String pass = null;
	    pass = userDao.getUserPasswordWithID(emailID);
		if(pass == null){
			return userDao.addUserAccount(emailID, passowrd);
		}else{
			return false;
		}
	}
}
