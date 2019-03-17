package springmvc.service;

import springmvc.model.User;

public interface UserService {
	void insertUser(User user);
	User searchUser(User user);
}
