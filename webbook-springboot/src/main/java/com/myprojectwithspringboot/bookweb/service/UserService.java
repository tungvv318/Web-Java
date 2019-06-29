package com.myprojectwithspringboot.bookweb.service;

import com.myprojectwithspringboot.bookweb.model.User;

public interface UserService {
    /**
     * hàm insert user nhập ở trên form xuống database
     *
     * @param user
     */
    void insertUser(User user);


    /**
     * hàm user tìm trong database theo email
     * kiểm tra email user khi đăng kí có bị trùng với email của user khác đã đăng kí không?
     *
     * @param email
     * @return: trả về user nếu đã tồn tại, trả về null nếu chưa tồn tại email cần
     *          đăng kí dưới database
     */
    User searchUserByEmail(String email);
}
