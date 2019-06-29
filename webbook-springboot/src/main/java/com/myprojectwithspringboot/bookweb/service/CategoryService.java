package com.myprojectwithspringboot.bookweb.service;

import com.myprojectwithspringboot.bookweb.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getListCategory();

    /**
     * hàm dùng để lấy thể loại(List<Product>, tên thể loại,...) theo id của thể
     * loại
     *
     * @param idCategory
     * @return
     */
    Category getCategoryByID(int idCategory);

    /**
     * hàm dùng để lấy danh sách sản phẩm ở dưới database theo thời gian mới nhất
     * đến cũ nhất
     *
     * @return
     */
}
