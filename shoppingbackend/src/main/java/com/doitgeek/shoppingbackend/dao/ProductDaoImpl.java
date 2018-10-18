package com.doitgeek.shoppingbackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doitgeek.shoppingbackend.entity.Product;

@Repository
public class ProductDaoImpl extends GenericDaoImpl<Product, Long> implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Product> getActiveProducts() {
		/*CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
		Root<Product> productRoot = criteriaQuery.from(Product.class);
		criteriaQuery.select(productRoot);
		return getCurrentSession().createQuery(criteriaQuery).getResultList();*/
		String hql = "FROM Product WHERE isActive = :active";
		return getCurrentSession()
				.createQuery(hql, Product.class)
				.setParameter("active", 'Y')
				.getResultList();
	}

	@Override
	public List<Product> getActiveProductsByCategoryId(Long categoryId) {
		/*CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
		Root<Product> productRoot = criteriaQuery.from(Product.class);
		criteriaQuery.select(productRoot);
		criteriaQuery.where(builder.equal(productRoot.get("categoryId"), categoryId));
		return getCurrentSession().createQuery(criteriaQuery).getResultList();*/
		String hql = "FROM Product WHERE isActive = :active AND categoryId = :categoryId";
		return getCurrentSession()
				.createQuery(hql, Product.class)
				.setParameter("active", 'Y')
				.setParameter("categoryId", categoryId)
				.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(Integer count) {
		return getCurrentSession()
				.createQuery("FROM Product WHERE isActive = :active ORDER BY id", Product.class)
				.setParameter("active", 'Y')
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
