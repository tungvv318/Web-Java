package springmvc.repository;

import java.util.List;

import springmvc.model.Category;
import springmvc.model.Product;

public interface ProductRepository {
	List<Category> getListCategory();
	List<Product> getListProductsByTime();
	Product getProductByID(int id);
//	List<Product> getListProductsByCategory(int id_type);
	List<Product> getListProductsByCategory(Category categoryOfProductSelected);
}
