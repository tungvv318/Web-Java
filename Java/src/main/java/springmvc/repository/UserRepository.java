package springmvc.repository;

import springmvc.model.User;

public interface UserRepository {
	void insertUser(User user);
	User searchUserInDatabase(User user);
	User searchUserByEmail(String email);
}
