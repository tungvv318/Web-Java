package springmvc.service;

import java.util.List;

import springmvc.model.Category;
import springmvc.model.Product;

public interface ProductService {
	List<Category> getListCategory();
	List<Product> getListProductsByTime();
	Product getProductByID(int id);
//	List<Product> getListProductsByCategory(int id_type);
//	List<Product> getListProductsByCategory(Product productSelected);
	List<Product> getListProductsByCategory(Category categoryOfProductSelected);
}
