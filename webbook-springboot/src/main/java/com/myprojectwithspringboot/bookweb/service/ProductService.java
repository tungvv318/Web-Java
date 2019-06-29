package com.myprojectwithspringboot.bookweb.service;

import com.myprojectwithspringboot.bookweb.model.Category;
import com.myprojectwithspringboot.bookweb.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    /**
     * hàm dùng để lấy danh sách các thể loại sản phẩm ở dưới database
     *
     * @return
     */
    List<Product> getListProductsByTime();

    /**
     * hàm dùng để lấy sản phẩm ở dưới database theo id
     *
     * @param idProduct
     * @return: product tìm được
     */
    Product getProductByID(int idProduct);

    /**
     * hàm dùng để lấy danh sách sản phẩm ở dưới database theo thể loại
     *
     * @param categoryOfProductSelected
     * @return
     */
    List<Product> getListProductsByCategory(Category categoryOfProductSelected);

    /**
     * hàm dùng để lấy sản phẩm theo giá từ thấp đến cao
     *
     * @return
     */
    List<Product> getListProductByPrice();

    /**
     * hàm dùng để tìm kiếm sản phẩm theo ký tự
     *
     * @param keyword
     * @return
     */
    List<Product> getListProductByText(String keyword);

    Page<Product> findProducts(Category category, Pageable pageable);
}
