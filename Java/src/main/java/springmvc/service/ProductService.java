package springmvc.service;

import java.util.List;

import springmvc.model.Category;
import springmvc.model.Product;

public interface ProductService {
	List<Category> getListCategory();
	List<Product> getListProducts();
}
