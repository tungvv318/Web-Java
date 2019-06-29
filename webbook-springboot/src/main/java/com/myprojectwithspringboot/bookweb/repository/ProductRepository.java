package com.myprojectwithspringboot.bookweb.repository;

import com.myprojectwithspringboot.bookweb.model.Category;
import com.myprojectwithspringboot.bookweb.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findById(int id);

    List<Product> findTop4ByOrderByIdAsc();

    List<Product> findTop3ByCategory(Category category);

    List<Product> findTop8ByOrderByPriceUnitProductAsc();

    List<Product> findByNameLike(String name);

    @Query("SELECT p FROM Product p where p.category = ?1")
    Page<Product> findProducts(Category category, Pageable pageable);
}
