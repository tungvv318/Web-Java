package springmvc.service;

import springmvc.model.User;

public interface UserService {
	void insertUser(User user);
	User searchUserInDatabase(User user);
	User searchUserByEmail(String email);
}
