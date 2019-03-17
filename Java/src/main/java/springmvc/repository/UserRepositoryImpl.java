package springmvc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.model.User;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public User searchUserInDatabase(User user) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		// câu lệnh and
		SimpleExpression email = Restrictions.eq("email", user.getEmail());
		SimpleExpression pass = Restrictions.eq("password", user.getPassword());
		LogicalExpression parameter = Restrictions.and(email, pass);
		criteria.add(parameter);
		// lấy điều kiện contactNumber
		List<User> users = criteria.list();
		return users.get(0);
	}

}
