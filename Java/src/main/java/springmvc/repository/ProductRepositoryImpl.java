package springmvc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.model.Category;
import springmvc.model.Product;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> getListCategory() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Category.class);
		// gom nhóm các sản phẩm theo thể loại
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<Category> categories = criteria.list();
		return categories;
	}

	@Override
	public List<Product> getListProductsByTime() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		criteria.addOrder(Order.desc("dateCreate"));
		List<Product> lstProductsByTime = criteria.list();
		return lstProductsByTime;
	}

	@Override
	public Product getProductByID(int idProduct) {
		Product productForFindByID = (Product) sessionFactory.getCurrentSession().get(Product.class, idProduct);
		return productForFindByID;
	}

	@Override
	public List<Product> getListProductsByCategory(Category categoryOfProductSelected) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		criteria.add(Restrictions.eq("category", categoryOfProductSelected));
		List<Product> lstProductsByCategory = criteria.list();
		return lstProductsByCategory;
	}

	@Override
	public List<Product> getListProductByPrice() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		criteria.addOrder(Order.asc("priceUnitProduct"));
		List<Product> lstProductByPrice = criteria.list();
		return lstProductByPrice;
	}

}
