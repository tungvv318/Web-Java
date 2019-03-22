package springmvc.service;

import springmvc.model.User;

public interface UserService {
	// hàm lưu user xuống database
	void insertUser(User user);

	// hàm tìm user dưới database
	User searchUserInDatabase(User user);

	// hàm tìm user dưới database theo email
	User searchUserByEmail(String email);
}
