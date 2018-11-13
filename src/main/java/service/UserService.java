package service;

import dao.UserDao;
import model.UserModel;

public class UserService {
	private static UserDao userDao;
	public static UserModel create(UserModel user) throws Exception {
		return userDao.create(user);
	}
	public static boolean login(UserModel user) throws Exception {
		return userDao.login(user);
	}
}
