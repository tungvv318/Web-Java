package com.myprojectwithspringboot.bookweb.service;

import com.myprojectwithspringboot.bookweb.model.Category;
import com.myprojectwithspringboot.bookweb.model.Product;
import com.myprojectwithspringboot.bookweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getListProductsByTime() {
        return productRepository.findTop4ByOrderByIdAsc();
    }

    @Override
    public Product getProductByID(int idProduct) {
        return productRepository.findById(idProduct);
    }

    @Override
    public List<Product> getListProductsByCategory(Category categoryOfProductSelected) {
        return productRepository.findTop3ByCategory(categoryOfProductSelected);
    }

    @Override
    public List<Product> getListProductByPrice() {
        return productRepository.findTop8ByOrderByPriceUnitProductAsc();
    }

    @Override
    public List<Product> getListProductByText(String keyword) {
        return productRepository.findByNameLike(keyword);
    }

    @Override
    public Page<Product> findProducts(Category category, Pageable pageable) {
        return productRepository.findProducts(category, pageable);
    }
}
