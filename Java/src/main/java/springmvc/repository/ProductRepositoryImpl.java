package springmvc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.model.Category;
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository{
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


}
