package com.myprojectwithspringboot.bookweb.service;


import com.myprojectwithspringboot.bookweb.model.Category;
import com.myprojectwithspringboot.bookweb.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getListCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryByID(int idCategory) {
        return categoryRepository.findById(idCategory);
    }
}
